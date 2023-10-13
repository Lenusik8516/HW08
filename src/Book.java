import java.util.*;
import java.util.stream.Collectors;

public class Book {
    // Enumeration for the genre of the book
    public enum Genre {
        HORROR, COMEDY, DRAMA, SCIFI, MYSTERY
    }

    // Book Fields
    private String title;
    private String author;
    private int releaseYear;
    private Genre genre;

    // Constructor for creating a book
    public Book(String title, String author, int releaseYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    // Getters and setters for fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Method for grouping books by author
    public static Map<String, List<Book>> groupBooksByAuthor(List<Book> books) {
        // Creating an empty map for grouping
        Map<String, List<Book>> result = new HashMap<>();

        // We use the Java Stream API to group books by author
        result = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        return result;
    }

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("abc", "a", 123, Genre.HORROR),
                new Book("abc2", "a", 1777, Genre.HORROR),
                new Book("123", "b", 1230, Genre.COMEDY),
                new Book("321", "b", 1243, Genre.COMEDY),
                new Book("title", "c", 1923, Genre.HORROR),
                new Book("title 2", "d", 2023, Genre.HORROR)
        );

        Map<String, List<Book>> groupedBooks = groupBooksByAuthor(books);

        // Output the result of grouping
        for (String author : groupedBooks.keySet()) {
            System.out.println(author + "=" + groupedBooks.get(author));
        }
    }
}
