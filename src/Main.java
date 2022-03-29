import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary newDictionary = new Dictionary();
        System.out.println(newDictionary.insert("1000", ""));
        System.out.println(newDictionary.insert("a", ""));
        System.out.println(newDictionary.insert("ability", ""));
        System.out.println(newDictionary.insert("able", "can do things"));
        menu();
        try (Scanner input = new Scanner(System.in)) {
            int choice = input.nextInt();
            while(choice != 6){
                if(choice == 1){
                    System.out.println("Enter a word");
                    String word = input.next();
                    System.out.println("Enter the meaning");
                    String meaning = input.next();
                    System.out.println(newDictionary.insert(word, meaning));
                    System.out.println();
                    menu();
                    choice = input.nextInt();
                }
                if(choice == 2){
                    System.out.println("Enter a word");
                    String word = input.next();
                    System.out.println(newDictionary.delete(word));
                    System.out.println();
                    menu();
                    choice = input.nextInt();
                }
                if(choice == 3){
                    System.out.println("Enter a word");
                    String word = input.next();
                    System.out.println(newDictionary.getMeaning(word.toLowerCase()));
                    System.out.println();
                    menu();
                    choice = input.nextInt();
                }
                if(choice == 4){
                    newDictionary.printWordList();
                    if(newDictionary.isBalanced(newDictionary.root)){
                        System.out.println("Tree is Balanced");
                    }
                    else{
                        System.out.println("Tree is not balanced");
                    }
                    
                    System.out.println();
                    menu();
                    choice = input.nextInt();
                }
                if(choice == 5){
                    
                    menu();
                    choice = input.nextInt();
                }
            }
        }
    }
    public static void menu(){
        System.out.println("1: Add new word\n" +
                           "2: Delete word\n" +
                           "3: Get meaning\n" +
                           "4: Dictionary list\n" +
                           "5: Spell check a text file.\n" +
                           "6: Exit");
       System.out.println();
    }
}
