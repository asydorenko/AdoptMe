package com.example.a1.campr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardsStackAdapter extends ArrayAdapter<Pets> {
    public CardsStackAdapter(Context context, ArrayList<Pets> petCards) {
        super(context, 0, petCards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pets pet = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        ImageView petImage = convertView.findViewById(R.id.image);
        TextView petName = convertView.findViewById(R.id.hello);

        //petImage.setImageBitmap(pet.getPetPic());
        petName.setText(pet.getName());

        return convertView;
    }
}
