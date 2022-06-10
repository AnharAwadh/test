package com.example.hospitalappointmentbookingsystem.serivce;

import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.repostory.CommentRepository;
import com.example.hospitalappointmentbookingsystem.repostory.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final CommentRepository commentRepository;

    public Doctor getDoctorById(Integer id){
        return doctorRepository.findById(id).orElseThrow(()-> new InvalidIdException("ID invild"));
    }
    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }


    public Doctor updateDoctor( Doctor doctor,Integer id){
        Doctor doctor1=getDoctorById(id);

      doctor1.setFirstName(doctor.getFirstName());
       doctor1.setLastName(doctor.getLastName());
      // doctor1.setPassword(doctor.getPassword());
       doctor1.setGender(doctor.getGender());
    //   doctor1.setEmail(doctor.getEmail());
        doctor1.setPhoneNumber(doctor.getPhoneNumber());

        return doctorRepository.save(doctor1);

    }


}
