package com.example.hospitalappointmentbookingsystem.serivce;

import com.example.hospitalappointmentbookingsystem.model.Appointment;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.repostory.AppointmentRepository;
import com.example.hospitalappointmentbookingsystem.repostory.DoctorRepository;
import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private  final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    public List<Appointment> getAppointmentByyPatientId(Integer patientId){
        return appointmentRepository.findAppointmentsByPatientId(patientId);
    }

    public List<Appointment> getAppointmentByyDoctorId(Integer doctorId){
        return appointmentRepository.findAppointmentsByDoctorId(doctorId);
    }
    public void deleteAppointmentByPatientId(Integer id){

        appointmentRepository.deleteAppointmentByPatientId(id);
    }
    public void addAppointmentToPatient(Integer userid,Integer doctorId,Appointment appointment){
        Patient newPat=patientRepository.findById(userid).orElseThrow(()->new RuntimeException(" not id"));
       Doctor newDoctor=doctorRepository.findById(doctorId).orElseThrow(()->new RuntimeException(" not id"));

        appointment.setDoctor(newDoctor);
        appointment.setPatient(newPat);
        appointmentRepository.save(appointment);
    }

}
