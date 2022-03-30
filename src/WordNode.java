public class WordNode {
    public WordInfo object;
    int height;
    WordNode left;
    WordNode right;

    public WordNode(WordInfo word){
        this.object = word;
        left=right=null;
        height = 1;
    }
}