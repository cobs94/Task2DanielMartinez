package com.danielmartinez.task2danielmartinez.activities;

import android.app.Activity;
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
import com.danielmartinez.task2danielmartinez.fragments.PerfilFragment;

public class CambioDatosActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editApellido, editNick, editEmail, editPass, editPass2;
    private Button btnCambiarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_datos);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editNick = (EditText) findViewById(R.id.editNick);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPass = (EditText) findViewById(R.id.editPass);
        editPass2 = (EditText) findViewById(R.id.editPass2);
        btnCambiarDatos = (Button) findViewById(R.id.btnCambiarDatos);

        btnCambiarDatos.setOnClickListener(this);

        Preferencias preferencias = new Preferencias(CambioDatosActivity.this);
        UsuarioBean usuarioBean = preferencias.getUsuario();

        editNombre.setText(usuarioBean.getNombre());
        editApellido.setText(usuarioBean.getApellido());
        editNick.setText(usuarioBean.getNick());
        editEmail.setText(usuarioBean.getEmail());
        editPass.setText(usuarioBean.getPass());
        editPass2.setText(usuarioBean.getPass2());

        btnCambiarDatos = (Button) findViewById(R.id.btnCambiarDatos);
    }

    @Override
    public void onClick(View v) {
        String nombre = (editNombre.getText().toString());
        String apellido = (editApellido.getText().toString());
        String nick = (editNick.getText().toString());
        String email = (editEmail.getText().toString());
        String pass = (editPass.getText().toString());
        String pass2 = (editPass2.getText().toString());

        if(email!=null && nombre!=null && apellido!=null && pass!=null && pass2!=null && nick!= null &&
                !email.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !pass.isEmpty() && !pass2.isEmpty() && !nick.isEmpty()) {
            if(Utils.isEmail(email)) {
                if(pass.equals(pass2)) {

                    Preferencias preferencias = new Preferencias(CambioDatosActivity.this);
                    UsuarioBean usuarioBean = preferencias.getUsuario();

                    UsuarioBean nuevousuario = new UsuarioBean(apellido, email, nick, nombre, pass2, pass);


                    usuarioBean.setNombre(nuevousuario.getNombre());
                    usuarioBean.setApellido(nuevousuario.getApellido());
                    usuarioBean.setEmail(nuevousuario.getEmail());
                    usuarioBean.setNick(nuevousuario.getNick());
                    usuarioBean.setPass(nuevousuario.getPass());

                    preferencias.setUsuario(usuarioBean);

                    Toast.makeText(CambioDatosActivity.this, R.string.registro, Toast.LENGTH_SHORT).show();

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("DATOS_KEY", usuarioBean);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();

                }else {
                    Toast.makeText(CambioDatosActivity.this, R.string.contrasenas, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(CambioDatosActivity.this, R.string.emailIncorrecto, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(CambioDatosActivity.this, R.string.datosObligatorios, Toast.LENGTH_SHORT).show();
        }
    }
}
