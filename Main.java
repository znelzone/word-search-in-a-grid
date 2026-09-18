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
import java.util.Scanner;


public class Main{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("What word would you like to find?");
    String ourWord = scanner.next();
    System.out.println(ourWord);

      scanner.close();
  }
}
