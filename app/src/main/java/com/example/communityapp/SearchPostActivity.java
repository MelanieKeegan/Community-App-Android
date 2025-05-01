package com.example.communityapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPostActivity extends AppCompatActivity {

    private EditText inputId;
    private Button searchButton;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_post);

        inputId = findViewById(R.id.inputPostId);
        searchButton = findViewById(R.id.btnSearchPost);
        recyclerView = findViewById(R.id.searchResultsRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchButton.setOnClickListener(v -> {
            String idStr = inputId.getText().toString();
            if (idStr.isEmpty()) {
                Toast.makeText(this, "Enter a post ID", Toast.LENGTH_SHORT).show();
                return;
            }

            long id = Long.parseLong(idStr);
            ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
            Call<Post> call = apiService.getPostById(id);

            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Post result = response.body();
                        postAdapter = new PostAdapter(Collections.singletonList(result));
                        recyclerView.setAdapter(postAdapter);
                    } else {
                        Toast.makeText(SearchPostActivity.this, "Post not found", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Toast.makeText(SearchPostActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
