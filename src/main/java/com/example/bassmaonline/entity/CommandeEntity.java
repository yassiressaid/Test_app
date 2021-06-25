package com.example.bassmaonline.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")

public class CommandeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long orderId;

    private String orderDate;

    private String codePostal;

    private String totalOrder;

    private String adresse;

    private String CodePromoId;

    public CommandeEntity() {
		super();
	}

	public CommandeEntity(String orderDate, String codePostal, String totalOrder, String adresse, String codePromoId) {
		super();
		this.orderDate = orderDate;
		this.codePostal = codePostal;
		this.totalOrder = totalOrder;
		this.adresse = adresse;
		CodePromoId = codePromoId;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePromoId() {
        return CodePromoId;
    }

    public void setCodePromoId(String codePromoId) {
        CodePromoId = codePromoId;
    }
}
