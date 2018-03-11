package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by martin on 12/01/2018.
 */

public class Resultat_DicteeMots extends AppCompatActivity {

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";

    private String resultat = "";
    private String resultatUser = "";
    private String equation = "";
    private String reussit = "Non";

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
                reussit = "Oui";
                textView8.setText("Bon");
            } else {
                textView8.setText("Pas bon");
            }
            // Enrengistrement dans un fichier text
            Score score = new Score(resultat, resultatUser, equation, reussit);
            try {
                // write object to file
                FileOutputStream fileOut = new FileOutputStream("score.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fileOut);
                oos.writeObject(score);
                oos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public String getReussit() {
        return reussit;
    }

}
