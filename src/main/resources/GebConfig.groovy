import com.aoe.gebspockreports.GebReportingListener
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

waiting {

    timeout = 5
    retryInterval = 0.5
    includeCauseInMessage = true

    preset {
        slow {
            timeout = 15
            retryInterval = 0.5
        }
        veryslow = {
            timeout = 50
        }
    }
}

atCheckWaiting = "slow"
atCheckWaiting = true


private static ChromeOptions getChromeOptions() {
    def options = new ChromeOptions()
    //def mobileEmulation = [deviceName: "iPhone X"]
    options.addArguments("disable-infobars")
    options.addArguments("allow-running-insecure-content")
    options.addArguments("disable-gpu")
    //options.setExperimentalOption("mobileEmulation", mobileEmulation)
    options.setAcceptInsecureCerts(true)
    options
}


def browser = System.getProperty('app.browser')

switch (browser) {

    case "chrome" :
    driver = {
        WebDriverManager.chromedriver().setup()
        def driver = new ChromeDriver(getChromeOptions())
        driver.manage().window().maximize()
        driver
    }
        break

    case "firefox":
    driver = {
        WebDriverManager.firefoxdriver().setup()
        def driver = new FirefoxDriver()
        driver.manage().window().maximize()
        driver
    }
        break

    case "hub-chrome":
    driver = {
        def gridUrl = System.getProperty('hubUrl')
        def remoteWebDriverServerUrl = new URL(gridUrl)
        new RemoteWebDriver(remoteWebDriverServerUrl, DesiredCapabilities.chrome())
    }
        break

    case "hub-firefox":
    driver = {
        def gridUrl = System.getProperty('hubUrl')
        def remoteWebDriverServerUrl = new URL(gridUrl)
        new RemoteWebDriver(remoteWebDriverServerUrl, DesiredCapabilities.firefox())
    }
    break
    default:
        driver = {
            WebDriverManager.chromedriver().setup()
            def driver = new ChromeDriver()
            driver.manage().window().maximize()
            driver
        }
        break

}



environments {

    test {
        envName = System.getProperty('app.envName')
        baseUrl = "https://${envName}.co.uk"
        System.setProperty("testDataFile", "src/main/resources/TestData/testdata.json")
    }
    stage {
        envName = System.getProperty('app.envName')
        platform = System.getProperty('app.platform')
        baseUrl = "https://${envName}.co.uk"
        System.setProperty("testDataFile", "src/main/resources/TestData/testdata.json")

    }
    prod {
        baseUrl = ""
        System.setProperty("testDataFile", "src/main/resources/TestData/testdata.json")

    }

}

baseUrl = "https:google.co.uk"
String folderName = System.getProperty('dateStamp')
reportingListener = new GebReportingListener()
reportsDir = "./target/Reports/${folderName}"