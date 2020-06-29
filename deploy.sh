# Create necessary folders.
if [ ! -d "public" ]; then
	mkdir public
fi

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

if [ ! -d "public/scoverage-report" ]; then
  mkdir public/scoverage-report
fi

if [ ! -d "public/docs" ]; then
  mkdir public/docs
fi

# Copy the coverage reports.

ls -l

# Execute sbt scripts for test, coverage and doc.
sbt compile test coverageReport doc

# Removed Scala.js, we'll use ScalaFX instead.
# sbt fastOptJS

# Copy static html files.
cp -fr source/* public/

# Copy Scala.js files.
# cp -r target/scala-*/*.js* public/js/

# Copy scoverage report html files.
cp -r target/scala-*/scoverage-report/* public/scoverage-report/

# Copy scaladoc html files.
cp -r target/scala-*/api/* public/docs/
