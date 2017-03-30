package com.example.tickets;

import com.example.Main;
import com.example.dataHolder.SeatHolder;
import com.example.dataHolder.TripHolder;
import com.example.exceptions.IllegalArgumentExceptionMapper;
import com.example.exceptions.SQLExceptionMapper;
import com.example.mysql.MySQLManager;
import com.example.dataHolder.StationHolder;
import com.example.seats.SeatModel;
import com.example.station.StationModel;
import com.example.steps.StepModel;
import com.example.trips.TripModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Pedro on 12/03/17.
 */
public class TicketManager {

    PreparedStatement ps;
    ResultSet rs;

    /**
     * Get the available tickets given a date, departure station, arrival station, and the trip
     * @param dateToCheck
     * @param depStation
     * @param arrStation
     * @param trip
     * @return
     */
    public AvailableTicketModel getAvailableTickets(Date dateToCheck, int depStation, int arrStation, int trip){
        if (dateToCheck == null | depStation <= 0 || arrStation <= 0 || trip <= 0) {
            throw new IllegalArgumentExceptionMapper("Error in arguments number, type or value. Perhaps some argument is wrong.");
        }

        try {
            AvailableTicketModel availableTickets = null;
            ps = MySQLManager.getConnection().prepareStatement("Call availableTickets(?,?,?,?)");
            ps.setDate(1, dateToCheck);
            ps.setInt(2, depStation);
            ps.setInt(3, arrStation);
            ps.setInt(4, trip);

            rs = ps.executeQuery();
            if (rs.next()) {
                int sold = rs.getInt("sold");
                int maxCapacity = rs.getInt("maxCapacity");
                availableTickets = new AvailableTicketModel(sold, maxCapacity);
            }
            return availableTickets;
        } catch (SQLException sql) {
            Main.getLogger().severe(sql.getMessage());
            throw new SQLExceptionMapper(sql.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
    }

    /**
     * This generates a ticket, not yet validated nor saved on the database, just to demonstrate
     * the parameters to the client.
     * @param tripId the id of the trip choosen
     * @param startStationId the id of the starting station
     * @param arrStationId the id of the arrival station
     * @return TicketModel the ticket, with id 0, no uniqueId, no ticketDate nor purchaseDate and also no isUsed flag
     */
    public TicketModel generateTicketPrice(int tripId, int startStationId, int arrStationId) {
        try {
            TicketModel ticket = null;
            ps = MySQLManager.getConnection().prepareStatement("Call getFair(?,?,?)");
            ps.setInt(1, tripId);
            ps.setInt(2, startStationId);
            ps.setInt(3, arrStationId);

            rs = ps.executeQuery();
            if (rs.next()) {
                int fkTripId = rs.getInt("fkTrip");
                int depStationId = rs.getInt("departureStationId");
                int arrivalStationId = rs.getInt("arrivalStationId");
                //int distance = rs.getInt("distance");
                int duration = rs.getInt("duration");
                Time depTime = rs.getTime("departureTime");
                Time arrTime = rs.getTime("arrivalTime");
                float price = rs.getFloat("price");

                TripModel trip = TripHolder.getTrips().get(fkTripId);
                List<StepModel> steps =  trip.getSteps().stream()
                        .filter(s -> s.getDepartureStation().getId() >= depStationId
                                && s.getArrivalStation().getId() <= arrivalStationId)
                        .collect(Collectors.toList());
                trip.setSteps(steps);


                ticket = new TicketModel(0, null, StationHolder.getStations().get(depStationId),
                        StationHolder.getStations().get(arrivalStationId), null, price, null,
                        trip, false, duration, depTime, arrTime);

            }
            return ticket;
        } catch (SQLException sql) {
            Main.getLogger().severe(sql.getMessage());
            throw new SQLExceptionMapper(sql.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
    }

    /**
     * This method returns all the tickets available for the given date and the trip id
     * @param date the date
     * @param tripId the id of the trip
     * @return List<TicketModel> the list of the tickets, with only the parameters to verify its authenticity
     */
    public List<TicketModel> getAllTicket(Date date, int tripId) {
        try {
            List<TicketModel> tickets = new ArrayList<>();
            ps = MySQLManager.getConnection().prepareStatement("Call getTicketsControl(?,?)");
            ps.setDate(1, date);
            ps.setInt(2, tripId);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String uId = rs.getString("uniqueId");
                Date ticketDate = rs.getDate("ticketDate");
                int departureStationId = rs.getInt("departureStationId");
                int arrivalStationId = rs.getInt("arrivalStationId");

                tickets.add(new TicketModel(id, UUID.fromString(uId), ticketDate,
                        StationHolder.getStations().get(departureStationId),
                        StationHolder.getStations().get(arrivalStationId)));
            }
            return tickets;
        } catch (SQLException sql) {
            Main.getLogger().severe(sql.getMessage());
            throw new SQLExceptionMapper(sql.getMessage());
        } catch (IllegalArgumentException arg) {
            Main.getLogger().severe(arg.getMessage());
            throw new IllegalArgumentExceptionMapper(arg.getMessage());
        }
    }

    /**
     * This method returns all the active tickets available for the given user id
     * @param userId the id of the user
     * @return List<TicketModel> the list of the active tickets
     */
    public List<TicketModel> getUserTickets(int userId) {
        try {
            List<TicketModel> tickets = new ArrayList<>();
            ps = MySQLManager.getConnection().prepareStatement("Call getUserTickets(?)");
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                String uuid = rs.getString("uniqueId");
                int id = rs.getInt("id");
                Time departureTime = rs.getTime("departureTime");
                Time arrivalTime = rs.getTime("arrivalTime");
                String departureStation = rs.getString("fromStation");
                String arrivalStation = rs.getString("toStation");
                int seatNumber = rs.getInt("seatNumber");
                String direction = rs.getString("direction");
                int tripId = rs.getInt("idTrip");

                StationModel depStation = StationHolder.getStations().values().stream()
                        .filter(s -> s.getStationName().equals(departureStation)).findFirst().get();
                StationModel arrStation = StationHolder.getStations().values().stream()
                        .filter(s -> s.getStationName().equals(arrivalStation)).findFirst().get();

                TripModel trip = TripHolder.getTrips().get(tripId);
                trip.setSteps(null);
                trip.setTrain(null);
                trip.setDirection(direction);

                //SeatModel seat = SeatHolder.getSeats().get(seatId);

                tickets.add(new TicketModel(id, UUID.fromString(uuid), depStation, arrStation, departureTime, arrivalTime, null, trip));
            }
            return tickets;
        } catch (SQLException sql){
            Main.getLogger().severe(sql.getMessage());
            throw new SQLExceptionMapper(sql.getMessage());
        }
    }
}
