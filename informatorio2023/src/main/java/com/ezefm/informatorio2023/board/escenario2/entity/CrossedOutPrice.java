package com.ezefm.informatorio2023.board.escenario2.entity;
import java.util.Date;
public class CrossedOutPrice {

    private Double value;
    private Date date;
    private Date validDate;

    public CrossedOutPrice(){}

    public CrossedOutPrice(Double value, Date date, Date validDate) {
        this.value = value;
        this.date = date;
        this.validDate = validDate;
    }
    public CrossedOutPrice(Double value) {
        this.value = value;
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
    public Date getValidDate() {
        return validDate;
    }
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
}