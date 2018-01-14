package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by martin on 13/01/2018.
 */

public class Acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_acceuil);

        // Création bouton compte avec moi !
        final ImageButton compte = findViewById(R.id.imageButton);
        compte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceuil.this, Compte.class);
                startActivity(intent);
            }
        });

        // Création bouton ecris avec moi 
        final ImageButton compteObjetsButton= findViewById(R.id.imageButton2);
        compteObjetsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceuil.this, Compte.class);
                startActivity(intent);
            }
        });
    }
}