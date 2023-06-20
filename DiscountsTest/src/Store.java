import java.util.List;

public class Store {

    private final String storeName;
    private final List<Product> listOfProducts;

    public Store(String storeName, List<Product> listOfProducts) {
        this.storeName = storeName;
        this.listOfProducts = listOfProducts;
    }


    private int totalDiscount(){

        return listOfProducts.stream()
                .mapToInt(Product::getDifference)
                .sum();
    }

    private float averageDiscount(){
        return ( (float) totalDiscount() / listOfProducts.size() );
    }

    @Override
    public String toString() {

        return storeName +
                "\nAverage discount: " +
                averageDiscount() +
                "%\nTotal discount: " +
                totalDiscount() +
                "\n" +
                listOfProducts;
    }
}
