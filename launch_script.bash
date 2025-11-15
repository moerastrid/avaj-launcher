find * -name "*.java" > sources.txt
javac @sources.txt

# andere dingen:
# rm ./**/*.class -> verwijdert alle compiled files
# java Simulator ./resources/scenario.txt -> run de simulator
