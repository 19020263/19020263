import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

    public static void insertFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:\\Documents\\GitHub\\NguyenDucDung\\sources\\dictionaries.txt"));
            String textInALine = br.readLine();
            while (textInALine != null) {
                List<String> s = new LinkedList<>();
                for(String w: textInALine.split("\\s", 2)) {
                    s.add(w);
                }
                Dictionary.addWord(new Word(s.get(0), s.get(1)));
                textInALine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dictionaryLookup() {
        String word = sc.next();
        for(Word w : Dictionary.getWords()) {
            if (word.equalsIgnoreCase(w.getWordtarget())) {
                System.out.println( w.getWordexplain());
            }
        }
    }
}
