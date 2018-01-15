package a.martindeguise.apprendsavecmoi;

//import activity_splash;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Leo on 15/01/2018.
 */


public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



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

