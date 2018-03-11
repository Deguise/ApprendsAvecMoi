package a.martindeguise.apprendsavecmoi;

import java.util.Date;
import java.io.Serializable;
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

    // Sera utilisée par ArrayAdapter dans la ListView
    @Override
    public String toString() {
        return reussit.toString();
    }
}
