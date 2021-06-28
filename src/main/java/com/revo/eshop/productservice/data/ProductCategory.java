package com.revo.eshop.productservice.data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<ProductEntity> products;

    @CreationTimestamp()
    @Column(name = "date_created")
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "last_updated")
    private Date dateUpdated;
}
