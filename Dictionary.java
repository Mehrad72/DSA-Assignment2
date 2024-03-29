package com.assignment2;

import java.util.Objects;

public class Dictionary {
     WordNode root;

    public Dictionary(){
        root = null;
    }

    WordNode arrayToTree(WordInfo[] array, int start, int end){
        //Base Case
        if(start > end){
            return null;
        }

        // Middle Element of the array
        int mid = (start + end) / 2;
        WordNode node = new WordNode(array[mid]);

        // Recursively build down the tree
        node.left = arrayToTree(array, start, mid - 1);
        node.right = arrayToTree(array, mid + 1, end);

        return node;
    }

    WordNode arrayInsertBalance(WordInfo[] wordList, int n){
        return root = arrayToTree(wordList,0, n);
    }

    public boolean insert(String word, String meaning){
        WordInfo newWord = new WordInfo(word.toLowerCase(), meaning.toLowerCase());
        WordNode newNode = new WordNode(newWord);

        if(!exists(word)){
            if(root == null){
                root = newNode;
                return true;
            }

            WordNode parent;
            WordNode current;
            parent = null;
            current = root;

            while(current != null){
                parent = current;
                if(newWord.word.compareTo(current.object.word) <= 0){
                    current = current.left;
                }
                else{
                    current = current.right;
                }
            }
            if(newWord.word.compareTo(parent.object.word) <= 0){
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
            return true;
        }
        System.out.println("This word already exists use another word");
        return false;
    }

    public String printWordList(){
        recursiveInOrder(root);
        return "";
    }
    private void recursiveInOrder(WordNode current){
        if (current == null) return;
        recursiveInOrder(current.left);
        System.out.println(current.object.word + " ");
        recursiveInOrder(current.right);
    }

    public int getCount(){
        return recursivePostOrderCount(root);
    }

    private int recursivePostOrderCount(WordNode current){
        int count = 1;
        if(current == null) { return 0; }
        else{
            count += recursivePostOrderCount(current.left);
            count += recursivePostOrderCount(current.right);
            return count;
        }
    }
    public void printDictionary(){
        System.out.println(recursivePostOrderPrint(root));
    }
    private boolean recursivePostOrderPrint(WordNode current){
        if(current == null) return false;
        recursivePostOrderPrint(current.left);
        recursivePostOrderPrint(current.right);
        System.out.println("Word: " + current.object.word + " Meaning: "  + current.object.meaning);

        return false;
    }

    public boolean exists(String word){
       WordNode current = root;
       while(current != null && !current.object.word.equals(word)){
           if(current.object.word.compareTo(word) >= 0){
               current = current.left;
           }
           else{
               current = current.right;
           }
       }
       return current != null;
    }

    public String getMeaning(String word){
        WordNode current = root;
        while(current != null && !current.object.word.equals(word)){
            if(current.object.word.compareTo(word) >= 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        if(current != null) { return current.object.meaning; }
        else{ return "Sorry this is not in the dictionary"; }

    }

    public boolean delete(String word){
        if(exists(word)){
            root = deleteRecursive(root, word);
            return true;
        }
        else{
            return false;
        }
    }

    WordNode deleteRecursive(WordNode root, String word){
        //Base Case
        if(root == null) { return null; }

        // Recursively move down the tree

        if(word.compareTo(root.object.word) < 0){
            root.left = deleteRecursive(root.left, word);
        }
        else if(word.compareTo(root.object.word) > 0){
            root.right = deleteRecursive(root.right, word);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            // Recursive Case 3
            WordNode success = root.right;
            while(success.left != null){
                success = success.left;
            }
            root.object.word = success.object.word;
            root.right = deleteRecursive(root.right, success.object.word);
        }
        return root;
    }

    boolean isBalanced(WordNode node){
        int lh;
        int rh;

        if(node == null){
            return true;
        }
        else{
            lh = heightBalnceCheck(node.left);
            rh = heightBalnceCheck(node.right);
        }

        return Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    int heightBalnceCheck(WordNode node){
        if(node == null){return 0;}
        return 1 + Math.max(heightBalnceCheck(node.left), heightBalnceCheck(node.right));
    }
}



