import java.util.*;

class Student {
    private String name;
    private double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Summary (Average, Highest, Lowest)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println("Name: " + s.getName() + " | Marks: " + s.getMarks());
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student data available to calculate summary.");
                    } else {
                        double total = 0, highest = -1, lowest = 101;
                        String topStudent = "", lowStudent = "";

                        for (Student s : students) {
                            double m = s.getMarks();
                            total += m;
                            if (m > highest) {
                                highest = m;
                                topStudent = s.getName();
                            }
                            if (m < lowest) {
                                lowest = m;
                                lowStudent = s.getName();
                            }
                        }

                        double average = total / students.size();
                        System.out.println("\n--- Summary Report ---");
                        System.out.printf("Total Students: %d\n", students.size());
                        System.out.printf("Average Marks: %.2f\n", average);
                        System.out.printf("Highest Marks: %.2f (%s)\n", highest, topStudent);
                        System.out.printf("Lowest Marks : %.2f (%s)\n", lowest, lowStudent);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
