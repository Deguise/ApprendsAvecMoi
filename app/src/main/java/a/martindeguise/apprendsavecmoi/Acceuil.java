package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.media.MediaPlayer;
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

       // MediaPlayer player = MediaPlayer.create(this, R.raw.theme1);
      //  player.setLooping(true);
      //  player.start();

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
                Intent intent = new Intent(Acceuil.this, Ecris.class);
                startActivity(intent);
            }
        });

        // Création bouton ma collection avec moi
        final ImageButton collectionButton= findViewById(R.id.imageButton3);
        collectionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceuil.this, Collection_resultat.class);
                startActivity(intent);
            }
        });
    }
}