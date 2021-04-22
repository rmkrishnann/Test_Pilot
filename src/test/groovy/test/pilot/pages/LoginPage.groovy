package test.pilot.pages

import geb.Page
import test.pilot.Modules.NotificationModule


class LoginPage extends Page {


    static url = ""

    static at = {
        title == ""
        /*println $("").text()
*/
    }
    static content = {

        headerTitle(wait: true) { $("") }
        acceptCookie(wait: true) { $() }
        emailField(wait: true) { $("") }
        passwordField(wait: true) { $("") }
        loginButton(wait: true) { $("") }
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
        acceptCookie.click()
        assert acceptCookie.click()
        emailField.value(email)
        assert emailField.value() == email
        passwordField.value(password)
        assert passwordField.value() == password
        loginButton.click()
        assert loginButton.click()
    }

}