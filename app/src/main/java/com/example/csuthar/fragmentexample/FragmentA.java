package com.example.csuthar.fragmentexample;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    private String TAG=FragmentA.class.getSimpleName();
    private Context context;
    private FragmetnInteraction listner;
    public static int resultCode=1;
    private View view;
    private Button save;
    private TextView textView;
    private EditText phn;
    private EditText name;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " );
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        listner=(FragmetnInteraction)context;
        Log.e(TAG, "onAttach: " );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: " );
        textView=(TextView)view.findViewById(R.id.text);
        phn=(EditText)view.findViewById(R.id.phn);
        name=(EditText)view.findViewById(R.id.name);
        save=(Button) view.findViewById(R.id.save);

        save.setOnClickListener(this);
        textView.setOnClickListener(this);

        //ProgressDialog progressDialog=new ProgressDialog(context);
        //progressDialog.setMessage("Loading ...");
        //progressDialog.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: " );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
        Log.e(TAG, "count : "+getFragmentManager().getBackStackEntryCount() );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: " );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: "+requestCode+" "+resultCode+" "+data.getStringExtra("TEST") );


    }
    public void test(){
        Log.e(TAG, "test: " );
    }



    @Override
    public void onClick(View view) {

        if(view==save){
            Bundle bundle=new Bundle();
          //  bundle.putString("NAME",name.getText().toString());
          //  bundle.putLong("PHN", Long.parseLong(phn.getText().toString()));
            listner.fragmentPutData(bundle);
        }else if(view==textView){
            listner.fragmentTransaction(1);
        }
    }
}
