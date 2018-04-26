package com.example.awesomefat.dungeonsanddatastructuredungeonbuilder;
/**
 * Created by awesomefat on 4/5/18.
 */

public abstract class Character
{
    public String name;
    public int currentRoom_index;

    public Character(){}

    public Character(String name)
    {
        this.name = name;
        this.currentRoom_index = -1;
    }

    public void display()
    {
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom()
    {
        return Core.theDungeon.rooms.get(this.currentRoom_index);
    }

    public void setCurrentRoomIndex(int currentRoom_index)
    {
        this.currentRoom_index = currentRoom_index;
    }
}
