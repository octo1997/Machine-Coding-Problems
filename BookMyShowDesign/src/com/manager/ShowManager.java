package com.manager;

import com.entiities.Show;
import com.entiities.Theatre;

import java.util.HashMap;
import java.util.Map;

public class ShowManager {
    private ShowManager(){}

    private static final ShowManager instance = new ShowManager();
    public static ShowManager getInstance(){
        return instance;
    }

    private Map<String, Show> showMap = new HashMap();
    private static int count = 0;
    public void addShow(String name){
        String id = Integer.toString(count++);
        showMap.put(id, new Show(id, name));
    }

    public Show getShow(String id){
        return showMap.get(id);
    }
}
