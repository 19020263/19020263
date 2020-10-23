package DataClass;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    static List<Word> words = new ArrayList<>();

    public static boolean duplicateWord(String word_target) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWordtarget().equals(word_target)) return false;
        }
        return true;
    }

    public static void addWord(Word newWord) {
        if(duplicateWord(newWord.getWordtarget())) {
            words.add(newWord);
        }
    }

    public static List<Word> getWords() {
        return words;
    }
}
