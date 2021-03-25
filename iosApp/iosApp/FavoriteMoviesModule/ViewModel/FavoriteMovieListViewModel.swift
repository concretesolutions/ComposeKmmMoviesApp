//
//  FavoriteMoviesViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

final class FavoriteMovieListViewModel: ObservableObject {
    
    private let manager: MovieManagerProtocol
    @Published var movies: [MovieViewModelProtocol] = []
    
    init(manager: MovieManagerProtocol) {
        self.manager = manager
    }
    
    func fetchMovies() {
        DispatchQueue.main.async { [weak self] in
            self?.manager.fetchFavoriteMovies(completionHandler: { (favorites) in
                self?.movies = favorites
            })
        }
    }
    
    func updateMovie(_ movie: MovieViewModelProtocol) {
        manager.updateMovie(movie)
    }
    
    func removeMovie(at index: Int) {
        let movie = movies[index]
        movies.remove(at: index)
        manager.updateMovie(movie)
    }
    
}


