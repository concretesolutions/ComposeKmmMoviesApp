//
//  FavoriteMoviesViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

final class FavoriteMovieListViewModel: ObservableObject {
    
    private let manager: MovieManager
    @Published var movies: [FavoriteMovieViewModel] = []
    
    init(manager: MovieManager) {
        self.manager = manager
    }
    
    func fetchMovies() {
        movies = manager.fetchFavoriteMovies()
    }
    
    func updateMovie(_ movie: MovieViewModelProtocol) {
        manager.updateMovie(movie)
    }
    
    func removeMovie(at index: Int) {
        let movie = movies[index]
        manager.updateMovie(movie)
        movies.remove(at: index)
    }
    
}


