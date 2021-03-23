//
//  MovieSDK_Native.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 23/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import MoviesSDK

// Adapter Movie
extension Movie: MovieProtocol {}

// Adapter MoviesSDKManager
extension MoviesSDKManager: MoviesSDKProtocol {
    
    func fetchFavoriteMovies(completionHandler: @escaping ([FavoriteMovieViewModel]) -> Void) {
        getFavoriteMovies { (result) in
            switch result {
            case .success(let movies):
                let favorites = movies.map { FavoriteMovieViewModel(favoriteMovie: $0) }
                completionHandler(favorites)
            case .failure(let error):
                print("Error to fetch favorites - \(error)")
                completionHandler([])
            }
        }
    }
    
    func fetchPopularMovies(completionHandler: @escaping (Result<[MovieViewModel], Error>) -> Void) {
        getPopularMovies { (result) in
            switch result {
            case .success(let response):
                let movies = response.results.map { MovieViewModel(movie: $0) }
                completionHandler(.success(movies))
            case .failure(let error):
                completionHandler(.failure(error))
            }
        }
    }
    
    func saveMovie(_ movie: MovieViewModelProtocol) {
        let newMovie = Movie(id: movie.id,
                             title: movie.title,
                             posterPath: movie.posterPath,
                             releaseYear: movie.releaseYear,
                             overview: movie.overview)
        saveMovie(newMovie)
    }
    
    func removeMovie(_ id: Int) {
        unsaveMovie(id)
    }
    
}

