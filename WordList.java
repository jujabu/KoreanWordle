import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// A class that takes inn  a csv-file and converts it into a list/array of Word

public class WordList {

    private File csvFile;
    private Word[] wordList;

    public WordList(String csvName) {

        csvFile = new File(csvName);
        scanCsvFile(csvFile);
    }

    private int getFileLength(File csvFile) {

        int length = 0;

        try (Scanner scan = new Scanner(csvFile)) {

            while(scan.hasNextLine()) {

                scan.nextLine();
                length++;
            }

            scan.close();
        }
        catch (FileNotFoundException e) {
            
            System.err.println("Error: File not found at " + csvFile);
            e.printStackTrace();
        }

        return length;
    }

    private void scanCsvFile(File csvFile) {

        wordList = new Word[getFileLength(csvFile)];
        int wordListNr = 0;

        //Write this in PowerShell: chcp 65001
        try (Scanner scan = new Scanner(csvFile)) {

            while(scan.hasNext()) {

                //Gets the next line and splits it by ";"
                String line = scan.nextLine();
                String[] lineData = line.split(";");

                //Adds the word to the word-list
                Word newWord = new Word(Integer.parseInt(lineData[0]), lineData[1], lineData[2]);
                wordList[wordListNr] = newWord;
                wordListNr++;
            }

            scan.close();
        }   
        catch (FileNotFoundException e) {
            System.err.println("Error: File not found at " + csvFile);
            e.printStackTrace();
        }
    }

    //Might need to add a bat-file to start the program at the end
    private void setTerminal() {
        
        try {
            new ProcessBuilder("cmd", "/c", "chcp 65001").inheritIO().start().waitFor();

        } catch (Exception e) {
            System.err.println("Could not change sign interpretation: " + e.getMessage());
        }
    }

    public void print() {

        if(wordList == null) {
            return;
        }
        
        setTerminal();

        for(Word word : wordList) {

            System.out.println(
                word.getNumber() + ": " + word.getWord() + " - " + word.getTranslation()
            );
        }
    }
}