# Simple Scala Template 1

# Getting Started

### Compile

```bash
simple-scala-template-1 $ sbt compile
```

### Clean

```bash
simple-scala-template-1 $ sbt clean
```

### Run

```bash
simple-scala-template-1 $ sbt core/run
```

### Stage and Run

```bash
simple-scala-template-1 $ sbt core/stage

simple-scala-template-1 $ ./core/target/universal/stage/bin/simple-core

~ $ http :10000

~ $ http :10000/metrics
```

### Packaging

```bash
simple-scala-template-1 $ sbt core/universal:packageZipTarball

simple-scala-template-1 $ ls core/target/universal/simple-core-0.0.1.tgz
core/target/universal/simple-core-0.0.1.tgz

```
