package com.hola.manavld.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserProfileActivity extends AppCompatActivity {

    private UserProfile user;
    private TextView name;
    private TextView nickname;
    private TextView followers;
    private TextView following;
    private TextView info;
    private ImageView picture;
    private ImageView background;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        name = findViewById(R.id.textName);
        nickname = findViewById(R.id.textNickname);
        followers = findViewById(R.id.textFollowersNum);
        following = findViewById(R.id.textFollowingNum);
        info = findViewById(R.id.textAboutMe);
        picture = findViewById(R.id.imageView2);
        background = findViewById(R.id.imageView3);

        gson = new Gson();

        Glide.with(this).load("file:///android_asset/UserProfile-background.jpg").into(background);
        Glide.with(this).load("file:///android_asset/manav.jpg").apply(RequestOptions.circleCropTransform()).into(picture);

        try{
            InputStream input_stream = getAssets().open("JohnDoe.json");
            InputStreamReader streamReader = new InputStreamReader(input_stream);
            user = gson.fromJson(streamReader,UserProfile.class);
        }catch (IOException e){
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }

        updateMovie();

    }
    private void updateMovie(){
        name.setText(user.getName());
        nickname.setText(user.getNickname());
        following.setText(user.getFollowing());
        followers.setText(user.getFollowers());
        info.setText(user.getAboutme());
    }
}
