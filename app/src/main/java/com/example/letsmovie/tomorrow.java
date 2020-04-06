package com.example.letsmovie;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;


/**
 * A simple {@link Fragment} subclass.
 */
public class tomorrow extends Fragment {


    public tomorrow() {
        // Required empty public constructor
    }


//    YouTubePlayerView youTubePlayerView;
//    Button youtubebutton;
//    YouTubePlayer.OnInitializedListener onInitializedListener;
//    YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        View rootView = inflater.inflate(R.layout.fragment_tomorrow,container,false);
//        youTubePlayerView = container.findViewById(R.id.youtube_Player);
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//
//                youTubePlayer.loadVideo("bwzLiQZDw2I");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//
//        youtubebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                youTubePlayerView.initialize(playerConfig.API_KEY,onInitializedListener );
//            }
//        });




        return inflater.inflate(R.layout.fragment_tomorrow, container, false);
    }

}
