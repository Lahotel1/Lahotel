/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String roomtype = "";
    private String startdate;
    private String enddate;
    private String isBed;
    private String isWifi;
    private String status;
    private Boolean isCheckin;
    private int cost;
    private int person;
    @ManyToMany(mappedBy = "booking")
    private List<Account> account = new ArrayList<Account>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Room> room = new ArrayList<Room>();

    public Booking(Account account, List<Room> room, int person, int cost) {
        this.name = account.getEmail();
        List<Room> temp = new ArrayList<Room>();
        for (Room room1 : room) {
            Boolean canAdd = false;
            for (Room room2 : temp) {
                if (room1.getRoom_id().equals(room2.getRoom_id())) {
                    canAdd = true;
                    break;
                }
            }
            if (canAdd == false) {
                temp.add(room1);
            }
        }
        for (Room room1 : temp) {
            this.roomtype = this.roomtype.concat(room1.getName() + ":" + room1.getRoom_id() + "\n");
        }

        this.startdate = room.get(0).getDay() + "/" + room.get(0).getMonth() + "/" + room.get(0).getYear();
        this.enddate = room.get(room.size() - 1).getDay() + "/" + room.get(room.size() - 1).getMonth() + "/" + room.get(room.size() - 1).getYear();
        if (room.get(0).getIsAddBed() == true) {
            this.isBed = "YES";
        } else {
            this.isBed = "NO";
        }
        if (room.get(0).getIsAddWifi() == true) {
            this.isWifi = "YES";
        } else {
            this.isWifi = "NO";
        }
        this.isCheckin = false;
        this.status = "WAITING";
        this.person = person;
        this.cost = cost;
    }

    public void checkin() {
        this.isCheckin = true;
        this.status = "CHECKIN";
    }

    public void cancel() {
        this.status = "CANCEL";
    }

    public void addRoom(Room room) {
        this.room.add(room);
        room.getBooking().add(this);
    }

    public void removeRoom(Room room) {
        this.room.remove(room);
        room.getBooking().remove(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getIsBed() {
        return isBed;
    }

    public void setIsBed(String isBed) {
        this.isBed = isBed;
    }

    public String getIsWifi() {
        return isWifi;
    }

    public void setIsWifi(String isWifi) {
        this.isWifi = isWifi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public Boolean getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Boolean isCheckin) {
        this.isCheckin = isCheckin;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
