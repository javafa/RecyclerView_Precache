package com.veryworks.android.recyclerviewprefetch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
  Coding Tip
  @author kodonho
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intentNone;
    Intent intentPrefetch;
    Intent intentPrecache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNone).setOnClickListener(this);
        findViewById(R.id.btnPrefetch).setOnClickListener(this);
        findViewById(R.id.btnPrecache).setOnClickListener(this);

        intentNone = new Intent(this,RecyclerActivity.class);
        intentPrefetch = new Intent(this,PrefetchActivity.class);
        intentPrecache = new Intent(this,PrecacheActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNone:
                startNone();
                break;
            case R.id.btnPrefetch:
                startPrefetch();
                break;
            case R.id.btnPrecache:
                startPreload();
                break;
        }
    }

    private void startNone(){
        startActivity(intentNone);
    }

    private void startPrefetch(){
        startActivity(intentPrefetch);
    }

    private void startPreload(){
        startActivity(intentPrecache);
    }
}
