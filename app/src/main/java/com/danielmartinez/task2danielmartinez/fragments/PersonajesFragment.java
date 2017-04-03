package com.danielmartinez.task2danielmartinez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.danielmartinez.task2danielmartinez.Adapter.PersonajesAdapter;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.PersonajesActivity;
import com.danielmartinez.task2danielmartinez.bean.PersonajesBean;

import java.util.ArrayList;


public class PersonajesFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static PersonajesFragment newInstance(){
        return new PersonajesFragment();
    }


    private ArrayList<PersonajesBean> personajes;
    private ListView lstPersonajes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personajes, container, false);

        lstPersonajes = (ListView) rootView.findViewById(R.id.lstPersonajes);

        personajes = new ArrayList<>();

        PersonajesAdapter adapter = new PersonajesAdapter(getActivity(), R.layout.item,personajes);

        lstPersonajes.setAdapter(adapter);
        lstPersonajes.setOnItemClickListener(this);


        personajes.add(new PersonajesBean("Esta nave fue creada en secreto en el planeta Damogran, es la primera en utilizar el motor de Improbabilidad Infinita, el día de su presentación es secuestrada por el presidente de la galaxia Zaphod Beeblebrox. ", R.drawable.nave1, "Heart Of Gold"));
        personajes.add(new PersonajesBean("En el año 2047, se capta desde la Tierra una señal de la nave espacial Event Horizon, desaparecida sin dejar rastro, más allá de Neptuno en 2040. Su pérdida había sido considerada el peor desastre espacial de la historia.  ", R.drawable.nave2, "Event Horizon"));
        personajes.add(new PersonajesBean("Esta simplemente es una nave que no se puede describir, capaz de viajar a través del tiempo y el espacio, soportar temperaturas tan altas como el Sol y tan bajas como el centro de Titan. ", R.drawable.nave3, "HippieVan3000"));
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
        PersonajesBean objetoBean = personajes.get(posicion);

        Intent intent = new Intent(getActivity(), PersonajesActivity.class);
        intent.putExtra("PERSONAJES_KEY", objetoBean);

        startActivity(intent);
    }
}
