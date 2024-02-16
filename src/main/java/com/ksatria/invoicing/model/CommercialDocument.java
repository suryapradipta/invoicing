package com.ksatria.invoicing.model;

import com.ksatria.invoicing.calculators.NextNumberForYearCalculator;
import lombok.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@View(
    members = "year, number, date;" +
        "data {" +
            "customer;" +
            "details;" +
        "remarks" +
        "}"
)
abstract public class CommercialDocument extends Identifiable {
    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Current year
    int year;

    @Column(length = 6)
    @DefaultValueCalculator(value = NextNumberForYearCalculator.class,
        properties = @PropertyValue(name = "year") // To inject the value of year from Invoice to
        // the calculator before calling to calculate()
    )
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Current date
    LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @ReferenceView("Simple") // The view named 'Simple' is used to display this reference
    Customer customer;

    @ElementCollection
    @ListProperties("product.id, product.description, quantity")
    Collection<Detail> details;

    @TextArea
    String remarks;
}


