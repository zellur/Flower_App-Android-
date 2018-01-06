package com.hfad.flowerapp.FlowerClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.flowerapp.MainActivity;
import com.hfad.flowerapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by rakib on 1/4/18.
 */

public class FlowerAdapter extends ArrayAdapter<FlowerResponse> {


     private Context context;
     private List<FlowerResponse> flowers;



    public FlowerAdapter(@NonNull Context context, List<FlowerResponse> flowers) {

        super(context, R.layout.flower_row,flowers);

        this.context = context;
        this.flowers= flowers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.flower_row,parent,false);

        TextView flowerN = convertView.findViewById(R.id.flowerName);
        TextView flowerP = convertView.findViewById(R.id.flowerPrice);

        flowerN.setText(flowers.get(position).getName());
        flowerP.setText(String.valueOf(flowers.get(position).getPrice()));
        return convertView;
    }
}
