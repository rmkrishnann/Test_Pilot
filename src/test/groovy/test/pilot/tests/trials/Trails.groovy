package test.pilot.tests.trials

import spock.lang.Issue
import spock.lang.Shared
import test.pilot.tests.baseSpecs.baseSpec

class Trails extends baseSpec {
    @Shared
            loginDetails = " user with invalid email"

    @Issue("Login1")
    def " Login Page Mandatory error validations"() {

        given:
        ("I am on  login page")
        to LoginPage

        when:
        ("I  click login without entering any credentials")
        at LoginPage
        "Click Submit"()

        then:
        ("I should see the error messages in the  login page")
        at LoginPage
        assert title == test.pilot.utils.PageTitle.LOGIN_PAGE_TITLE
        assert msgEmailMandatory.text() == test.pilot.utils.Notifications.MANDATORY_EMAIL_MISSING
        assert msgPasswordMandatory.text() == test.pilot.utils.Notifications.MANDATORY_PASSWORD_MISSING
    }


}
