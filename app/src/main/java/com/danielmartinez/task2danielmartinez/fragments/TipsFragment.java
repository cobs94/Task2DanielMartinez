package com.danielmartinez.task2danielmartinez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.danielmartinez.task2danielmartinez.Adapter.TipsAdapter;
import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.activities.TipActivity;
import com.danielmartinez.task2danielmartinez.bean.PersonajesBean;
import com.danielmartinez.task2danielmartinez.bean.TipsBean;

import java.util.ArrayList;

import static com.danielmartinez.task2danielmartinez.R.string.personajes;

public class TipsFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static TipsFragment newInstance(){
        return new TipsFragment();
    }


    private ArrayList<TipsBean> tips;
    private ListView lstTips;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);

        lstTips = (ListView) rootView.findViewById(R.id.lstTips);

        tips = new ArrayList<>();

        TipsAdapter adapter = new TipsAdapter(getActivity(), R.layout.item,tips);

        lstTips.setAdapter(adapter);
        lstTips.setOnItemClickListener(this);


        tips.add(new TipsBean("Calcula cuando cojer los power up para que no te golpeen al cogerlos", "Tip 1"));
        tips.add(new TipsBean("Golpea al Boss final cuando se le abran las escotillas", "Tip 2"));
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        TipsBean tipsBean = tips.get(posicion);

        Intent intent = new Intent(getActivity(), TipActivity.class);
        intent.putExtra("TIPS_KEY", tipsBean);

        startActivity(intent);
    }
}
