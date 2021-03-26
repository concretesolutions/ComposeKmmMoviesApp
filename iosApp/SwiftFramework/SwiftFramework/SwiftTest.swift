public class FavoriteMovieSwift {
    public var id: Int64
    public var posterPath: String
    public var originalTitle: String
    public var genres: String
    public var releaseYear: Int32
    public var overview: String?
    
    public init(id: Int64, posterPath: String, originalTitle: String, genres: String, releaseYear: Int32, overview: String? = nil) {
        self.id = id
        self.posterPath = posterPath
        self.originalTitle = originalTitle
        self.genres = genres
        self.releaseYear = releaseYear
        self.overview = overview
    }
}

public class SwiftFramework {
    public init() {
        
    }
    
    public func objectFeedback(_ movie: FavoriteMovieSwift) -> FavoriteMovieSwift {
        return movie
    }
}
