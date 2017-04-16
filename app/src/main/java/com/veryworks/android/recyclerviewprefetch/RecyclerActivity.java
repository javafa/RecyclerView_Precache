package com.veryworks.android.recyclerviewprefetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.veryworks.android.recyclerviewprefetch.domain.User;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements Loader.CallBack{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        load();
    }

    private void load(){
        String url="https://api.github.com/";
        Loader.getList(url,this);
    }

    private void setList(List<User> datas){
        RecyclerView view = (RecyclerView) findViewById(R.id.listView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, datas );
        adapter.setView(view);
        view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void call(List list) {
        setList(list);
    }
}
