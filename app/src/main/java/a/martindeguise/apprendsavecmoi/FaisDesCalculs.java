package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FaisDesCalculs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fais_des_calculs);

        // Création bouton addition
        final ImageButton additionButton = findViewById(R.id.imageButton2);
        additionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaisDesCalculs.this, Consigne_addition.class);
                startActivity(intent);
            }
        });

        // Création bouton addition a trou
        final ImageButton additionTrouButton = findViewById(R.id.imageButton);
        additionTrouButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaisDesCalculs.this, Consigne_additionTrou.class);
                startActivity(intent);
            }
        });

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaisDesCalculs.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }
}
