package com.ksatria.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Getter
@Setter
@View(
    extendsView = "super.DEFAULT",
    members = "invoice {invoice}"
)
@View( name="NoCustomerNoInvoice", // A view named NoCustomerNoInvoice
    members=                       // that does not include customer and invoice.
        "year, number, date;" +    // Ideal to be used from Invoice
            "details;" +
            "remarks"
)
public class Order extends CommercialDocument {
    @ManyToOne
    @ReferenceView("NoCustomerNoOrders") // This view is used to display invoice
    Invoice invoice; // Reference to invoice added
}
