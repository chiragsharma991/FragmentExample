package com.example.csuthar.fragmentexample;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class FragmentB extends Fragment {

    private String TAG=FragmentB.class.getSimpleName();
    private Context context;
    private View view;
    private FragmetnInteraction listner;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " );
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_b, container, false);
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
       // Log.e(TAG, "onActivityCreated: " );
        String user=getArguments().getString("NAME","");
        long number=getArguments().getLong("PHN",0);
        Log.e(TAG, "onActivityCreated: arguments"+user+" "+number );
        TextView textView=(TextView)view.findViewById(R.id.text);
        EditText phn=(EditText)view.findViewById(R.id.phn);
        EditText name=(EditText)view.findViewById(R.id.name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.fragmentTransaction(2);
            }
        });
       // ProgressDialog progressDialog=new ProgressDialog(context);
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
}
