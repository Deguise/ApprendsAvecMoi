package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.Math;

public class Addition extends AppCompatActivity {

    private int nb1, nb2;

    final String EXTRA_RESULTAT = "resultat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addtion);

        // Affichage de l'addition
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(genererAddition());

        final EditText resultat = findViewById(R.id.edittext); // AJOUTER LA EDIT TEXT

        final Button okButton = findViewById(R.id.button5);
        okButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Addition.this, Resultat.class);
                intent.putExtra(EXTRA_RESULTAT, resultat.getText().toString());
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
        return nb1 + "+" + nb2 + "= ?";
    }

    public int getNb1() {
        return nb1;
    }

    public int getNb2() {
        return nb2;
    }

    public int resultat() {
        return nb1 + nb2;
    }
}
