# Happy Cube Solver
 See [Happy Cube website](http://www.happycube.com/) and [Wikipedia](https://en.wikipedia.org/wiki/Happy_Cube) 
 for more details about Happy Cube.

### Instructions
Project should be built and run using Java 1.8.

There are four Happy cubes: blue, red, violet and yellow that are encoded using ' ' and 'o' ASCII characters and
stored in the text files inside the project's resources directory. 
All the four files will be copied into the project's (or JAR's) current working directory. 
Files with solutions for all the cubes will be stored in the current working directory also.

From IDE execute *com.bipinet.cubes.cube.HappyCube.main()* .

Alternatively build with Maven ```clean install``` and execute in the terminal 
```java -jar cubes-1.0-SNAPSHOT.jar ``` 

Happy Cube pieces in input files.
                
         ooooo ooooo ooooo
         o   o o   o o   o
         o 0 o o 1 o o 2 o  
         o   o o   o o   o
         ooooo ooooo ooooo   

         ooooo ooooo ooooo
         o   o o   o o   o
         o 2 o o 4 o o 5 o  
         o   o o   o o   o
         ooooo ooooo ooooo 
 

 
 Solved Happy Cube in unfolded representation.   
                  
          ooooo ooooo ooooo
          o   o o   o o   o
          o 0 o o 1 o o 5 o  
          o   o o   o o   o
          ooooo ooooo ooooo 
 
                 ooooo
                 o   o
                 o 2 o
                 o   o
                 ooooo
 
                 ooooo
                 o   o
                 o 3 o
                 o   o
                 ooooo
 
                 ooooo
                 o   o
                 o 4 o
                 o   o
                 ooooo
           