package com.klef.fsadcom.klef.fsad.ProductHibernate;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="product")
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;
    public String description;

    @Temporal(TemporalType.DATE)
    public Date date;

    public String status;
}