###### 15 Puzzle game console application

Project build/run dependencies:``maven 3`` (tested with Apache Maven 3.5.2) and ``java 8``

Build project with :
```
mvn package site
```

After successful build run game:
```
java -jar target/puzzle-game-1.0.jar
```

After successful build open unit test + code coverage reports in your browser:
```
target/site/index.html
```

To check if project has at least 90% code coverage run:
```
mvn verify
``` 

Generated random game board is solvable. Proof of fact:
```
    The initial (solved) state is solvable.
    After applying some number of random legal moves it becomes shuffled. 
    You can solve board at least by repeating inversed previously applied random moves.
```
