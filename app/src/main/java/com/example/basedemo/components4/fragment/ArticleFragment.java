package com.example.basedemo.components4.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.basedemo.R;

public class ArticleFragment extends Fragment {

    private OnArticleCallBack callBack;

    void setOnArticleCallBack(OnArticleCallBack callBack) {
        this.callBack = callBack;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_article, container, false);
        TextView textView = inflate.findViewById(R.id.textView);
        textView.setOnClickListener(v -> callBack.onArticle(2));
        return inflate;
    }

    public void article(){
        Toast.makeText(getContext(), "文章", Toast.LENGTH_SHORT).show();
    }

    public interface OnArticleCallBack {
        public void onArticle(int position);
    }
}
