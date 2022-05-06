package com.example.gsonapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    MainActivity mainActivity;
    List<Example> dataList;
    public RecyclerAdapter(MainActivity mainActivity, List<Example> datalist) {
        this.dataList=datalist;
        this.mainActivity=mainActivity;

        }


    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.profile,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {

        holder.id.setText("ID:"+dataList.get(position).getId());
        holder.userid.setText("UserID:"+dataList.get(position).getUserId());
        holder.title.setText("Title:"+dataList.get(position).getTitle());
        holder.body.setText("Body:"+dataList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        TextView id,userid,title,body;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            userid=itemView.findViewById(R.id.userid);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
