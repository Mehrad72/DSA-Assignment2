package com.assignment2;

public class WordNode {
    public WordInfo object;
    WordNode left;
    WordNode right;

    public WordNode(WordInfo word){
        this.object = word;
        left=right=null;
    }


}
