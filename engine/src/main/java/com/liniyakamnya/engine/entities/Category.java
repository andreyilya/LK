package com.liniyakamnya.engine.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 17.07.12
 */
@Entity
public class Category implements Serializable {
    private int id;
    private String name;
    private List<SubCategory> subCategories;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
