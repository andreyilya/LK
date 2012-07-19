package com.liniyakamnya.engine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author a.radkov
 *         Date: 19.07.12
 */
@Entity
public class Note implements Serializable {
    private Long id;

    private Date createdDate;
    private Category category;
    private SubCategory subCategory;
    private double price;
    private double number;
    private int status;
    private String customerName;
    private String customersPhone;
    private String others;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Column
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column
    public double getNumber() {
        return number;
    }

    @Column
    public void setNumber(double number) {
        this.number = number;
    }

    @Column
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column
    public String getCustomersPhone() {
        return customersPhone;
    }

    public void setCustomersPhone(String customersPhone) {
        this.customersPhone = customersPhone;
    }

    @Column
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
