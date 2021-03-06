package com.example.letsmovie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideos extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, View.OnClickListener  {
    private static final String TAG = YoutubeVideos.class.getSimpleName();


    public static final String API_KEY = "AIzaSyDUVRKDtu1uGsqC1Zoi7qK3XgfIVAYt36w";

    TextView frozenname , frozentime;
    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String FROZEN_VIDEO_ID = "bwzLiQZDw2I";
    public static final String FORD_VIDEO_ID = "zyYgDtY2AMY";
    public static final String JOKER_VIDEO_ID = "DJEzZk2pc";
    public static final String IT_VIDEO_ID = "QN-zI7bNrrU";
    public static final String EVIL_VIDEO_ID = "n0OFH4xpPr4";
    public static final String AVENGERS_VIDEO_ID = "TcMBFSGVi1c";


    private YouTubePlayer mPlayer;

    private View mPlayButtonLayout;
    private TextView mPlayTimeTextView;

    private Handler mHandler = null;
    private SeekBar mSeekBar;

    private String video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.activity_youtubevideos);

       // this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //set the fragment value to the text view

        Intent intent= getIntent();
        video = intent.getStringExtra("name");

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);

        //Add play button to explicitly play video in YouTubePlayerView
        mPlayButtonLayout = findViewById(R.id.video_control);
        findViewById(R.id.play_video).setOnClickListener(this);
        findViewById(R.id.pause_video).setOnClickListener(this);

        mPlayTimeTextView = (TextView) findViewById(R.id.play_time);
        mSeekBar = (SeekBar) findViewById(R.id.video_seekbar1);
        mSeekBar.setOnSeekBarChangeListener(mVideoSeekBarChangeListener);

        mHandler = new Handler();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (null == player) return;
        mPlayer = player;

        displayCurrentTime();

        // Start buffering
        if (!wasRestored) {

            if(video.equals( "Frozen 2")){
                player.cueVideo(FROZEN_VIDEO_ID);
            }
            else if(video.equals( "Ford vs Ferrai")){
                player.cueVideo(FORD_VIDEO_ID);
            }
            else if(video.equals("IT")){
                player.cueVideo(IT_VIDEO_ID);
            }
            else if(video.equals("Meilficient")){
                player.cueVideo(EVIL_VIDEO_ID);
            }
            else if(video.equals("Joker")){
                player.cueVideo(JOKER_VIDEO_ID);
            }else{
                player.cueVideo(AVENGERS_VIDEO_ID);
            }
//            player.cueVideo(FROZEN_VIDEO_ID);
        }

        player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        mPlayButtonLayout.setVisibility(View.VISIBLE);

        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(mPlayerStateChangeListener);
        player.setPlaybackEventListener(mPlaybackEventListener);
        //player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);
       // player.setFullscreen(true);
    }

    YouTubePlayer.PlaybackEventListener mPlaybackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
            mHandler.removeCallbacks(runnable);
        }

        @Override
        public void onPlaying() {
            mHandler.postDelayed(runnable, 100);
            displayCurrentTime();
        }

        @Override
        public void onSeekTo(int arg0) {
            mHandler.postDelayed(runnable, 100);
        }

        @Override
        public void onStopped() {
            mHandler.removeCallbacks(runnable);
        }
    };

    YouTubePlayer.PlayerStateChangeListener mPlayerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
            displayCurrentTime();
        }
    };

    SeekBar.OnSeekBarChangeListener mVideoSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            long lengthPlayed = (mPlayer.getDurationMillis() * progress) / 100;
            mPlayer.seekToMillis((int) lengthPlayed);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_video:
                if (null != mPlayer && !mPlayer.isPlaying())
                    mPlayer.play();
                break;
            case R.id.pause_video:
                if (null != mPlayer && mPlayer.isPlaying())
                    mPlayer.pause();
                break;
        }
    }

    private void displayCurrentTime() {
        if (null == mPlayer) return;
        String formattedTime = formatTime(mPlayer.getDurationMillis() - mPlayer.getCurrentTimeMillis());
        mPlayTimeTextView.setText(formattedTime);
    }

    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;

        return (hours == 0 ? "--:" : hours + ":") + String.format("%02d:%02d", minutes % 60, seconds % 60);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            displayCurrentTime();
            mHandler.postDelayed(this, 100);
        }
    };



}
