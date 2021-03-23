//
//  BuildModule.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 23/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
import MoviesSDK

enum ModuleType {
    case kmm
    case native
}


struct BuildModule {
    
    static func create(type: ModuleType) -> MovieManagerProtocol {
        
        var sdk: MoviesSDKProtocol
        
        switch type {
        case .kmm:
            sdk = MoviesSdk(databaseDriverFactory: DatabaseDriverFactory())
        case .native:
            sdk = MoviesSDKManager()
        }
        
        return MovieManager(moviesSDK: sdk)
    }
    
}
