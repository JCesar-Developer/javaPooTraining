import java.util.ArrayList;

public class Book {

    //ATTRIBUTES
    private String ID;
    private String title;
    private String author;
    private int    pages;

    //BUILDER

    /**
     * Builder with all parameters.
     * @param ID
     * @param title
     * @param author
     * @param pages
     */
    public Book(String ID, String title, String author, int pages) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //GETTERS & SETTERS
    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    //CLASS METHODS
    @Override
    public String toString() {
        return "The book " + this.title + ", with ID: " + this.ID +
                ", created by: " + this.author + ". Have: " + this.pages + " pages.";
    }

    //-------------------------- MAIN --------------------------//
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        Book b1 = new Book("1110", "Harry Potter", "J.K. Rowling", 200);
        Book b2 = new Book("2220", "The lord of the rings", "J.R.R. Tolkien", 800);
        Book b3 = new Book("3330", "Game of thrones", "George R. R. Martin", 500);

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        //ADDING BOOKS IN THE LIBRARY
        books.add(b1);
        books.add(b2);
        books.add(b3);

        //CHOOSE WHICH BOOK IS LONGER
        int maxPages = 0;
        Book longerBook = null;

        for (Book b : books) {
            if ( b.getPages() > maxPages ) {
                maxPages   = b.getPages();
                longerBook = b;
            }
        }

        //SHOWING THE LONGEST BOOK IN THE LIBRARY
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("The longest book is: " + longerBook.title +
                ", with " + longerBook.pages + " pages.");
        System.out.println("-----------------------------------------------------------");

    }

}
