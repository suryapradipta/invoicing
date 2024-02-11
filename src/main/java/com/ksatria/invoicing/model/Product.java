package com.ksatria.invoicing.model;

import lombok.*;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    @Required
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    Category category;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Author author;

    @Money // The price property is used to store money
    BigDecimal price;  // BigDecimal is typically used for money

    @Files // A complete image gallery is available
    @Column(length = 32) // The 32 length string is for storing the key of the gallery
    String photos;

    @TextArea// This is for a big text, a text area or equivalent will be used
    String remarks;
}
