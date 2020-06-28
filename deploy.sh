# Copy public files and fastOpt.

if [ ! -d "public" ]; then
	mkdir public
fi

cp -fr source/* public/

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

sbt fastOptJS

cp target/scala-*/*.js* public/js/

# Copy the coverage reports.

ls -l

if [ ! -d "public/scoverage-report" ]; then
  mkdir public/scoverage-report
fi

cp target/scala-*/scoverage-report/* public/scoverage-report/