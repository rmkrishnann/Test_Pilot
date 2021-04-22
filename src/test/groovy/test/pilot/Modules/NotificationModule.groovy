package test.pilot.Modules

import geb.Module

class NotificationModule extends Module {

    static content = {
        header { $(" ").$("") }
        errorHeader { header.filter("") }
        successHeader { header.filter("") }
        msgDescription { $("") }
        resendMailSuccess { $("").$("") }
    }
}
