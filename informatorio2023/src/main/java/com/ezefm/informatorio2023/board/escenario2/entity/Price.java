package com.ezefm.informatorio2023.board.escenario2.entity;

import java.util.Date;

public class Price {

    private Double value;
    private Date date;

    public Price(){}
    public Price(Double value, Date date) {
        this.value = value;
        this.date = date;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}