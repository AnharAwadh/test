package com.example.hospitalappointmentbookingsystem.controller;

import com.example.hospitalappointmentbookingsystem.DTO.Api;
import com.example.hospitalappointmentbookingsystem.model.Admin;
import com.example.hospitalappointmentbookingsystem.serivce.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;



    @GetMapping("/damin")
    public ResponseEntity<List<Admin>>getAdmin(){

        return ResponseEntity.status(200).body(adminService.getAdmin());
    }
    @PostMapping("/addregister")
    public ResponseEntity<Api> addAdmin(@RequestBody @Valid Admin admin){

       adminService.addAdmin(admin);
        return ResponseEntity.status(201).body(new Api("admin  added",201));

}
    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id){

        return ResponseEntity.status(200).body(adminService.updateAdmin(id));
    }
    @DeleteMapping("/admin/delpatient/{id}")
    public ResponseEntity deletePatientByAdmin(@PathVariable Integer id){

        adminService.deletePatientByAdmin(id);
        return ResponseEntity.status(200).body("The Patient deleted");

    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity deleteDoctorByAdmin(@PathVariable Integer id){

        adminService.deleteDoctorByAdmin(id);
        return ResponseEntity.status(200).body("The Doctor deleted");

    }


    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteCommentByAdmin(@PathVariable Integer id){

      adminService.deleteCommentByAdmin(id);
        return ResponseEntity.status(200).body("The comment deleted");

    }



}
