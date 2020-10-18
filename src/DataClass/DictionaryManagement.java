package DataClass;


import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class DictionaryManagement {

    public static Scanner sc = new Scanner(System.in);
    private static final String FILENAME = new File("src/DictionaryApplication/dictionaries.txt").getAbsolutePath();

    public static void insertWord(String a, String b) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = a + " " + b;
            File file = new File(FILENAME);
            // if file doesnt exists, then create it
            if (!file.exists()) file.createNewFile();
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void exportToFile() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            try {
                String data = Dictionary.getWords().get(i).getWordtarget() + "   " + Dictionary.getWords().get(i).getWordexplain() + "\n";
                File file = new File(FILENAME);
                // if file doesnt exists, then create it
                if (!file.exists()) file.createNewFile();
                // true = append file
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void deleteWord(String word) throws FileNotFoundException {
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            if (word.equalsIgnoreCase(Dictionary.getWords().get(i).getWordtarget())) {
                Dictionary.getWords().remove(i);
            }
        }
        PrintWriter writer = new PrintWriter(FILENAME);
        writer.print("");
        writer.close();
        exportToFile();
    }

    public static void fixWord(String oword, String word, String wordm) throws FileNotFoundException {
        String s = oword;
        for (int i = 0; i < Dictionary.getWords().size(); i++) {
            if (s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordtarget()) || s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordexplain())) {
                Dictionary.getWords().get(i).setWordtarget(word);
                Dictionary.getWords().get(i).setWordexplain(wordm);
            }
        }
        PrintWriter writer = new PrintWriter(FILENAME);
        writer.print("");
        writer.close();
        exportToFile();
    }

    public static void insertFromFile() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(new File(FILENAME)));
        try {
            String textInALine = br.readLine();
            while (textInALine != null) {
                String[] s = textInALine.split("\\s", 2);
                Dictionary.addWord(new Word(s[0], s[1]));
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

    public static String dictionaryLookup(String s) {
        String word = s;
        String ans = "";
        for (Word w : Dictionary.getWords()) {
            if (word.equalsIgnoreCase(w.getWordtarget())) {
                ans = w.getWordexplain();
            }
        }
        return ans;
    }
}
