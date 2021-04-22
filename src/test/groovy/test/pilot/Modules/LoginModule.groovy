package test.pilot.Modules

import geb.Module
import test.pilot.utils.JsonDataReader

import javax.inject.Inject

class LoginModule extends Module {
    static content = {
        form { $("form") }
        acceptCookie(wait: true) { ("")[1] }
        emailField(wait: true) { form.$("") }
        passwordField(wait: true) { form.$("") }
        loginButton(wait: true) { form.$("") }
    }

    private JsonDataReader jsonDataReader

    @Inject
    LoginModule(final JsonDataReader jsonDataReader) {
        this.jsonDataReader = jsonDataReader
    }

    def loginProcess(userType) {
        jsonDataReader.UserDataReader(userType)
        emailField.value(jsonDataReader.username)
        passwordField.value(jsonDataReader.password)
        loginButton.click()
    }


    def loginToId(userType) {
        JsonDataReader getData = new JsonDataReader()
        getData.UserDataReader(userType)
        emailField.value(getData.username)
        passwordField.value(getData.password)
        loginButton.click()
    }
}
