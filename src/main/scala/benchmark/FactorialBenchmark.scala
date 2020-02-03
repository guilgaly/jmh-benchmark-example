package benchmark

import java.util.concurrent.TimeUnit

import factorial.{FactorialDivideAndConquer, FactorialReduce}
import org.openjdk.jmh.annotations.{
  Benchmark,
  BenchmarkMode,
  Fork,
  Measurement,
  Mode,
  OutputTimeUnit,
  Param,
  Scope,
  State,
  Warmup,
}

@State(Scope.Thread)
// Setup number and length of iterations (for JVM warm-up and for actual measurement):
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
// Different ways to sample result numbers:
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
// JVM args passed to the forked JVMs running the benchmarks:
// - 'AlwaysPreTouch' allocates memory from the OS for the entire heap space at
// JVM startup.
// - 'UseEpsilonGC': Epsilon is a no-op GC (it never actually collects garbage
// memory); it can be interesting as a baseline to compare GCs (but it only
// works if the benchmark doesn't allocate too much memory, as memory is never
// reclaimed...).
@Fork(
  jvmArgs = Array(
    "-Xms256M",
    "-Xmx256M",
    "-Xss4M",
    "-XX:+UseG1GC",
    "-XX:+AlwaysPreTouch",
    "-XX:FlightRecorderOptions=samplethreads=true,stackdepth=100",
  ),
)
//@Fork(jvmArgs = Array("-Xms8G", "-Xmx8G", "-Xss4M", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseEpsilonGC", "-XX:+AlwaysPreTouch"))
class FactorialBenchmark {

//  @Param(Array("10", "100"/*, "1000", "10000"*/))
  @Param(Array("10")) // For Epsilon GC - bigger numbers will use too much memory
  var arg: Int = _

//  @Benchmark
  def factorialReduceBenchmark(): Unit = {
    FactorialReduce.factorial(arg)
  }

  @Benchmark
  def factorialDivideAndConquerBenchmark(): Unit = {
    FactorialDivideAndConquer.factorial(arg)
  }
}
