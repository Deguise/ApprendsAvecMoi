package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Leo on 12/03/2018.
 */

public class Consigne_Tracelettredifficile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trace_lettre_consigne);

        MediaPlayer player = MediaPlayer.create(this, R.raw.consignes_tracelettre);
        player.start();

        //Création bouton validé
        final ImageButton validerButton = findViewById(R.id.imageButton);
        validerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consigne_Tracelettredifficile.this, Tracelalettre_difficile.class);
                startActivity(intent);
            }
        });

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consigne_Tracelettredifficile.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }
}
