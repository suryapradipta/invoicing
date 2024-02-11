package com.ksatria.invoicing.model;

import lombok.*;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@View(
    extendsView = "super.DEFAULT",
    members = "orders {orders}"
)
@View( name="NoCustomerNoOrders", // A view named NoCustomerNoOrders
    members=                      // that does not include customer and orders
        "year, number, date;" +   // Ideal to be used from Order
            "details;" +
            "remarks"
)
public class Invoice extends CommercialDocument {
    @OneToMany(mappedBy = "invoice")
    @CollectionView("NoCustomerNoInvoice") // This view is used to display orders
    Collection<Order> orders; // Collection of Order entities added
}
