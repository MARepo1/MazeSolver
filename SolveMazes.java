/*
In collbaration with Luke, Adib, and Kareem.
*/
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SolveMazes extends MazeSolver{
public static void main(String[] args)throws FileNotFoundException{


Scanner kb = new Scanner(System.in);
String filename;
String [] temp = null;
MazeSolver testMaze = new MazeSolver();
 // Still working on this 

   System.out.println();
   System.out.print("Enter a filename or 'stop' to exit: ");
   filename = kb.nextLine();
   
while(!(filename.equals("stop"))){
   
   
   
   GridReader grid = new GridReader(filename);
   
   
   char[][] maze = grid.getCopy();
   
   
   System.out.println(filename + " grid: ");
   System.out.print(grid.toString());
   System.out.println();
   System.out.println(testMaze.solveMaze(maze));
   temp = testMaze.getMoves();
   System.out.println(Arrays.toString(temp));
   
   
   System.out.println();
   System.out.print("Enter a filename or 'stop' to exit: ");
   filename = kb.nextLine();
   
   
   
    
   
 }
   int total = (int)(testMaze.getPerformance() * 100);
   System.out.println("Your Performance: " + total + "%");





   
   }
}
