package com.example.hospitalappointmentbookingsystem.controller;

import com.example.hospitalappointmentbookingsystem.DTO.Api;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.serivce.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;



    @GetMapping("/getdoctor/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Integer id){

        return ResponseEntity.status(200).body(doctorService.getDoctorById(id));
    }
    @PostMapping("/register")
    public ResponseEntity<Api> addDoctor(@RequestBody @Valid Doctor doctor){

       doctorService.addDoctor(doctor);
        return ResponseEntity.status(201).body(new Api("Doctor  added",201));

}
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody @Valid Doctor doctor,@PathVariable Integer id){

        return ResponseEntity.status(200).body(doctorService.updateDoctor(doctor,id));
    }
}
