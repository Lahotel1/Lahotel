/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author terkg
 */
@MappedSuperclass
public class GroupRoom extends Room {

    public GroupRoom(String room_id, String day, String month, String year) {
        super(room_id, day, month, year);
        super.setName("GroupRoom");
    }



    @Override
    public void CalculateCost() {
        int temp_cost = 4000;
        if (this.getIsAddBed() == true) {
            temp_cost += 500;
        }
        if (this.getIsAddWifi() == true) {
            temp_cost += 300;
        }
        super.setCost(temp_cost);
    }

}
