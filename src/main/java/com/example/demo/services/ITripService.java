package com.example.demo.services;

import java.util.List;
import com.example.demo.models.Trip;

public interface ITripService {

    void guardar(Trip trip);

    List<Trip> obtenerTodos();

}