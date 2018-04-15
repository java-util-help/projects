/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

/**
 *
 * @author MEDİA MARKT
 */
public class Room {
    
    private int number;
    private String type;
    private int price;
    
    
    private enum status{
        BOS,
        DOLU
    };
    status x;

    public Room(int number) {
        this.number = number;
        x = status.BOS; 
   }


    public status getX() {
        return x;
    }

    public void setX() {
       x = status.DOLU;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    

}

