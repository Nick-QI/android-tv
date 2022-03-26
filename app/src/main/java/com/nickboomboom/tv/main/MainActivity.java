package com.nickboomboom.tv.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nickboomboom.tv.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {
    @BindView(R.id.activity_main_recycler)
    RecyclerView channel_recycler_view;
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.init();
    }

    public void init() {

        List<ChannelBean> list = ChannelList.setup();
        GridLayoutManager manager = new GridLayoutManager(this, 8);
        ChanelAdapter adapter = new ChanelAdapter(this, list);

        this.channel_recycler_view.setLayoutManager(manager);
        this.channel_recycler_view.setAdapter(adapter);

        this.channel_recycler_view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                Log.d(TAG, "onKey: " + i + keyEvent);
                return true;
            }
        });
    }


}