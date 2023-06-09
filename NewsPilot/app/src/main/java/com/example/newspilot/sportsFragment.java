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

public class sportsFragment extends Fragment {
    Adapter adapter;
    String api = "bf2a393676d347bfaad8135c5494680e";
    private String category = "sports";
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewSports;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sportsfragment, (ViewGroup) null);
        recyclerViewSports = view.findViewById(R.id.rvsports);
        modelClassArrayList = new ArrayList<>();
        recyclerViewSports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewSports.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(category, country, 100, api).enqueue(new Callback<news>() {
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
