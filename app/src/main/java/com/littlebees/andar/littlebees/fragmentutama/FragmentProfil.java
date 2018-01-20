package com.littlebees.andar.littlebees.fragmentutama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.littlebees.andar.littlebees.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProfil.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfil extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_profil, container, false);
        return view;
    }

}
