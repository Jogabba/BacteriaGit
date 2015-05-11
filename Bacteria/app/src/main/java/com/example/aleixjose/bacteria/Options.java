package com.example.aleixjose.bacteria;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import android.app.AlertDialog;


public class Options extends Activity {

    //Counter get extra
    public int coins = 0;
    public int MainCounter = 0;
    //Points

    //Para recoger del intent
    public int TouchPLvl = 1;
    public int TouchPower = 1;
    public float CriticalPower = 2.5f;
    public int CriticalPLvl = 1;
    public int AutoclickPower = 0;
    public int AutoclickPLvl = 1;
    public int CriticalCLvl = 1;
    public float CriticalChance = 1;



    //Touch
    public int TouchP = 1;
    public int TouchPowerLevel = 1;
    public int upgrade1price = 4;


    //Autoclick
    public int AutoclickP = 0;
    public int AutoclickPowerLevel = 1;
    public int upgrade2price = 7;


    //Critical power
    public float CriticalP = 2.5f;
    public int CriticalPowerLevel = 1;
    public int upgrade3price = 8;


    //Critical chance
    public float CriticalC = 1;
    public int CriticalChanceLevel = 1;
    public int upgrade4price = 3;
    public float CC=0;

    //Random variables
    int ran1 = 666;
    int ran2 = 666;
    int random1 = 666;
    int random2 = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recibirIntent();

        setContentView(R.layout.activity_options);

        recibirtexto();
        setUpgrades();
    }

    public void recibirIntent(){
        Intent intent = getIntent();
        coins = intent.getIntExtra("Contador", MainCounter);
        TouchP = intent.getIntExtra("TouchPower", TouchPower);
        CriticalP = intent.getFloatExtra("CriticalPower", CriticalPower);
        CriticalC = intent.getFloatExtra("CriticalChance", CriticalChance);
        AutoclickP = intent.getIntExtra("AutoclickPower", AutoclickPower);
        TouchPowerLevel = intent.getIntExtra("TouchPowerLevel", TouchPLvl);
        AutoclickPowerLevel = intent.getIntExtra("AutoclickPowerLevel", AutoclickPLvl);
        CriticalPowerLevel = intent.getIntExtra("CriticalPowerLevel", CriticalPLvl);
        CriticalChanceLevel = intent.getIntExtra("CriticalChanceLevel",CriticalCLvl );
        random1 = intent.getIntExtra("NumeroRandom1", ran1);
        random2 = intent.getIntExtra("NumeroRandom2",ran2 );
    }

    public void recibirtexto(){

        ((TextView) findViewById(R.id.counter)).setText("Counter: " + coins + " pts");
        ((TextView)findViewById(R.id.TouchPowerLvlId)).setText("Lvl: " + (TouchPowerLevel-1));
        ((TextView)findViewById(R.id.AutoClickLvlId)).setText("Lvl: "+(AutoclickPowerLevel-1));
        ((TextView) findViewById(R.id.CriticalPowerLvlId)).setText("Lvl: "+(CriticalPowerLevel-1));
        ((TextView) findViewById(R.id.CriticalChanceLvlId)).setText("Lvl :"+(CriticalChanceLevel-1));
    }

    public void notEnoughtMoney(){

        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
        alertTouchDialog.setTitle("You have not enought money to upgrade");
        alertTouchDialog.setCancelable(false);
        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        //alertTouchDialog.setIcon(R.drawable.cell);
        alertTouchDialog.show();}



    public void UpgradeBuy(View UpgradeButton){

        int ButtonID= UpgradeButton.getId();

        if(ButtonID == R.id.send){
            switch (random1){
                case 1:
                    if(coins>=upgrade1price*TouchPowerLevel*4){
                        coins-=upgrade1price*TouchPowerLevel*4;
                        //upgrade1price *= TouchPowerLevel*4;
                        TouchP *= 2;
                        TouchPowerLevel++;
                        random1 = randomInt(1,4);
                        ((TextView) findViewById(R.id.TouchPowerLvlId)).setText("Lvl: " + (TouchPowerLevel-1));
                        ((TextView)findViewById(R.id.counter)).setText("Counter: " + coins + " pts");
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Touch level have been upgraded to " + (TouchPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.clickpower);
                        alertTouchDialog.show();
                    }else{
                        notEnoughtMoney();}
                    break;
                case 2:
                    if(coins>=upgrade2price*AutoclickPowerLevel*4){
                        coins-=upgrade2price*AutoclickPowerLevel*4;
                        //upgrade2price *=  AutoclickPowerLevel*4;
                        AutoclickP = AutoclickPowerLevel;
                        AutoclickPowerLevel++;
                        random1 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.AutoClickLvlId)).setText("Lvl: " + (AutoclickPowerLevel - 1));
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Autoclick level have been upgraded to " + (AutoclickPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.autoclick);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
                case 3:
                    if(coins>=upgrade3price*CriticalPowerLevel*4){
                        coins-=upgrade3price*CriticalPowerLevel*4;
                        //upgrade3price *= CriticalPowerLevel*4;
                        CriticalP *= 2;
                        CriticalPowerLevel++;
                        random1 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.CriticalPowerLvlId)).setText("Lvl: " + (CriticalPowerLevel - 1));
                        setUpgrades();

                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Critical Power have been upgraded to " + (CriticalPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.critpower);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
                case 4:
                    if(coins>=upgrade4price*CriticalChanceLevel*4){
                        coins-=upgrade4price*CriticalChanceLevel*4;
                        //upgrade4price *= CriticalChanceLevel*4;
                        CriticalC *= 2;
                        CriticalChanceLevel++;
                        random1 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.CriticalChanceLvlId)).setText("Lvl: " + (CriticalChanceLevel - 1));
                        setUpgrades();

                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Critical Chance level have been upgraded to " + (CriticalChanceLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.critchance);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
            }

        }
        if(ButtonID == R.id.send2) {
            switch (random2) {
                case 1:
                    if(coins>=upgrade1price*TouchPowerLevel*4){
                        coins-=upgrade1price*TouchPowerLevel*4;
                        //upgrade1price *= TouchPowerLevel*4;
                        TouchP *= 2;
                        TouchPowerLevel++;
                        random2 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.TouchPowerLvlId)).setText("Lvl: " + (TouchPowerLevel - 1));
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Touch level have been upgraded to " + (TouchPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.clickpower);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
                case 2:
                    if(coins>=upgrade2price*AutoclickPowerLevel*4){
                        coins-=upgrade2price*AutoclickPowerLevel*4;
                        //upgrade2price *=  AutoclickPowerLevel*4;
                        AutoclickP = AutoclickPowerLevel;
                        AutoclickPowerLevel++;
                        random2 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.AutoClickLvlId)).setText("Lvl: " + (AutoclickPowerLevel - 1));
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Autoclick level have been upgraded to " + (AutoclickPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.autoclick);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
                case 3:
                    if(coins>=upgrade3price*CriticalPowerLevel*4){
                        coins-=upgrade3price*CriticalPowerLevel*4;
                        //upgrade3price *= CriticalPowerLevel*4;
                        CriticalP *= 1.2;
                        CriticalPowerLevel++;
                        random2 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.CriticalPowerLvlId)).setText("Lvl: " + (CriticalPowerLevel - 1));
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Critical Power have been upgraded to " + (CriticalPowerLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.critpower);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
                case 4:
                    if(coins>=upgrade4price*CriticalChanceLevel*4){
                        coins-=upgrade4price*CriticalChanceLevel*4;
                        //upgrade4price *= CriticalChanceLevel*4;
                        CriticalC *= 1.2;
                        CriticalChanceLevel++;
                        random2 = randomInt(1,4);
                        ((TextView)findViewById(R.id.counter)).setText("Counter: "+coins+" pts");
                        ((TextView) findViewById(R.id.CriticalChanceLvlId)).setText("Lvl: " + (CriticalChanceLevel - 1));
                        setUpgrades();
                        AlertDialog alertTouchDialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertUpgrades)).create();
                        alertTouchDialog.setTitle("Your Critical Chance level have been upgraded to " + (CriticalChanceLevel - 1) + "!");
                        alertTouchDialog.setCancelable(false);
                        alertTouchDialog.setButton("Accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        //alertTouchDialog.setIcon(R.drawable.critchance);
                        alertTouchDialog.show();
                    }
                    else{
                        notEnoughtMoney();}
                    break;
            }
        }
    }



    public void setUpgrades(){

        if(random1 == 666){
            random1 = randomInt(1,4);
        }

        if (random2 == 666) {
            random2 = randomInt(1,4);
        }


        while (random2 == random1){
            random2 = randomInt(1,4);
        }

        switch (random1) {
            case 1:
                ((TextView)findViewById(R.id.TitleUpgrade1)).setText("+TOUCH POWER");
                ((TextView)findViewById(R.id.DescriptionUpgrade1)).setText((TouchP*2)+" per touch");
                ((Button)findViewById(R.id.send)).setText("Buy("+(upgrade1price*TouchPowerLevel*4)+")");
                ImageView TouchPowerImage = (ImageView)findViewById(R.id.Upgrade1Image);
                TouchPowerImage.setImageResource(R.drawable.clickpowerp);

                break;

            case 2:
                ((TextView)findViewById(R.id.TitleUpgrade1)).setText("+AUTOCLICK/S");
                ((TextView)findViewById(R.id.DescriptionUpgrade1)).setText((1+AutoclickPowerLevel)+" per second");
                ((Button)findViewById(R.id.send)).setText("Buy("+(upgrade2price*AutoclickPowerLevel*4)+")");
                ImageView AutoclickPowerImage = (ImageView)findViewById(R.id.Upgrade1Image);
                AutoclickPowerImage.setImageResource(R.drawable.autoclickp);
                break;

            case 3:
                ((TextView)findViewById(R.id.TitleUpgrade1)).setText("+CRIT POWER");
                ((TextView)findViewById(R.id.DescriptionUpgrade1)).setText((CriticalP*2)+" per touch");
                ((Button)findViewById(R.id.send)).setText("Buy("+(upgrade3price*CriticalPowerLevel*4)+")");
                ImageView CritPowerImage = (ImageView)findViewById(R.id.Upgrade1Image);
                CritPowerImage.setImageResource(R.drawable.critpowerp);
                break;

            case 4:
                NumberFormat formatter = new DecimalFormat("%.2f");
                formatter.format(CC);
                ((TextView)findViewById(R.id.TitleUpgrade1)).setText("+CRIT CHANCE");
                ((TextView)findViewById(R.id.DescriptionUpgrade1)).setText((CriticalC*1.2)+"% per touch");
                ((Button)findViewById(R.id.send)).setText("Buy(" + (upgrade4price * CriticalChanceLevel * 4)+")");
                ImageView CritChanceImage = (ImageView)findViewById(R.id.Upgrade1Image);
                CritChanceImage.setImageResource(R.drawable.critchancep);

                break;
        }



        switch (random2) {
            case 1:

                ((TextView)findViewById(R.id.TitleUpgrade2)).setText("+TOUCH POWER");
                ((TextView)findViewById(R.id.DescriptionUpgrade2)).setText((TouchP*2)+" per touch");
                ((Button)findViewById(R.id.send2)).setText("Buy("+(upgrade1price*TouchPowerLevel*4)+")");
                ImageView TouchPowerImage = (ImageView)findViewById(R.id.Upgrade2Image);
                TouchPowerImage.setImageResource(R.drawable.clickpowerp);

                break;

            case 2:
                ((TextView)findViewById(R.id.TitleUpgrade2)).setText("+AUTOCLICK/S");
                ((TextView)findViewById(R.id.DescriptionUpgrade2)).setText((1+AutoclickPowerLevel)+" per second");
                ((Button)findViewById(R.id.send2)).setText("Buy("+(upgrade2price*AutoclickPowerLevel*4)+")");
                ImageView AutoclickPowerImage = (ImageView)findViewById(R.id.Upgrade2Image);
                AutoclickPowerImage.setImageResource(R.drawable.autoclickp);
                break;

            case 3:
                ((TextView)findViewById(R.id.TitleUpgrade2)).setText("+CRIT POWER");
                ((TextView)findViewById(R.id.DescriptionUpgrade2)).setText((CriticalP*2)+" per touch");
                ((Button)findViewById(R.id.send2)).setText("Buy("+(upgrade3price*CriticalPowerLevel*4)+")");
                ImageView CritPowerImage = (ImageView)findViewById(R.id.Upgrade2Image);
                CritPowerImage.setImageResource(R.drawable.critpowerp);
                break;

            case 4:
                CC= (float) (CriticalC*1.2);
                NumberFormat formatter = new DecimalFormat("%.2f");
                formatter.format(CC);
                //String s = String.format(("%.2f"), CC);
                ((TextView)findViewById(R.id.TitleUpgrade2)).setText("+CRIT CHANCE");
                ((TextView)findViewById(R.id.DescriptionUpgrade2)).setText((CC) +"% per touch");
                ((Button)findViewById(R.id.send2)).setText("Buy(" + (upgrade4price * CriticalChanceLevel * 4)+")");
                ImageView CritChanceImage = (ImageView)findViewById(R.id.Upgrade2Image);
                CritChanceImage.setImageResource(R.drawable.critchancep);
        }
    }

    public static int randomInt(int min,int max){

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min)+1)+min;

        return randomNum;
    }

    public void volver(){
        Intent main = new Intent(this, Main.class);

        main.putExtra("Contador", coins);
        main.putExtra("CriticalChance", CriticalC);
        main.putExtra("CriticalPower", CriticalP);
        main.putExtra("TouchPower", TouchP);
        main.putExtra("AutoclickPower", AutoclickP);
        main.putExtra("TouchPowerLevel",TouchPowerLevel);
        main.putExtra("AutoclickPowerLevel",AutoclickPowerLevel);
        main.putExtra("CriticalPowerLevel",CriticalPowerLevel);
        main.putExtra("CriticalChanceLevel",CriticalChanceLevel);
        main.putExtra("NumeroRandom1",random1);
        main.putExtra("NumeroRandom2",random2);


        startActivity(main);
        Log.i("Mensaje", "Esto funciona");

    }

    public void mainMenu(View view){
        volver();
    }

}

