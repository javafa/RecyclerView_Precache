package com.veryworks.android.recyclerviewprefetch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veryworks.android.recyclerviewprefetch.domain.User;

import java.util.List;

/**
 *
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    Context context;
    List<User> datas;

    public RecyclerAdapter(Context context, List<User> datas){
        this.context = context;
        this.datas = datas;
    }

    public void setView(@NonNull RecyclerView listView){
        listView.setAdapter(this);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        User data = datas.get(position);
        holder.setImage(data.getAvatar_url());
        holder.setTitle(data.getLogin());
        Log.i("ITEM","Position================"+position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        public Holder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.imageView);
            title = (TextView)itemView.findViewById(R.id.editText);
        }

        public void setImage(String src){
            Glide
            .with(context)
            .load(src)
            .skipMemoryCache(true)
            .placeholder(R.drawable.progress_spinner)
            .into(image);
        }

        public void setTitle(String title){
            this.title.setText(title);
        }
    }
}
