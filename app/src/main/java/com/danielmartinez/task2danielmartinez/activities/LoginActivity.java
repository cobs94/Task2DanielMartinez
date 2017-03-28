package com.danielmartinez.task2danielmartinez.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.danielmartinez.task2danielmartinez.Preferencias;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNickname, editPass;
    private Button btnLogin, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Preferencias preferencias = new Preferencias(LoginActivity.this);
        if (preferencias.isLogin() == false) {

            editNickname = (EditText) findViewById(R.id.editNickname);
            editPass = (EditText) findViewById(R.id.editPass);

            btnLogin = (Button) findViewById(R.id.btnLogin);
            btnRegistro = (Button) findViewById(R.id.btnRegistro);

            btnLogin.setOnClickListener(this);
            btnRegistro.setOnClickListener(this);
        } else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin: //login
                //validar datos
                String email = editNickname.getText().toString();
                String pass = editPass.getText().toString();
                if (email != null && pass != null && !email.isEmpty() && !pass.isEmpty()) {
                    Preferencias preferencias = new Preferencias(LoginActivity.this);
                    UsuarioBean usuarioBean = preferencias.getUsuario();
                    if (usuarioBean.getNick() != null) {
                        if (email.equals(usuarioBean.getNick()) && pass.equals(usuarioBean.getPass())) {

                            preferencias.setLogin(true);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "No existe el usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Datos obligatorios", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnRegistro:
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                break;
        }
    }
}
