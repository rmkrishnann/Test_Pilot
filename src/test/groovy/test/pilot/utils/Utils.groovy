package test.pilot.utils

class Utils {

    def randomEmailString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890"
        StringBuilder salt = new StringBuilder()
        Random rnd = new Random()
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length())
            salt.append(SALTCHARS.charAt(index))
        }
        String saltStr = salt.toString()
        return saltStr

    }

}