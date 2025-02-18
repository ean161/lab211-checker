import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Checker {
    Scanner in = new Scanner(System.in);
    private String dir;
    private ArrayList<String> files = new ArrayList<>();

    public Checker() {
        this.license();
        if (this.dir()) {
            this.check();
        }
    }

    public void license() {
        System.out.println(
            "------------------------------\n"
            + "@hoaian161 contact: 0365993818\n"
            + "------------------------------"
        );
    }

    public boolean dir() {
        System.out.print("Project directory: ");
        this.dir = "./" + in.nextLine() + "/src/";

        File dir = new File(this.dir);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    this.files.add(this.dir + file.getName());
                }
            }
        } else {
            System.out.println("No file found in directory");
            return false;
        }

        return true;
    }

    public void check() {
        for (String file : files) {
            boolean isError = false;
            System.out.println("File " + file + ":");
            ArrayList<String> raw = raw(file);

            for (int i = 1; i < raw.size() - 1; i++) {
                String here = raw.get(i).toLowerCase();
                String before = raw.get(i - 1).toLowerCase();
                String after = raw.get(i + 1).toLowerCase();
            
                if (here.contains("void main") && here.contains("throw")) {
                    isError = true;
                    System.out.println("\t- [Line " + (i + 1) + "] Throw error in main method");
                }

                if (
                    (
                        here.contains("public")
                        || here.contains("private")
                        || here.contains("static")
                    )
                    &&
                    (
                        here.contains("(")
                        && here.contains(")")
                    )
                    &&
                    (
                        here.contains("{")
                        || after.contains("{")
                    )
                    &&
                    (
                        !before.contains("*/")
                    )
                ) {
                    isError = true;
                    System.out.println("\t- [Line " + (i + 1) + "] Method doesnt have comment");
                }

                if (
                    here.contains(" class ")
                    &&
                    (
                        here.contains("{")
                        || after.contains("{")
                    )
                    &&
                    !before.contains("*/")
                ) {
                    isError = true;
                    System.out.println("\t- [Line " + (i + 1) + "] Class doesnt have comment");
                }

                if (here.contains("@return")) {
                    String[] parts = here.split("@return");

                    if (parts.length >= 2) {
                        if (parts[1].length() < 3) {
                            isError = true;
                            System.out.println("\t- [Line " + (i + 1) + "] Return comment might not available");
                        }
                    } else {
                        isError = true;
                        System.out.println("\t- [Line " + (i + 1) + "] No return comment");
                    }
                }

                if (here.contains("@param")) {
                    String[] paramPath = here.split("@param");
                    
                    if (paramPath.length == 1) {
                        isError = true;
                        System.out.println("\t- [Line " + (i + 1) + "] Parameter doesnt have enough part");
                    } else {
                        String[] paramPaths = paramPath[1].split(" ");

                        if (paramPaths.length <= 2) {
                            isError = true;
                            System.out.println("\t- [Line " + (i + 1) + "] Parameter doesnt have comment");
                        }
                    }
                }
            }

            if (!isError) {
                System.out.println("\t- SAFE");
            }

            System.out.println("");
        }
    }

    public ArrayList<String> raw(String item) {
        ArrayList<String> result = new ArrayList<>();

        File file = new File(item);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error on file read: " + e.getMessage());
        }

        return result;
    }
}
