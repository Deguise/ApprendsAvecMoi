package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Clem on 20/03/2018.
 */

public class TraceLettreResultat extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trace_lettre_resultat);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);
        //System.out.println("dans result : "+score);
        TextView textView100 = findViewById(R.id.textView100);
        score = score * 10;

        textView100.setText("Ton score : " + score + " points ! \n");

        TextView textView101 = findViewById(R.id.textView101); // Vrai resultat

        if (isBetween(score, 0, 50)) {
            textView101.setText("Tu peux encore t'améliorer !");
        } else if (isBetween(score, 50, 100)) {
            textView101.setText("Pas mal du tout !");
        } else if (isBetween(score, 100, 150)) {
            textView101.setText("Waou !");
        } else if (isBetween(score, 150, 200)) {
            textView101.setText("Impressionnant !");
        } else if (isBetween(score, 200, 250)) {
            textView101.setText("Super fort !");
        } else if (isBetween(score, 300, 350)) {
            textView101.setText("T'es fort de ouf !");
        } else if (isBetween(score, 350, 400)) {
            textView101.setText("Bravo !");
        } else if (isBetween(score, 400, 450)) {
            textView101.setText("Incroyable !");
        } else if (isBetween(score, 450, 500)) {
            textView101.setText("Super fort !");
        } else {
            textView101.setText("Tu déchires tout !");
        }






        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TraceLettreResultat.this, Acceuil.class);
                startActivity(intent);
            }
        });
    }

    public static boolean isBetween(int x, int lower, int upper)
    {
        return lower <= x && x <= upper;
    }
}
