package com.ksatria.invoicing.model;

import lombok.*;
import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Address {
    private String street;

    private int zipCode;

    private String city;

    private String state;
}
