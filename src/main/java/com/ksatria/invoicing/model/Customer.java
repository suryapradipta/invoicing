package com.ksatria.invoicing.model;

import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@View(name="Simple", // This view is used only when “Simple” is specified
    members="id, name" // Shows only number and name in the same line
)
@View( name="Only", // A view named NoCustomerNoInvoice
    members=                       // that does not include customer and invoice.
        "year, number, date;" +    // Ideal to be used from Invoice
            "details;" +
            "remarks"
)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @NoFrame
    @Embedded
    private Address address;
}
