package com.example.dataholder;

import com.example.models.StationModel;

import java.util.HashMap;

/**
 * Created by mercurius on 29/03/17.
 */
public class StationHolder {
    public static HashMap<Integer, StationModel> stations;

    public static HashMap<Integer, StationModel> getStations() {
        return stations;
    }
    public static void setStations(HashMap<Integer, StationModel> stations) {
        StationHolder.stations = stations;
    }
}
