package com.levelUp.dyachenko;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity//по-умолчанию имя сущности совпадает с именем класса
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    @OneToMany(cascade=CascadeType.ALL)//Когда будем сохранять клиента, пусть его заказы так же сохраняются автоматически
    @JoinColumn(name="client_id")//Сказал хиберу, что не надо делать отдельную таблицу, сделай дополнительный столбец в inverse - таблице и назови её clientId
    private Set<SomeOrder> someOrderSet = new HashSet<SomeOrder>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();
}
