find src/ -type f -name "*.java" > sources.txt
javac -cp "lib/*" -d out/production/Oct-2022-Hackathon/ @sources.txt
java -cp "lib/*:out/production/Oct-2022-Hackathon/:resources/" Main
