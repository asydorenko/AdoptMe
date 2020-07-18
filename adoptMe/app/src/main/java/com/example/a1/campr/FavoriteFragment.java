package com.example.a1.campr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FavoriteFragment extends Fragment {
    public static RecyclerView recyclerView;
    public RecyclerView.Adapter mAdapter_favorite;
    public RecyclerView.LayoutManager layoutManager;

   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pets,container,false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView image = getActivity().findViewById(R.id.add_pet);
        image.setVisibility(View.GONE);
        recyclerView = getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //mAdapter_favorite = new MyAdapterFavorite(LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).chosenPets);
        recyclerView.setAdapter(mAdapter_favorite);
    }
}

