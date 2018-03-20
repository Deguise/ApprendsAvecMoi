package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Leo on 19/03/2018.
 */

public class Choix_collection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choix_collection);


        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Acceuil.class);
                startActivity(intent);
            }
        });



    }
}
