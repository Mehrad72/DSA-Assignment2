package com.assignment2;

public class Dictionary {
    public WordNode root;

    public Dictionary(){
        root = null;
    }

    public boolean insert(String word, String meaning){
        WordInfo newWord = new WordInfo(word, meaning);
        WordNode newNode = new WordNode(newWord);
        if(root == null){
            root = newNode;
            return true;
        }
        WordNode parent;
        WordNode current;
        parent = current = root;
        while(current != null){
            parent = current;
            if(newWord.word.compareTo(current.word.word) <= 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        if(newWord.word.compareTo(parent.word.word) <= 0){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }
        return true;
    }

    public String printWordList(){
        recursiveInOrder(root);
        return "";
    }
    private void recursiveInOrder(WordNode current){
        if (current == null) return;
        recursiveInOrder(current.left);
        System.out.println(current.word.word + " ");
        recursiveInOrder(current.right);
    }

    boolean isBalanced(WordNode node){
        int lh;
        int rh;

        if(node == null){return true;}

        lh = height(node.left);
        rh = height(node.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    int height(WordNode node){
        if(node == null){return 0;}
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
