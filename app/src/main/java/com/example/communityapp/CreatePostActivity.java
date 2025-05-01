package com.example.communityapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePostActivity extends AppCompatActivity {

    private EditText titleInput, contentInput, categoryInput, locationInput, contactInput;
    private Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        titleInput = findViewById(R.id.inputTitle);
        contentInput = findViewById(R.id.inputContent);
        categoryInput = findViewById(R.id.inputCategory);
        locationInput = findViewById(R.id.inputLocation);
        contactInput = findViewById(R.id.inputContact);
        postButton = findViewById(R.id.btnSubmitPost);

        postButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String content = contentInput.getText().toString();
            String category = categoryInput.getText().toString();
            String location = locationInput.getText().toString();
            String contact = contactInput.getText().toString();

            Post newPost = new Post();
            newPost.Title = title;
            newPost.Content = content;
            newPost.Category = category;
            newPost.Location = location;
            newPost.ContactInfo = contact;

            ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
            Call<Post> call = apiService.createPost(newPost);

            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(CreatePostActivity.this, "Post created!", Toast.LENGTH_SHORT).show();
                        finish(); // go back to MainActivity
                    } else {
                        Toast.makeText(CreatePostActivity.this, "Failed to create post", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Toast.makeText(CreatePostActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
