package com.example.aleixjose.bacteria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.Date;
import java.util.Random;


public class Main extends Activity {

public int FinalCounter=0;
    public int coins;
    public int MainCounter;
    //Points

    //Touch
    public int TouchPower = 1;
    public int TouchP = 1;
    public int TouchFinalPower;
    public int TouchPowerLevel = 1;
    public int TouchPowerLvl = 1;
    public int TouchPLvl = 1;

    //Autoclick
    public int AutoclickPower = 0;
    public int AutoclickP = 0;
    TextView timerTextView;
    long startTime = 0;
    long startTime2 = 0;
    public int contador;
    public TextView CounterTextView;
    public int AutoclickPowerLvl = 1;
    public int AutoclickPowerLevel = 1;
    public int AutoclickPLvl = 1;

    //Critical power
    public float CriticalPower = 2.5f;
    public float CriticalP = 2.5f;
    public int CriticalN=0;
    public int CriticalPowerLvl = 1;
    public int CriticalPowerLevel = 1;
    public int CriticalPLvl = 1;

    //Critical chance
    public float CriticalChance = 1;
    public float CriticalC = 1;
    public int CriticalChanceLvl = 1;
    public int CriticalChanceLevel = 1;
    public int CriticalCLvl = 1;
    String formattedString = String.format("%.02f", CriticalC);

    //Random variables
    int ran1 = 666;
    int ran2 = 666;
    int random1 = 666;
    int random2 = 666;


    //Share Photo Social NetWorks


    public int photo = 1;

    //SharedPreferences Stuff
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            contador += AutoclickP;
            CounterTextView = (TextView) findViewById(R.id.MainCounterId);
            FinalCounter = MainCounter + contador;
            CounterTextView.setText(String.valueOf(FinalCounter));
            timerHandler.postDelayed(this, 1500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recogerPrefs();
        recibirIntent();
        recibirTexto();
        recibirFuentes();
        InicializarTimer();
        InicializarTimer2();

    }

    public void InicializarTimer(){

        //timerTextView = (TextView) findViewById(R.id.TimeCounterId);
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
        }

    public void recibirIntent(){
        Intent intent = getIntent();
        MainCounter = intent.getIntExtra("Contador", coins);
        CriticalC = intent.getFloatExtra("CriticalChance", CriticalChance);
        CriticalP = intent.getFloatExtra("CriticalPower", CriticalPower);
        TouchP = intent.getIntExtra("TouchPower", TouchPower);
        AutoclickP = intent.getIntExtra("AutoclickPower", AutoclickPower);
        TouchPLvl = intent.getIntExtra("TouchPowerLevel", TouchPowerLevel);
        AutoclickPLvl = intent.getIntExtra("AutoclickPowerLevel", AutoclickPowerLevel);
        CriticalPLvl = intent.getIntExtra("CriticalPowerLevel", CriticalPowerLevel);
        CriticalCLvl = intent.getIntExtra("CriticalChanceLevel", CriticalChanceLevel);
        random1 = intent.getIntExtra("NumeroRandom1", ran1);
        random2 = intent.getIntExtra("NumeroRandom2",ran2 );
        TextView CounterText = (TextView)findViewById(R.id.MainCounterId);
        CounterText.setText(String.valueOf(MainCounter));
    }

    public void recibirTexto(){
//power

/*
        TextView TouchText = (TextView)findViewById(R.id.TouchPowerId);
        TouchText.setText(String.valueOf(("TouchP: ")+TouchP));

        TextView CriticalPText = (TextView)findViewById(R.id.CriticalPowerId);
        CriticalPText.setText(String.valueOf(("CriticalP: ")+CriticalP));

        TextView CriticalCText = (TextView)findViewById(R.id.CriticalChanceId);
        CriticalCText.setText(String.valueOf(("CriticalC: ")+CriticalC));

        TextView AutoclickText = (TextView)findViewById(R.id.AutoClickId);
        AutoclickText.setText(String.valueOf(("AutoclickP: ")+AutoclickP));

//Lvls
        TextView TouchTextLvl = (TextView)findViewById(R.id.TouchPowerLvlId);
        TouchTextLvl.setText(String.valueOf(("TouchP: ")+TouchPowerLevel));

        TextView CriticalPTextLvl = (TextView)findViewById(R.id.CriticalPowerLvlId);
        CriticalPTextLvl.setText(String.valueOf(("CriticalP: ")+CriticalPowerLevel));

        TextView CriticalCTextLvl = (TextView)findViewById(R.id.CriticalChanceLvlId);
        CriticalCTextLvl.setText(String.valueOf(("CriticalC: ")+CriticalChanceLevel));

        TextView AutoclickTextLvl = (TextView)findViewById(R.id.AutoClickLvlId);
        AutoclickTextLvl.setText(String.valueOf(("AutoclickP: ")+AutoclickPowerLevel));*/
    }


    public void recibirFuentes(){/*
        TextView tv=(TextView)findViewById(R.id.MainLevelBox);
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/robotoregular.ttf");
        tv.setTypeface(face);*/
    }


    public void ActualitzarNivells(String string,Integer imatge,String nextgoal){
        TextView LvlText = (TextView)findViewById(R.id.MainLevelBox);
        LvlText.setText(string);
        ImageButton LvlImage = (ImageButton)findViewById(R.id.CreaturePic);
        LvlImage.setImageResource(imatge);
        TextView NextGoalText = (TextView)findViewById(R.id.NextGoalId);
        NextGoalText.setText(nextgoal);
    }


    Handler timerHandler2 = new Handler();
    Runnable timerRunnable2 = new Runnable() {

        @Override
        public void run() {

            timerHandler2.postDelayed(this, 250);

            if(FinalCounter>=0&&FinalCounter<999){
                ActualitzarNivells("You are a bacteria",R.drawable.celula,"Next goal: 1000");
            }

            if(FinalCounter>=1000&&FinalCounter<9999){
                ActualitzarNivells("You are a streptococcus", R.drawable.strepto,"Next goal: 10.000");
            }

            if(FinalCounter>=10000&&FinalCounter<199999) {
                ActualitzarNivells("You are a tardigradus", R.drawable.tardi,"Next goal: 200.000");
            }

            if(FinalCounter>=2000000&&FinalCounter<2999999) {
                ActualitzarNivells("You are a jellyfish", R.drawable.medusa,"Next goal: 3.000.000");
            }

            if(FinalCounter>=500000&&FinalCounter<14999999) {
                ActualitzarNivells("You are a sponge", R.drawable.sponge,"Next goal: 15.000.000");
            }

            if(FinalCounter>=1500000&&FinalCounter<4999999) {
                ActualitzarNivells("You are a ball bug", R.drawable.bola,"Next goal: 100.000.000");
            }

            if(FinalCounter>=5000000&&FinalCounter<14999999) {
                ActualitzarNivells("You are a bee", R.drawable.bee,"Next goal: 2.500.000.000");
            }
            if(FinalCounter>=15000000&&FinalCounter<2999999) {
                ActualitzarNivells("You are a frog", R.drawable.frog,"Next goal: 30.000.000.000");
            }
            if(FinalCounter>=30000000) {
                ActualitzarNivells("You are a bird", R.drawable.bird,"Next goal: Coming soon...");
            }
        }
    };

    public void InicializarTimer2(){

        startTime2 = System.currentTimeMillis();
        timerHandler2.postDelayed(timerRunnable2, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void creatureClick(View view){
        if( (Math.random() * (100 - 0)) < CriticalC ){

            TouchFinalPower= (int) (TouchP*CriticalP);
            CriticalN++;
        }
        else{TouchFinalPower=TouchP;}

        MainCounter= MainCounter + TouchFinalPower;

        TextView CounterText = (TextView)findViewById(R.id.MainCounterId);
        CounterText.setText(String.valueOf(MainCounter + contador));
/*
        TextView TouchText = (TextView)findViewById(R.id.TouchPowerId);
        TouchText.setText(String.valueOf(("TouchP: ") + TouchP + "(" + CriticalN + ")"));

        TextView CriticalPText = (TextView)findViewById(R.id.CriticalPowerId);
        CriticalPText.setText(String.valueOf(("CriticalP: ") + CriticalP));

        TextView CriticalCText = (TextView)findViewById(R.id.CriticalChanceId);
        CriticalCText.setText(String.valueOf(("CriticalC: ") + CriticalC));

        TextView AutoclickText = (TextView)findViewById(R.id.AutoClickId);
        AutoclickText.setText(String.valueOf(("AutoclickP: ") + AutoclickP));*/
    }

   /* public void shareFromFacebook(){
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.id.CreaturePic);

        SharePhoto.Builder photo = new SharePhoto.Builder().setBitmap(image);
        photo.build();

        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(image)
                .build();


        Bitmap image = BitmapFactory.decodeResource(getResources(), R.id.CreaturePic);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        }*/


public void openGameMenu(View view){
    Intent Enviar = new Intent(this, Options.class);
    Enviar.putExtra("Contador", MainCounter + contador);
    Enviar.putExtra("TouchPower", TouchP);
    Enviar.putExtra("CriticalPower", CriticalP);
    Enviar.putExtra("CriticalChance", CriticalC);
    Enviar.putExtra("AutoclickPower", AutoclickP);
    Enviar.putExtra("TouchPowerLevel",TouchPLvl);
    Enviar.putExtra("AutoclickPowerLevel",AutoclickPLvl);
    Enviar.putExtra("CriticalPowerLevel",CriticalPLvl);
    Enviar.putExtra("CriticalChanceLevel",CriticalCLvl);
    Enviar.putExtra("NumeroRandom1",random1);
    Enviar.putExtra("NumeroRandom2",random2);
    startActivity(Enviar);
    Log.i("Mensaje", "Esto funciona");
}

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = myPrefs.edit();

        Date OldDate = new Date(System.currentTimeMillis());
        long OldMillis = OldDate.getTime();

        editor.putLong("OldMillis", OldMillis);
        editor.putInt("Counter", FinalCounter);

        editor.putInt("CriticalChanceLevel", CriticalChanceLevel);
        editor.putInt("CriticalPowerLevel", CriticalPowerLevel);
        editor.putInt("AutoclickPowerLevel", AutoclickPowerLevel);
        editor.putInt("TouchPowerLevel", TouchPowerLevel);

        editor.putFloat("CriticalChancePower", CriticalC);
        editor.putFloat("CriticalPower", CriticalP);
        editor.putInt("AutoclickPower", AutoclickP);
        editor.putInt("TouchPower", TouchP);
        editor.commit();
    }

    public void recogerPrefs(){
        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        long OldDateMillis =  myPrefs.getLong("OldMillis", 0);
        int OldCounter = myPrefs.getInt("Counter", 0);

        CriticalChanceLevel = myPrefs.getInt("CriticalChanceLevel", CriticalChanceLevel);
        CriticalPowerLevel = myPrefs.getInt("CriticalPowerLevel", CriticalPowerLevel);
        AutoclickPowerLevel = myPrefs.getInt("AutoClickPowerLevel", AutoclickPowerLevel);
        TouchPowerLevel = myPrefs.getInt("TouchPowerLevel", TouchPowerLevel);

        CriticalC = myPrefs.getFloat("CriticalChancePower", CriticalChance);
        CriticalP= myPrefs.getFloat("CriticalPower", CriticalPower);
        AutoclickP = myPrefs.getInt("AutoClickPower", AutoclickPower);
        TouchP = myPrefs.getInt("TouchPower", TouchPower);

        long CurrentTime = System.currentTimeMillis();
        long DifferenceMillis = CurrentTime - OldDateMillis;
        int IdleBonus = ((int)DifferenceMillis / 2500)* AutoclickP;
        MainCounter = OldCounter + IdleBonus;
        //((TextView)findViewById(R.id.MainCounterId)).setText(String.valueOf());
    }


    public void resetGame(View view){
        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = myPrefs.edit();

        editor.clear();
        editor.commit();



        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
        alertTouchDialog.setTitle("Do you want to restart the game? ");
        alertTouchDialog.setCancelable(true);
        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                contador = 0;
                FinalCounter = 0;
                MainCounter = 0;
                coins = 0;

                //Touch
                TouchPower = 1;
                TouchP = 1;
                TouchPowerLevel = 1;
                TouchPLvl = 1;

                //Autoclick
                AutoclickPower = 1;
                AutoclickP = 0;
                startTime = 0;
                startTime2 = 0;
                AutoclickPowerLevel = 1;
                AutoclickPLvl = 1;

                //Critical power
                CriticalPower = 2.5f;
                CriticalP = 2.5f;
                CriticalN = 0;
                CriticalPowerLevel = 1;
                CriticalPLvl = 1;

                //Critical chance
                CriticalChance = 1;
                CriticalC = 1;
                CriticalChanceLevel = 1;
                CriticalCLvl = 1;
                // Activity.re
                recibirTexto();
            }
        });

        alertTouchDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //alertTouchDialog.setIcon(R.drawable.cell);
        alertTouchDialog.show();


    }

}
