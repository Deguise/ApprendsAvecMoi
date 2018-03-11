package a.martindeguise.apprendsavecmoi;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by martin on 11/03/2018.
 */

public class Score implements Serializable{

    private long id;
    //private Date date;
    private String resultat;
    private String resultatUser;
    private String equation;
    private String reussit;
    private static final AtomicInteger count = new AtomicInteger(0);

    private static List<Score> scores;
    private String filePath = "score.ser";

    public Score(){

    }

    public Score(String resultat, String resultatUser, String equation, String reussit) {
        this.id = count.incrementAndGet();
        this.resultat = resultat;
        this.resultatUser = resultatUser;
        this.equation = equation;
        this.reussit = reussit;
    }

    public long getId() {
        return id;
    }

    public String getResultat() {
        return resultat;
    }

    public String getResultatUser() {
        return resultatUser;
    }

    public String getEquation() {
        return equation;
    }

    public String getReussit() {
        return reussit;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public void setResultatUser(String resultatUser) {
        this.resultatUser = resultatUser;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public void setReussit(String reussit) {
        this.reussit = reussit;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nEquation: " + equation + "\nResultat attendu: " + resultat + "\nVotre resultat: " + resultatUser + "L'exercice est reussit? " + reussit;
    }

    public void saveScores(List<Score> score) {
        // Enrengistrement dans un fichier text
        try {
            // write object to file
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(score);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Score> getAllScores() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Score> scores = (List<Score>) ois.readObject();
        return scores;
    }

    public static List<Score> getScores() {
        return scores;
    }

    public void setScore(Score score){
        scores.add(score);
    }
}
