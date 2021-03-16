import SwiftUI
import shared

struct MovieListView: View {
    
    @ObservedObject var viewModel: MovieListViewModel
    private let maxColumns = 2
    
    var body: some View {
        NavigationView {
            //No iOS 14 é possível utilizar LazyVStack
            ScrollView {
                ForEach(0..<viewModel.moviesInColumns.count, id: \.self) { index in
                    HStack(spacing: 15) {
                        ForEach(viewModel.moviesInColumns[index]) { movie in
                            MovieCell(viewModel: movie)
                                .frame(height: 250)
                        }
                    }
                }
            }
            .frame(maxWidth: .infinity)
            .padding([.leading, .trailing], 15)
            .onAppear {
                viewModel.fetchMoviesInColumns(numberOfColumns: maxColumns)
            }
            .navigationBarTitle("Movies", displayMode: .inline)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        let sdk = MoviesSdk(databaseDriverFactory: DatabaseDriverFactory())
        let viewModel = MovieListViewModel(moviesSdk: sdk)
        MovieListView(viewModel: viewModel)
    }
}
