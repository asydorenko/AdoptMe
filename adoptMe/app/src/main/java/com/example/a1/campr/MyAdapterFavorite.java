package com.example.a1.campr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*public class MyAdapterFavorite extends RecyclerView.Adapter<MyAdapterFavorite.ViewHolder> {
    private List<Pets> values;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView petPicture;
        public TextView txtHeader;
        public TextView txtFooter;
        public TextView txtId;
        public TextView txtAplication;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            petPicture = (ImageView) v.findViewById(R.id.icon);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtId = (TextView) v.findViewById(R.id.pet_id);
            txtAplication = v.findViewById(R.id.applicants);

            v.setOnClickListener(this);
        }

        public void onClick(View v) {
            TextView applied = v.findViewById(R.id.applicants);
            String app = applied.getText().toString();
            TextView textView = v.findViewById(R.id.pet_id);
            String key = textView.getText().toString();
            Pets temp = AdopterActivity.myChosenPets.get(key);
            Intent intent = new Intent(v.getContext(), ViewPetsFavorite.class);
            intent.putExtra("parcel_data", temp);
            intent.putExtra("applied_value", app);
            v.getContext().startActivity(intent);
        }
    }

    public void add(int position, Pets item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapterFavorite(List<Pets> myDataset) {
        values = myDataset;
    }

    @Override
    public MyAdapterFavorite.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapterFavorite.ViewHolder holder, final int position) {
        final Pets pet = values.get(position);
        holder.txtHeader.setText(pet.getName());
        /*holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //add(position, pet);
            }
        });*/

        /*holder.txtFooter.setText(pet.getGender());
        holder.txtId.setText(pet.getPetId());
        holder.petPicture.setImageBitmap(pet.getPetPic());
        /*if (pet.applicantId.size() > 0 && pet.applicantId.containsKey(Integer.toString(LoginActivity.currentUser))) {
            holder.txtAplication.setTextColor(Color.parseColor("#ff669900"));
            holder.txtAplication.setText("APPLIED");
        }*/
        /*if(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).appliedPets.containsKey(pet.getPetId())) {
            if (LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).appliedPets.get(pet.getPetId()).equals("approved")) {
                holder.txtAplication.setTextColor(Color.parseColor("#ff669900"));
                holder.txtAplication.setText("APPROVED");
            }
            else if (LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).appliedPets.get(pet.getPetId()).equals("declined")) {
                holder.txtAplication.setTextColor(Color.RED);
                holder.txtAplication.setText("DECLINED");
            }
            else if (LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).appliedPets.get(pet.getPetId()).equals("applied")) {
                holder.txtAplication.setTextColor(Color.parseColor("#ff669900"));
                holder.txtAplication.setText("APPLIED");
            }
        }
        else {
            holder.txtAplication.setText("");
        }*//*
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}*/
