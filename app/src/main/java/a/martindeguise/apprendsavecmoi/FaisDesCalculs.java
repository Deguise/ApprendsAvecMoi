package a.martindeguise.apprendsavecmoi;

import java.lang.Math;

/**
 * Created by martin on 11/01/2018.
 */

public class FaisDesCalculs {

    private int generateurNombreAleatoire(int n){
        return (int) (Math.random() * n); //Pour un entier entre 0 et n-1
    }

    public int genererAddition(){
        int nb1 =  generateurNombreAleatoire(10);
        int nb2 =  generateurNombreAleatoire(10);
        int result = nb1 + nb2;
        System.out.println(nb1 + "+" + nb2 +"= ?");
        return result;
    }
}
