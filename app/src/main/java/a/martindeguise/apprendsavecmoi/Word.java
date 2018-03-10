package a.martindeguise.apprendsavecmoi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by martin on 10/03/2018.
 */

public class Word{

    private String word = "";
    private static String filepath = "dictionnaire.txt";

    public Word(){
        initWord();
    }

    public void initWord(){

        int i = (int)(Math.random() * 100000);
        while(i > 336529){
            i /= 2;
        }
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(filepath));

            int compteur = 0;
            while ((this.word = bufferedReader.readLine()) != null) {
                compteur ++;
                if (compteur == i) {
                    break;
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {

                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    }


    public String getWord() {
        return word;
    }

}
