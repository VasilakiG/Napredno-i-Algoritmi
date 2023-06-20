public class Product {

    private final float percentPerProduct;
    private final int discountedPrice;
    private final int nonDiscountedPrice;
    private final int difference;

    public Product( int discountedPrice, int nonDiscountedPrice) {
        this.discountedPrice = discountedPrice;
        this.nonDiscountedPrice = nonDiscountedPrice;
        this.percentPerProduct = calculatePercent();
        this.difference = calculateDifference();
    }

    public float getPercentPerProduct() {
        return percentPerProduct;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public int getNonDiscountedPrice() {
        return nonDiscountedPrice;
    }

    public int getDifference() {
        return difference;
    }

    private float calculatePercent() {
        return ( 1 - ( (float) this.discountedPrice / this.nonDiscountedPrice ) * 100);
    }

    private int calculateDifference(){
        return ( this.nonDiscountedPrice - this.discountedPrice );
    }

    @Override
    public String toString() {

        return percentPerProduct +
                "% " +
                discountedPrice +
                "/" +
                nonDiscountedPrice +
                "\n";
    }
}
