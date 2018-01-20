package com.littlebees.andar.littlebees.fragmentevaluasisholat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.littlebees.andar.littlebees.R;

/**
 * Created by andar on 12/31/17.
 */

public class ashar_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_ashar_fragment,container,false);

        return view;
    }
}
