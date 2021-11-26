all: run

clean:
	rm -f out/Solver.jar out/Palindrom.jar

out/Solver.jar: out/parcs.jar src/Solver.java
	@javac -cp out/parcs.jar src/Solver.java
	@jar cf out/Solver.jar -C src Solver.class -C src
	@rm -f src/Solver.class

out/Palindrom.jar: out/parcs.jar src/Palindrom.java
	@javac -cp out/parcs.jar src/Palindrom.java
	@jar cf out/Palindrom.jar -C src Palindrom.class -C src
	@rm -f src/Palindrom.class

build: out/Solver.jar out/Palindrom.jar

run: out/Solver.jar out/Palindrom.jar
	@cd out && java -cp 'parcs.jar:Solver.jar' Solver