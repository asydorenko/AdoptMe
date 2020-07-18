package com.example.a1.campr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Pets> values;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView petPicture;
        public TextView txtHeader;
        public TextView txtFooter;
        public TextView txtId;
        public TextView txtApplication;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            petPicture = v.findViewById(R.id.icon);
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
            txtId =  v.findViewById(R.id.pet_id);
            txtApplication = v.findViewById(R.id.applicants);

            v.setOnClickListener(this);
            /*txtApplication.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!txtApplication.getText().toString().equals("")) {
                        txtApplication.setText("HELLO");
                    }
                }
            });*/
        }

        public void onClick(View v) {
            TextView textView = v.findViewById(R.id.pet_id);
            String key = textView.getText().toString();
            //Pets temp = PetsFragment.myPets.get(key);
            Intent intent = new Intent(v.getContext(), ViewPetsActivity.class);
            intent.putExtra("pet_id", key);
            v.getContext().startActivity(intent);
        }
    }

    /*public void add(int position, Pets item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }*/

    public MyAdapter(List<Pets> myDataset) {
        values = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Pets pet = values.get(position);
        if(pet != null) {
        holder.txtHeader.setText(pet.getName());
        /*holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //add(position, pet);
            }
        });*/

        holder.txtFooter.setText(pet.getGender());
        holder.txtId.setText(pet.getPetId());
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference petPicRef = storage.getReference().child("pets").child(pet.getPetId());
        petPicRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                GlideApp.with(holder.petPicture).load(uri).into(holder.petPicture);
            }
        });
        //holder.petPicture.setImageBitmap(pet.getPetPic());
/*        int index = LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.indexOf(pet);
        int size = LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).listedPets.get(index).applicantId.size();
        if (size > 0) {
            holder.txtApplication.setText(Integer.toString(size));
        }
        if(pet.approved == false) {
            if (pet.applicantId.size() > 0) {
                if (pet.applicantId.size() == 1) {
                    holder.txtApplication.setText("         " + Integer.toString(pet.applicantId.size()) + "\nAPPLICANT");
                } else {
                    holder.txtApplication.setText("          " + Integer.toString(pet.applicantId.size()) + " APPLICANTS");
                }
            }
            else {
                holder.txtApplication.setText("");
            }
        }
        else {
            holder.txtApplication.setText("APPROVED");
        }

        holder.txtApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView apprv = view.findViewById(R.id.applicants);
                String apr_value = apprv.getText().toString();
                Intent intent;
                if(apr_value.equals("APPROVED")) {
                    intent = new Intent(view.getContext(), ViewApplicantActivity.class);
                    intent.putExtra("user_id", pet.approvedId);
                    intent.putExtra("approved", apr_value);
                }
                else {
                    intent = new Intent(view.getContext(), ApplicantsActivity.class);
                    intent.putExtra("pet_id", pet.getPetId());
                }
                view.getContext().startActivity(intent);
            }
        });
 */   }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}
