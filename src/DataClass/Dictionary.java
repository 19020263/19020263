package DataClass;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    static List<Word> words = new ArrayList<>();
    static int num = 0;

    static boolean duplicateWord(String word_target) {
        for (int i = 0; i < num; i++) {
            if (words.get(i).getWordtarget().equals(word_target)) return false;
        }
        return true;
    }

    public static void addWord(Word newWord) {
        words.add(newWord);
        num++;
    }

    public static List<Word> getWords() {
        return words;
    }
}
