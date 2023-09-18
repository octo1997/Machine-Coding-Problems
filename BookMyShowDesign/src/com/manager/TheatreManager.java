package com.manager;

import com.entiities.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreManager {
    private TheatreManager(){}

    private static final TheatreManager instance = new TheatreManager();
    public static TheatreManager getInstance(){
        return instance;
    }

    private Map<String, Theatre> theatreMap = new HashMap();
    private static int count = 0;
    public void addTheatre(String loc, String name){
        String id = Integer.toString(count++);
        theatreMap.put(id, new Theatre(id, loc, name, 10));
    }

    public Theatre getTheatre(String id){
        return theatreMap.get(id);
    }

    public List<String> getShowsByLocation(String location){
        List<String> shows = new ArrayList();
        theatreMap.forEach((k, v) -> {
            if(v.getLocation().equals(location)){
                v.getHallMap().forEach((a, b) -> {
                    b.getSlotShowMap().forEach((c, d) -> {
                        shows.add(d);
                    });
                });
            }
        });
        return shows;
    }

    public List<Theatre> getTheatreByShowsAtMyLocation(String location, String showName) {
        List<Theatre> theatres = new ArrayList();
        theatreMap.forEach((k, v) -> {
            if(v.getLocation().equals(location)){
                v.getHallMap().forEach((a, b) -> {
                    b.getSlotShowMap().forEach((c, d) -> {
                        if(d.equals(showName)) theatres.add(v);
                    });
                });
            }
        });
        return theatres;
    }


}
