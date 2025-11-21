find * -name "*.java" > sources.txt
javac @sources.txt

#javac -d target @sources.txt && java -cp target ajav/Simulator resources/scenario.txt