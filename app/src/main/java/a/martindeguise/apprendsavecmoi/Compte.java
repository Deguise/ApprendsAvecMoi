package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Compte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte);

        final ImageButton faisDesCalculsButton = (ImageButton) findViewById(R.id.imageButton);
        faisDesCalculsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compte.this, FaisDesCalculs.class);
                startActivity(intent);
            }
        });
    }
}
