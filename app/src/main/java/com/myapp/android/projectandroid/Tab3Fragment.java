package com.myapp.android.projectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab3Fragment extends Fragment {
    public Tab3Fragment()
    {

    }
    private static final String TAG = "Tab3Fragment";

    private Button btnTEST,b1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment,container,false);


       Button purple=(Button)view.findViewById(R.id.courses);
        purple.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Couses.class);
                startActivity(intent);
            }
        });
        Button hr=(Button)view.findViewById(R.id.hr);
        hr.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),hrword.class);
                startActivity(intent);
            }
        });
        Button qn=(Button)view.findViewById(R.id.qn);
        qn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Queries.class);
                startActivity(intent);
            }
        });
        Button hack=(Button)view.findViewById(R.id.hack);
        hack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Hackathons.class);
                startActivity(intent);
            }
        });
        return view;
    }




}

