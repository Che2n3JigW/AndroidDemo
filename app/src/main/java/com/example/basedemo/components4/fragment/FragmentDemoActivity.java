package com.example.basedemo.components4.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.basedemo.R;

public class FragmentDemoActivity extends AppCompatActivity implements ArticleFragment.OnArticleCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ArticleFragment articleFragment = new ArticleFragment();
            articleFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
//                    .add(R.id.fragment_container, articleFragment)
                    .replace(R.id.fragment_container, articleFragment)
                    .commit();
        }
    }

    @Override
    public void onArticle(int position) {
        Log.e("===cjw", position + "");
        Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragmentById instanceof ArticleFragment){
            ((ArticleFragment) fragmentById).article();
        }
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof ArticleFragment) {
            ((ArticleFragment) fragment).setOnArticleCallBack(this);
        }
    }
}
