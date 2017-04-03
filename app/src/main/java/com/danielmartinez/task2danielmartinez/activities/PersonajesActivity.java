package com.danielmartinez.task2danielmartinez.activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.bean.PersonajesBean;

public class PersonajesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNombrePers, txtDescripcionPers;
    private ImageView imgPers;
    private Button btnCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        txtNombrePers = (TextView) findViewById(R.id.txtNombre);
        txtDescripcionPers = (TextView) findViewById(R.id.txtDescripcion);
        imgPers = (ImageView) findViewById(R.id.imgPers);
        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(this);

        Intent intent = getIntent();

        PersonajesBean personajesBean = (PersonajesBean) intent.getSerializableExtra("PERSONAJES_KEY");

        txtNombrePers.setText(personajesBean.getNombre());
        txtDescripcionPers.setText(personajesBean.getDescripcion());
        imgPers.setImageDrawable(ContextCompat.getDrawable(PersonajesActivity.this, personajesBean.getFoto()));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcionPers.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
