package models.cart;

import java.math.BigDecimal;

public class ProductLine {

    private Product product;
    private int quantity;

    public ProductLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getTotalValueOfLine() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int value) {
        quantity = value;
    }

    public boolean equals(ProductLine productLine) {
        return this.product.equals(productLine.product) && this.quantity == productLine.quantity;
    }
}
