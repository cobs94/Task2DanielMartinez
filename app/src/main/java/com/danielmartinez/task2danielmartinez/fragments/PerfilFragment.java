package com.danielmartinez.task2danielmartinez.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.Preferencias;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.LoginActivity;
import com.danielmartinez.task2danielmartinez.bean.UsuarioBean;

import java.io.IOException;


public class PerfilFragment extends Fragment implements View.OnClickListener {


    private TextView txtNombre, txtApellido, txtNickName, txtEmail;
    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";

    private final int SELECT_PICTURE = 200;
    private ImageView imgPerfil;
    private Button btnCambiarImagen;


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

        Preferencias preferencias = new Preferencias(getActivity());
        UsuarioBean usuarioBean = preferencias.getUsuario();

        txtNombre.setText("Nombre: " + usuarioBean.getNombre());
        txtApellido.setText("Apellido: " + usuarioBean.getApellido());
        txtEmail.setText("Email: " +  usuarioBean.getEmail());
        txtNickName.setText("Nick: " + usuarioBean.getNick());

        btnCambiarImagen.setOnClickListener(this);


        return rootView;
    }

    public static PerfilFragment newInstance(){
        return new PerfilFragment();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent, "Selecciona app de imagen"), SELECT_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            Uri path = data.getData();
            imgPerfil.setImageURI(path);

            Preferencias preferencias = new Preferencias(getActivity());
            UsuarioBean usuarioBean = preferencias.getUsuario();

            usuarioBean.setImgPerfil(path.toString());

            Bitmap bitmap = null;
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), path);

                imgPerfil.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
