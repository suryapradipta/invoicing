package com.ksatria.invoicing.model;

import lombok.*;
import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Detail {
    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;
}
