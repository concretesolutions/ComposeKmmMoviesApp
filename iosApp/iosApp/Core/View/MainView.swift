//
//  MainView.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    
    private let manager: MovieManagerProtocol
    
    init(manager: MovieManagerProtocol) {
        self.manager = manager
    }
    
    var body: some View {
        TabView {
            MovieListView()
                .tabItem {
                    Image(systemName: "list.bullet")
                    Text("Movies")
                }
                .environmentObject(MovieListViewModel(manager: manager))
            
            FavoriteMoviesView()
                .tabItem {
                    Image(systemName: "heart")
                    Text("Favorites")
                }
                .environmentObject(FavoriteMovieListViewModel(manager: manager))
        }
        .navigationBarTitle("Movies", displayMode: .inline)
    }
}

