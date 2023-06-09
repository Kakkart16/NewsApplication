package com.example.newspilot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homeFragment extends Fragment {
    Adapter adapter;
    String api = "bf2a393676d347bfaad8135c5494680e";
    String country = "in";
    ArrayList<ModelClass> modelClassArrayList;
    private RecyclerView recyclerViewHome;
//    ProgressBar pb;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,(ViewGroup) null);
        recyclerViewHome = view.findViewById(R.id.rvhome);
        modelClassArrayList = new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewHome.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country, 100, api).enqueue(new Callback<news>() {
            public void onResponse(Call<news> call, Response<news> response) {
                if (response.isSuccessful()) {
//                    pb.setVisibility(View.INVISIBLE);
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            public void onFailure(Call<news> call, Throwable t) {
            }
        });
    }
}
