package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DicteeDeMots extends AppCompatActivity {

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";
    private String word = "mot de base";
    private static String filepath = "dictionnaire.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dictee_mots);

        // Determiner la ligne du mot dans le dictionnaire
        int i = (int)(Math.random() * 100000);
        while(i > 336529){
            i /= 2;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                new InputStreamReader(getAssets().open(filepath)));

            // do reading, usually loop until end of file reading
            String mLine;
            int compteur = 0;
            while ((mLine = reader.readLine()) != null) {
                compteur++;
                if(compteur == i){
                    word = mLine;
                    break;
               }
            }
        } catch (IOException e) {
            word = e.toString();
        } finally {
            if (reader != null) {
                 try {
                     reader.close();
                 } catch (IOException e) {
                     word = e.toString();
                 }
            }
        }

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DicteeDeMots.this, Acceuil.class);
                startActivity(intent);
            }
        });

        // Affichage du mot que l'enfant doit ecrire
        TextView textView25 = findViewById(R.id.textView25);
        textView25.setText(word);

        final EditText resultat = findViewById(R.id.edittext22); // AJOUTER LA EDIT TEXT

        final Button okButton = findViewById(R.id.button25);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DicteeDeMots.this, Resultat_DicteeMots.class);
                intent.putExtra(EXTRA_RESULTATUSER, resultat.getText().toString());
                intent.putExtra(EXTRA_RESULTAT, word);
                startActivity(intent);
            }
        });
    }

}
