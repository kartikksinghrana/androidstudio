package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int time=30;
    int ts=0,s=0;
    int tso=0,so=0;
    TextView counter,msgdisplay,equation,score;
    Button playagain ,redbutton, greenbutton,yellowbutton,bluebutton,t,chosenbutton;
    Random rand=new Random();
    public void chooseanswere(View view){
        Log.i("buttonpressed",view.getTag().toString()+chosenbutton.getTag().toString());
        if (view.getTag()==chosenbutton.getTag())
        {
            msgdisplay.setText("Correct");
            randequationgenration();
            scoring(1,1);
        }
        else
        {
            msgdisplay.setText("Incorrect");
            scoring(0,1);
        }
    }
    public void timeleft() {
        CountDownTimer counttimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long l) {
                updatecountown((int) l / 1000);
            }

            @Override
            public void onFinish() {
                msgdisplay.setText("GAME OVER!!!");
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void randequationgenration() {

        int r1 = rand.nextInt(101);
        int r2 = rand.nextInt(101);
        String operator = null;
        int r3 = rand.nextInt(3);
        switch (r3) {
            case 0:
                operator = "+";
                break;
            case 1:
                operator = "-";
                break;
            case 2:
                operator = "*";
                break;
            case 3:
                operator = "/";
                break;
        }
        String rs1 = Integer.toString(r1);
        String rs2 = Integer.toString(r2);
        String Equation = rs1 + operator + rs2;
        int answere = Answere(operator, r1, r2);
        String ans = Integer.toString(answere);
        Button chosenbuttonn = buttonselect();
        chosenbuttonn.setText(ans);
        otheroption(chosenbuttonn);
        chosenbutton = (Button) chosenbuttonn;
        equation.setText(Equation);
    }
    public int Answere(String operator, int r1, int r2){
        int answere = 0;
        if (operator.equals("+"))
        {
            answere=r1+r2;
            return answere;
        }
        else if (operator.equals("-"))
        {
            answere=r1-r2;
            return answere;
        }
        else if (operator.equals("/"))
        {
            answere=r1/r2;
            return answere;
        }
        else if (operator.equals("*"))
        {
            answere=r1*r2;
            return answere;
        }
    return answere;
    }
    public Button buttonselect(){
        int r4 =rand.nextInt(4);
        switch (r4)
        {
            case 0:
                return redbutton;
            case 1:
                return greenbutton;
            case 2:
                return bluebutton;
            case 3:
                return yellowbutton;
        }
        return null;
    }
    public void otheroption(Button selectedbutton){
        if (selectedbutton==redbutton)
        {
            greenbutton.setText(Integer.toString(rand.nextInt(101)));
            yellowbutton.setText(Integer.toString(rand.nextInt(101)));
            bluebutton.setText(Integer.toString(rand.nextInt(101)));
        }
        else if (selectedbutton==greenbutton)
        {
            yellowbutton.setText(Integer.toString(rand.nextInt(101)));
            bluebutton.setText(Integer.toString(rand.nextInt(101)));
            redbutton.setText(Integer.toString(rand.nextInt(101)));
        }
        else if (selectedbutton==yellowbutton)
        {
            greenbutton.setText(Integer.toString(rand.nextInt(101)));
            bluebutton.setText(Integer.toString(rand.nextInt(101)));
            redbutton.setText(Integer.toString(rand.nextInt(101)));
        }
        else if (selectedbutton==bluebutton)
        {
            greenbutton.setText(Integer.toString(rand.nextInt(101)));
            yellowbutton.setText(Integer.toString(rand.nextInt(101)));
            redbutton.setText(Integer.toString(rand.nextInt(101)));
        }
    }
    public void reset(View view){
        time=30;
        playagain.setVisibility(View.INVISIBLE);
        msgdisplay.setText("GAME START!!!");
        timeleft();


    }
    public void updatecountown(int timeleft) {
        counter.setText(Integer.toString(timeleft));
    }
    public void scoring(int s, int so){
        ts=ts+s;
        tso=tso+so;

        score.setText(Integer.toString(ts) +"/"+Integer.toString(tso));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation= (TextView)findViewById(R.id.question);
        counter= (TextView)findViewById(R.id.countdown);
        msgdisplay=(TextView)findViewById(R.id.display);
        playagain=(Button)findViewById(R.id.playagain);
        redbutton=(Button)findViewById(R.id.red);
        greenbutton=(Button)findViewById(R.id.green);
        yellowbutton=(Button)findViewById(R.id.yellow);
        bluebutton=(Button)findViewById(R.id.blue);
        score=(TextView)findViewById(R.id.scoreboard);
        timeleft();
        randequationgenration();

    }
}