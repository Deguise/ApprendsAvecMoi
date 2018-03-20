package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Leo on 19/03/2018.
 */

public class Collection_resultat  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_collection_resultat);

        // Création bouton collection
        final ImageButton collectionButton = findViewById(R.id.imageButton2);
        collectionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_resultat.this, Choix_collection.class);
                startActivity(intent);
            }
        });

        // Création bouton résultat
        final ImageButton boutonResultat = findViewById(R.id.imageButton);
        boutonResultat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_resultat.this, Resultat_total.class);
                startActivity(intent);
            }
        });

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton = findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_resultat.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }
}
