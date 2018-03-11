package a.martindeguise.apprendsavecmoi;

import android.content.Context;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Leo on 10/03/2018.
 */

public class Collection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_collection);


        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Collection.this, "" +position, Toast.LENGTH_SHORT).show();
            }
        });


        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection.this, Acceuil.class);
                startActivity(intent);
            }
        });

    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem (int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            return  imageView;
        }


        private Integer[] mThumbIds = {
                R.drawable.trace_lettre_facile_camion,
                R.drawable.trace_lettre_facile_bateau,
                R.drawable.trace_lettre_facile_bus,
                R.drawable.trace_lettre_facile_scooter,
                R.drawable.trace_lettre_facile_helicoptere,
                R.drawable.trace_lettre_facile_velo,
                R.drawable.trace_lettre_facile_voiture,
                R.drawable.trace_lettre_facile_avion,
                R.drawable.trace_lettre_difficile_baleine,
                R.drawable.trace_lettre_difficile_chouette,
                R.drawable.trace_lettre_difficile_loup,
                R.drawable.trace_lettre_difficile_cochon,
                R.drawable.trace_lettre_difficile_girafe,
                R.drawable.trace_lettre_difficile_herisson,
                R.drawable.trace_lettre_difficile_koala,
                R.drawable.trace_lettre_difficile_mouton,
                R.drawable.trace_lettre_difficile_panda,
                R.drawable.trace_lettre_difficile_raton,
                R.drawable.trace_lettre_difficile_paresseux,
                R.drawable.dictee_mot_parapluie,
                R.drawable.dictee_mot_orage,
                R.drawable.dictee_mot_pluie,
                R.drawable.dictee_mot_arc_en_ciel,
                R.drawable.dictee_mot_soleil,
                R.drawable.dictee_mot_lune,
                R.drawable.dictee_mot_planete_rouge,
                R.drawable.dictee_mot_planete_bleu,
                R.drawable.dictee_mot_planete_rayee,
                R.drawable.dictee_mot_planete_anneau,
                R.drawable.dictee_mot_planete_terre,
                R.drawable.dictee_mot_fusee,
                R.drawable.compte_objets_orange,
                R.drawable.compte_objets_banane,
                R.drawable.compte_objets_cerise,
                R.drawable.compte_objets_fraise,
                R.drawable.compte_objets_mure,
                R.drawable.compte_objets_citron,
                R.drawable.compte_objets_poire,
                R.drawable.compte_objets_pomme,
                R.drawable.compte_objets_pasteque,
                R.drawable.compte_objets_myrtille,
                R.drawable.compte_objets_ananas,
                R.drawable.fais_calculs_addition_arbre,
                R.drawable.fais_calculs_addition_pelle,
                R.drawable.fais_calculs_addition_rateau,
                R.drawable.fais_calculs_addition_brouette,
                R.drawable.fais_calculs_addition_gants,
                R.drawable.fais_calculs_addition_tuyau,
                R.drawable.fais_calculs_addition_fleur,
                R.drawable.fais_calculs_addition_buisson,
                R.drawable.fais_calculs_addition_arrosoir,
                R.drawable.fais_calculs_addition_graines,
                R.drawable.fais_calculs_addition_trou_artichaud,
                R.drawable.fais_calculs_addition_trou_aubergine,
                R.drawable.fais_calculs_addition_trou_carotte,
                R.drawable.fais_calculs_addition_trou_champignon,
                R.drawable.fais_calculs_addition_trou_harricot,
                R.drawable.fais_calculs_addition_trou_oignon,
                R.drawable.fais_calculs_addition_trou_patate,
                R.drawable.fais_calculs_addition_trou_tomate,
                R.drawable.fais_calculs_addition_trou_radis,
                R.drawable.fais_calculs_addition_trou_citrouille,

        };

        private Integer[] mThumbIds2 = {
                R.drawable.trace_lettre_difficile_baleine,
                R.drawable.trace_lettre_difficile_chouette,
                R.drawable.trace_lettre_difficile_loup,
                R.drawable.trace_lettre_difficile_cochon,
                R.drawable.trace_lettre_difficile_girafe,
                R.drawable.trace_lettre_difficile_herisson,
                R.drawable.trace_lettre_difficile_koala,
                R.drawable.trace_lettre_difficile_mouton,
                R.drawable.trace_lettre_difficile_panda,
                R.drawable.trace_lettre_difficile_raton,
                R.drawable.trace_lettre_difficile_paresseux,
        };

        private Integer[] mThumbIds3 = {
                R.drawable.dictee_mot_parapluie,
                R.drawable.dictee_mot_orage,
                R.drawable.dictee_mot_pluie,
                R.drawable.dictee_mot_arc_en_ciel,
                R.drawable.dictee_mot_soleil,
                R.drawable.dictee_mot_lune,
                R.drawable.dictee_mot_planete_rouge,
                R.drawable.dictee_mot_planete_bleu,
                R.drawable.dictee_mot_planete_rayee,
                R.drawable.dictee_mot_planete_anneau,
                R.drawable.dictee_mot_planete_terre,
                R.drawable.dictee_mot_fusee,
        };


        private Integer[] mThumbIds4 = {
                R.drawable.compte_objets_orange,
                R.drawable.compte_objets_banane,
                R.drawable.compte_objets_cerise,
                R.drawable.compte_objets_fraise,
                R.drawable.compte_objets_mure,
                R.drawable.compte_objets_citron,
                R.drawable.compte_objets_poire,
                R.drawable.compte_objets_pomme,
                R.drawable.compte_objets_pasteque,
                R.drawable.compte_objets_myrtille,
                R.drawable.compte_objets_ananas,
        };

        private Integer[] mThumbIds5 = {
                R.drawable.fais_calculs_addition_arbre,
                R.drawable.fais_calculs_addition_pelle,
                R.drawable.fais_calculs_addition_rateau,
                R.drawable.fais_calculs_addition_brouette,
                R.drawable.fais_calculs_addition_gants,
                R.drawable.fais_calculs_addition_tuyau,
                R.drawable.fais_calculs_addition_fleur,
                R.drawable.fais_calculs_addition_buisson,
                R.drawable.fais_calculs_addition_arrosoir,
                R.drawable.fais_calculs_addition_graines,
        };

        private Integer[] mThumbIds6 = {
                R.drawable.fais_calculs_addition_trou_artichaud,
                R.drawable.fais_calculs_addition_trou_aubergine,
                R.drawable.fais_calculs_addition_trou_carotte,
                R.drawable.fais_calculs_addition_trou_champignon,
                R.drawable.fais_calculs_addition_trou_harricot,
                R.drawable.fais_calculs_addition_trou_oignon,
                R.drawable.fais_calculs_addition_trou_patate,
                R.drawable.fais_calculs_addition_trou_tomate,
                R.drawable.fais_calculs_addition_trou_radis,
                R.drawable.fais_calculs_addition_trou_citrouille,
        };



    }

}
