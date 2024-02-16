package com.ksatria.invoicing.model;

import lombok.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category extends Identifiable {
    String description;
}
