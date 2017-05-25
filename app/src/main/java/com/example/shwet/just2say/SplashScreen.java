package com.example.shwet.just2say;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Shwet on 2/17/2017.
 */
/*
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
*/
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView splash_img;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        splash_img=(ImageView)findViewById(R.id.imageView);
        final Animation an1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);


        splash_img.startAnimation(an1);
        an1.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splash_img.startAnimation(an2);
                finish();
                Intent i=new Intent(getBaseContext(),LoginActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}


