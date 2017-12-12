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
public class GroupRoom extends Room {

    public GroupRoom(String room_id, String day) {
        super(room_id, day);
        super.setName("GroupRoom");
    }

    @Override
    void CalculateCost() {
        int temp_cost = 4000;
        if (this.getIsAddBed() == true) {
            temp_cost += 300;
        }
        if (this.getIsAddWifi() == true) {
            temp_cost += 500;
        }
        super.setCost(temp_cost);
    }

}
