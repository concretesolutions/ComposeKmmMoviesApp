import Foundation
@testable import iosApp

class PerformanceTestWrapper {
    let sdk: MoviesSDKProtocol
    
    init(sdk: MoviesSDKProtocol) {
        self.sdk = sdk
    }
    
    func runSaveMovie(iterations: Int) {
        for i in 0...iterations {
            let movie = generateMovieModel(id: i)
            sdk.saveMovie(movie)
        }
    }
    
    func runRemoveMovie(iterations: Int) {
        for _ in 0...iterations {
            sdk.removeMovie(0)
        }
    }
    
    private func generateMovieModel(id: Int) -> MovieModel {
        return MovieModel(
            title: "Movie \(id)",
            id: id,
            imageURL: URL(string: "https://example.com/img\(id).jpg"),
            releaseYear: 1999,
            overview: "Overview for movie \(id)",
            posterPath: "poster\(id)",
            isFavorite: false
        )
    }
    
    private class MovieModel: MovieViewModelProtocol {
        var title: String
        var id: Int
        var imageURL: URL?
        var releaseYear: Int
        var overview: String
        var posterPath: String
        var isFavorite: Bool
        
        init(title: String,
             id: Int,
             imageURL: URL?,
             releaseYear: Int,
             overview: String,
             posterPath: String,
             isFavorite: Bool) {
            
            self.title = title
            self.id = id
            self.imageURL = imageURL
            self.releaseYear = releaseYear
            self.overview = overview
            self.posterPath = posterPath
            self.isFavorite = isFavorite
        }
    }
}
