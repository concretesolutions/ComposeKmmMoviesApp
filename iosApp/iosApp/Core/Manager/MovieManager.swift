//
//  MovieManager.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

protocol MovieManagerProtocol {
    func updateMovie(_ movie: MovieViewModelProtocol)
    func fetchFavoriteMovies(completionHandler: @escaping ([MovieViewModelProtocol]) -> Void)
    func fetchMoviesAPI(completion: (([MovieViewModel]) -> Void)?)
}

final class MovieManager: MovieManagerProtocol {
    
    private let moviesSDK: MoviesSDKProtocol
    private var favoriteMovies: [MovieViewModelProtocol]?
    
    init(moviesSDK: MoviesSDKProtocol) {
        self.moviesSDK = moviesSDK
    }
    
    //MARK: Methods
    func updateMovie(_ movie: MovieViewModelProtocol) {
        if movie.isFavorite {
            moviesSDK.removeMovie(movie.id)
        } else {
            moviesSDK.saveMovie(movie)
        }
    }
    
    func fetchFavoriteMovies(completionHandler: @escaping ([MovieViewModelProtocol]) -> Void) {
        moviesSDK.fetchFavoriteMovies(completionHandler: completionHandler)
        
    }
    
    func fetchMoviesAPI(completion: (([MovieViewModel]) -> Void)? = nil) {
        
        let group = DispatchGroup()
        var favoritesMoviesID: [Int] = []
        
        group.enter()
        
        fetchFavoriteMovies { (favorites) in
            favoritesMoviesID = favorites.map( { $0.id })
            group.leave()
        }
        
        group.notify(queue: .main) { [weak self] in
            self?.moviesSDK.fetchPopularMovies { (result) in
                switch result {
                case .success(let movies):
                    
                    movies.forEach { (movie) in
                        if favoritesMoviesID.contains(where: { $0 == movie.id }) {
                            movie.isFavorite = true
                        }
                    }
                    
                    completion?(movies)
                default:
                    break
                }
            }
        }
    }
}
