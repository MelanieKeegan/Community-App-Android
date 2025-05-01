package com.example.communityapp;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("api/Post/all")
    Call<List<Post>> getPosts();

    @POST("api/Post")
    Call<Post> createPost(@Body Post post);

    @GET("/api/Post/{id}")
    Call<Post> getPostById(@Path("id") long id);

    @GET("/api/users")
    Call<List<User>> getAllUsers();
}
