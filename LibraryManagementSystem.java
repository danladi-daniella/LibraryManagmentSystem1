import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display available books");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    library.displayBooks();
                    System.out.print("Enter book title to remove: ");
                    String bookTitle = scanner.nextLine();

                    boolean found = false;
                    for (Book b : library.getBooks()) {
                        if (b.getTitle().equalsIgnoreCase(bookTitle)) {
                            library.removeBook(b);
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}