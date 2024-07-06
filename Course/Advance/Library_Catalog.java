import java.util.ArrayList;
import java.util.List;

class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true; // Initially, every book is available.
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setisAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void displayDetails() {
        System.out.println("BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + isAvailable);
    }
}

class FictionBook extends Book {
    public FictionBook(String bookID, String title, String author) {
        super(bookID, title, author, "Fiction");
    }

    @Override
    public void displayDetails() {
        System.out.println("Fiction Book - Title: " + getTitle() + ", Author: " + getAuthor());
    }
}

class NonFictionBook extends Book {
    public NonFictionBook(String bookID, String title, String author) {
        super(bookID, title, author, "Non-Fiction");
    }

    @Override
    public void displayDetails() {
        System.out.println("Non-Fiction Book - Title: " + getTitle() + ", Author: " + getAuthor());
    }
}

class Catalog {
    private List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayDetails();
            }
        }
    }
}

class User {
    private String userID;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setisAvailable(false);
            System.out.println("\n"+name + " has borrowed " + book.getTitle());
        } 
        else {
            System.out.println("Sorry, "+book.getTitle()+" is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setisAvailable(true);
            System.out.println("\n"+name + " has returned " + book.getTitle());
        }
    }
}

public class Library_Catalog {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Book book3 = new FictionBook("1", "Angels and Demons", "Dan Brown");
        Book book1 = new FictionBook("2", "Divergent", "Vironica Roth");
        Book book2 = new FictionBook("3", "Hunger Games", "Suzaine");
        Book book4 = new NonFictionBook("4", "Wings of Fire", "Abdul Kalam");
        Book book5 = new NonFictionBook("5", "Our Past", "NCERT");
        
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        catalog.addBook(book4);
        catalog.addBook(book5);
        
        User user1 = new User("U1", "Jerry");
        User user2 = new User("U2", "Oreo");
        User user3 = new User("U3", "Cookie");
        
        catalog.displayAvailableBooks();

        user1.borrowBook(book1); 
        user2.borrowBook(book3); 
        catalog.displayAvailableBooks(); 
                
        user1.returnBook(book1); 
        catalog.displayAvailableBooks(); 
        
        user3.borrowBook(book4); 
        user1.borrowBook(book4);
        catalog.displayAvailableBooks(); 
    }
}
