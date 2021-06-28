package com.revo.eshop.productservice.shared;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {
    private final long serialVersionUID = 3318408331472178160L;

    private String productId;

    private String sku;

    private String productName;

    private BigDecimal mainPrice;

    private String productDescription;

    private boolean active;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getMainPrice() {
        return mainPrice;
    }

    public void setMainPrice(BigDecimal mainPrice) {
        this.mainPrice = mainPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
