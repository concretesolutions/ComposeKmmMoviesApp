import SwiftUI

struct MovieListView: View {
    
    @EnvironmentObject var movieViewModel: MovieListViewModel
    private let maxColumns = 2
    
    var body: some View {
        NavigationView {
            //No iOS 14 é possível utilizar LazyVStack
            ScrollView {
                ForEach(0..<movieViewModel.moviesInColumns.count, id: \.self) { index in
                    HStack(spacing: 15) {
                        ForEach(movieViewModel.moviesInColumns[index]) { movie in
                            MovieCell(viewModel: movie, tapSaveButton: tapSaveButton(movie:))
                                .frame(height: 250)
                        }
                    }
                }
            }
            .frame(maxWidth: .infinity)
            .padding([.leading, .trailing], 15)
            .navigationBarTitle("Movies", displayMode: .inline)
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
