package FwkLibrary;

public class AssertLibrary {

    public static void assertContains(String message, String expectedSubstring, String actualString) {
        if (actualString == null) {
            throw new AssertionError(message + ": The actual string is null.");
        }
        if (!actualString.contains(expectedSubstring)) {
            throw new AssertionError(message + ": Expected substring \"" + expectedSubstring + "\" was not found in \"" + actualString + "\".");
        }
    }

    public static void assertContains(String expectedSubstring, String actualString) {
        assertContains("Assertion Contains failed", expectedSubstring, actualString);
    }

    // Other assert methods and exception handling can go here

    private static void handleException(AssertionError e) {
        // Handle the exception as needed. For example, log the error or rethrow it.
        System.err.println("Assertion failed: " + e.getMessage());
        throw e;
    }
}
