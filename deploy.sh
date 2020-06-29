# Create necessary folders.
if [ ! -d "public" ]; then
	mkdir public
fi

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

if [ ! -d "public/scoverage-report" ]; then
  mkdir public/scoverage-reports
  if [ ! -d "public/scoverage-reports/client" ]; then
    mkdir public/scoverage-reports/client
  fi
  if [ ! -d "public/scoverage-reports/server" ]; then
    mkdir public/scoverage-reports/server
  fi
fi

if [ ! -d "public/api" ]; then
  mkdir public/api
  if [ ! -d "public/api/client" ]; then
    mkdir public/api/client
  fi
  if [ ! -d "public/api/server" ]; then
    mkdir public/api/server
  fi
fi

# Copy the coverage reports.

ls -l

# Execute sbt scripts for test, coverage and doc.
sbt compile coverage test coverageReport doc

# Removed Scala.js, we'll use ScalaFX instead.
# sbt fastOptJS

# Copy static html files.
cp -fr source/* public/

# Copy Scala.js files.
# cp -r target/scala-*/*.js* public/js/

# Copy scoverage report html files.
cp -r target/scala-*/scoverage-report/* public/scoverage-report/
cp -r client/target/scala-*/scoverage-report/* public/scoverage-reports/client
cp -r server/target/scala-*/scoverage-report/* public/scoverage-reports/server

# Copy scaladoc html files.
cp -r target/scala-*/api/* public/docs/
cp -r client/target/scala-*/api/* public/api/client
cp -r server/target/scala-*/api/* public/api/server
