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
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)//пусть при сохранении в БД продукта, его категории сохранятся автоматически
    private Set<Category> categorySet = new HashSet<Category>();

    @OneToOne(cascade = CascadeType.ALL)//Так же и описание пусть сохраняется само
    private ProductDescription description;
    //Нужно добавить Set<ProductPrice>, Set<ProductCost>, ProductDescription productDescription,

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate=new Date();

    private int cost;
    private int price;

}
