//
//  MovieSDK_KMM.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 22/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

// Adapter Movie
extension Movie: MovieProtocol {
    
    var id: Int { Int(component1()) }
    var title: String { originalTitle }
    
    var releaseYear: Int {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "YYYY-MM-dd"
        guard let date = dateFormatter.date(from: releaseDate) else { return 0 }
        let year = Calendar.current.component(.year, from: date)
        return year
    }
}

// Adapter Favorite Movie
extension FavoriteMovie: MovieProtocol {
    var id: Int { Int(component1()) }
    var title: String { originalTitle }
    var overview: String { component6() ?? "" }
    var releaseYear: Int { Int(component5()) }
}

// Adapter MoviesSdk
extension MoviesSdk: MoviesSDKProtocol {
        
    func fetchFavoriteMovies(completionHandler: @escaping ([FavoriteMovieViewModel]) -> Void) {
        let favorites = getFavoriteMovies().map { FavoriteMovieViewModel(favoriteMovie: $0) }
        completionHandler(favorites)
    }
    
    func fetchPopularMovies(completionHandler: @escaping (Result<[MovieViewModel], Error>) -> Void) {
        getPopularMovies(page: 1) { (response, error) in
            if let response = response as? ResponseSuccess,
               let result = response.data?.results {
            
                let movies = result.map { MovieViewModel(movie: $0) }
                completionHandler(.success(movies))
            }
        }
    }
    
    func saveMovie(_ movie: MovieViewModelProtocol) {
        let favorite = FavoriteMovie(id: Int64(movie.id),
                                     posterPath: movie.posterPath,
                                     originalTitle: movie.title,
                                     genres: "",
                                     releaseYear: Int32(movie.releaseYear),
                                     overview: movie.overview)
        saveMovie(favoriteMovie: favorite)
    }
    
    func removeMovie(_ id: Int) {
        unsaveMovie(idMovie: Int64(id))
    }
}
