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

public class Main{
  public static void main(String[] args){
    
    //asks what word to search for in the file
    Scanner scanner = new Scanner(System.in);
    System.out.println("What word would you like to find?");
    String searchWord = scanner.nextLine();

    //asking the user for the name of the file to search in
    System.out.println("What file would you like to read:");
    String findFile = scanner.next();
    scanner.close();
    //opens file
    File file = new File(findFile);





    //loop to interate through 2d array
//    for(int row = 0, col = 0; col < searchArray; row++){
//        while(col < searchArray.lenght){
//                
//
//
//         col++;
//      }
//  }


    int location = 0;
    char letter = searchWord.charAt(location);

    try {
      //Opens the file
      Scanner fileScanner = new Scanner(file);
      List<char[]> rows = new ArrayList<>();

      //reads each line of file
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();

        //splits string into chars
        String[] parts = line.split(" ");
        char[] row = new char[parts.length];

        //converts string into chars
        for (int i = 0; i < parts.length; i++) {
          row[i] = parts[i].charAt(0);
        }
        rows.add(row);
      }

      fileScanner.close();

      //converts into 2d char array
      char[][] grid = rows.toArray(new char[0][]);

    }catch (FileNotFoundException e) {
      System.out.println("File not found: " + findFile);
    }












    /**Copys a String into a character array placing a space
     * between each character in the array.
     * @param text the string to be converted
     * @return a char array with spaces between each original character
     * @throws IllegalArgumentException if text is empty
     * @since version 0.1.1 
     */
    public static char[] convertSpacedstringtoarray(String text){

      if(text.length() == 0){
          //if the string is empty throws an exception
          throw new IllegalArgumentException("String cannont be empty.");
          //maybe should change this to "please enter a word"
      }

        
    //     } else if (text.length()==1){
    //       //if string has one character makes an array with one character
          
    //       char[] extendedArray = new char[1];
    //       extendedArray[0] = text.charAt(0);
    //       return extendedArray;
        
    //     } else (text.length()>1){
    //       //converts the string into an array of chars with
    //       //spaces between each char.
          
    //       char[] extendedArray = new char[(text.length()*2)-1];
    //       for(int arrayloc = 0, strloc = 0;strloc < text.length();arrayloc+=2, strloc++){
              
    //           extendedArray[arrayloc] = text.charAt(strloc);
          
    }


}
