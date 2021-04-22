package test.pilot.DataObjects

import groovy.transform.AutoClone
import groovy.transform.TupleConstructor

@AutoClone
@TupleConstructor
class LoginData {
    String email,
           password
}
