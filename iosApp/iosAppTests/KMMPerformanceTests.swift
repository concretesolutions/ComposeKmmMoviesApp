import XCTest
import shared
@testable import iosApp

class KMMPerformanceTests: XCTestCase {
    var sdk: MoviesSdk!
    
    override func setUp() {
        super.setUp()
        
        sdk = MoviesSdk(databaseDriverFactory: DatabaseDriverFactory())
    }
    
    func testSaveMoviePerformance() {
        let testWrapper = makeTestWrapper()
        
        measure {
            testWrapper.runSaveMovie(iterations: 1_000)
        }
    }
    
    func testRemoveMoviePerformance() {
        let testWrapper = makeTestWrapper()
        
        measure {
            testWrapper.runRemoveMovie(iterations: 1_000)
        }
    }
    
    func testObjectFeedback() {
        let localSdk = MoviesSdk(databaseDriverFactory: DatabaseDriverFactory())
        let movie = makeMovie()
        
        measure {
            var i = 0
            while i < 1_000_000 {
                i += 1
                
                _ = localSdk.objectFeedback(obj: movie)
            }
        }
    }
    
    private func makeMovie() -> FavoriteMovie {
        return FavoriteMovie(id: 0, posterPath: "", originalTitle: "", genres: "", releaseYear: 0, overview: "")
    }
}

private extension KMMPerformanceTests {
    func makeTestWrapper() -> PerformanceTestWrapper {
        return PerformanceTestWrapper(sdk: sdk)
    }
}
