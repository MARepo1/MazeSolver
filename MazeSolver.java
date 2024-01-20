/*
In collbaration with Luke, Adib, and Kareem.
*/
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


   public class MazeSolver{ // class start
	
      private final char OPEN = '.';
      private final char BLOCKED = '#';
      private final char START = 'S';
      private final char GOAL = 'G';
      private final char MARKED = '+';
      private final char UNMARKED = 'x';
   

   
      private char[][] maze;
      private ArrayList<String> mazePath; // need arraylist
   
      private int numCellsVisited;
      private int mazesSolved;
      private int mazesTried;
      
      
      
   //MazeSolver start
   public MazeSolver(){ // An object for reading files into a 2-D array.
     
  
      
      
   }
 
   //MazeSolver end

   //solveMaze start
   public boolean solveMaze(char[][] maze){
   
      this.maze = maze;
    
    mazePath = new ArrayList<String>();
    int mazeRow = 0; // row 
    int mazeColumn = 0; // column
    
    
    for (int y = 0; y < maze.length; y++){
      for(int x = 0; x < maze[y].length; x++){
            if(maze[y][x] == START){
               mazeRow = y;
               mazeColumn = x;
            }
            
            
      }
    }
  
    maze[mazeRow][mazeColumn] = OPEN;
    
    
    boolean result = findPath(mazeColumn,mazeRow);
    mazesTried++;
    
    if(result == true){
      mazesSolved++;
    }
    
    maze[mazeRow][mazeColumn] = START;
     
    return result;
   }
 
   //solveMaze end
   
   //findPath start
   public boolean findPath(int x, int y){   // x = column and y = row
	   
   if((y < 0 || y >= maze.length) || (x < 0 || x >= maze[y].length)){ // Checks if array is out of bounds
      return false;
   }
	   
   if(maze[y][x] == GOAL){ // Checks if at maze is at the goal
      return true;
   }
   
   if(maze[y][x] != OPEN){ // If x,y is not open
      return false;
   }

   maze[y][x] = MARKED;
	
   
   if(maze[y][x] == OPEN && maze[y][x] == MARKED){
         numCellsVisited++;
   }
   
 
   if(findPath(x,y-1) == true){ // North
      mazePath.add("North");
      return true;
      
     
   }
   if(findPath(x+1,y) == true){ // East
      mazePath.add("East");
      return true;
      
     
   }
   if(findPath(x,y+1) == true){ // South
      mazePath.add("South");
      return true;
      
     
   }
   if(findPath(x-1,y) == true){ // West
      mazePath.add("West");
      return true;
      
   }
      maze[y][x] = UNMARKED; 
      
  	
	return false;
   }
 
   //findPath end

   //getMoves start
   public String[] getMoves() { // Method should return the mazePath as an array or null if the maze was not solved.
     
     
     
     String moves[] = new String[mazePath.size()];
      
     for(int i = 0; i < mazePath.size(); i++){
         moves[moves.length - 1 - i] = mazePath.get(i);
     }
     
     

     
      if(moves.length > 0)
         return moves;
      else
         return null;
   
      
    
     
   }
   
   //getMoves end

   //getNumCellsVisited start
   public int getNumCellsVisited(){
      return numCellsVisited;
   }

   //getNumCellsVisited end

   //getPerformance start
   public double getPerformance(){  
      return mazesSolved /(double)mazesTried;
   }
   
   //getPerformance end

} //end class
