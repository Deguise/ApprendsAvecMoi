package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by martin on 10/03/2018.
 */

public class TraceLettre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trace_la_lettre);

        // Création bouton facile
        final ImageButton facileButton = findViewById(R.id.imageButton);
        facileButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TraceLettre.this, Consigne_Tracelettre.class);
                startActivity(intent);
            }
        });

        // Création bouton difficile
        final ImageButton difficileButton= findViewById(R.id.imageButton2);
        difficileButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TraceLettre.this, Consigne_Tracelettredifficile.class);
                startActivity(intent);
            }
        });

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TraceLettre.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }
}
