# Benchmark examples with sbt-jmh

Run commands in SBT shell:

- Run the benchmarks: `jmh:run`
- Run with GC profiler: `jmh:run -prog gc`
- It should also be possible to run with JDK Flight Recorder profiler (see
[here](https://github.com/ktoso/sbt-jmh#using-oracle-flight-recorder), available
on Oracle JDK, or on OpenJDK 11+) and read the profiling data with
[Mission Control](https://stackoverflow.com/a/55629586/3801695), but I haven't
gotten it to work so far...
- See all command line options: `jmh:run -help`
- List available profilers: `jmh:run -lprof`
- Help for a specific profiler (e.g. `gc`): `jmh:run -prof gc:help`

## Links

- [JMH playground](https://github.com/Valloric/jmh-playground) (tons of useful
examples to learn how to use JMH; see for instance
[JMHSample_35_Profilers](https://github.com/Valloric/jmh-playground/blob/master/src/jmh/java/org/openjdk/jmh/samples/JMHSample_35_Profilers.java)
about profilers)
- [sbt-jmh](https://github.com/ktoso/sbt-jmh)
- [sbt-jmh-example](https://github.com/wadejensen/sbt-jmh-example)
