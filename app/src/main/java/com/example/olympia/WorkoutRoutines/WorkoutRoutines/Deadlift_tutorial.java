package com.example.olympia.WorkoutRoutines.WorkoutRoutines;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import com.example.olympia.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Deadlift_tutorial extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadlift_tutorial);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String videoId = "U3da4QV-z04";
                youTubePlayer.loadVideo(videoId, 0); //use cueVideo to load video and thumbnail but doesnt auto play
                 //youTubePlayerView.enterFullScreen();
                //youTubePlayerView.exitFullScreen();
                // youTubePlayerView.isFullScreen();
               youTubePlayerView.toggleFullScreen();
            }
        });
    }
}
/*  youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String videoId = "U3da4QV-z04";
                youTubePlayer.loadVideo(videoId, 0); //use cueVideo to load video and thumbnail but doesnt auto play
                // youTubePlayerView.enterFullScreen();
                //youTubePlayerView.exitFullScreen();
                // youTubePlayerView.isFullScreen();
                //youTubePlayerView.toggleFullScreen();
            }
        }); */