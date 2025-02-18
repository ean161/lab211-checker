import java.util.ArrayList;

/**
 * S07 - Employee
 * @author CE190990 Nguyen Hoai An
 */
public class EmpManager {
    // Storage all employee as array list
    private ArrayList<Employee> list = new ArrayList<>();

    /**
     * Add function, add new employee to list
     */
    public void add() {
        int empCount = Lib.inputInteger(
            true,
            "+ Enter number of Employee: ",
            "Employee number must be a valid integer\n",
            1,
            "Employee number must be greater than 0\n",
            Integer.MAX_VALUE,
            "Employee number must be a valid integer\n"
        );

        // Add each employee after request input fields
        for (int i = 0; i < empCount; i++) {
            System.out.printf("- Employee %d:\n", (i + 1));
            Employee entity = new Employee();
            entity.input(list);
            list.add(entity);
        }
    }

    /**
     * Show function, show all employee that added as table format
     */
    public String show() {
        if (list.isEmpty()) {
            return "No employee found\n";
        }

        String result = "";

        // Print out header
        result += "=================== List Employee ===================\n" +
            String.format(
                "|%-5s|%-10s|%-15s|%-10s|%-8s\n",
                "No.",
                "ID",
                "Name",
                "Salary",
                "COE"
            );

        // Print each employee
        int i = 0;
        for(Employee emp : list) {
            result += String.format(
                    "|%5s%s\n",
                    (++i),
                    emp.output()
                );
        }

        return result;
    }

    /**
     * Return menu string
     * @return Menu string
     */
    public String menu() {
        return "----------MENU----------\n" +
            "1. Input employee.\n" +
            "2. Show list employee.\n" +
            "0. Exit.";
    }
}
