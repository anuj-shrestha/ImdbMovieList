package com.example.anuj.imdbmovielist;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * Created by anuj on 5/4/17.
 * Presenter for managing main view, logics and api call.
 */

public class ImdbMainPresenter implements ImdbContract.Presenter {
    private ImdbContract.View imdbView;
    private ImdbInteractor imdbInteractor;
    private ImdbInteractor.SearchMovieCallback searchMovieCallback;

    public ImdbMainPresenter(ImdbInteractor imdbInteractor) {
        this.imdbInteractor = imdbInteractor;
        this.searchMovieCallback = new SearchCallbackImplementation();
    }
//    public ImdbMainPresenter(ImdbInteractor imdbInteractor) {
//        this.imdbInteractor = imdbInteractor;
//        this.searchMovieCallback = new SearchCallbackImplementation();
//    }



    public void setImdbiView(ImdbContract.View ImdbView) {
        this.imdbView = ImdbView;
    }

    public void onShowSearchBox() {
        imdbView.showSearchBox();
    }

    public void onRemoveSearchBox() {
        imdbView.removeSearchBox();
    }

    @Override
    public void searchMovies(String searchQuery) {
        imdbInteractor.searchMovies(searchQuery, searchMovieCallback);
    }

    /**
     * Implements callbacks for search movies method.
     */
    public class SearchCallbackImplementation implements ImdbInteractor.SearchMovieCallback {

        @Override
        public void onSuccess(ArrayList<Results> movies) {
            imdbView.removeSpinner();
            imdbView.setMovieListAdapterData(movies);
        }

        @Override
        public void onFailure(String errorMessage) {
            imdbView.removeSpinner();
            imdbView.displayErrorMessage("Error has occured");
        }
    }

}
