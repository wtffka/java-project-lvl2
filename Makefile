#Makefile

install: 
	./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain checkstyleTest

Build:
	./gradlew clean build
