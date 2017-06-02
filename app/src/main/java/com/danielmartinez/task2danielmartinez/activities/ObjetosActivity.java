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
import com.danielmartinez.task2danielmartinez.bean.ObjetoBean;

public class ObjetosActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNombre, txtDescripcion;
    private ImageView imgObjeto;
    private Button btnCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetos);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);
        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(this);

        Intent intent = getIntent();

        ObjetoBean objetoBean = (ObjetoBean) intent.getSerializableExtra("OBJETO_KEY");

        txtNombre.setText(objetoBean.getNombre());
        txtDescripcion.setText(objetoBean.getDescripcion());
        imgObjeto.setImageDrawable(ContextCompat.getDrawable(ObjetosActivity.this, objetoBean.getFoto()));
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
