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

public class Resultat_DicteeMots extends AppCompatActivity {

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";

    private String resultat = "";
    private String resultatUser = "";
    private String equation = "";
    private Boolean reussit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultat_dictee_mots);

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultat_DicteeMots.this, Acceuil.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        // Affichage du resultat
        TextView textView70 = findViewById(R.id.textView70); // Vrai resultat
        TextView textView71 = findViewById(R.id.textView71); // Resultat donnée par l'utilisateur
        TextView textView8 = findViewById(R.id.textView72); // Dire a l'utilisateur si son resultat est bon ou pas

        if (intent != null) {
            textView70.setText(intent.getStringExtra(EXTRA_RESULTAT));
            textView71.setText(intent.getStringExtra(EXTRA_RESULTATUSER));

            resultat = intent.getStringExtra(EXTRA_RESULTAT).toString();
            resultatUser = intent.getStringExtra(EXTRA_RESULTATUSER).toString();
            equation = intent.getStringExtra(EXTRA_RESULTAT);

            //Affichage du message pour savoir si le resultat donnée par l'utilisateur est bon ou pas
            if (resultat.equalsIgnoreCase(resultatUser)) {
                reussit = true;
                textView8.setText("Bon");
            } else {
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
