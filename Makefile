all:
	javac *.java

clean:
	rm *.class

cleanlogs:
	rm logs/*

cleanall:	clean cleanlogs

	