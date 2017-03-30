package com.danielmartinez.task2danielmartinez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.danielmartinez.task2danielmartinez.Adapter.ObjetosAdapter;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.ObjetosActivity;
import com.danielmartinez.task2danielmartinez.bean.ObjetosBean;

import java.util.ArrayList;

public class ObjetosFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static ObjetosFragment newInstance(){
        return new ObjetosFragment();
    }


    private ArrayList<ObjetosBean> objetos;
    private ListView lstObjetos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_objetos, container, false);

        lstObjetos = (ListView) rootView.findViewById(R.id.lstObjetos);

        objetos = new ArrayList<>();

        ObjetosAdapter adapter = new ObjetosAdapter(getActivity(), R.layout.item,objetos);

        lstObjetos.setAdapter(adapter);
        lstObjetos.setOnItemClickListener(this);


        objetos.add(new ObjetosBean("nave protagonista la Heart of gold", R.drawable.nave1, "nave1"));
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        ObjetosBean objetoBean = objetos.get(posicion);

        Intent intent = new Intent(getActivity(), ObjetosActivity.class);
        intent.putExtra("OBJETO_KEY", objetoBean);

        startActivity(intent);
    }
}
