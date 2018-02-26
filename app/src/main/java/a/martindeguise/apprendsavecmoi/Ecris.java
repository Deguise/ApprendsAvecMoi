package a.martindeguise.apprendsavecmoi;

/**
 * Created by Leo on 26/02/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Ecris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte);

        // Création bouton trace la lettre
        final ImageButton tracelalettreButton = findViewById(R.id.imageButton);
        tracelalettreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, Trace_la_lettre.class);
                startActivity(intent);
            }
        });

        // Création bouton dictée de mot
        final ImageButton dicteeButton= findViewById(R.id.imageButton2);
        dicteeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ecris.this, Dictee_de_mot.class);
                startActivity(intent);
            }
        });
    }
}