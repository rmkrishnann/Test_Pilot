package test.pilot.utils

import groovy.json.JsonSlurper

class JsonDataReader {
    def jsonSlurper = new JsonSlurper()
    File fl = new File('src/main/resources/TestData/testdata.json')
    //def testData = jsonSlurper.parse(fl)
    Map testData = jsonSlurper.parse(fl)
    def array1 = testData.testCreds.data
    String username = ""
    String password = ""
    String firstName = ""
    String lastName = ""
    String contactNumber = ""


    def "UserDataReader"(userData) {
         /*def dataFile = System.getProperty("testDataFile")
         def jsonSlurper = new JsonSlurper()
         File fl = new File(dataFile)
         //def testData = jsonSlurper.parse(fl)
         Map testData = jsonSlurper.parse(fl)
         def array1 = testData.testCreds.data*/
        for (def member : array1) {
            if (member.userType == userData) {
                username = member.emailAddress
                password = member.password
                contactNumber = member.contactNumber
                firstName = member.firstName
                lastName = member.lastName
                break
            }
        }

    }

}


