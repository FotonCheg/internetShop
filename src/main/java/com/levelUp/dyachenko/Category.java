package com.levelUp.dyachenko;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
