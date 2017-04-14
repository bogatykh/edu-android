package com.example.st26536.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView _listView;
    List<ToDoItem> _items = new ArrayList<>();
    private ToDoAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _listView = (RecyclerView)findViewById(R.id.listView);
        _adapter = new ToDoAdapter(_items);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        _listView.setLayoutManager(mLayoutManager);
        _listView.setAdapter(_adapter);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtName = (EditText)findViewById(R.id.txtName);
                String name = txtName.getText().toString();
                if (name.length() > 0) {
                    addItem(new ToDoItem(txtName.getText().toString()));
                    txtName.setText("");
                }
            }
        });
    }

    private void addItem(ToDoItem item) {
        _items.add(item);
        _adapter.notifyDataSetChanged();
    }
}
