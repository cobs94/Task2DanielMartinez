package com.danielmartinez.task2danielmartinez.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.Preferencias;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.LoginActivity;
import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;


public class PerfilFragment extends Fragment {


    private TextView txtNombre, txtApellido, txtNickName, txtEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);
        txtNombre = (TextView) rootView.findViewById(R.id.editNombre);
        txtApellido = (TextView) rootView.findViewById(R.id.editApellido);
        txtNickName = (TextView) rootView.findViewById(R.id.editNickname);
        txtEmail = (TextView) rootView.findViewById(R.id.editEmail);


        UsuarioBean usuarioBean = preferencias.getUsuario();

        txtNombre.setText();
        return rootView;
    }

    public static PerfilFragment newInstance(){
        return new PerfilFragment();
    }
}
