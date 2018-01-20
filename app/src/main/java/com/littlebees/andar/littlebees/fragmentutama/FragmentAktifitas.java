package com.littlebees.andar.littlebees.fragmentutama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.littlebees.andar.littlebees.R;
import com.littlebees.andar.littlebees.adapter.GridAdapterAktifitas;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentAktifitas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentAktifitas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAktifitas extends Fragment {


    RecyclerView mRecyclerView1;
    RecyclerView.LayoutManager mLayoutManager1;
    RecyclerView.Adapter mAdapter1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_aktifitas, container, false);
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.card_view_aktifitas);
        mRecyclerView1.setHasFixedSize(true);

        mLayoutManager1  = new GridLayoutManager(getActivity(),2);
        mRecyclerView1.setLayoutManager(mLayoutManager1);

        mAdapter1 = new GridAdapterAktifitas();
        mRecyclerView1.setAdapter(mAdapter1);

        return view ;
    }

}
