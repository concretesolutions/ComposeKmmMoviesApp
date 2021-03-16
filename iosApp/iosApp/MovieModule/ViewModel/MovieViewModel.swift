//
//  MovieViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

protocol MovieViewModelProtocol {
    var title: String { get }
    var id: Int32 { get }
    var imageURL: URL? { get }
}

final class MovieViewModel: MovieViewModelProtocol, Identifiable {
    
    private let movie: Movie
    
    init(movie: Movie) {
        self.movie = movie
    }
    
    var title: String {
        movie.originalTitle
    }
    
    var id: Int32 {
        movie.id
    }

    var imageURL: URL? {
        URL(string: Constants.Image.baseURL.rawValue + movie.posterPath)
    }
    
}
