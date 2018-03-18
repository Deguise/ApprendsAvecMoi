package a.martindeguise.apprendsavecmoi;

//import activity_splash;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Leo on 15/01/2018.
 */


public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MediaPlayer player = MediaPlayer.create(this, R.raw.theme1);
        player.start();

         new Handler().postDelayed(new Runnable() {

            @Override
            public void run(){
                Intent i = new Intent(SplashScreen.this, Acceuil.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

