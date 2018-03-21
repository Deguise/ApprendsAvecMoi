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


        // Création bouton retour accueil
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Acceuil.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton = findViewById(R.id.imageButton2);
        collectionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton2 = findViewById(R.id.imageButton);
        collectionButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection_2.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton3 = findViewById(R.id.imageButton4);
        collectionButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection_3.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton4 = findViewById(R.id.imageButton5);
        collectionButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection_4.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton5 = findViewById(R.id.imageButton6);
        collectionButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection_5.class);
                startActivity(intent);
            }
        });

        // Création bouton collection
        final ImageButton collectionButton6 = findViewById(R.id.imageButton7);
        collectionButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choix_collection.this, Collection_6.class);
                startActivity(intent);
            }
        });


    }
}
