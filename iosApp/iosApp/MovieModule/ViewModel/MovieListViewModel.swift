//
//  MoviesViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

final class MovieListViewModel: ObservableObject {
    
    private let moviesSdk: MoviesSdk
    @Published var movies: [MovieViewModel] = []
    @Published var moviesInColumns: [[MovieViewModel]] = []
    
    init(moviesSdk: MoviesSdk) {
        self.moviesSdk = moviesSdk
    }
    
    // Fetch movies and separate in columns
    func fetchMoviesInColumns(numberOfColumns: Int) {
        fetchMovies { [weak self] in
            
            guard let self = self else { return }
            
            var column: [MovieViewModel] = []
            
            for i in 0..<self.movies.count {
                
                if column.count == numberOfColumns {
                    self.moviesInColumns.append(column)
                    column = []
                }
                
                column.append(self.movies[i])
            }
        }
    }
    
    func fetchMovies(completion: (() -> Void)? = nil) {
        moviesSdk.getPopularMovies { [weak self] (response, error) in
            if let response = response as? ResponseSuccess,
               let result = response.data?.results {
                self?.movies = result.map { MovieViewModel(movie: $0) }
                completion?()
            }
        }
    }
}
