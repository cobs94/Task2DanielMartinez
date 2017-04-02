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
        View rootView = inflater.inflate(R.layout.fragment_objetos, container, false);

        lstPersonajes = (ListView) rootView.findViewById(R.id.lstPersonajes);

        personajes = new ArrayList<>();

        PersonajesAdapter adapter = new PersonajesAdapter(getActivity(), R.layout.item,personajes);

        lstPersonajes.setAdapter(adapter);
        lstPersonajes.setOnItemClickListener(this);


        personajes.add(new PersonajesBean("nave protagonista la Heart of gold", R.drawable.nave1, "nave1"));
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
