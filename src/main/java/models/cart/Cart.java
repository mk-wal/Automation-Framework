package models.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<ProductLine> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProductLineToCart(ProductLine productLine) {
        if (products.stream().anyMatch(pl -> pl.getProduct().equals(productLine.getProduct()))) {
            products.get(getIndexOfProduct(productLine)).increaseQuantity(productLine.getQuantity());
        } else {
            products.add(productLine);
        }
    }

    public void addProductLineToCart(String name, BigDecimal price, int quantity) {
        addProductLineToCart(new ProductLine(new Product(name, price), quantity));
    }

    private int getIndexOfProduct(ProductLine productLine) {
        return products.indexOf(products.stream().filter(pl -> pl.getProduct().equals(productLine.getProduct())).toList().get(0));
    }

    public List<ProductLine> getProducts() {
        return products;
    }

    public BigDecimal getTotalValueOfCart() {
        BigDecimal value = BigDecimal.valueOf(0);
        for (ProductLine productLine : products) {
            value = value.add(productLine.getTotalValueOfLine());
        }
        return value;
    }
}
