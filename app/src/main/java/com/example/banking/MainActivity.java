package com.example.banking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tname,tacc,tbal;
    Button bname,bacc,bbal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tname = (TextView) findViewById(R.id.txtName);
        tacc = (TextView) findViewById(R.id.txtAcc);
        tbal = (TextView) findViewById(R.id.txtBal);

        bname = (Button) findViewById(R.id.btnName);
        bacc = (Button) findViewById(R.id.btnAcc);
        bbal = (Button) findViewById(R.id.btnBal);

        bname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tname.setText("Gaurav");
            }
        });

        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tacc.setText("SBI1432");
            }
        });

        bbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_demo_alert,null);
                final EditText username = (EditText) view.findViewById(R.id.username);
               final EditText password = (EditText) view.findViewById(R.id.password);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("Login");
                builder .setView(view);
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String u = username.getText().toString();
                        String p = password.getText().toString();

                        if(u.equals("gaurav") && p.equals("1234"))
                        {
                            tbal.setText("Rs.12500");
                        }
                        else
                        {
                            tbal.setText("Invalid credentials.");
                        }
                    }
                })
                        .setNegativeButton("Cancel", null);
                        AlertDialog alert = builder.create();
                        alert.show();
            }
        });
    }
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Really Exit?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        })
                .setNegativeButton("Cancel", null);

        AlertDialog alert = builder.create();
        alert.show();
    }
}
