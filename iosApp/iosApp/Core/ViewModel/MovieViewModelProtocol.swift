//
//  MovieViewModel.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

protocol MovieViewModelProtocol: AnyObject {
    var title: String { get }
    var id: Int { get }
    var imageURL: URL? { get }
    var releaseYear: Int { get }
    var overview: String { get }
    var posterPath: String { get }
    var isFavorite: Bool { get set }
}
