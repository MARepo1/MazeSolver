import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class GridReader{ 
	
	private char[][] grid;
	private String fileName;

//gridreader start
public GridReader(String fileName) throws FileNotFoundException{ // fixes try and catch exception
      
   this.fileName = fileName;
   
   Scanner scan = new Scanner(new File(fileName));
  
   int row = 0;
   int col = 0;
   String line;
   
   while(scan.hasNextLine()){
      
      line = scan.nextLine(); 
      ++row; 
   }
   
   grid = new char[row][];
   
   
   scan = new Scanner(new File(fileName));
   
  
  for (int i = 0; i < grid.length; i++){
      line = scan.nextLine();
      grid[i] = new char[line.length()];
         for(int j = 0; j < grid[i].length; ++j){
             grid[i][j] = line.charAt(j);
            }
   }
     scan.close();
}
 
 
   

//gridreader end

//toString start
public String toString() { 

   String stringGrid = "";

   for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
         stringGrid = stringGrid + grid[i][j];
      }
     
      stringGrid = stringGrid + "\n";
   }
  
   return stringGrid;
       
   
  }
//toString end

//getCopy start
public char[][] getCopy(){

    
      if(fileName == null){ // returns null if file is not found
      return null;
      }
      
      char[][] gridCopy = new char[grid.length][]; // line 81
   
      for (int i = 0; i < grid.length; i++) {
         gridCopy[i] = new char[grid[i].length];
         for (int j = 0; j < grid[i].length; j++) {
            gridCopy[i][j] = grid[i][j];
         }
      }
      return gridCopy;
}
//getCopy end

//getFileName start
public String getFileName()throws FileNotFoundException{ 
   return fileName; // returns filename intialized in constructor
}
//getFileName end

} //end class
