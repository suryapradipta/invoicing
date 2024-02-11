package com.ksatria.invoicing.model;

import com.ksatria.invoicing.calculators.NextNumberForYearCalculator;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@View(members= // This view has no name, so it will be the view used by default
    "year, number, date;" + // Comma separated means in the same line
        "customer;" + // Semicolon means a new line
        "details;" +
        "remarks"
)
public class Invoice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // customer is required
    @ReferenceView("Simple") // The view named 'Simple' is used to display this reference
    Customer customer;

    @ElementCollection
    @ListProperties("product.id, product.description, quantity")
    Collection<Detail> details;

    @TextArea
    String remarks;
}


