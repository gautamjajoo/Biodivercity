package com.example.sridhar123.biodiversity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BioBaseActivity{

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.my_feed)
    RecyclerView myFeed;

    ArrayList<NewPost> newPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        gettingUserData();
    }

    @OnClick(R.id.fab)
    public void fabAction() {
        Intent intent = new Intent(MainActivity.this, CreateNewPost.class);
        startActivity(intent);
        finish();
    }

    private void setUpRecyclerView(ArrayList<NewPost> a) {
        MyFeedAdapter myFeedAdapter = new MyFeedAdapter(a, MainActivity.this);
        myFeed.setLayoutManager(new LinearLayoutManager(this));
        myFeed.setAdapter(myFeedAdapter);
    }

    public void gettingUserData() {
        Bundle b = getIntent().getExtras();
        if(b!=null) {
            if(getIntent().hasExtra("list")) {
                Bundle bundle = getIntent().getExtras();
                if(bundle!=null) {
                    newPosts = (ArrayList<NewPost>) bundle.getSerializable("list");
                    setUpRecyclerView(newPosts);
                }
            }
        }
    }
}
