package com.example.awesomefat.dungeonsanddatastructuredungeonbuilder;
/**
 * Created by awesomefat on 3/29/18.
 */

public class Exit
{
    public int r1_index;
    public int r2_index;

    public Exit(){}

    public Exit(int r1_index, int r2_index)
    {
        this.r1_index = r1_index;
        this.r2_index = r2_index;
    }

    public boolean takeExit(Player p)
    {
        //make the player move to the room they are NOT currently in.
        Room r1 = Core.theDungeon.rooms.get(this.r1_index);
        Room r2 = Core.theDungeon.rooms.get(this.r2_index);

        if(p.getCurrentRoom() == r1)
        {
            r1.removePlayer(p);
            r2.addPlayer(p);
            return true;
        }
        else if(p.getCurrentRoom() == r2)
        {
            r2.removePlayer(p);
            r1.addPlayer(p);
            return true;
        }
        return false;
    }
}
