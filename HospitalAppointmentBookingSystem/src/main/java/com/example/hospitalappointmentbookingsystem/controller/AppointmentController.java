package com.example.hospitalappointmentbookingsystem.controller;

import com.example.hospitalappointmentbookingsystem.DTO.Api;
import com.example.hospitalappointmentbookingsystem.model.Appointment;
import com.example.hospitalappointmentbookingsystem.model.Comment;
import com.example.hospitalappointmentbookingsystem.serivce.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;


    @PostMapping("/addappointment/{pid}/{did}")
    public ResponseEntity<Api> addappointmen(@PathVariable Integer pid, @PathVariable Integer did, @RequestBody @Valid Appointment appointment){
        appointmentService.addAppointmentToPatient(pid,did,appointment);


        return ResponseEntity.status(201).body(new Api("Appointment  added",201));

    }

    @GetMapping("/getappointment/{pid}")
    public ResponseEntity getAppointment(@PathVariable Integer pid){



        return ResponseEntity.status(201).body(appointmentService.getAppointmentByyPatientId(pid));

    }
    @DeleteMapping("/appointment/{id}")
    public ResponseEntity deleteAppointmentByPatient(@PathVariable Integer id){

        appointmentService.deleteAppointmentByPatientId(id);
        return ResponseEntity.status(200).body("The Appointment deleted");

    }
    @GetMapping("/getappointmentbydoctor/{did}")
    public ResponseEntity getAppointmentByDoctor(@PathVariable Integer did){


        return ResponseEntity.status(201).body(appointmentService.getAppointmentByyDoctorId(did));

    }

}
