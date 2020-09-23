import java.util.Scanner;

public class DictionaryManagement {

    public static Scanner sc = new Scanner(System.in);

    public static void insertFromCommandline() {
        int numWord = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < numWord; i++) {
            String word_target_ = sc.nextLine();
            String word_explain_ = sc.nextLine();
            Word newWord = new Word(word_target_, word_explain_);
            Dictionary.addWord(newWord);
        }
    }
}
