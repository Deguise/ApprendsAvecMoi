package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Ecris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ecrit);

        // Création bouton Trace la lettre
        final ImageButton traceLettreButton = findViewById(R.id.imageButton51);
        traceLettreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, TraceLettre.class);
                startActivity(intent);
            }
        });

        // Création bouton dictee de mots
        final ImageButton dicteeMotsButton= findViewById(R.id.imageButton50);
        dicteeMotsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, DicteeDeMots.class);
                startActivity(intent);
            }
        });
    }
}
