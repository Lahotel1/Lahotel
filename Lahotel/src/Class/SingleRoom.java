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
public class SingleRoom extends Room{
    
    public SingleRoom(String room_id, String day) {
        super(room_id, day);
        super.setName("SingleRoom");
    }

    @Override
    void CalculateCost() {
        int temp_cost =1000;
        if(this.getIsAddBed()==true)
            temp_cost+=300;
        if(this.getIsAddWifi()==true)
            temp_cost+=500;
        super.setCost(temp_cost); 
    }
}
