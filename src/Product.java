public class Product {
        private String name;
        private double unitPrice;

        public Product(String name, double unitPrice) {
            this.name = name;
            this.unitPrice = unitPrice;
        }



        @Override
        public String toString() {
            return name + " ($" + unitPrice + ")";
        }

    public double getUnitPrice() {
        return 0;
    }
}
