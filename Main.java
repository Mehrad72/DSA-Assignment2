package com.assignment2;

public class Main {

    public static void main(String[] args) {
        Dictionary newDictionary = new Dictionary();

        System.out.println(newDictionary.insert("1000", ""));
        System.out.println(newDictionary.insert("a", ""));
        System.out.println(newDictionary.insert("ability", ""));
        System.out.println(newDictionary.insert("able", "can do things"));

        newDictionary.printWordList();
        System.out.println("The Count of the words in the dictionary is: " + newDictionary.getCount());

        if(newDictionary.isBalanced(newDictionary.root)){
            System.out.println("Tree is Balanced");
        }
        else{
            System.out.println("Tree is not balanced");
        }

        System.out.println();
        System.out.println("Does the word 1000 exist?: " + newDictionary.exists("1000"));
        System.out.println("Does the word banana exist?: " + newDictionary.exists("banana"));
        System.out.println();
        System.out.println(newDictionary.delete("1000"));
        System.out.println();
        System.out.println(newDictionary.getMeaning("able"));
        System.out.println(newDictionary.printWordList());

    }
}
