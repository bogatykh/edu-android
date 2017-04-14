package com.example.st26536.helloworld;

import java.util.Date;

/**
 * Created by st26536 on 18.03.2017..
 */
public class ToDoItem {
    Date _created;
    String _name;

    public ToDoItem(String name) {
        _name = name;
        _created = new Date();
    }
}
