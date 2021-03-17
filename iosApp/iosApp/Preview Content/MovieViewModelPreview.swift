//
//  FavoriteMovieViewModelPreview.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 17/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

final class MovieViewModelPreview: MovieViewModelProtocol {
    
    var isFavorite: Bool = false
    var title: String { "Thor" }
    var id: Int { 0 }
    var releaseYear: Int { 2020 }
    var overview: String { Array(repeating: "Description", count: 100).joined() }
    var posterPath: String { "" }
    
    var imageURL: URL? {
        Bundle.main.url(forResource: "poster", withExtension: "jpeg")
    }
}
