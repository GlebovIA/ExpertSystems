package com.example.expertsystems;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    public Boolean selectedSpina;
    public Boolean selectedBicepc;
    public Boolean selectedTricepc;
    public Boolean selectedIcronogniye;
    public int nLayout = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnLayout(View view){
        if(nLayout == 0) {
            setContentView(R.layout.step_1);
            nLayout = 1;
        }
        if(nLayout == 1) {
            EditText etName = findViewById(R.id.etName);
            EditText etSurname = findViewById(R.id.etSurname);

            if (String.valueOf(etName.getText()).isEmpty()) {
                AlertDialog("Уведомление", "Необходимо ввести имя пользователя");
            } else if (String.valueOf(etSurname.getText()).isEmpty()) {
                AlertDialog("Уведомление", "Необходимо ввести фамилию пользователя");
            } else {
                setContentView(R.layout.step_2);
                nLayout = 2;
            }
        }else if(nLayout == 2){
            RadioGroup rgPeriod = findViewById(R.id.rgPeriod);
            if(rgPeriod.getCheckedRadioButtonId() == -1){
                AlertDialog("Уведомление", "Необходимо выбрать периодичность занятий!");
            }else{
                setContentView(R.layout.step_3);
                nLayout = 3;
            }
        } else if (nLayout == 3) {
            CheckBox spina = findViewById(R.id.spina);
            CheckBox bicepc = findViewById(R.id.bicepc);
            CheckBox tricepc = findViewById(R.id.tricepc);
            CheckBox icronojniye = findViewById(R.id.ikronogniye);
            if(spina.isChecked() || bicepc.isChecked() || tricepc.isChecked() || icronojniye.isChecked()){
                selectedSpina = spina.isChecked();
                selectedBicepc = bicepc.isChecked();
                selectedTricepc = tricepc.isChecked();
                selectedIcronogniye = icronojniye.isChecked();
                setContentView(R.layout.step_4);
                nLayout = 4;
            }else{
                AlertDialog("Уведомление", "Необходимо выбрать часть тела для тренировок!");
            }
        } else if (nLayout == 4) {
            EditText etVes = findViewById(R.id.etVes);
            EditText etRost = findViewById(R.id.etRost);

            if (String.valueOf(etVes.getText()).isEmpty()) {
                AlertDialog("Уведомление", "Необходимо ввести вес пользователя");
            } else if (String.valueOf(etRost.getText()).isEmpty()) {
                AlertDialog("Уведомление", "Необходимо ввести рост пользователя");
            } else {
                setContentView(R.layout.step_5);
                nLayout = 5;
            }
        } else if (nLayout == 5) {
            RadioGroup rgPol = findViewById(R.id.rgPol);
            if(rgPol.getCheckedRadioButtonId() == -1) {
                AlertDialog("Уведомление", "Необходимо выбрать ваш пол.");
            } else{
                setContentView(R.layout.main);

                if(!selectedSpina) {
                    findViewById(R.id.flSpina).setVisibility(View.GONE);
                }
                if(!selectedBicepc) {
                    findViewById(R.id.flBicepc).setVisibility(View.GONE);
                }
                if(!selectedTricepc) {
                    findViewById(R.id.flTricepc).setVisibility(View.GONE);
                }
                if(!selectedIcronogniye) {
                    findViewById(R.id.flIcronogniye).setVisibility(View.GONE);
                }

                findViewById(R.id.flSpina).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sPZoMFXemtA?si=1xV_-pRvKPQupAdB"));
                        startActivity(browserIntent);
                    }
                });
                findViewById(R.id.flBicepc).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_G4_-hfb3LY?si=c1ncoXOrIEpeprQm"));
                        startActivity(browserIntent);
                    }
                });
                findViewById(R.id.flTricepc).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/OWOjTJeGotk?si=U1HqVfvFRcY5MzOT"));
                        startActivity(browserIntent);
                    }
                });
                findViewById(R.id.flIcronogniye).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/3ar7aUC3e1k?si=d5f5wGWCoIcI7kXO"));
                        startActivity(browserIntent);
                    }
                });

                nLayout = 6;
            }
        }
    }

    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("Ok",
                        (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}