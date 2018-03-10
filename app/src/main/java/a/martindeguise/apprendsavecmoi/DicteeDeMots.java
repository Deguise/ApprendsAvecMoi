package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DicteeDeMots extends AppCompatActivity {

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";

    private Word mot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mot = new Word();
        setContentView(R.layout.layout_dictee_mots);

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
        textView25.setText(mot.getWord());

        // Affichage dans le terminal du mot à dicter
        //System.out.println(mot.getWord());

        final EditText resultat = findViewById(R.id.edittext22); // AJOUTER LA EDIT TEXT

        final Button okButton = findViewById(R.id.button25);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DicteeDeMots.this, Resultat_DicteeMots.class);
                intent.putExtra(EXTRA_RESULTATUSER, resultat.getText());
                intent.putExtra(EXTRA_RESULTAT, mot.getWord());
                startActivity(intent);
            }
        });
    }

}
