package com.example.karshi.callerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> contactListArray = new ArrayList<String>();
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = (ListView)findViewById(R.id.Listview);
        Populate();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,contactListArray);
        mylist.setAdapter(adapter);
        registerForContextMenu(mylist);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String a = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(),"Clicked :"+ a, Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"Send Message");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle()=="Call")Toast.makeText(getApplicationContext(),"Call selected", Toast.LENGTH_LONG).show();
        if(item.getTitle()=="Send Message")Toast.makeText(getApplicationContext(),"Send Message selected", Toast.LENGTH_LONG).show();
        if(item.getTitle()=="Edit")Toast.makeText(getApplicationContext(),"Edit selected", Toast.LENGTH_LONG).show();
        if(item.getTitle()=="Delete")Toast.makeText(getApplicationContext(),"Delete selected", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.contactlistmenu,menu);
        return true;
    }

    void Populate(){

        contactListArray.add("Anne");
        //contactListArray.add("Anne");
        contactListArray.add("Mary");
        contactListArray.add("John");
        contactListArray.add("Tom");
        contactListArray.add("Ben");
        contactListArray.add("Sam");
        contactListArray.add("Shannon");
        contactListArray.add("Jason");
        contactListArray.add("Lois");
        contactListArray.add("Tammy");


        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.menuAdd:
                Intent intent= new Intent(MainActivity.this,Add_a_contact_Activity.class);
                startActivityForResult(intent,1024);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }



        //Intent intent = new Intent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){

            case 1024:
                if(resultCode== Activity.RESULT_OK){

                    if(data.hasExtra(Add_a_contact_Activity.CONTACTTOKEN)){

                        String msg= data.getStringExtra(Add_a_contact_Activity.CONTACTTOKEN);
                        contactListArray.add(msg);
                       // mylist.setAdapter();
                        ArrayAdapter<String> adapter = (ArrayAdapter<String>) mylist.getAdapter();
                        adapter.notifyDataSetChanged();
                    }
                }
        }
    }
} 


