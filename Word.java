public class Word {

    private int number;
    private String word;
    private String translation;

    //My version 
    public Word(int number, String word, String translation) {

        this.number = number;
        this.word = word;
        this.translation = translation;
    }

    public int getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }
}