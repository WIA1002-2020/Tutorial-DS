/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial01;

/**
 *
 * @author muham
 */
public class Sentence {
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public int length() {
        return sentence.length();
    }

    public int noVowel() {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char cha = sentence.charAt(i);
            if (cha == 'a' || cha == 'e' || cha == 'i' || cha == 'o' || cha == 'u' || cha == 'A' || cha == 'E' || cha == 'I' || cha == 'O' || cha == 'U') {
                ++count;
            }
        }
        return count;
    }

    public int noWords() {
        int count = 0;
        for (int i = 0; i < sentence.length() - 1; i++) {
            if (sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i + 1)) && (i > 0)) {
                count++;
            }
        }
        count++;
        return count;
    }
    
    @Override
    public String toString(){
        return ("The sentence is: "+ sentence +
                "\nThe length of sentence: "+ length() +
                "\nThe number of vowels: "+ noVowel() +
                "\nThe number of words: "+ noWords());
    }
}
