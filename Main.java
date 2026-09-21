/**
 * Java Docs experimentation Class
 *

 * 
 * @author Zackary Nelson
 * @author Bradly Patton
 * @author Ulises Royal
 * @author Peyton Slusser
 * @version 0.1.0
 * @since 0.1.0
 * @param text file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    
    //asks what word to search for in the file
    Scanner scanner = new Scanner(System.in);
    System.out.println("What word would you like to find?");
    String ourWord = scanner.nextLine();

    //asking the user for the name of the file to search in
    System.out.println("What file would you like to read:");
    String findFile = scanner.next();
    scanner.close();

    //looking at char in search word
    int location = 0;
    char letter = ourWord.charAt(location);

    //opens file
    File file = new File(findFile);

    //reads data in file and creates a string for a line in the file
    try (Scanner myReader = new Scanner(file)) {
      while (myReader.hasNextLine()) {
        String line = myReader.nextLine();

        //searches a line in the file for a letter from search word
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == letter) {
            System.out.println("Found " + letter + " at index " + i);
          } else {
            System.out.println("Not found");
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    
  }
}
