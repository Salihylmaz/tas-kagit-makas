package com.sa.tas_kagit_makas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int comskor = 0, kulscr = 0, bilsecimi;
    ImageButton tas,kagit,makas;

    TextView bilskor,kulskor,sonuc,bilsec;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tas = findViewById(R.id.tas);
        kagit = findViewById(R.id.kagit);
        makas = findViewById(R.id.makas);
        bilskor = findViewById(R.id.bilskor);
        kulskor = findViewById(R.id.kulskor);
        sonuc = findViewById(R.id.kazanan);
        bilsec = findViewById(R.id.bilsec);
        //Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.buton_hareket);
        //tas.startAnimation(anim1);
    }

    public void bas(View view){
        int id = view.getId();
        if(id == R.id.tas){
            bilsecmetot(1);
        } else if (id == R.id.kagit) {
            bilsecmetot(2);
        }else{
            bilsecmetot(3);
        }
    }

    public void bilsecmetot(int kulsec){
        bilsecimi = (int)(Math.random()*3+1);
        String secbil;
        if(bilsecimi == 1){
            secbil ="TAŞ";
        } else if (bilsecimi == 2) {
            secbil = "KAĞIT";
        }else{
            secbil = "MAKAS";
        }
        bilsec.setText("Bilgisayarın seçimi: "+ secbil);
        if (bilsecimi == kulsec){
            sonuc.setText("BERABERE");
        } else if ((bilsecimi == 1 && kulsec == 3)||(bilsecimi == 2 && kulsec == 1)||(bilsecimi ==3 && kulsec == 2) ){
            sonuc.setText("BİLGİSAYAR KAZANDI");
            comskor++;
            bilskor.setText(String.valueOf(comskor));
        }else{
            sonuc.setText("OYUNCU KAZANDI");
            kulscr++;
            kulskor.setText(String.valueOf(kulscr));
        }
    }
}