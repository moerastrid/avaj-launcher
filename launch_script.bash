find * -name "*.java" > sources.txt
javac @sources.txt

# andere dingen:
# rm ./**/*.class -> verwijdert alle compiled files
# java Simulator ./resources/scenario.txt -> run de simulator

# vanuit root makkelijk opstarten:
# javac -d out @sources.txt
# java -cp out Simulator resources/scenario.txt
