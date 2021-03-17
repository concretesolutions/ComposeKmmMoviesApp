//
//  MoviesViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

final class MovieListViewModel: ObservableObject {
    
    private let manager: MovieManagerProtocol
    @Published var moviesInColumns: [[MovieViewModel]] = []
    
    init(manager: MovieManagerProtocol) {
        self.manager = manager
    }
    
    // Fetch movies and separate in columns
    func fetchMoviesInColumns(numberOfColumns: Int) {
        
        moviesInColumns = []
        
        manager.fetchMoviesAPI { [weak self] movies in
            
            guard let self = self else { return }
            
            var column: [MovieViewModel] = []
            
            
            for i in 0..<movies.count {
                
                if column.count == numberOfColumns {
                    self.moviesInColumns.append(column)
                    column = []
                }
                
                column.append(movies[i])
            }
        }
    }
    
    func updateMovie(_ movie: MovieViewModelProtocol) {
        manager.updateMovie(movie)
    }
    
}

