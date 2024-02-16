package com.ksatria.invoicing.model;

import lombok.*;
import org.openxava.annotations.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Author extends Identifiable {

    String name;

    @OneToMany(mappedBy = "author")
    @ListProperties("id, description, price")
    Collection<Product> products;
}
