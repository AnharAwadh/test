package com.example.hospitalappointmentbookingsystem.serivce;

import com.example.hospitalappointmentbookingsystem.model.Comment;
import com.example.hospitalappointmentbookingsystem.model.Doctor;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.repostory.CommentRepository;
import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public void addCommentByPatient(Integer patientId, Integer doctorId, Comment comment){
        Patient newPatient=patientService.getPatientById(patientId);
        Doctor newDoctor=doctorService.getDoctorById(doctorId);
        comment.setPatient(newPatient);
        comment.setDoctor(newDoctor);
//        if(newPatient.getComments() == null) {
//           newPatient.setComments(new HashSet<>());
//        }
//       newPatient.getComments().add(comment);
        commentRepository.save(comment);

    }

    public List<Comment> getAllCommentByDoctorId(Integer doctorId){

       return commentRepository.findAllByDoctorId(doctorId);
    }



}
