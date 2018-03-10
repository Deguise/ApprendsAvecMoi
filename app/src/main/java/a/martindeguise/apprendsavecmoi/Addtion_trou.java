package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by martin on 12/01/2018.
 */

public class Addtion_trou extends AppCompatActivity{
    private int nb1, nb2;

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";
    final String EXTRA_EQUATION = "Equation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addition_trou);

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Addtion_trou.this, Acceuil.class);
                startActivity(intent);
            }
        });

        // Affichage de l'addition
        final String addition = genererAddition();
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(addition);

        final EditText resultat = findViewById(R.id.edittext); // AJOUTER LA EDIT TEXT

        final Button okButton = findViewById(R.id.button5);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Addtion_trou.this, Resultat.class);
                intent.putExtra(EXTRA_RESULTATUSER, resultat.getText().toString());
                intent.putExtra(EXTRA_RESULTAT, Integer.toString(resultat()));
                intent.putExtra(EXTRA_EQUATION, addition);
                startActivity(intent);
            }
        });
    }

    private int generateurNombreAleatoire(int n) {
        return (int) (Math.random() * n); //Pour un entier entre 0 et n-1
    }

    public String genererAddition() {
        nb1 = generateurNombreAleatoire(10);
        nb2 = generateurNombreAleatoire(10);

        // On veut eviter les nombre negatif pour l'enfant
        if (nb1 > nb2){
            int temp = nb1;
            nb1 = nb2;
            nb2 = temp;
        }
        return nb1 + "+ " + "?" + " = " + nb2;
    }

    public int getNb1() {
        return nb1;
    }

    public int getNb2() {
        return nb2;
    }

    public int resultat() {
        return nb2 - nb1;
    }
}