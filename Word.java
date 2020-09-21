public class Word {
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

    Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
}
