package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/** 
 * Name: Mick Zeller
 * Date: March 3, 2015
 */
public class MountainApp {

   public static void main(String[] args) {
      List<Mountain> mountainList = new LinkedList<Mountain>();
      try {
      	
         Scanner input = new Scanner(new File("src/file/Mountains.csv")); //run via eclipse console
      	
         Mountain newMountain; //temp Mountain object
      	
         while (input.hasNextLine()) { //check if still have a new line
            newMountain = getMountain(input.nextLine());
            if (newMountain != null){
               mountainList.add(newMountain);
            }
         
         }
         input.close();
      	
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   	
      for(Mountain el : mountainList) {//print all elements
         System.out.println(el.toString());
      }
   	
   }

   private static Mountain getMountain(String nextLine) {
      try{
         String[] parts = nextLine.split(",");
         return new Mountain(parts[0],Integer.parseInt(parts[1]), Boolean.parseBoolean(parts[2]));
      	
      } 
      catch(Exception e) {
      	//return null in case of failure of obj initialization.
         System.err.println(nextLine + "Could not be read in as a mountain\n");
         return null;
      	
      }
   }
}
