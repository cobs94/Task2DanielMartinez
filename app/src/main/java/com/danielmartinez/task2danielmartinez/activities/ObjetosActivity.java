package com.danielmartinez.task2danielmartinez.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.bean.ObjetosBean;

public class ObjetosActivity extends AppCompatActivity {

    private TextView txtNombre, txtDescripcion;
    private ImageView imgObjeto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);

        Intent intent = getIntent();

        ObjetosBean objetoBean = (ObjetosBean) intent.getSerializableExtra("OBJETO_KEY");

        txtNombre.setText(objetoBean.getNombre());
        txtDescripcion.setText(objetoBean.getDescripcion());
        imgObjeto.setImageDrawable(ContextCompat.getDrawable(ObjetosActivity.this, objetoBean.getFoto()));
    }
}
