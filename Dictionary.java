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
        return recursivePostOrder(root);
    }

    private int recursivePostOrder(WordNode current){
        int count = 1;
        if(current == null) { return 0; }
        else{
            count += recursivePostOrder(current.left);
            count += recursivePostOrder(current.right);
            return count;
        }
    }

    public boolean exists(String word){
        WordNode current = root;
        while(current != null && !current.object.word.equals(word)){
            if(current.object.word.compareTo(word) > 0){
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
        String meaningOut = "";
        while(current != null && !current.object.word.equals(word)){
            if(current.object.word.compareTo(word) > 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        if(current != null) { meaningOut = current.object.meaning; }
        else{ meaningOut = "Sorry this is not in the dictionary"; }

        return meaningOut;
    }

    public boolean delete(String word){
        root = deleteRecursive(root, word);
        if(root != null){
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
