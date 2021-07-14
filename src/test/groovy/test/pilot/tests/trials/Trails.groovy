package test.pilot.tests.trials

import spock.lang.Issue
import spock.lang.Shared
import test.pilot.pages.Homepage
import test.pilot.tests.baseSpecs.baseSpec
import test.pilot.pages.LoginPage

class Trails extends baseSpec {
    @Shared
            email = "standard_user",
            password = "secret_sauce"

    @Issue("Login1")
    def " Login Page Mandatory error validations"() {

        given:
        ("I am on  login page")
        to LoginPage

        when:
        ("I  click login without entering any credentials")
        at LoginPage
        "Login to Profile"(email, password)

        then:
        ("I should see swag labs homepage")
        at Homepage
        assert title == test.pilot.utils.PageTitle.HOME_PAGE_TITLE
    }


}
