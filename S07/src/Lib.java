import java.util.Scanner;

/**
 * S07 - Employee
 * @author CE190990 Nguyen Hoai An
 * @version 17.02.25
 */
public class Lib {
    // Scanner for keyboard input
    private static Scanner in = new Scanner(System.in);

    /**
     * Validates and returns an double input within specified bounds
     * @param loop If true, continues asking for input until valid; if false, returns after first attempt
     * @param label Prompt message displayed before input
     * @param exception Error message for invalid number format
     * @param min Minimum acceptable value
     * @param minException Error message when input is below minimum
     * @param max Maximum acceptable value
     * @param maxException Error message when input is above maximum
     * @return A validated double within the specified range
     */
    public static double inputDouble(boolean loop, String label, String exception, int min, String minException, int max, String maxException) {
        // Track input validation status
        boolean valid = false;
        // Store input value
        double value = 0;

        do {
            // Handle potential parsing errors
            try {
                // Display prompt if provided
                if (!label.isEmpty()) {
                    System.out.print(label);
                }

                // Read and parse user input
                value = Double.parseDouble(in.nextLine());

                // Validate against minimum bound
                if (value < min) {
                    System.out.print(minException);
                // Validate against maximum bound
                } else if (value > max) {
                    System.out.print(minException);
                // Input is valid
                } else {
                    valid = true;
                }

                // Exit loop if not in continuous mode
                if (!loop) {
                    valid = true;
                }
            } catch (Exception ex) {
                // Display error message if provided
                if (!exception.isEmpty()) {
                    System.out.print(exception);
                }
            }
        // Continue until valid input received
        } while (!valid);

        return value;
    }

    /**
     * Validates and returns an integer input within specified bounds
     * @param loop If true, continues asking for input until valid; if false, returns after first attempt
     * @param label Prompt message displayed before input
     * @param exception Error message for invalid number format
     * @param min Minimum acceptable value
     * @param minException Error message when input is below minimum
     * @param max Maximum acceptable value
     * @param maxException Error message when input is above maximum
     * @return A validated integer within the specified range
     */
    public static int inputInteger(boolean loop, String label, String exception, int min, String minException, int max, String maxException) {
        // Track input validation status
        boolean valid = false;
        // Store input value
        int value = 0;

        do {
            // Handle potential parsing errors
            try {
                // Display prompt if provided
                if (!label.isEmpty()) {
                    System.out.print(label);
                }

                // Read and parse user input
                value = Integer.parseInt(in.nextLine());

                // Validate against minimum bound
                if (value < min) {
                    System.out.print(minException);
                // Validate against maximum bound
                } else if (value > max) {
                    System.out.print(minException);
                // Input is valid
                } else {
                    valid = true;
                }

                // Exit loop if not in continuous mode
                if (!loop) {
                    valid = true;
                }
            } catch (Exception ex) {
                // Display error message if provided
                if (!exception.isEmpty()) {
                    System.out.print(exception);
                }
            }
        // Continue until valid input received
        } while (!valid);

        return value;
    }

    /**
     * Validates and returns an string input within specified length bounds
     * @param loop If true, continues asking for input until valid; if false, returns after first attempt
     * @param label Prompt message displayed before input
     * @param exception Error message for invalid string format
     * @param min Minimum length acceptable value
     * @param minException Error message when input is below minimum length
     * @param max Maximum length acceptable value
     * @param maxException Error message when input is above maximum length
     * @param regex Regex string
     * @param regexException Error message when input not match regex
     * @return A validated string within the specified range
     */
    public static String inputString(boolean loop, String label, String exception, int min, String minException, int max, String maxException, String regex, String regexException) {
        // Track input validation status
        boolean valid = false;
        // Store input value
        String value = "";

        do {
            // Handle errors
            try {
                // Display prompt if provided
                if (!label.isEmpty()) {
                    System.out.print(label);
                }

                // Read and parse user input
                value = in.nextLine().trim();

                // Validate against minimum length bound
                if (value.length() < min) {
                    System.out.print(minException);
                // Validate against maximum length bound
                } else if (value.length() > max) {
                    System.out.print(minException);
                // Input is valid
                } else if (!regex.isEmpty() && !value.matches(regex)) {
                    System.out.print(regexException);
                } else {
                    valid = true;
                }

                // Exit loop if not in continuous mode
                if (!loop) {
                    valid = true;
                }
            } catch (Exception ex) {
                // Display error message if provided
                if (!exception.isEmpty()) {
                    System.out.print(exception);
                }
            }
        // Continue until valid input received
        } while (!valid);

        return value;
    }

    /**
     * Require input between Y or N
     * @param label Message before press
     * @param other Message of other input format
     * @return True if user choose Y, otherwise is false
     */
    public static boolean inputYoN(String label, String other) {
        while (true) {
            System.out.print(label);
            String choice = in.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                return true;
            } else if (choice.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.print(other);
            }
        }
    }
}
