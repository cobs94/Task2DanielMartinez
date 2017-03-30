package com.danielmartinez.task2danielmartinez.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.bean.PersonajesBean;

public class PersonajesActivity extends AppCompatActivity {

    private TextView txtNombre, txtDescripcion;
    private ImageView imgObjeto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);

        Intent intent = getIntent();

        PersonajesBean personajesBean = (PersonajesBean) intent.getSerializableExtra("PERSONAJE_KEY");

        txtNombre.setText(personajesBean.getNombre());
        txtDescripcion.setText(personajesBean.getDescripcion());
        imgObjeto.setImageDrawable(ContextCompat.getDrawable(PersonajesActivity.this, personajesBean.getFoto()));
    }
}
