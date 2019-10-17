package com.example.basedemo.mvvm;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basedemo.R;
import com.example.basedemo.databinding.ItemContributorBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Contributor> data;

    MyAdapter() {
        setHasStableIds(true);
    }

    public void setData(List<Contributor> data) {
        this.data = data;
        notifyItemRangeInserted(0, data.size());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContributorBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_contributor, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setData(data.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemContributorBinding binding;

        MyViewHolder(ItemContributorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
