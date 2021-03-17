//
//  FavoriteMoviesView.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct FavoriteMoviesView: View {
    
    @EnvironmentObject var favoriteListViewModel: FavoriteMovieListViewModel
    
    var body: some View {
        NavigationView {
            List {
                ForEach(favoriteListViewModel.movies) { movie in
                    FavoriteMovieCell(viewModel: movie)
                        .listRowInsets(EdgeInsets(top: 2, leading: 0, bottom: 2, trailing: 0))
                }
                .onDelete(perform: { indexSet in
                    removeMovie(indexSet)
                })
            }
            .navigationBarTitle("Movies", displayMode: .inline)
        }
        .environment(\.defaultMinListRowHeight, 140)
        .onAppear {
            favoriteListViewModel.fetchMovies()
        }
    }
    
    private func removeMovie(_ indexSet: IndexSet) {
        guard let index = indexSet.first else { return }
        favoriteListViewModel.removeMovie(at: index)
    }
}

struct FavoriteMoviesView_Previews: PreviewProvider {
    static var previews: some View {
        //Falta criar preview content e setar como environment object
        FavoriteMoviesView()
    }
}
