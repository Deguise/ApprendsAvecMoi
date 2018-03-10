package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Compte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte);

        // Création bouton fais des calculs
        final ImageButton faisDesCalculsButton = findViewById(R.id.imageButton40);
        faisDesCalculsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compte.this, FaisDesCalculs.class);
                startActivity(intent);
            }
        });

        // Création bouton compte objets
        final ImageButton compteObjetsButton= findViewById(R.id.imageButton42);
        compteObjetsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compte.this, CompteObjet.class);
                startActivity(intent);
            }
        });
    }
}
