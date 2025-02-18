import java.util.ArrayList;

/**
 * S07 - Employee
 * @author CE190990 Nguyen Hoai An
 */
public class Employee {
    // Employee properties
    private String id, name;
    private double salary, COE;

    /**
     * Input employee fields
     * @param list Employee list to check duplicate
     */
    public void input(ArrayList<Employee> list) {
        boolean isValidID = true;

        do {
            this.id = Lib.inputString(
                true,
                "--Please enter id number: ",
                "--------Erorr! ID must be following NVxxxx format\n",
                6,
                "--------Erorr! ID must be following NVxxxx format\n",
                6,
                "--------Erorr! ID must be following NVxxxx format\n",
                "^NV\\d{4}$",
                "--------Erorr! ID must be following NVxxxx format\n"
            );

            // Check duplicated ID
            isValidID = true;
            for (Employee emp : list) {
                if (emp.getId().equalsIgnoreCase(this.id)) {
                    isValidID = false;
                    System.out.println("--------Erorr! ID was duplicated");
                    break;
                }
            }

        } while (!isValidID);

        this.name = Lib.inputString(
            true,
            "--Please enter name: ",
            "--------Erorr! Name must be just contains alpha and space\n",
            1,
            "--------Erorr! Name must be not null\n",
            Integer.MAX_VALUE,
            "--------Erorr! Name must be a valid string\n",
            "^[A-Za-z ]+$",
            "--------Erorr! Name must be just contains alpha and space\n"
        );

        this.salary = Lib.inputDouble(
            true,
            "--Please enter salary: ",
            "--------Erorr! Salary must be greater than 100\n",
            100,
            "--------Erorr! Salary must be greater than 100\n",
            Integer.MAX_VALUE,
            "--------Erorr! Salary must be a valid number\n"
        );

        this.COE = Lib.inputDouble(
            true,
            "--Please enter coefficients salary: ",
            "--------Erorr! Coefficients must be in range 1 - 5\n",
            1,
            "--------Erorr! Coefficients must be in range 1 - 5\n",
            5,
            "--------Erorr! Coefficients must be in range 1 - 5\n"
        );
    }

    /**
     * Get all employee info following table format
     * @return Employee row infomation
     */
    public String output() {
        return String.format(
            "|%-10s|%-15s|%10.0f|%8.1f",
            this.id,
            this.name,
            this.salary,
            this.COE
        );
    }

    /**
     * Calc employee salary
     * @return Salary of employee
     */
    public double calSalary() {
        return this.salary;
    }

    /**
     * ID getter
     * @return Employee ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * Name getter
     * @return Employee name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Salary getter
     * @return Employee salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * COE getter
     * @return Employee COE
     */
    public double getCOE() {
        return this.COE;
    }

    /**
     * ID setter
     * @param id New id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name setter
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Salary setter
     * @param salary New salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * COE setter
     * @param COE New COE
     */
    public void setCOE(double COE) {
        this.COE = COE;
    }
}
