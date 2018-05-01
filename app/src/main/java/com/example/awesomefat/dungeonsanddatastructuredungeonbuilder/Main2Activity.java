package com.example.awesomefat.dungeonsanddatastructuredungeonbuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity
{
    private EditText newName;
    private EditText newDescription;
    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        this.newName = (EditText) this.findViewById(R.id.newNameTV);
        this.newDescription = (EditText) this.findViewById(R.id.newDescriptionTV);
        this.northButton = (Button)this.findViewById(R.id.northButton);
        this.southButton = (Button)this.findViewById(R.id.southButton);
        this.eastButton = (Button)this.findViewById(R.id.eastButton);
        this.westButton = (Button)this.findViewById(R.id.westButton);


        //code to add an exit associated with one of the current rooms
    }

    public void onNorthButtonPressed()
    {
        Core.rooms.addExit("North", this.currentRoom);
    }

    public void onSouthButtonPressed()
    {
        Core.rooms.addExit("South", this.currentRoom);
    }

    public void onEastButtonPressed()
    {
        Core.rooms.addExit("East", this.currentRoom);
    }

    public void onWestButtonPressed()
    {
        Core.rooms.addExit("West", this.currentRoom);
    }

    //Upon saving, the room is added to the LOCAL copy of the dungeon and can be tested by
    // using your exit buttons. And then each room page should have a save button that overrides
    // the database with the new version of the dungeon, such that the next time you launch
    // builder or the original app, it shows this new dungeon.
    public void saveButtonPressed(View v)
    {
        Core.rooms = new Room(newName.toString(), newDescription.toString());
    }
}