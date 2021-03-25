//
//  FavoriteMovieViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

final class FavoriteMovieViewModel: MovieViewModelProtocol, Identifiable {
        
    private let favoriteMovie: MovieProtocol
    
    init(favoriteMovie: MovieProtocol) {
        self.favoriteMovie = favoriteMovie
    }
    
    var title: String { favoriteMovie.title }
    
    var id: Int {
        Int(favoriteMovie.id)
    }
    
    var isFavorite: Bool = true
    
    var imageURL: URL? {
        URL(string: Constants.Image.baseURL.rawValue + favoriteMovie.posterPath)
    }
    
    var posterPath: String {
        favoriteMovie.posterPath
    }
    
    var releaseYear: Int {
        favoriteMovie.releaseYear
    }
    
    var overview: String { favoriteMovie.overview }
    
}
