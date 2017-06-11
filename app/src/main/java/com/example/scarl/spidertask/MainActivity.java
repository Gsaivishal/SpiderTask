package com.example.scarl.spidertask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button x;
    EditText e;
    EditText e1;
    String s1;
    ArrayList<String> s = new ArrayList<String>();
    ListView l;
    ArrayAdapter<String> L ;
    static int m=0;
    static int n=0;
    static int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (Button) findViewById(R.id.AddItem);
        l = (ListView) findViewById(R.id.Listview);
        e = (EditText) findViewById(R.id.editText);
        e1 = (EditText) findViewById(R.id.editText2);


         final Intent intent = new Intent(this,Main2Activity.class);

         L = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
         l.setAdapter(L);



        l.setOnItemClickListener(
               new AdapterView.OnItemClickListener(){

                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                       intent.putExtra("Name", s.get(position));

                       startActivity(intent);
                   }
               }
        );



    }

    public void onClick (View v) {

        s1=e.getText().toString();
        if(s1.length() > 0)
        {
            s.add(s1);
            L.notifyDataSetChanged();
        }

        e.setText("");
    }

    public void OnClick(View v1) {
        n = Integer.parseInt(e1.getText().toString());
        
        if (n-1<=l.getAdapter().getCount()) {
            Object toRemove = L.getItem(n-1);
            L.remove((String) toRemove);
            L.notifyDataSetChanged();
        }

        else
            Toast.makeText(MainActivity.this,"No item in the position",Toast.LENGTH_LONG).show();

        e1.setText("");



    }


}
