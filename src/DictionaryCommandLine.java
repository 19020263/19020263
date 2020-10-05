import java.io.FileNotFoundException;
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

    static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    static void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        int choice = 1;
        while (choice != 0) {
            System.out.println("0. Close");
            System.out.println("1. Insert word");
            System.out.println("2. Delete word");
            System.out.println("3. Translate");
            System.out.println("4. Show all words");
            System.out.println("5. Search for word");
            System.out.println("6. Fix word");
            System.out.println("Your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Which word:");
                    DictionaryManagement.insertFromCommandline();
                    DictionaryManagement.insertFromFile();
                    break;
                case 2:
                    System.out.println("Which word:");
                    DictionaryManagement.deleteWord();
                    break;
                case 3:
                    System.out.println("Which word:");
                    DictionaryManagement.dictionaryLookup();
                    break;
                case 4:
                    showAllWords();
                    break;
                case 5:
                    System.out.println("Which word:");
                    dictionarySearcher();
                    break;
                case 6:
                    System.out.println("Which word:");
                    DictionaryManagement.fixWord();
                    break;
                default:
                    break;
            }
        }
    }
}
