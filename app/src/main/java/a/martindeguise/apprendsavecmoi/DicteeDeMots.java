package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        // Affichage du mot que l'enfant doit ecrire
        TextView textView5 = findViewById(R.id.textView25);
        textView5.setText(mot.getSecretWord());

        final EditText resultat = findViewById(R.id.edittext2); // AJOUTER LA EDIT TEXT

        final Button okButton = findViewById(R.id.button15);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DicteeDeMots.this, Resultat_DicteeMots.class);
                intent.putExtra(EXTRA_RESULTATUSER, resultat.getText().toString());
                intent.putExtra(EXTRA_RESULTAT, mot.getSecretWord());
                startActivity(intent);
            }
        });
    }

}
