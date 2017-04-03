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
import com.danielmartinez.task2danielmartinez.bean.TipsBean;

public class TipActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNombreTip, txtDescripcionTip;
    private Button btnCompartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        txtNombreTip = (TextView) findViewById(R.id.txtNombre);
        txtDescripcionTip = (TextView) findViewById(R.id.txtDescripcion);
        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(this);

        Intent intent = getIntent();

        TipsBean tipsBean = (TipsBean) intent.getSerializableExtra("TIPS_KEY");

        txtNombreTip.setText(tipsBean.getNombre());
        txtDescripcionTip.setText(tipsBean.getDescripcion());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, txtDescripcionTip.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
