import XCTest
import MoviesSDK
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
}

private extension SwiftPMPerformanceTests {
    func makeTestWrapper() -> PerformanceTestWrapper {
        return PerformanceTestWrapper(sdk: sdk)
    }
}
