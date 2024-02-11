package com.ksatria.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 50)
    @Required
    String name;

    @OneToMany(mappedBy = "author")
    @ListProperties("id, description, price")
    Collection<Product> products;
}
