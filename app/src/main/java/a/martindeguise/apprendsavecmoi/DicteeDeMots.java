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
import android.media.MediaPlayer;
import java.util.Random;


public class DicteeDeMots extends AppCompatActivity {

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";
    private String word = "mot de base";
    private static String filepath = "dictionnaire.txt";

    MediaPlayer [] s = new MediaPlayer[30];
    int n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dictee_mots);

        s[0] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_abeille);
        s[1] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_ananas);
        s[2] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_artichaud);
        s[3] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_aubergine);
        s[4] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_avion);
        s[5] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_baleine);
        s[6] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_bateau);
        s[7] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_bus);
        s[8] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_champignon);
        s[9] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_chouette);
        s[10] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_citron);
        s[11] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_citrouille);
        s[12] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_fusee);
        s[13] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_gant);
        s[14] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_graine);
        s[15] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_haricot);
        s[16] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_helicoptere);
        s[17] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_herisson);
        s[18] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_koala);
        s[19] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_loup);
        s[20] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_myrtille);
        s[21] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_oignon);
        s[22] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_orage);
        s[23] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_pasteque);
        s[24] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_pelle);
        s[25] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_pluie);
        s[26] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_radis);
        s[27] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_soleil);
        s[28] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_velo);
        s[29] = MediaPlayer.create(DicteeDeMots.this,R.raw.dictee_voiture);

        //lancement du son de façon random
        for(int i =0 ;i<1;i++)
        {
            Random r = new Random();
            n = r.nextInt(30);

            s[n].start();
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
                if(compteur == n+1){
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
                Intent intent = new Intent(DicteeDeMots.this, PopActivity.class);
                startActivity(intent);
            }
        });

        // Affichage du mot que l'enfant doit ecrire
        TextView textView25 = findViewById(R.id.textView25);
        textView25.setText(word);

        final EditText resultat = findViewById(R.id.edittext22); // AJOUTER LA EDIT TEXT

        final ImageButton okButton = findViewById(R.id.imageButton25);
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
