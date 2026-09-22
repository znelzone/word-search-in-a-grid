
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

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {


    // asks what word to search for in the file
    Scanner scanner = new Scanner(System.in);
    System.out.println("What word would you like to find?");
    String searchWord = scanner.nextLine();

    // asking the user for the name of the file to search in
    System.out.println("What file would you like to read:");
    String gridFile = scanner.nextLine();
    scanner.close();


    // tries to read the specified file and convert its content into a 2D char array
    try {
      // places the desired file into our file variable wordBoard
      File wordBoard = new File(gridFile);
      // create a filescanner ie open our file
      Scanner fileScanner = new Scanner(wordBoard);

      //makes the char list and fills it with the rows of words from our file.
      List<char[]> rowList = new ArrayList<char[]>();
      while (fileScanner.hasNextLine()) {
        String wordBoardLine = fileScanner.nextLine();
        char[] row = convertSpacedStringToArray(wordBoardLine);
        rowList.add(row);
      }
      fileScanner.close();

      // converts into 2d char array
      char[][] ourGrid = rowList.toArray(new char[0][]);

    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + gridFile);
    }




    
  }

  /**
   * Converts a String where each char has a space
   * in between into a Char[] that eliminates the spaces
   * between chars.
   * 
   * @param text the string to be converted
   * @return a char array without spaces between each char
   * @throws IllegalArgumentException if text is empty
   * @since version 0.1.1
   */
  public static char[] convertSpacedStringToArray(String text) {

    if (text.length() == 0) {
      // if the string is empty throws an exception
      throw new IllegalArgumentException("String cannot be empty.");

    } else if (text.length() == 1) {
      // if string has one character makes an array with one character
      char[] nonSpaced = text.toCharArray();
      return nonSpaced;

    } else {
      // converts the string into an array of characters without
      // spaces between the characters.
      char[] nonSpaced = new char[(text.length() + 1) / 2];

      for (int arrayind = 0, textind = 0; textind < text.length(); arrayind++, textind += 2) {
        nonSpaced[arrayind] = text.charAt(textind);
      }
      return nonSpaced;
    }
  }

}
