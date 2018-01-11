package a.martindeguise.apprendsavecmoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.Math;

public class FaisDesCalculs extends AppCompatActivity {

    private int nb1, nb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fais_des_calculs);

        // Affichage de l'addition
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setText(genererAddition());

        // Affichage du resultat
        // TextView textView5 = (TextView)findViewById(R.id.textView5);
        // textView5.setText(String.valueOf(resultat()));
    }

    private int generateurNombreAleatoire(int n){
        return (int) (Math.random() * n); //Pour un entier entre 0 et n-1
    }

    public String genererAddition(){
        nb1 =  generateurNombreAleatoire(10);
        nb2 =  generateurNombreAleatoire(10);
        return nb1 + "+" + nb2 +"= ?";
    }

    public int getNb1(){
        return nb1;
    }

    public int getNb2(){
        return nb2;
    }

    public int resultat(){
        return nb1 + nb2;
    }
}
