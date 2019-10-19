package com.example.basedemo.components4.notification;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.basedemo.R;
import com.example.basedemo.databinding.ActivityNotificationDemoBinding;

public class NotificationDemoActivity extends AppCompatActivity {


    private ActivityNotificationDemoBinding binding;
    private NotificationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        binding = DataBindingUtil
                .setContentView(this
                        , R.layout.activity_notification_demo);


        viewModel = ViewModelProviders
                .of(this)
                .get(NotificationViewModel.class);

        binding.setData(viewModel);


    }


}
