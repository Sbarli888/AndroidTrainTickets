package feup.cm.traintickets.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;

/**
 * Created by pedro on 26/03/17.
 */

public class StepModel {

    private int id;
    private int stepNumber;
    private int distance;
    private double price;
    private int waitingTime;
    private int duration;
    private Time departureTime;
    private Time arrivalTime;
    private StationModel departureStation;
    private StationModel arrivalStation;

    public StepModel(int id, int stepNumber, int distance, double price, int waitingTime, int duration,
                     Time departureTime, Time arrivalTime, StationModel departureStation,
                     StationModel arrivalStation) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.distance = distance;
        this.price = price;
        this.waitingTime = waitingTime;
        this.duration = duration;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
    }

    public int getId() {
        return id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public int getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getDuration() {
        return duration;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public StationModel getDepartureStation() {
        return departureStation;
    }

    public StationModel getArrivalStation() {
        return arrivalStation;
    }
}