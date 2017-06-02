package com.danielmartinez.task2danielmartinez.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.bean.TipBean;

import java.util.List;

/**
 * Created by ALUMNOS on 30/03/2017.
 */
public class TipsAdapter extends ArrayAdapter<TipBean>{

    private Context context;
    private int resource;
    private List<TipBean> objects;
    public TipsAdapter(Context context, int resource, List<TipBean> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layaoutInflater = LayoutInflater.from(context);

        View item = convertView;
        ViewHolder viewHolder;
        if(item ==null){
            viewHolder = new ViewHolder();
            item = layaoutInflater.from(context).inflate(resource,null);
            viewHolder.txtNombre = (TextView) item.findViewById(R.id.txtNombre);

            item.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) item.getTag();
        }

        TipBean tip = objects.get(position);
        viewHolder.txtNombre.setText(tip.getNombre());
        return item;
    }

    class ViewHolder{
        TextView txtNombre;
    }
}
