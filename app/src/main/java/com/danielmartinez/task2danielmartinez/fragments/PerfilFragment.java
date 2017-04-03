package com.danielmartinez.task2danielmartinez.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.Preferencias;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.CambioDatosActivity;
import com.danielmartinez.task2danielmartinez.activities.LoginActivity;
import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;

import java.io.IOException;


public class PerfilFragment extends Fragment implements View.OnClickListener {


    private TextView txtNombre, txtApellido, txtNickName, txtEmail;
    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";

    private final int SELECT_PICTURE = 200;
    private final int CHANGE_DATA = 100;

    private ImageView imgPerfil;
    private Button btnCambiarImagen;
    private Button btnCambiarDatos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);
        txtNombre = (TextView) rootView.findViewById(R.id.txtNombre);
        txtApellido = (TextView) rootView.findViewById(R.id.txtApellido);
        txtNickName = (TextView) rootView.findViewById(R.id.txtNickName);
        txtEmail = (TextView) rootView.findViewById(R.id.txtEmail);
        imgPerfil = (ImageView) rootView.findViewById(R.id.imgPerfil);
        btnCambiarImagen = (Button) rootView.findViewById(R.id.btnCambiarImg);
        btnCambiarDatos = (Button) rootView.findViewById(R.id.btnCambiarDatos);

        Preferencias preferencias = new Preferencias(getActivity());
        UsuarioBean usuarioBean = preferencias.getUsuario();

        txtNombre.setText("Nombre: " + usuarioBean.getNombre());
        txtApellido.setText("Apellido: " + usuarioBean.getApellido());
        txtEmail.setText("Email: " +  usuarioBean.getEmail());
        txtNickName.setText("Nick: " + usuarioBean.getNick());

        btnCambiarImagen.setOnClickListener(this);
        btnCambiarDatos.setOnClickListener(this);

        if(usuarioBean.getImgPerfil() != null && !usuarioBean.getImgPerfil().isEmpty()){
            Uri path = Uri.parse(usuarioBean.getImgPerfil());

            imgPerfil.setImageURI(path);
        }

        return rootView;
    }

    public static PerfilFragment newInstance(){
        return new PerfilFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCambiarImg:
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "Selecciona app de imagen"), SELECT_PICTURE);
                break;
            case R.id.btnCambiarDatos:
                Intent intent2 = new Intent(getActivity(), CambioDatosActivity.class);

                startActivityForResult(intent2, CHANGE_DATA);


        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200) {
            if (resultCode == Activity.RESULT_OK) {
                Uri path = data.getData();

                imgPerfil.setImageURI(path);

                Preferencias preferencias = new Preferencias(getActivity());
                UsuarioBean usuarioBean = preferencias.getUsuario();

                usuarioBean.setImgPerfil(path.toString());
                preferencias.setUsuario(usuarioBean);
            }
        }else{
            if (resultCode == Activity.RESULT_OK) {
                UsuarioBean nuevousuario = (UsuarioBean) data.getSerializableExtra("DATOS_KEY");

                Preferencias preferencias = new Preferencias(getActivity());
                UsuarioBean usuarioBean = preferencias.getUsuario();

                usuarioBean = nuevousuario;
            }
        }
    }
}
