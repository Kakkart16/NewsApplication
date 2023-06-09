package com.example.newspilot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class technologyFragment extends Fragment {
    Adapter adapter;
    String api = "bf2a393676d347bfaad8135c5494680e";
    private String category = "technology";
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewTechnology;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technologyfragment, (ViewGroup) null);
        this.recyclerViewTechnology = (RecyclerView) view.findViewById(R.id.rvtechnology);
        this.modelClassArrayList = new ArrayList<>();
        this.recyclerViewTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter adapter2 = new Adapter(getContext(), this.modelClassArrayList);
        this.adapter = adapter2;
        this.recyclerViewTechnology.setAdapter(adapter2);
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(this.category, this.country, 100, this.api).enqueue(new Callback<news>() {
            public void onResponse(Call<news> call, Response<news> response) {
                if (response.isSuccessful()) {
                    technologyFragment.this.modelClassArrayList.addAll(response.body().getArticles());
                    technologyFragment.this.adapter.notifyDataSetChanged();
                }
            }

            public void onFailure(Call<news> call, Throwable t) {
            }
        });
    }
}

