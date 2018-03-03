package com.tinysun.secretlottosix;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import static com.tinysun.secretlottosix.DummyData.PREVIOUS_ROUNDS;
import static com.tinysun.secretlottosix.DummyData.PREVIOUS_WINNING_NUM_LIST;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_generate:
                    selectedFragment = FragmentGenerate.newInstance();
                    break;
                case R.id.navigation_purchase:
                    selectedFragment = FragmentPurchase.newInstance();
                    break;
                case R.id.navigation_history:
                    selectedFragment = FragmentHistory.newInstance();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentGenerate.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);


        // 더미 데이터 입력
        setDummyData();
    }

    public void setDummyData(){
        PREVIOUS_ROUNDS = 1256;

        PREVIOUS_WINNING_NUM_LIST = new ArrayList<>();
        PREVIOUS_WINNING_NUM_LIST.add(0, 2);
        PREVIOUS_WINNING_NUM_LIST.add(1, 5);
        PREVIOUS_WINNING_NUM_LIST.add(2, 16);
        PREVIOUS_WINNING_NUM_LIST.add(3, 32);
        PREVIOUS_WINNING_NUM_LIST.add(4, 35);
        PREVIOUS_WINNING_NUM_LIST.add(5, 41);
        //PREVIOUS_WINNING_NUM_LIST.add(6, 25); // 보너스 번호
    }

}
