package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by martin on 12/01/2018.
 */

public class Resultat extends AppCompatActivity{

    final String EXTRA_RESULTAT = "resultat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultat);

        Intent intent = getIntent();

        // Affichage du resultat
        TextView textView6 = findViewById(R.id.textView6);
        if (intent != null) {
            textView6.setText(intent.getStringExtra(EXTRA_RESULTAT));
        }
    }
}
