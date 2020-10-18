package DataClass;


import java.util.Scanner;

public class DictionaryCommandLine {

    public static Scanner sc = new Scanner(System.in);


    static void showAllWords() {
        System.out.println("NO     | English     | Vietnamese");
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            System.out.printf("%-6d | %-11s | %s \n",
                    (i + 1),
                    Dictionary.getWords().get(i).getWordtarget(),
                    Dictionary.getWords().get(i).getWordexplain());
        }
    }

    static void dictionarySearcher() {
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("English     | Vietnamese");
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            if(Dictionary.getWords().get(i).getWordtarget().toLowerCase().indexOf(s.toLowerCase()) == 0) {
                System.out.printf("%-11s | %s \n",
                        Dictionary.getWords().get(i).getWordtarget(),
                        Dictionary.getWords().get(i).getWordexplain());
            }
        }
    }

}
