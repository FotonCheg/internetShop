package com.levelUp.dyachenko;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
public class SomeOrder {
    @Id
    @GeneratedValue
    private int id;
    private String name;//Потом убрать
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> productSet = new HashSet<Product>();
}
