package com.assignment2;

public class WordNode {
    public WordInfo word;
    WordNode left;
    WordNode right;

    public WordNode(WordInfo word){
        this.word = word;
        left=right=null;
    }


}
