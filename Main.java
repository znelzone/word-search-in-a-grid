
/**
 * Reads a text file and searches for a word within the file.
 * If the word is found, will return found,
 * otherwise will return not found.
 * 
 * @author Zackary Nelson
 * @author Bradly Patton
 * @author Ulises Royal
 * @author Peyton Slusser
 * @version 0.1.2
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

    boolean wordFound = false;

    // asks what word to search for in the file
    Scanner scanner = new Scanner(System.in);
    System.out.println("What word would you like to find?");
    String searchWord = scanner.nextLine();

    // asking the user for the name of the file to search in
    System.out.println("What file would you like to read:");
    String gridFile = scanner.nextLine();
    scanner.close();

    // creates our 2D array that we will be converting our file into
    char[][] ourGrid = null;

    // tries to read the specified file and convert its content into a 2D char array
    // while eliminating the spaces between characters from the original file for
    // easier searching for the searchWord
    try {
      // places the desired file into our file variable wordBoard
      File wordBoard = new File(gridFile);
      // create a filescanner ie open our file
      Scanner fileScanner = new Scanner(wordBoard);

      // makes the char list and fills it with the rows of words from our file.
      List<char[]> rowList = new ArrayList<char[]>();
      while (fileScanner.hasNextLine()) {
        String wordBoardLine = fileScanner.nextLine();
        char[] row = convertSpacedStringToArray(wordBoardLine);
        rowList.add(row);
      }
      fileScanner.close();

      // converts our List of char[] named rowList into 2d ourGrid char array
      ourGrid = rowList.toArray(new char[0][]);

    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + gridFile);
    }

    // this set of if statements utilizes a set of three methods to determine
    // if the word we're looking for is infact in the text file
    if (horizontalSearch(ourGrid, searchWord)) {
      wordFound = true;
    } else if (verticalSearch(ourGrid, searchWord)) {
      wordFound = true;
    } else if (diagonalSearch(ourGrid, searchWord)) {
      wordFound = true;
    }

    // final output statement's
    if (wordFound) {
      System.out.println("Your Word Found!");
    } else {
      System.out.println("Your Word Not Found");
    }

    // end of main method
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

    // end of convertSpacedStringToArray method
  }

  /**
   * Searches diagonally through a 2D array for a string.
   * 
   * @param twoDArray a 2D array to be searched through diagonally
   * @param text      the String we're looking for in the 2D array
   * @return true or false based on if the string was found
   * @since version 0.1.2
   */
  public static boolean diagonalSearch(char[][] twoDArray, String text) {

    return false;

    // end of diagonalSearch method
  }

  /**
   * Searches horizontally through a 2D array for a string
   * 
   * @param twoDArray a 2D array to be searched through horizontally
   * @param text      the String we're looking for in the 2D array
   * @return true or false based on if the string was found
   * @since version 0.1.2
   */
  public static boolean horizontalSearch(char[][] twoDArray, String text) {

    // horizontal search
    // goes through each row
    for (int row = 0; row < twoDArray.length; row++) {

      // goes through the columns without falling out of the array
      for (int col = 0; col <= twoDArray[row].length - text.length(); col++) {
        boolean match = false;

        //compares each index of text with the current starting point being whichever
        //column the column loop is currently pointing at
        for (int wordIndex = 0; wordIndex < text.length(); wordIndex++) {
          
          if (twoDArray[row][col + wordIndex] == text.charAt(wordIndex)) {
            match = true;
          } else {
            // if at any point the word doesn't match with whats in the row
            // break out of loop after recording a false value. this will
            // cause loops to move to the next col
            match = false;
            break;
          }
        }
        //having made it out of the word checking loop, if every char was a match
        //then this if statement should trigger and cause the method to return true
        //it has found a matching word.
        if (match) {
          return true;
        }
      }
    }
    return false;
    // end of horizontalSearch method
  }

  /**
   * Searches vertically through a 2D array for a string
   * 
   * @param twoDArray a 2D array to be searched through vertically
   * @param text      the String we're looking for in the 2D array
   * @return true or false based on if the string was found
   * @since version 0.1.2
   */
  public static boolean verticalSearch(char[][] twoDArray, String text) {

    //vertical search
    //goes through each column
    for(int col = 0; col < twoDArray[0].length; col++){
      
      //goes through each row without falling off the bottom
      for(int row = 0; row <= twoDArray.length-text.length(); row++){
        boolean match = false;

        //compares each index w each character
        //if it finds a match the loop keeps going
        //if it doesn't find a match the loop breaks and moves to the
        //next row and searches from there again.
        for(int wordIndex = 0; wordIndex < text.length(); wordIndex++){
          if(twoDArray[row + wordIndex][col]==text.charAt(wordIndex)){

            match = true;
          } else {
            match = false;
            break;
          }
        }
        
        //having made it out of the word checking loop, if every char was a match
        //then this statement should trigger and cause the method to return true
        //it has found a matching word.
        if(match){
          return true;
        }
      }
    }
    return false;

    // end if verticalSearch method
  }

  // end of Main class
}
