package com.example.awesomefat.dungeonsanddatastructuredungeonbuilder;
import android.view.View;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Room
{
    @Exclude
    public ArrayList<Player> players;

    public ArrayList<NPC> npcs;
    public Map<String, Exit> exits;
    public String description;
    public String name;

    public Room()
    {
        this.players = new ArrayList<Player>();
        this.npcs = new ArrayList<NPC>();
        this.exits = new HashMap<String, Exit>();
    }

    public Room(String name, String description)
    {
        this();
        this.name = name;
        this.description = description;
    }



    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public Map<String, Exit> getExits() {
        return exits;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    //Exit Management
    synchronized  public void addExit(String direction, Exit e)
    {
        this.exits.put(direction, e);
    }



    public boolean takeExit(String direction)
    {
        Exit temp = this.exits.get(direction);
        if(temp != null)
        {
            return temp.takeExit(this.players.get(0));
        }
        else
        {
            return false;
        }
    }

    //Player management
    synchronized private void players_PerformAction(String action, Object[] params)
    {
        if(action.equals("addPlayer"))
        {
            Player temp = (Player)params[0];
            this.players.add(temp);
            temp.setCurrentRoomIndex(Core.theDungeon.findIndexOfRoom(this));
        }
        else if(action.equals("removePlayer"))
        {
            Player temp = (Player)params[0];
            if(this.players.remove(temp))
            {
                temp.setCurrentRoomIndex(-1);
            }
        }
    }


    public void addPlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("addPlayer", params);
    }


    public void removePlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("removePlayer", params);
    }

    //NPC management
    synchronized private void npcs_PerformAction(String action, Object[] params)
    {
        if(action.equals("addNPC"))
        {
            NPC temp = (NPC)params[0];
            this.npcs.add(temp);
            temp.setCurrentRoomIndex(Core.theDungeon.findIndexOfRoom(this));
        }
        else if(action.equals("removeNPC"))
        {
            NPC temp = (NPC)params[0];
            if(this.npcs.remove(temp))
            {
                temp.setCurrentRoomIndex(-1);
            }
        }
    }

    public void addNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("addNPC", params);
    }

    public void removeNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("removeNPC", params);
    }
}
