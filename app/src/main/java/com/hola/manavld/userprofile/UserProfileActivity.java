package com.hola.manavld.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserProfileActivity extends AppCompatActivity {

    private UserProfile user;
    private TextView name;
    private TextView nickname;
    private TextView followers;
    private TextView following;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        name = findViewById(R.id.textName);
        nickname = findViewById(R.id.textNickname);
        followers = findViewById(R.id.textFollowersNum);
        following = findViewById(R.id.textFollowingNum);
        info = findViewById(R.id.textAboutMe);
        //gson = new Gson();
    }
    private void updateMovie(){
        name.setText(user.getName());
        nickname.setText(user.getNickname());
        following.setText(user.getFollowing());
        followers.setText(user.getFollowers());
        info.setText(user.getAboutme());
    }
}
