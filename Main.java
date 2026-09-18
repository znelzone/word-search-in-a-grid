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

//random test
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.println("What word would you like to find?");
    String ourWord = scanner.next();
    scanner.close();

    //checking for letter
    int location = 0;
    char letter = ourWord.charAt(location);

    //testing file reading
    File file = new File("test.txt");
    try (Scanner myReader = new Scanner(file)) {
      while (myReader.hasNextLine()) {
        String line = myReader.nextLine();
        
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
