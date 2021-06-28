package com.revo.eshop.productservice.ui.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateProductRequestModel {
    @NotNull(message = "Product code cannot be null")
    private String sku;

    @NotNull(message = "Product name cannot be null")
    private String productName;

    private BigDecimal mainPrice;

    private String productDescription;

    private boolean active;

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
