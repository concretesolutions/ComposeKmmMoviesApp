//
//  MoviesSDKProtocol.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 22/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

protocol MoviesSDKProtocol {
    func fetchFavoriteMovies(completionHandler: @escaping ([FavoriteMovieViewModel]) -> Void)
    func fetchPopularMovies(completionHandler: @escaping (Result<[MovieViewModel], Error>) -> Void)
    func saveMovie(_ movie: MovieViewModelProtocol)
    func removeMovie(_ id: Int)
}
