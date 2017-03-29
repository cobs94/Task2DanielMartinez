package com.danielmartinez.task2danielmartinez.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;


public class PerfilFragment extends Fragment {


    private TextView txtNombre, txtApellido, txtNickName, txtEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        txtNickName = (TextView) findViewById(R.id.editNickname);

        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    public static PerfilFragment newInstance(){
        return new PerfilFragment();
    }
}
