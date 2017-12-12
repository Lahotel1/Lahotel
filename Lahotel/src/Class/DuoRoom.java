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
public class DuoRoom extends Room{

    public DuoRoom(String room_id, String day, String month, String year) {
        super(room_id, day, month, year);
        super.setName("DuoRoom");
    }



    @Override
    void CalculateCost() {
        int temp_cost =2000;
        if(this.getIsAddBed()==true)
            temp_cost+=300;
        if(this.getIsAddWifi()==true)
            temp_cost+=500;
        super.setCost(temp_cost); 
    }
    
}
