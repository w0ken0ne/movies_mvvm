package com.woken.moviesmvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.woken.moviesmvvm.data.repository.NetworkState
import com.woken.moviesmvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId:Int):ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val movieDetails : LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }
    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}