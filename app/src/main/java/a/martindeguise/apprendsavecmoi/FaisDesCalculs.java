package a.martindeguise.apprendsavecmoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.Math;

public class FaisDesCalculs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte);
        int resultat = genererAddition();
    }

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
