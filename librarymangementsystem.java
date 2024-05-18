import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int sNo;
    String bookName;
    String authorName;
    int bookQty;
    int bookQtyCopy;

    Book(int sNo, String bookName, String authorName, int bookQty) {
        this.sNo = sNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookQty = bookQty;
        this.bookQtyCopy = bookQty;
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<Book>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        System.out.println("List of Books:");
        for (Book book : books) {
            System.out.println(book.sNo + ". " + book.bookName + " by " + book.authorName + ", Quantity: " + book.bookQty);
        }
    }

    Book searchBookByName(String bookName) {
        for (Book book : books) {
            if (book.bookName.equals(bookName)) {
                return book;
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book(1, "Java", "John Doe", 10));
        library.addBook(new Book(2, "Computer architecture", "Jane Doe", 20));
        library.addBook(new Book(31, "Python", "Jane Doe", 30));
        library.addBook(new Book(4, "DBMS", "Jane Doe", 10));

        while (true) {
            System.out.println("\nWelcome to the Library Management System!");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the name of the book: ");
                    scanner.nextLine();
                    String bookName = scanner.nextLine();
                    Book searchedBook = library.searchBookByName(bookName);
                    if (searchedBook != null) {
                        System.out.println("Book found: " + searchedBook.bookName);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Library Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}