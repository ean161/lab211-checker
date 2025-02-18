import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Checker {
    Scanner in = new Scanner(System.in);
    private String dir;
    private ArrayList<String> files = new ArrayList<>();
    private ArrayList<String> raw = new ArrayList<>();

    public Checker() {
        this.license();
        if (this.dir()) {
            this.check();

            for (String file : files) {
                ArrayList<String> raw = raw(file);
                System.out.println(raw.toString());
            }
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
