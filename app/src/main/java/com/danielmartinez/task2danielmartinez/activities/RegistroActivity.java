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
import com.danielmartinez.task2danielmartinez.Utils;
import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editApellido, editNick, editEmail, editPass, editPass2;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editNick = (EditText) findViewById(R.id.editNick);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPass = (EditText) findViewById(R.id.editPass);
        editPass2 = (EditText) findViewById(R.id.editPass2);

        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String nombre = editNombre.getText().toString();
        String apellido = editApellido.getText().toString();
        String nick = editNick.getText().toString();
        String email = editEmail.getText().toString();
        String pass = editPass.getText().toString();
        String pass2 = editPass2.getText().toString();

        if(email!=null && nombre!=null && apellido!=null && pass!=null && pass2!=null && nick!= null &&
                !email.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !pass.isEmpty() && !pass2.isEmpty() && !nick.isEmpty()) {
            if(Utils.isEmail(email)) {
                if(pass.equals(pass2)) {
                    UsuarioBean usuarioBean = new UsuarioBean(apellido, email, nick, nombre, pass2, pass);

                    Preferencias preferencias = new Preferencias(RegistroActivity.this);
                    preferencias.setUsuario(usuarioBean);

                    Toast.makeText(RegistroActivity.this, "Te has registrado correctamente", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(RegistroActivity.this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(RegistroActivity.this, "El email no es correcto", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(RegistroActivity.this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}
