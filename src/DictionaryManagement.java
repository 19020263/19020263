import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class DictionaryManagement {

    public static Scanner sc = new Scanner(System.in);
    private static final String FILENAME = "D:\\Documents\\GitHub\\NguyenDucDung\\sources\\dictionaries.txt";

    public static void insertFromCommandline() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = sc.nextLine();
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
        for(int i = 0; i < Dictionary.getWords().size(); i++) {
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

    public static void deleteWord() throws FileNotFoundException {
        String s = sc.nextLine();
        for(int i = 0; i < Dictionary.getWords().size(); i++) {
            if(s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordtarget()) || s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordexplain()) ) {
                Dictionary.getWords().remove(i);
            }
        }
        PrintWriter writer = new PrintWriter(FILENAME);
        writer.print("");
        writer.close();
        exportToFile();
    }

    public static void fixWord() throws FileNotFoundException {
        String s = sc.nextLine();
        for(int i = 0; i < Dictionary.getWords().size(); i++) {
            if(s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordtarget()) || s.equalsIgnoreCase(Dictionary.getWords().get(i).getWordexplain()) ) {
                System.out.println("Change old word to:");
                Dictionary.getWords().get(i).setWordtarget(sc.nextLine());
                System.out.println(("Meaning:"));
                Dictionary.getWords().get(i).setWordexplain(sc.nextLine());
            }
        }
        PrintWriter writer = new PrintWriter(FILENAME);
        writer.print("");
        writer.close();
        exportToFile();
    }

    public static void insertFromFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            String textInALine = br.readLine();
            while (textInALine != null) {
                List<String> s = new LinkedList<>();
                Collections.addAll(s, textInALine.split("\\s", 2));
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
