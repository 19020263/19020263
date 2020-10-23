package DataClass;


import java.util.Scanner;

public class DictionaryCommandLine {

    public static Scanner sc = new Scanner(System.in);


    public static String showAllWords() {
        String data = "";
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            data += Dictionary.getWords().get(i).getWordtarget() + "\t" + Dictionary.getWords().get(i).getWordexplain() + "\n";
        }
        return data;
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
