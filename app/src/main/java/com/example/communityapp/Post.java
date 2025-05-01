package com.example.communityapp;

import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

public class Post {
    @SerializedName("id") public long Id;
    @SerializedName("userid") public long UserId;
    @SerializedName("title") public String Title;
    @SerializedName("content") public String Content;
    @SerializedName("category") public String Category;
    @SerializedName("location") public String Location;
    @SerializedName("contactinfo") public String ContactInfo;
    @SerializedName("createdat") public DateTime CreatedAt;
}