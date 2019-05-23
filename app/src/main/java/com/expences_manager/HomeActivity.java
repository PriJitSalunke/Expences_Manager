package com.expences_manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

  //  private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_transaction:
                    //loading the default fragment
                    loadFragment(new transaction_fragment());
                  //  mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_graph:
                    //loading the default fragment
                    loadFragment(new Graph_fragment());
                  //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_categories:
                    //loading the default fragment
                    loadFragment(new transaction_fragment());
                    //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_recurrings:
                    //loading the default fragment
                    loadFragment(new transaction_fragment());
                    //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_more:
                    //loading the default fragment
                    loadFragment(new transaction_fragment());
                    //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //loading the default fragment
        loadFragment(new transaction_fragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
      /*  // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_refresh){
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.action_new){
            Toast.makeText(MainActivity.this, "Create Text", Toast.LENGTH_LONG).show();
        }*/
        return super.onOptionsItemSelected(item);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_transaction:
                fragment = new transaction_fragment();
                break;

            case R.id.navigation_graph:
                fragment = new Graph_fragment();
                break;

        }

        return loadFragment(fragment);
    }
}
