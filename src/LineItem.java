public class LineItem {

    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }



    public double calculateTotal() {
        return product.getUnitPrice() * quantity; }

    @Override
    public String toString() {
        return product.toString() + " x " + quantity + " = $" + calculateTotal();
    }
}

