package com.liniyakamnya.ui.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 17.07.12
 */
@Entity
@NamedQueries({

        @NamedQuery(name = "category.all",
                query = "from Category")}

)

public class Category implements Identifiable {
    private Long id;
    private String name;
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL},
            targetEntity=SubCategory.class,
            orphanRemoval = true)
    @JoinColumn(name="category_id")
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
