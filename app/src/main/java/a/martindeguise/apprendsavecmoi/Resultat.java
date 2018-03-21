package a.martindeguise.apprendsavecmoi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;


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
    private String reussit = "Non";

    private String FILENAME = "score.txt";

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
                reussit = "Oui";
                textView8.setText("Bon");
            }
            else{
                textView8.setText("Pas bon");
            }

            String content = "Equation: " + equation + "Resultat attendu: " + resultat + "Votre resultat: " + resultatUser + "L'exercice est reussit? " + reussit + "\n";

            writeToFile("A:\\ApprendsAvecMoi\\app\\src\\main\\assets\\", "score.txt", content);
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

    public boolean writeToFile(String directory, String filename, String data ) {
        File out;
        OutputStreamWriter outStreamWriter = null;
        FileOutputStream outStream = null;

        out = new File(new File(directory), filename);

        try {

            if (out.exists() == false) {
                out.createNewFile();
            }

            outStream = new FileOutputStream(out, true);
            outStreamWriter = new OutputStreamWriter(outStream);

            outStreamWriter.append(data);
            outStreamWriter.flush();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            return false;
        }
        return true;
    }
}
