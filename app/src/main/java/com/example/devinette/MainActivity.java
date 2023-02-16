package com.example.devinette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper Mydb;
    ArrayList<String> player_id,devinette_title,score;
    public EditText ed1;
    public TextView tv_p;
    public TextView tv_r;
    public TextView tv_c;
    public TextView tv_m;
    public Button b_ok;
    public ImageButton b_reload;
    public ImageButton term;
    public int a;

    public int number_of_clicks;
    private static final long START_TIME_IN_MILLIS=20000;
    public    CountDownTimer mCountDownTimer;
    public    Boolean mTimerRunning;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    public  int int1;
    public   int sc ;
    public static int sc1;
    public  String sc2;

    CustomAdapter CustomAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        tv_p=(TextView) findViewById(R.id.ran);
        tv_r=(TextView) findViewById(R.id.res);
        tv_c=(TextView) findViewById(R.id.clicks);
        tv_m=(TextView) findViewById(R.id.tv_m);
        ed1=(EditText) findViewById(R.id.pr);
        b_ok=(Button) findViewById(R.id.verif);
        b_reload=(ImageButton) findViewById(R.id.reload);
        term=(ImageButton) findViewById(R.id.term);
        Bundle extras=getIntent().getExtras();
        String p =extras.getString("Nom");





        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, p, Toast.LENGTH_SHORT).show();

                sc=0;
                int1=0;
                mTimeLeftInMillis=20000;
                tv_m.setText("");
                tv_p.setText("");
                tv_c.setText("");

           new CountDownTimer(100000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        updateCount();
                        mTimeLeftInMillis=100-(millisUntilFinished/1000) ;
                        String m =Long.toString(mTimeLeftInMillis);
                    int int1 = Integer.parseInt(m)-number_of_clicks;
                    sc=100-(int1);




                       // tv_c.setText("seconds remaining: " + mTimeLeftInMillis / 1000);
                        tv_c.setText("" + (100-mTimeLeftInMillis)+"s");




                    }
               public void updateCount() {



               }

                    public void onFinish() {

                        tv_p.setText("Vous Avez Perdu");
                        tv_p.setTextColor(Color.RED);
                    }
                }.start();

                SecureRandom r =new SecureRandom();
                int rs = r.nextInt(100);

                a = rs;
                Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
         //  tv_r.setText(String.valueOf(a));
                number_of_clicks=0;
            //   tv_c.setText(String.valueOf(number_of_clicks));







            }
        });
        b_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                number_of_clicks++;
              //  tv_c.setText(String.valueOf(number_of_clicks));






                String b =  ed1.getText().toString();
                int number = Integer.parseInt(b);
                if(number<a){
                  tv_p.setText("Plus QUE "+number);
                  tv_p.setTextColor(Color.BLACK);

                }else if(number>a){
                   tv_p.setText("Moins QUE "+ number);
                    tv_p.setTextColor(Color.BLACK);
                    }


               else{
                    sc1=sc;
                    sc2=String.valueOf(sc1);

                    // tv_r.setText(sc1);
                    tv_m.setText("score : "+sc1);


                  tv_p.setText("Vous Avez Gagné");
                    tv_p.setTextColor(Color.GREEN);



                }


                }







        });
        term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.addScore(p.trim(),

                       sc2.trim());
                Intent intent = new Intent(MainActivity.this,recyclerv.class);
                startActivity(intent);


            }

        });

    }

    void storeDataInArrays(){
        Cursor cursor = Mydb.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){

                devinette_title.add(cursor.getString(1));
                score.add(cursor.getString(2));

            }

        }
    }

    private void startTimer(){

    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
    }
    private void resetTimer(){};


}
