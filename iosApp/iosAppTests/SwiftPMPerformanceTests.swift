import XCTest
import MoviesSDK
import SwiftFramework
@testable import iosApp

class SwiftPMPerformanceTests: XCTestCase {
    var sdk: MoviesSDKManager!
    
    override func setUp() {
        super.setUp()
        
        sdk = MoviesSDKManager()
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
        let localSdk = SwiftFramework()
        let movie = makeMovie()
        
        measure {
            var i = 0
            while i < 1_000_000 {
                i += 1
                
                _ = localSdk.objectFeedback(movie)
            }
        }
    }
    
    private func makeMovie() -> FavoriteMovieSwift {
        return FavoriteMovieSwift(id: 0, posterPath: "", originalTitle: "", genres: "", releaseYear: 0, overview: "")
    }
}

private extension SwiftPMPerformanceTests {
    func makeTestWrapper() -> PerformanceTestWrapper {
        return PerformanceTestWrapper(sdk: sdk)
    }
}
