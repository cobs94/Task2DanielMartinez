package com.danielmartinez.task2danielmartinez.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielmartinez.task2danielmartinez.R;


public class DescripcionFragment extends Fragment {

    public static DescripcionFragment newInstance(){
        return new DescripcionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_descripcion, container, false);
    }

}
