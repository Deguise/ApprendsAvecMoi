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

public class Collection_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_collection3);


        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Collection_3.this, "" +position, Toast.LENGTH_SHORT).show();
            }
        });


        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_3.this, Acceuil.class);
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


    }
}