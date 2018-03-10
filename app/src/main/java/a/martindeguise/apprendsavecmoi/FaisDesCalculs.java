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

        // Création bouton addtion
        final ImageButton additionButton = findViewById(R.id.imageButton63);
        additionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaisDesCalculs.this, Addition.class);
                startActivity(intent);
            }
        });

        // Création bouton addtion a trou
        final ImageButton additionTrouButton = findViewById(R.id.imageButton64);
        additionTrouButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaisDesCalculs.this, Addtion_trou.class);
                startActivity(intent);
            }
        });
    }
}
