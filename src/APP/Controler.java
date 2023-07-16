package APP;
import java.sql.Timestamp;
import java.util.Scanner;

public class Controler {
    static APP.CRUDtoDo books = new APP.CRUDtoDo();

    static Scanner scanner = new Scanner(System.in);
    static int option = 0;
    public static void main(String[] args) {

        while (option != 6) {
                             Controler.menu();
            switch (option) {
                case 1 -> Controler.add();

                case 2 -> Controler.selectBiYd();

                case 3 -> books.selectAll();

                case 4 -> Controler.updateTable();

                case 5 -> Controler.DeleteById();

                case 6 -> System.out.println("Quitting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
    public static void menu(){
        System.out.println("========== TODO menu =====");
        System.out.println("1) - Add a new TODO");
        System.out.println("2) - Find a TODO");
        System.out.println("3) - Show all TODO");
        System.out.println("4) - Update a TODO");
        System.out.println("5) - Delete a TODO");
        System.out.println("6) - Quit");

        System.out.print("Enter your choice: ");
        option = scanner.nextInt();
        scanner.nextLine();

    }
    public static void add(){
        System.out.println("Enter the details for the new TODO:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Deadline (YYYY-MM-DD HH:MM:SS): ");
        String deadlineStr = scanner.nextLine();
        Timestamp deadline = Timestamp.valueOf(deadlineStr);
        System.out.print("Priority (0-10): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Done (true/false): ");
        boolean done = scanner.nextBoolean();
        scanner.nextLine();
        books.insert(id, title, description, deadline, priority, done);

    }
    public static void selectBiYd(){
        System.out.print("Enter the ID of the TODO to find: ");
        int findId = scanner.nextInt();
        scanner.nextLine();
        books.selectById(findId);
    }
    public static void updateTable(){
        System.out.println("Enter the details for the updated TODO:");
        System.out.print("ID: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Title: ");
        String newTitle = scanner.nextLine();
        System.out.print("New Description: ");
        String newDescription = scanner.nextLine();
        System.out.print("New Deadline (YYYY-MM-DD HH:MM:SS): ");
        String newDeadlineStr = scanner.nextLine();
        Timestamp newDeadline = Timestamp.valueOf(newDeadlineStr);
        System.out.print("New Priority: ");
        int newPriority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Done (true/false): ");
        boolean newDone = scanner.nextBoolean();
        scanner.nextLine();
        books.update(updateId, newTitle, newDescription, newDeadline, newPriority, newDone);

    }
    public static void DeleteById(){
        System.out.print("Enter the ID of the TODO to delete: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine();
        books.delete(deleteId);
    }

}
