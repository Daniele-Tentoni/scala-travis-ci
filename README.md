# scala-travis-ci

### Integrations
| NAME | VALUE |
| --- | --- |
| Travis CI | [![Build Status](https://travis-ci.com/Daniele-Tentoni/scala-travis-ci.svg?branch=master)](https://travis-ci.com/Daniele-Tentoni/scala-travis-ci) | 
| Codecov | [![codecov](https://codecov.io/gh/Daniele-Tentoni/scala-travis-ci/branch/master/graph/badge.svg)](https://codecov.io/gh/Daniele-Tentoni/scala-travis-ci) |

Find more infos on Pages [here!](https://daniele-tentoni.github.io/scala-travis-ci/)

### How to compile
You may wish compile this project using sbt. You can get that from `apt` with:
```bash
sudo apt install sbt
```

If you have modified `build.sbt` file, reload it with:
```bash
sbt reload
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

### Travis CI

We use [Travis CI](https://travis-ci.com/) for continuous integration.
Each time a new commit is received on master, Travis trigger a build.

You can commit without trigger a build, writing a commit message like
```git
git commit -m "[skip travis] Update README"
```

Actual configured builds:

| JDK | OS | DIST | NOTE |
| --- | --- | --- | --- |
| openjdk11 | linux | xenial |
| openjdk11 | osx |
| openjdk11 | windows | | unsupported |

You can test conditional build properties by parse and eval. More infos on: [Testing Condition](https://docs-staging.travis-ci.com/user/conditions-testing)
* Parse

  Check the syntax of a condition by inspecting the resulting abstract syntax tree.
  ```bash
  $ travis-conditions parse "branch = foo"
  [:eq, [:var, :branch], [:val, "foo"]]

  ```
  
* Eval

  Check conditions against a given data hash.
  ```bash
  $ travis-conditions eval "branch = foo" --data '{"branch": "foo"}'
  true
  
  $ echo '{"branch": "foo"}' | travis-conditions eval "branch = foo"
  true
  ```
  
  You can represent data with Array and JSON notation too.