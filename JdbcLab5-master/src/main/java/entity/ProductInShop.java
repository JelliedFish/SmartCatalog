package entity;

import java.util.Objects;

public class ProductInShop {

    private Long shopId;
    private Long productId;
    private Long count;

    public ProductInShop(){}

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInShop that = (ProductInShop) o;
        return Objects.equals(shopId, that.shopId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, productId, count);
    }

    @Override
    public String toString() {
        return "ProductInShop{" +
                "shopId=" + shopId +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }
}
