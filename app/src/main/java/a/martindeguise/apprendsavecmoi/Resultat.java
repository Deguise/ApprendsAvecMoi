package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by martin on 12/01/2018.
 */

public class Resultat extends AppCompatActivity{

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";
    final String EXTRA_EQUATION = "Equation";

    private String resultat = "";
    private String resultatUser = "";
    private String equation = "";
    private Boolean reussit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultat);

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultat.this, Acceuil.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        // Affichage du resultat
        TextView textView9 = findViewById(R.id.textView9); // Vrai resultat
        TextView textView7 = findViewById(R.id.textView7); // Resultat donnée par l'utilisateur
        TextView textView8 = findViewById(R.id.textView8); // Dire a l'utilisateur si son resultat est bon ou pas
        TextView textView11 = findViewById(R.id.textView11); //Affiche le calcul fait par précédement

        if (intent != null) {
            textView9.setText(intent.getStringExtra(EXTRA_RESULTAT));
            textView7.setText(intent.getStringExtra(EXTRA_RESULTATUSER));
            textView11.setText(intent.getStringExtra(EXTRA_EQUATION));

            resultat = intent.getStringExtra(EXTRA_RESULTAT);
            resultatUser = intent.getStringExtra(EXTRA_RESULTATUSER);
            equation = intent.getStringExtra(EXTRA_EQUATION);

            //Affichage du message pour savoir si le resultat donnée par l'utilisateur est bon ou pas
            if (resultat.equals(resultatUser)){
                reussit = true;
                textView8.setText("Bon");
            }
            else{
                textView8.setText("Pas bon");
            }
            inBDD();
        }
    }

    public String getVraiResultat() {
        return resultat;
    }

    public String getResultatUser() {
        return resultatUser;
    }

    public String getEquation() {
        return equation;
    }

    public Boolean getReussit() {
        return reussit;
    }

    public void inBDD() {
        //Création d'une instance de ma classe LivresBDD
        ScoresBDD scoreBdd = new ScoresBDD(this);

        //On ouvre la base de données pour écrire dedans
        scoreBdd.open();
        //On insère le livre que l'on vient de créer
        scoreBdd.insertScore(resultat, resultatUser, equation, reussit);
        scoreBdd.close();
    }

}
