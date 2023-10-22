import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Word{
    public Word(String word) {
        this.word = word;
        this.num = 1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum() {
        num ++;
    }
    private String word ;
    private int num ;
    public int compareTo(String word){
        return this.word.compareTo(word) ;
    }
}
class ListWord{
    public ListWord() {
        wordList = new ArrayList<>() ;
    }

    public List<Word> wordList ;
    public void insert(String word){
        if (!check(word)){
            Word word1 = new Word(word) ;
            wordList.add(word1) ;
        }
        else {
            for ( int i = 0 ; i < wordList.size() ; i++){
                if (wordList.get(i).compareTo(word) == 0){
                    wordList.get(i).setNum();
                }
            }
        }
    }
    public boolean check(String word){
        if (wordList.isEmpty()){
            return false ;
        }
        for ( int i = 0 ; i < wordList.size() ; i++){
            if (wordList.get(i).compareTo(word) == 0){
                return true ;
            }
        }
        return false ;
    }
    public void sort(){
        for ( int i = 0 ; i < wordList.size() ; i++){
            for ( int j = i + 1 ; j < wordList.size() ; j++){
                if (wordList.get(i).compareTo(wordList.get(j).getWord()) > 0){
                    Word tmp = wordList.get(i) ;
                    wordList.set(i , wordList.get(j)) ;
                    wordList.set(j , tmp) ;
                }
            }
        }
    }
    public void print(){
        for ( int i = 0 ; i < wordList.size();i++){
            System.out.println(wordList.get(i).getWord() + " " + wordList.get(i).getNum());
        }
    }
}
public class dem_tu {
    public static void main(String[] args) throws FileNotFoundException {
        ListWord listWord = new ListWord() ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\test.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("\\s+");
                for ( int i = 0  ;i < arr.length ; i++){
                    listWord.insert(arr[i]);
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        listWord.sort();
        listWord.print();
    }
}
