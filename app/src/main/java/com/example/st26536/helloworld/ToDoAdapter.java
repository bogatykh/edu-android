package com.example.st26536.helloworld;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by st26536 on 18.03.2017..
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    List<ToDoItem> _items;
    final SimpleDateFormat dt = new SimpleDateFormat("MM.dd.yyyy");

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txtDate;
        public Button btnDelete;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
            btnDelete = (Button) view.findViewById(R.id.btnDelete);
        }
    }

    public ToDoAdapter(List<ToDoItem> items) {
        _items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ToDoItem item = _items.get(position);
        holder.txtName.setText(item._name);
        holder.txtDate.setText(dt.format(item._created));

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _items.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return _items.size();
    }
}
