/**
 * Reads a text file and searches for a word within the file.
 * If the word is found, will return found,
 * otherwise will return not found.
 * 
 * @author Zackary Nelson
 * @author Bradly Patton
 * @author Ulises Royal
 * @author Peyton Slusser
 * @version 0.1.1
 * @since 0.1.0
 * @param args
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
    //opens file
    File file = new File(findFile);


    //looking at char in search word
    int location = 0;
    char letter = ourWord.charAt(location);

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
      System.out.println("An error occurred, file not found.");
      e.printStackTrace();
    }

    
  }

    /**Copys a String into a character array placing a space
     * between each character in the array.
     * @param text the string to be converted
     * @return a char array with spaces between each original character
     * @throws IllegalArgumentException if text is empty
     * @since version 0.1.1 
     */
    public static char[] spacedChararray(String text){
        
        if(text.length() == 0){
          //if the string is empty throws an exception
          throw new IllegalArgumentException("String cannont be empty.");
          //maybe should change this to "please enter a word"
        
        } else if (text.length()==1){
          //if string has one character makes an array with one character
          
          char[] extendedArray = new char[1];
          extendedArray[0] = text.charAt(0);
          return extendedArray;
        
        } else (text.length()>1){
          //converts the string into an array of chars with
          //spaces between each char.
          
          char[] extendedArray = new char[(text.length()*2)-1];
          for(int arrayloc = 0, strloc = 0;strloc < text.length();arrayloc+=2, strloc++){
              
              extendedArray[arrayloc] = text.charAt(strloc);
              
              if(arrayloc < extendedArray.length-1){
              extendedArray[arrayloc+1] = ' ';
              }
          }
          return extendedArray;
        }
          
    }


}
