package com.danielmartinez.task2danielmartinez.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielmartinez.task2danielmartinez.R;


public class AjustesFragment extends Fragment {

    public static AjustesFragment newInstance(){
        return new AjustesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ajustes, container, false);
    }
}
