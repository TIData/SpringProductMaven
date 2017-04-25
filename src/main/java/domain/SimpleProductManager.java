package domain;

import java.util.List;

public class SimpleProductManager implements ProductManager {

    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice()
                        * (100 + percentage) / 100;
                product.setPrice(newPrice);
            }
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void decreasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice()
                        - (product.getPrice() * percentage / 100);
                product.setPrice(newPrice);
            }
        }
    }
}
