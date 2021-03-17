//
//  MovieManager.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

protocol MovieManagerProtocol {
    func updateMovie(_ movie: MovieViewModelProtocol)
    func fetchFavoriteMovies() -> [FavoriteMovieViewModel]
    func fetchMoviesAPI(completion: (([MovieViewModel]) -> Void)?)
}

final class MovieManager: MovieManagerProtocol {
    
    private let moviesSdk: MoviesSdk
    
    init(moviesSdk: MoviesSdk) {
        self.moviesSdk = moviesSdk
    }
    
    //MARK: Methods
    func updateMovie(_ movie: MovieViewModelProtocol) {
        if movie.isFavorite {
            removeMovie(movie.id)
        } else {
            saveMovie(movie)
        }
    }
    
    func fetchFavoriteMovies() -> [FavoriteMovieViewModel] {
        let favoriteMovies = moviesSdk.getFavoriteMovies().map { FavoriteMovieViewModel(favoriteMovie: $0) }
        return favoriteMovies
    }

    func fetchMoviesAPI(completion: (([MovieViewModel]) -> Void)? = nil) {
        
        let favoriteMovies = moviesSdk.getFavoriteMovies()
        
        moviesSdk.getPopularMovies { [weak self] (response, error) in
            
            if let response = response as? ResponseSuccess,
               let result = response.data?.results {
                
                let movies: [MovieViewModel] = result.compactMap { [weak self] movie in
                    guard let self = self else { return nil }
                    return self.setMovieFavorite(movie: movie, favoritesList: favoriteMovies)
                }
                completion?(movies)
            }
        }
    }

}

//MARK: Private methods
private extension MovieManager {
    
    func saveMovie(_ movie: MovieViewModelProtocol) {
        let favorite = FavoriteMovie(id: Int64(movie.id),
                                     posterPath: movie.posterPath,
                                     originalTitle: movie.title,
                                     genres: "",
                                     releaseYear: Int32(movie.releaseYear),
                                     overview: movie.overview)
        moviesSdk.saveMovie(favoriteMovie: favorite)
    }
    
    func removeMovie(_ id: Int) {
        moviesSdk.unsaveMovie(idMovie: Int64(id))
    }
    
    func setMovieFavorite(movie: Movie, favoritesList: [FavoriteMovie]) -> MovieViewModel {
        let viewModel = MovieViewModel(movie: movie)
        
        if favoritesList.contains(where: { $0.id == movie.id }) {
            viewModel.isFavorite = true
        }
        
        return viewModel
    }
}
