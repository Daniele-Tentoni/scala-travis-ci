if [ ! -d "public" ]; then
	mkdir public
fi

cp -fr source/* public/

if [ ! -d "public/js" ]; then
	mkdir public/js
fi

sbt fastOptJS

cp target/scala-*/*.js public/js/
