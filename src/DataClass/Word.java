package DataClass;

public class Word implements Comparable<Word>{
    String word_target;
    String word_explain;


    public String getWordtarget() {
        return word_target;
    }

    public void setWordtarget(String word_target) {
        this.word_target = word_target;
    }

    public String getWordexplain() {
        return word_explain;
    }

    public void setWordexplain(String word_explain) {
        this.word_explain = word_explain;
    }

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    @Override
    public int compareTo(Word o) {
        return this.getWordtarget().compareTo(o.getWordtarget());
    }
}
