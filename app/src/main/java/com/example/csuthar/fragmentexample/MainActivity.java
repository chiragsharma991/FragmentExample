package com.example.csuthar.fragmentexample;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmetnInteraction {

    private Handler handler;
    private int navItemIndex=0;
    private String TAG=this.getClass().getSimpleName();
    private  String TAG_FRAGMENT_ONE="FragmentA";
    private  String TAG_FRAGMENT_TWO="FragmentB";
    private  String TAG_FRAGMENT_THREE="FragmentC";
    private String CURRENT_TAG=TAG_FRAGMENT_ONE;
    private Bundle bundle=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler();
        Toast.makeText(this,"activity_blue",Toast.LENGTH_SHORT).show();
        TextView text=(TextView)findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: Main activity." );
            }
        });
        Fragment fragment=getHomeFragment();
        loadHomeFragment(fragment);


    }

    private void loadHomeFragment(final Fragment fragment) {



   /*     if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }*/


        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment,CURRENT_TAG);
                fragmentTransaction.addToBackStack(CURRENT_TAG);
                fragmentTransaction.commit();

            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            handler.post(mPendingRunnable);
        }


    }



    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                return new FragmentA();

            case 1:
                // home
                return new FragmentB();

            case 2:
                // home
                return new FragmentC();


            default:
                return new FragmentA();
        }    }

    @Override

    public void fragmentTransaction(int id) {

        Log.e(TAG, "fragmentTransaction: "+id );

        switch (id){
            case 0:
                navItemIndex=0;
                CURRENT_TAG=TAG_FRAGMENT_ONE;
                Fragment fragment=getHomeFragment();
                loadHomeFragment(fragment);
                break;
            case 1:
                navItemIndex=1;
                CURRENT_TAG=TAG_FRAGMENT_TWO;
                fragment = getHomeFragment();
                if(bundle!=null)fragment.setArguments(bundle);
                loadHomeFragment(fragment);
                break;
            case 2:
                navItemIndex=2;
                CURRENT_TAG=TAG_FRAGMENT_THREE;
                fragment = getHomeFragment();
                loadHomeFragment(fragment);
                break;
            default:
                break;

        }
    }

    @Override
    public void fragmentPutData(Bundle bundle) {
        Log.e(TAG, "fragmentPutData: " );
        this.bundle=bundle;
    }

    @Override
    public void onBackPressed() {

        Log.e(TAG, "onBackPressed: "+getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_TWO) );
        Fragment fragment=getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_TWO);
        if(fragment instanceof FragmentB ){
            Log.e(TAG, "onBackPressed: fragment b okkk " );
        }
        getSupportFragmentManager().popBackStackImmediate(TAG_FRAGMENT_TWO, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        //getSupportFragmentManager().beginTransaction().commit();
        // super.onBackPressed();


    }
}
