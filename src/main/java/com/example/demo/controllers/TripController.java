package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Trip;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.services.ITripService;


@Controller
public class TripController {

    @GetMapping("/trips/create")
    public String crear() {
        return "trips/formTrip";
    }

    @PostMapping("/trips/save")
    public String guardar(Trip trip, BindingResult result) {

        if(result.hasErrors()) {
            return "trips/formTrip";
        }

        serviceTrips.guardar(trip);

        return "redirect:/trips/list";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        webDataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, false));
    }
    
    @Autowired
    private ITripService serviceTrips;
    
    
    @GetMapping("/trips/detalle")
    public String verDetalle(org.springframework.ui.Model model) {

        Trip trip = new Trip();
        trip.setNombre("Viaje Playa");
        trip.setDestino("La Libertad");
        trip.setFecha(new Date());

        model.addAttribute("trip", trip);

        return "trips/detalle";
    }
    
    @GetMapping("/trips/list")
    public String listarTrips(org.springframework.ui.Model model) {

        model.addAttribute("trips", serviceTrips.obtenerTodos());

        return "trips/listTrips";
    }

}