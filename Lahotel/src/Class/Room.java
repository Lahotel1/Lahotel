/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author terkg
 */
@Entity
public abstract class Room {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String room_id;
    private Boolean isBook;
    private String day;
    private String month;
    private String year;
    private Boolean isAddBed;
    private Boolean isAddWifi;
    private int Cost;
    @ManyToMany(mappedBy = "tags")
    private List<Account> account = new ArrayList<Account>();
    Room(String room_id,String day,String month,String year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.room_id=room_id;
        initial();
    }
    
    private void initial(){
        this.isBook = false;
        this.isAddBed = false;
        this.isAddWifi = false;
        this.CalculateCost();
    }
    
    abstract void CalculateCost();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Boolean getIsBook() {
        return isBook;
    }

    public void setIsBook(Boolean isBook) {
        this.isBook = isBook;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getIsAddBed() {
        return isAddBed;
    }

    public void setIsAddBed(Boolean isAddBed) {
        this.isAddBed = isAddBed;
    }

    public Boolean getIsAddWifi() {
        return isAddWifi;
    }

    public void setIsAddWifi(Boolean isAddWifi) {
        this.isAddWifi = isAddWifi;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
    
}
