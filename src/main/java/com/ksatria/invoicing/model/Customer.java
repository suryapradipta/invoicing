package com.ksatria.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.*;


@Entity
@Getter
@Setter
@View(name="Simple", // This view is used only when “Simple” is specified
    members="id, name" // Shows only number and name in the same line
)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    @Required
    private String name;

    @NoFrame
    @Embedded
    private Address address;
}
