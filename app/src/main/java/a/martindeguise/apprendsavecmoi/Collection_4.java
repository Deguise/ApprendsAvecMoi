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

public class Collection_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_collection4);


        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Collection_4.this, "" +position, Toast.LENGTH_SHORT).show();
            }
        });


        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_4.this, Acceuil.class);
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


    }
}