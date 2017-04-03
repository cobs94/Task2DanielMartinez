package com.danielmartinez.task2danielmartinez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;


public class DescripcionFragment extends Fragment implements View.OnClickListener {

    public static DescripcionFragment newInstance(){
        return new DescripcionFragment();
    }

    private Button btnCompartir;
    private TextView txtDescripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_descripcion, container, false);

        txtDescripcion = (TextView) rootView.findViewById(R.id.txtDescripcion);
        btnCompartir = (Button) rootView.findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
