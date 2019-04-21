package com.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private  Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status){
            FirstFragment firstFragment= new FirstFragment();
            fragmentTransaction.add(R.id.rl,firstFragment);
            fragmentTransaction.commit();
            btn.setText("Load second");
            status=false;

        }
        else {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.rl,secondFragment);
            fragmentTransaction.commit();
            btn.setText("Load first");
            status=true;

        }
    }
}
