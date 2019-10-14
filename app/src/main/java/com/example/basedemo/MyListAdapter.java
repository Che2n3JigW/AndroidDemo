package com.example.basedemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    private String[] strings;
    private onItemClickListener itemClickListener;

    //构造函数
    MyListAdapter(String[] strings) {
        this.strings = strings;
    }

    //item点击事件绑定
    void setOnItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    //绑定视图
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity_main, parent, false);
        return new ViewHolder(view);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btn.setText(strings[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    //新建ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AppCompatButton btn;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onClick(getAdapterPosition());
            }
        }
    }

    public interface onItemClickListener {
        void onClick(int position);
    }
}
