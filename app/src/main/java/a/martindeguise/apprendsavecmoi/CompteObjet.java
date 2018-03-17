package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by martin on 12/01/2018.
 */

public class CompteObjet extends AppCompatActivity{
    private int nb1, nb2, nb3;

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";
    final String EXTRA_EQUATION = "Equation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte_objet);

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompteObjet.this, Acceuil.class);
                startActivity(intent);
            }
        });

        // Definition du layout
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rowParams1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        // Creation du layout
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));// assuming the parent view is a LinearLayout

        // Creation de la premiere ligne
        TableRow tableRow1 = new TableRow(this);
        tableRow1.setLayoutParams(tableParams);// TableLayout is the parent view

        // Du texte "Compte les pommes:"
        TextView consigne = new TextView(this);
        consigne.setText("Compte les pommes:");
        consigne.setTextSize(30);
        consigne.setGravity(1); // 1 => center-horizontal

        // Creation des parametres pour la mise en forme du texte des consignes
        rowParams.span = 4;
        consigne.setLayoutParams(rowParams); // causes layout update

        // Ajout de la consigne à la premiere ligne
        tableRow1.addView(consigne);

        // Creation de la deuxième ligne
        TableRow tableRow2 = new TableRow(this);
        tableRow2.setLayoutParams(tableParams);// TableLayout is the parent view

        // On génère le nombre aléatoire de pomme pour les deux ligne
        genererLayout();

        // Création de la première ranger de pomme
        for(int x=0;x<nb1;x++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(R.drawable.pomme);
            tableRow2.addView(image);
        }


        // Creation de la troisieme ligne
        TableRow tableRow3 = new TableRow(this);
        tableRow3.setLayoutParams(tableParams);// TableLayout is the parent view

        // Création de la première ranger de pomme
        for(int x=0;x<nb3;x++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(R.drawable.pomme);
            tableRow3.addView(image);
        }

        /*
        // Ajout du signe plus à la ligne
        ImageView signePlus = new ImageView(this);
        signePlus.setBackgroundResource(R.drawable.plus);
        rowParams1.span = 4;
        rowParams1.gravity = 1;
        signePlus.setLayoutParams(rowParams1); // causes layout update
        tableRow3.addView(signePlus);
        */

        // Creation de la quatrieme ligne
        TableRow tableRow4 = new TableRow(this);
        tableRow4.setLayoutParams(tableParams);// TableLayout is the parent view

        // Création de la deuxieme ranger de pomme (ligne 4)
        for(int x=0;x<nb2;x++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(R.drawable.pomme);
            tableRow4.addView(image);
        }

        // Creation de la cinquième ligne
        TableRow tableRow5 = new TableRow(this);
        tableRow5.setLayoutParams(tableParams);// TableLayout is the parent view

        // Ajout du signe égal
        ImageView signeEgal = new ImageView(this);
        signeEgal.setBackgroundResource(R.drawable.egal);
        tableRow5.addView(signeEgal);

        // Ajout de la zone de texte editable par l'utilisateur
        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        tableRow5.addView(editText);

        // Creation du bouton de validation
        Button verifier = new Button(this);
        verifier.setText("Vérifier !");
        tableRow5.addView(verifier);

        // Ajout de la Scroll view
        ScrollView scroll = new ScrollView(this);
        //scroll.setBackgroundColor(R.color.colorAccent);
        scroll.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

        // Ajout de toutes les lignes dans le table Layout
        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);
        tableLayout.addView(tableRow4);
        tableLayout.addView(tableRow5);

        scroll.addView(tableLayout);
        setContentView(scroll);

        verifier.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompteObjet.this, Resultat.class);
                intent.putExtra(EXTRA_RESULTATUSER, editText.getText().toString());
                intent.putExtra(EXTRA_RESULTAT, Integer.toString(resultat()));
                String value = getNb1() + " pomme(s) + " + getNb2() + " pomme(s)";
                intent.putExtra(EXTRA_EQUATION, value);
                startActivity(intent);
            }
        });
    }

    private int generateurNombreAleatoire(int n) {
        return (int) (Math.random() * n) + 1; //Pour un entier entre 0 et n-1
    }

    public void genererLayout() {
        nb1 = generateurNombreAleatoire(4);
        nb2 = generateurNombreAleatoire(4);
        nb3 = generateurNombreAleatoire(4);
    }

    public int getNb1() {
        return nb1;
    }

    public int getNb2() {
        return nb2;
    }

    public int resultat() {
        return nb1 + nb2;
    }
}