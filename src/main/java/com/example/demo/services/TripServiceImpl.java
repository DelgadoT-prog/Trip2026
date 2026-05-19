package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Trip;

@Service
public class TripServiceImpl implements ITripService {

    private List<Trip> listaTrips = new ArrayList<>();

    @Override
    public void guardar(Trip trip) {

        listaTrips.add(trip);

        System.out.println("Trip guardado: " + trip);
    }

    @Override
    public List<Trip> obtenerTodos() {

        return listaTrips;
    }

}