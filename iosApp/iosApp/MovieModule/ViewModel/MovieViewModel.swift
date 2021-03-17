//
//  MovieViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

final class MovieViewModel: MovieViewModelProtocol, Identifiable {
        
    private let movie: Movie
    
    init(movie: Movie) {
        self.movie = movie
    }
    
    var isFavorite: Bool = false
    
    var title: String {
        movie.originalTitle
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
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "YYYY-MM-dd"
        guard let date = dateFormatter.date(from: movie.releaseDate) else { return 0 }
        let year = Calendar.current.component(.year, from: date)
        return year
    }
    
}
