package a.martindeguise.apprendsavecmoi;

/**
 * Created by Leo on 26/02/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Ecris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ecris);

        // Création bouton trace la lettre !
        final ImageButton tracebutton = findViewById(R.id.imageButton);
        tracebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, TraceLettre.class);
                startActivity(intent);
            }
        });

        // Création bouton dictée de mot
        final ImageButton compteObjetsButton = findViewById(R.id.imageButton2);
        compteObjetsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, DicteeDeMots.class);
                startActivity(intent);
            }
        });

        // Création bouton retour accueil
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }
}
