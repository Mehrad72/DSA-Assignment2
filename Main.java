package com.assignment2;

public class Main {

    public static void main(String[] args) {
        Dictionary newDictionary = new Dictionary();

        System.out.println(newDictionary.insert("b", ""));
        System.out.println(newDictionary.insert("a", ""));
        System.out.println(newDictionary.insert("c",""));
        newDictionary.printWordList();

        if(newDictionary.isBalanced(newDictionary.root)){
            System.out.println("Tree is Balanced");
        }
        else{
            System.out.println("Tree is not balanced");
        }

    }
}
