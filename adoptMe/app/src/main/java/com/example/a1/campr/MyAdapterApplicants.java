package com.example.a1.campr;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapterApplicants extends RecyclerView.Adapter<MyAdapterApplicants.ViewHolder> {
    private List<User> values;

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
            TextView textView = v.findViewById(R.id.applicants);
            String approved = textView.getText().toString();
            TextView id = v.findViewById(R.id.pet_id);
            String key = id.getText().toString();
            Intent intent = new Intent(v.getContext(), ViewApplicantActivity.class);
            intent.putExtra("user_id", key);
            intent.putExtra("approved", approved);
            v.getContext().startActivity(intent);
        }
    }

    public void add(int position, User item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapterApplicants(List<User> myDataset) {
        values = myDataset;
    }

    @Override
    public MyAdapterApplicants.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        MyAdapterApplicants.ViewHolder vh = new MyAdapterApplicants.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapterApplicants.ViewHolder holder, final int position) {
        final User user = values.get(position);
        holder.txtHeader.setText(user.userName);
        holder.txtFooter.setText(user.userCity);
        //holder.txtFooter.setText(pet.getGender());
        holder.txtId.setText(user.userID);
        //holder.petPicture.setImageBitmap(pet.getPetPic());
        /*if (pet.applicantId.size() > 0 && pet.applicantId.containsKey(Integer.toString(LoginActivity.currentUser))) {
            holder.txtAplication.setText("APPLIED");
        }*/
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

