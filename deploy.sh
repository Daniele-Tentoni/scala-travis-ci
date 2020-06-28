# Copy public files and fastOpt.

if [ ! -d "public" ]; then
	mkdir public
fi

cp -fr source/* public/

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

# Removed Scala.js, we'll use ScalaFX instead.

# sbt fastOptJS

# cp -r target/scala-*/*.js* public/js/

# Copy the coverage reports.

ls -l

if [ ! -d "public/scoverage-report" ]; then
  mkdir public/scoverage-report
fi

cp -r target/scala-*/scoverage-report/* public/scoverage-report/