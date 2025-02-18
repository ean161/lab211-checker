import java.util.Scanner;

/**
 * S07 - Employee
 * @author CE190990 Nguyen Hoai An
 */
public class App {
    /**
     * The main method
     * @param args The command line args
     */
    public static void main(String[] args) {
        // Stop loop flag
        boolean isStop = false;
        // Manager obj
        EmpManager manager = new EmpManager();

        do {
            // Print out menu
            System.out.println(manager.menu());
            int choice = Lib.inputInteger(
                true,
                "Please choose: ",
                "Choose input must be in range 0 - 2\n",
                0,
                "Choose input must be in range 0 - 2\n",
                2,
                "Choose input must be in range 0 - 2"
            );

            // Run func for each choice
            switch (choice) {
                case 1:
                    manager.add();
                    break;
                case 2:
                    System.out.print(manager.show());;
                    break;
                case 0:
                    isStop = true;
                    System.out.println("SEE YOU AGAIN!");
                    break;
                default:
                    break;
            }
        } while (!isStop);
        
    }
}
