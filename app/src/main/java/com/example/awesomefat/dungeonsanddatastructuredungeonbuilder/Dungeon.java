package com.example.awesomefat.dungeonsanddatastructuredungeonbuilder;
import java.awt.Button;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dungeon
{
    public int startRoomIndex;
    public String name;
    public ArrayList<Exit> exits;
    public ArrayList<Room> rooms;


    public Dungeon()
    {
        this.exits = new ArrayList<Exit>();
        this.rooms = new ArrayList<Room>();
    }

    public Dungeon(String name)
    {
        this();
        this.name = name;
        this.startRoomIndex = -1;
    }

    public Dungeon(String name, Room startRoom)
    {
        this(name);
        this.startRoomIndex = 0;
        this.rooms.add(startRoom);
    }

    public int findIndexOfRoom(Room r)
    {
        return this.rooms.indexOf(r);
    }

    public void addExit(Exit e)
    {
        this.exits.add(e);
    }

    public void addRoom(Room r)
    {
        this.rooms.add(r);
    }

    public void addPlayer(Player p)
    {
        this.rooms.get(this.startRoomIndex).addPlayer(p);
    }
}
