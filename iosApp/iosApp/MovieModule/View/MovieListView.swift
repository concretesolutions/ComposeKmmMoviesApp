//
//  MovieListView.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 19/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct MovieListView: View {
    
    @EnvironmentObject var movieViewModel: MovieListViewModel
    private let maxColumns = 2
    
    var body: some View {
        GeometryReader { reader in
            ScrollView {
                ZStack {
                    Rectangle()
                        .foregroundColor(.clear)
                    
                    GridView(rows: movieViewModel.moviesInColumns.count,
                             columns: maxColumns) { row, column in
                        
                        let movie = movieViewModel.moviesInColumns[row][column]
                        MovieCell(viewModel: movie, tapSaveButton: tapSaveButton(movie:))
                            .frame(width: reader.size.width * 0.45, height: reader.size.height * 0.4)
                    }
                }
            }
            .frame(maxWidth: reader.size.width)
        }
        .onAppear {
            movieViewModel.fetchMoviesInColumns(numberOfColumns: maxColumns)
        }
    }
    
    func tapSaveButton(movie: MovieViewModelProtocol) {
        movieViewModel.updateMovie(movie)
    }
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        //Falta criar preview content e setar como environment object
        MovieListView()
    }
}
