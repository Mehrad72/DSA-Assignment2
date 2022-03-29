public class WordInfo {
    public String word;
    public String meaning;

    public WordInfo(String word, String meaning) {
        this.word = word.toLowerCase();
        this.meaning = meaning.toLowerCase();
    }

    public WordInfo(String word){
        this.word = word.toLowerCase();
    }

}