package com.liniyakamnya.engine.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author a.radkov
 *         Date: 17.07.12
 */
@Entity
public class SubCategory implements Serializable {
    private int id;
    private String name;
    private Category category;

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

    @ManyToOne(fetch = FetchType.LAZY)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
