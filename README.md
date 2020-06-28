# scala-travis-ci

[![Build Status](https://travis-ci.com/Daniele-Tentoni/scala-travis-ci.svg?branch=master)](https://travis-ci.com/Daniele-Tentoni/scala-travis-ci)
We use [Travis CI](https://travis-ci.com/) for continuous integration.
Each time a new commit is received on master, Travis trigger a build.

Find more infos on Pages [here!](https://daniele-tentoni.github.io/scala-travis-ci/)

### How to compile
You may wish compile this project using sbt. You can get that from `apt` with:
```bash
sudo apt install sbt
```

You can run the compilation by executing the command
```bash
sbt clean compile
```

You can run tests with
```bash
sbt test
```

You can get coverage reports with
```bash
sbat coverage test coverageReport
```