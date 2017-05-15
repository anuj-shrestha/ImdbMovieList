package com.example.anuj.imdbmovielist.MovieDetail;

import android.content.Context;
import android.widget.ImageView;

import com.example.anuj.imdbmovielist.Results;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

/**
 * Created by anuj on 5/4/17.
 */

public interface MovieDetailContract {

    interface View {
        void removeSpinner();

        void removeMiniSpinner();

        void applyFormatedReleasedDate(String releasedDate);

        void showErrorMessage(String errorMessage);

        void setVideosToAdapter(ArrayList<Results> vidoes, String backDropUri);

        void loadVideo (String videoId);
    }

    interface Presenter {
        void setMovieDetailView(MovieDetailContract.View movieDetailView);

        void showMainPoster(Context context, String mainPoster, ImageView posterImageView);

        void showTitlePoster(Context context, String titlePoster, ImageView miniPosterImageView);

        void applyFormatedReleasedDate(String tmdbReleaseDate);

        void fetchVideos(String id, String backDropUri);
    }
}
