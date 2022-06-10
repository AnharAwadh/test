package com.example.hospitalappointmentbookingsystem.repostory;

import com.example.hospitalappointmentbookingsystem.model.Appointment;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment,Integer>{

    List<Appointment> findAppointmentsByPatientId(Integer patientId);
    List<Appointment> findAppointmentsByDoctorId(Integer doctorId);
    Appointment deleteAppointmentByPatientId(Integer patientId);
}
