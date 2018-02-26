package a.martindeguise.apprendsavecmoi;

/**
 * Created by Leo on 26/02/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Trace_la_lettre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte);

        // Création bouton facile
        final ImageButton facileButton = findViewById(R.id.imageButton);
        facileButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trace_la_lettre.this, Tracelalette_facile.class);
                startActivity(intent);
            }
        });

        // Création bouton difficile
        final ImageButton difficileButton= findViewById(R.id.imageButton2);
        difficileButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trace_la_lettre.this, Tracelalettre_difficile.class);
                startActivity(intent);
            }
        });
    }
}
