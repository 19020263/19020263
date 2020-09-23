public class DictionaryCommandLine {


    static void showAllWords() {
        System.out.println("NO     | English     | Vietnamese" );
        for(int i = 0; i < Dictionary.getWords().size(); i++) {
            System.out.printf("%-6d | %-11s | %s \n",
                             (i + 1),
                             Dictionary.getWords().get(i).getWordtarget(),
                             Dictionary.getWords().get(i).getWordexplain());
        }
    }

    static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
}
