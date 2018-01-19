package com.a99minutos.a99minutoscom.App.ui.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.a99minutos.a99minutoscom.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoPersonalFragment extends Fragment {
    //Entities
    OnHeadlineSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }

    public InfoPersonalFragment() {
        // Required empty public constructor
    }


}
