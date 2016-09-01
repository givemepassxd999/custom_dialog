package com.example.givemepass.custommenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final OptionDialog mOptionDialog = new OptionDialog(MainActivity.this);
                mOptionDialog.findViewById(R.id.dialog_outside).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOptionDialog.dismiss();
                    }
                });
                mOptionDialog.setOnItemClickListener(new OptionDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Toast.makeText(MainActivity.this, "item " + (pos + 1) + " 被按下。", Toast.LENGTH_SHORT).show();
                        mOptionDialog.dismiss();
                    }
                });
                mOptionDialog.show();
                return false;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
