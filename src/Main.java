import java.util.*;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
    }
}

class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getYear(), b2.getYear());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));

        System.out.println("Books sorted by title:");
        Collections.sort(books);
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nBooks sorted by year:");
        books.sort(new BookComparator());
        for (Book book : books) {
            System.out.println(book);
        }
    }
}