import XCTest
import shared
@testable import iosApp

class KMMPerformanceTests: XCTestCase {
    var sdk: MoviesSDKProtocol!
    
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
}

private extension KMMPerformanceTests {
    func makeTestWrapper() -> PerformanceTestWrapper {
        return PerformanceTestWrapper(sdk: sdk)
    }
}
