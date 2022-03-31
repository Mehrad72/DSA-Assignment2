package com.assignment2;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        menu();
    }
    public static void menu() throws IOException {
        // Load the file and create new dictionary
        Dictionary newDictionary = new Dictionary();
        File myWordList = new File("wordList.txt");
        Scanner input = new Scanner(System.in);

        // Read file once and get a count of how many items are in it
        BufferedReader lineCount = new BufferedReader(new FileReader(myWordList));
        int fileLength = 0;
        while (lineCount.readLine() != null) fileLength++;
        lineCount.close();

        // Create array to store the words
        WordInfo[] wordArray = new WordInfo[fileLength];

        // Generate a balanced tree on insertion
        try {
            String stringLine;
            BufferedReader reader = new BufferedReader(new FileReader(myWordList));
            int i = 0;
            while ((stringLine = reader.readLine()) != null) {
                WordInfo wordFromFile = new WordInfo(stringLine, "");
                wordArray[i] = wordFromFile;
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has happened, try again!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int n = wordArray.length;
        newDictionary.arrayInsertBalance(wordArray, n - 1);

        if (newDictionary.isBalanced(newDictionary.root)) {
            System.out.println("Tree is Balanced");
        } else {
            System.out.println("Tree is not balanced");
        }


        int choice;
        do {
            System.out.println("1: Add new word\n" +
                    "2: Delete word\n" +
                    "3: Get meaning\n" +
                    "4: Dictionary list\n" +
                    "5: Spell check a text file.\n" +
                    "6: Exit");
            System.out.println();
            System.out.print("Your selection: ");
            while (!input.hasNextInt()) {
                System.err.println("Sorry this isn't a number");
                System.out.println(" ");
                System.out.print("Your selection: ");
                input.nextLine();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a word");
                    String word = input.next();
                    System.out.println("Enter the meaning");
                    input.nextLine();
                    String meaning = input.nextLine();
                    newDictionary.insert(word, meaning);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter a word");
                    String wordDelete = input.next();
                    if (newDictionary.delete(wordDelete)) {
                        System.out.println("The word has been removed from the dictionary");
                    } else {
                        System.out.println("Sorry this word is not in the dictionary");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter a word");
                    String wordMeaning = input.next();
                    System.out.println(newDictionary.getMeaning(wordMeaning));
                    System.out.println();
                    break;

                case 4:
                    newDictionary.printWordList();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Please tell us which file you would like spell checked");
                    System.out.println("Please enter it as fileName.txt");
                    String fileName = input.next();
                    try {
                        File wordDocument = new File(fileName);
                        Scanner reader = new Scanner(wordDocument);

                        while (reader.hasNextLine()) {
                            Scanner reader2 = new Scanner(reader.nextLine());
                            while (reader2.hasNextLine()) {
                                String wordCheck = reader2.next().toLowerCase();
                                String comma = wordCheck.replaceAll(",", "");
                                String finalWord = comma.replaceAll("[.]", "");
                                if (!newDictionary.exists(finalWord)) {
                                    System.out.println(finalWord);
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Sorry we cannot locate this file.");
                        System.out.println("Please try again.");
                    }
                    break;

                case 6:
                    System.out.println(" ");
                    System.out.println("Thank you for using this dictionary.");
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("Invalid choice");
                    System.out.println(" ");
            }
        }
        while (choice != 6);
    }
}
