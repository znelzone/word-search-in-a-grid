/**
 * 
 * 
 * @author Zackary Nelson
 * @author Bradly Patton
 * @author Ulises Royal
 * @author Peyton Slusser
 * @version 0.1.0
 * @since 0.1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){

    //testing file reading
    File file = new File("test.txt");
    try (Scanner myReader = new Scanner(file)) {
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    Scanner scanner = new Scanner(System.in);
    //System.out.println("What word would you like to find?");
    String ourWord = scanner.next();
    //temp print statement inorder to check that the answer input actually was saved.
    System.out.println(ourWord);

    //required to close scanner
    scanner.close();
  }
}
