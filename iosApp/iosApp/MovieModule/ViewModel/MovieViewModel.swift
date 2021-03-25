//
//  MovieViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

final class MovieViewModel: MovieViewModelProtocol, Identifiable {
        
    private let movie: MovieProtocol
    
    init(movie: MovieProtocol) {
        self.movie = movie
    }
    
    var isFavorite: Bool = false
    
    var title: String {
        movie.title
    }
    
    var id: Int {
        Int(movie.id)
    }

    var imageURL: URL? {
        URL(string: Constants.Image.baseURL.rawValue + movie.posterPath)
    }
    
    var posterPath: String {
        movie.posterPath
    }
    
    var overview: String {
        movie.overview
    }
    
    var releaseYear: Int {
        movie.releaseYear
    }
    
}
