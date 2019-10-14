package com.example.basedemo.components4.fragment;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.basedemo.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.disposables.Disposable;


public class FragmentDemoActivity
        extends AppCompatActivity
        implements ArticleFragment.OnArticleCallBack {

    private ArticleFragment articleFragment;
    private CursorLoaderListFragment cursorLoaderListFragment;

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    void showContacts() {
        CursorLoaderListFragment fragment = new CursorLoaderListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        Log.e("===cjw", "???");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            articleFragment = new ArticleFragment();
            cursorLoaderListFragment = new CursorLoaderListFragment();
            articleFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, articleFragment)
                    .add(R.id.fragment_container, cursorLoaderListFragment)
                    .replace(R.id.fragment_container, articleFragment)
                    .commit();

            RxPermissions rxPermissions = new RxPermissions(this);

            Disposable subscribe = rxPermissions
                    .request(Manifest.permission.READ_CONTACTS,
                            Manifest.permission.WRITE_CONTACTS)
                    .subscribe(granted -> {
                        if (granted) {
                            // All requested permissions are granted
                            showContacts();
                        } else {
                            // At least one permission is denied
                            Toast.makeText(this, "拒绝", Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }

    @Override
    public void onArticle(int position) {
        Log.e("===cjw", position + "");
        Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragmentById instanceof ArticleFragment) {
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
