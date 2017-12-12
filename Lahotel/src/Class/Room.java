/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author terkg
 */
public abstract class Room {
    private String name;
    private String room_id;
    private Boolean isBook;
    private String day;
    private Boolean isAddBed;
    private Boolean isAddWifi;
    private int Cost;
    Room(String room_id,String day)
    {
        this.day = day;
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
    
}
