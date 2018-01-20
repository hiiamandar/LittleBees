package com.littlebees.andar.littlebees.fragmentutama;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.littlebees.andar.littlebees.R;
import com.littlebees.andar.littlebees.adapter.GridAdapter;


public class FragmentBeranda extends Fragment {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Button pilih;
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_beranda, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.card_view_home);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager  = new GridLayoutManager(getActivity(),1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter();
        mRecyclerView.setAdapter(mAdapter);


        return view ;
    }
}
