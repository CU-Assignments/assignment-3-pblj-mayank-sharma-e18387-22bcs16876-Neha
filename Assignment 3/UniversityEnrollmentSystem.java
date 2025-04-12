// ✅ Problem 3: University Enrollment System (Hard Level)
// Description:
// Create a university enrollment system with exception handling:

// Allow students to enroll in courses.
// Throw CourseFullException if the course is full.
// Throw PrerequisiteNotMetException if prerequisites are not completed.
// Example Input:

// Enroll in Course: Advanced Java
// Prerequisite: Core Java
// Status: Prerequisite not completed
// Example Output:

// Error: PrerequisiteNotMetException - Complete Core Java before enrolling in Advanced Java.

// Custom Exceptions
import java.util.Scanner;

// Custom Exception: CourseFullException
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

// Custom Exception: PrerequisiteNotMetException
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

// Main Class
public class UniversityEnrollmentSystem {
    private static final int MAX_CAPACITY = 2;
    private static int enrolledStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Have you completed the prerequisite (yes/no)? ");
            String prerequisite = scanner.nextLine().toLowerCase();

            if (!prerequisite.equals("yes")) {
                throw new PrerequisiteNotMetException("Complete Core Java before enrolling in " + course + ".");
            }

            if (enrolledStudents >= MAX_CAPACITY) {
                throw new CourseFullException("Course is already full.");
            }

            enrolledStudents++;
            System.out.println("Enrollment successful in " + course + ". Total Enrolled: " + enrolledStudents);

        } catch (PrerequisiteNotMetException | CourseFullException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
