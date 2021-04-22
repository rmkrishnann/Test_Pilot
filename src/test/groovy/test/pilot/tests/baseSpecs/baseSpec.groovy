package test.pilot.tests.baseSpecs

import geb.driver.CachingDriverFactory
import geb.spock.GebReportingSpec

abstract class baseSpec extends GebReportingSpec {

    def setup() {

    }

    def cleanup() {
        this."_browser" = null
        CachingDriverFactory.clearCacheAndQuitDriver()

    }
}