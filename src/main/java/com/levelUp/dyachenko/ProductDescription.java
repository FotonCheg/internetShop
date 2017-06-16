package com.levelUp.dyachenko;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter

@Entity
public class ProductDescription {
    @Id
    @GeneratedValue
    private int id;

    @Lob//Чтобы хибер не создал в базе VARCHAR(255), а создал LONGTEXT для большого текста
    private String description;
}
