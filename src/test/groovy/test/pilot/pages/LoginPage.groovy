package test.pilot.pages

import geb.Page
import test.pilot.Modules.NotificationModule


class LoginPage extends Page {


    static url = "https://www.saucedemo.com/"

    static at = {
        title == "Swag Labs"
        /*println $("").text()
*/
    }
    static content = {

        headerTitle(wait: true) { $("head > title") }
        emailField(wait: true) { $("#user-name") }
        passwordField(wait: true) { $("#password") }
        loginButton(wait: true) { $("#login-button") }
        loginForm { module test.pilot.Modules.LoginModule }
        notification { module NotificationModule }
    }

    def "loginToId"(userType) {
        loginForm.loginToId(userType)
    }

    def "accept cookies"() {
        acceptCookie.click()
    }

    def "Show Title"()

    {
        headerTitle.text()

    }


    def "Login to Profile"(email, password) {

        emailField.value(email)
        assert emailField.value() == email
        passwordField.value(password)
        assert passwordField.value() == password
        loginButton.click()
    }

}