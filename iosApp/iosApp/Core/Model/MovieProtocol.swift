//
//  MovieProtocol.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 23/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

protocol MovieProtocol {
    var id: Int { get }
    var posterPath: String { get }
    var title: String { get }
    var releaseYear: Int { get }
    var overview: String { get }
}
