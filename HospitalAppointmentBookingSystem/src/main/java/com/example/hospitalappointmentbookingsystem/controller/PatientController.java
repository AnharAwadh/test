package com.example.hospitalappointmentbookingsystem.controller;

import com.example.hospitalappointmentbookingsystem.DTO.Api;
import com.example.hospitalappointmentbookingsystem.DTO.RegisterPatientDto;
import com.example.hospitalappointmentbookingsystem.Utils;
import com.example.hospitalappointmentbookingsystem.model.Account;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
import com.example.hospitalappointmentbookingsystem.serivce.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/patien")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/getpatient")
    public ResponseEntity<Patient> getPatient(){
        Account account = Utils.getAccount(SecurityContextHolder.getContext());
        return ResponseEntity.status(200).body(patientService.getPatientByEmail(account.getEmail()));
    }



    @PostMapping("/register")
    public ResponseEntity<Api> addPatient(@RequestBody @Valid RegisterPatientDto registerPatientDto){
      patientService.addPatient(registerPatientDto.getAccount(),registerPatientDto.getPatient());
        return ResponseEntity.status(201).body(new Api("Patient added",201));


    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id,@RequestBody @Valid Patient patient){

        return ResponseEntity.status(200).body(patientService.updatePatient(patient,id));
    }
    @DeleteMapping("/delpatient/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id){

       patientService.deletePatient(id);
        return ResponseEntity.status(200).body("The Patient deleted");

    }


    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteCommentByPatient(@PathVariable Integer id){

       patientService.deleteCommentByPatient(id);
        return ResponseEntity.status(200).body("The comment deleted");

    }
    @GetMapping("getrate/{doctorid}")
    public ResponseEntity getrate(@PathVariable Integer doctorid){
       // logger.info("get rate");
        return ResponseEntity.status(200).body(patientService.getrate(doctorid));}
}
