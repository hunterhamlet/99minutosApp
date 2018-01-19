package com.a99minutos.a99minutoscom.App.ui.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a99minutos.a99minutoscom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoVehicleFragment extends Fragment {


    public InfoVehicleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_vehicle, container, false);
    }

}
