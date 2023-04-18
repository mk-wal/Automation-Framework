package models.cart;

import java.math.BigDecimal;

public record Product(
        String name,
        BigDecimal price) {

    public boolean equals(Product secondProduct) {
        return this.name.equals(secondProduct.name) && this.price.equals(secondProduct.price);
    }
}
