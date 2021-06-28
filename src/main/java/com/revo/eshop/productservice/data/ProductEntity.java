package com.revo.eshop.productservice.data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true,name = "product_id")
    private String productId;

    @Column(nullable = false, unique = true,name = "sku")
    private String sku;

    @Column(nullable = false,name = "product_name")
    private String productName;

    @Column(nullable = false, name = "main_price")
    private BigDecimal mainPrice;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp()
    @Column(name = "date_created")
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "last_updated")
    private Date dateUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
