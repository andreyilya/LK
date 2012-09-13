package com.liniyakamnya.ui.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author a.radkov
 *         Date: 19.07.12
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "note.all",
				query = "from Note")
})
public class Note implements Identifiable {
    private Long id;

    private Date createdDate = new Date();
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

    @ManyToOne(fetch = FetchType.LAZY)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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
