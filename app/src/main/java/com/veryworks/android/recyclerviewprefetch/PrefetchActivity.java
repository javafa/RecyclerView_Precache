package com.veryworks.android.recyclerviewprefetch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.veryworks.android.recyclerviewprefetch.domain.User;

import java.util.List;

public class PrefetchActivity extends AppCompatActivity implements Loader.CallBack{

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
        LinearLayoutManager manager = new LinearLayoutManager(this);
        // prefetch 적용
        manager.setItemPrefetchEnabled(true);
        manager.setInitialPrefetchItemCount(10);
        view.setLayoutManager(manager);
    }

    @Override
    public void call(List list) {
        setList(list);
    }
}
