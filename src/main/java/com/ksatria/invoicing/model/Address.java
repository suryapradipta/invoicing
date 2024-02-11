package com.ksatria.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    @Column(length = 50)
    private String street;

    @Column(length = 5)
    @Required
    private int zipCode;

    @Column(length = 20)
    private String city;

    @Column(length = 30)
    private String state;
}
