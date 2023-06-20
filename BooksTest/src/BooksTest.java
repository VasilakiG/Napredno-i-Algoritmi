import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BooksTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        BookCollection booksCollection = new BookCollection();
        Set<String> categories = fillCollection(scanner, booksCollection);
        System.out.println("=== PRINT BY CATEGORY ===");
        for (String category : categories) {
            System.out.println("CATEGORY: " + category);
            booksCollection.printByCategory(category);
        }
        System.out.println("=== TOP N BY PRICE ===");
        print(booksCollection.getCheapestN(n));
    }

    static void print(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    static TreeSet<String> fillCollection(Scanner scanner,
                                          BookCollection collection) {
        TreeSet<String> categories = new TreeSet<String>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            Book book = new Book(parts[0], parts[1], Float.parseFloat(parts[2]));
            collection.addBook(book);
            categories.add(parts[1]);
        }
        return categories;
    }
}

// Вашиот код овде
class Book {

    private final String title;
    private final String category;
    private final float price;

    public Book(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

//    @Override
//    public int compareTo(Book other) {
//        int titleComparison = this.title.compareTo(other.getTitle());
//        int priceComparison = Float.compare(this.price, other.getPrice());
//        int categoryComparison = this.category.compareTo(other.getCategory());
//
//        if ( titleComparison == 0 && priceComparison == 0 ){
//            return categoryComparison;
//        }else if ( titleComparison == 0 ){
//            return priceComparison;
//        }
//        return titleComparison;
//    }

    @Override
    public String toString() {
        return String.format("%s (%s) %.2f", title, category, price);
    }
}

class BookCollection {

    private List<Book> bookCollection;

    public BookCollection() {
        bookCollection = new ArrayList<Book>();
    }

    public void printByCategory(String otherCategory) {

        bookCollection.stream()
                .filter(book -> book
                        .getCategory()
                        .equalsIgnoreCase(otherCategory))
                .sorted(Comparator
                        .comparing(Book::getTitle)
                        .thenComparing(Book::getPrice)
                        .thenComparing(Book::getCategory))
                .forEach(System.out::println);

//        if (IntStream.range(0, bookCollection.size())
//                .anyMatch(i -> bookCollection.get(i).getCategory().equals(otherCategory.toLowerCase()))
//        ){
//            bookCollection.stream()
//                    .sorted()
//                    .forEach(System.out::println);
//        }
    }

    public List<Book> getCheapestN(int n) {
        return bookCollection.stream()
                .sorted(Comparator.comparing(Book::getPrice).thenComparing(Book::getTitle).thenComparing(Book::getCategory))
                .limit(n)
                .collect(Collectors.toList());
    }

    public void addBook(Book book) {
        bookCollection.add(book);
    }
}
