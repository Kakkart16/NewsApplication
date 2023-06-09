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

public class healthFragment extends Fragment {
    Adapter adapter;
    String api = "bf2a393676d347bfaad8135c5494680e";
    private String category = "health";
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewHealth;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.healthfragment, (ViewGroup) null);
        recyclerViewHealth = view.findViewById(R.id.rvhealth);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewHealth.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(category,country,100, api).enqueue(new Callback<news>() {
            public void onResponse(Call<news> call, Response<news> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            public void onFailure(Call<news> call, Throwable t) {
            }
        });
    }
}
