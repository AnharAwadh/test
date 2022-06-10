package com.example.hospitalappointmentbookingsystem.serivce;

import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
import com.example.hospitalappointmentbookingsystem.model.Account;
import com.example.hospitalappointmentbookingsystem.model.Comment;
import com.example.hospitalappointmentbookingsystem.model.Patient;
import com.example.hospitalappointmentbookingsystem.repostory.CommentRepository;
import com.example.hospitalappointmentbookingsystem.repostory.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService  {

    private final PatientRepository patientRepository;
    private final CommentRepository commentRepository;
    public Patient getPatientById(Integer idPatient){
     return patientRepository.findById(idPatient).orElseThrow(()-> new InvalidIdException("ID invild"));
    }
    public void addPatient(Account account, Patient patient){
        String hashedPassword=new BCryptPasswordEncoder().encode(account.getPassword());
        patient.setAccount(account);
        account.setPassword(hashedPassword);

        patientRepository.save(patient);
    }
    public Patient updatePatient(Patient patient,Integer id){
        Patient patient1=getPatientById(id);

        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
       // patient1.setPassword(patient.getPassword());
        patient1.setGender(patient.getGender());
      //  patient1.setEmail(patient.getEmail());
        patient1.setPhoneNumber(patient.getPhoneNumber());
       return patientRepository.save(patient1);

    }
    public void deletePatient(Integer id){

        patientRepository.deleteById(id);
    }


    public void deleteCommentByPatient(Integer commentId){
        Comment comment=commentRepository.findById(commentId).
                orElseThrow(()->
                        new InvalidIdException("ID invild"));

        commentRepository.delete(comment);


    }

//    public Integer getRate(Doctor doctor) {
//        Integer rate = 0;
//        for (Comment comment : doctor.getComments()) {
//            rate += comment.getRate();
//        }
//        if (doctor.getComments().size()!=0){
//            return rate/doctor.getComments().size();}
//    return 0;}

    public double getrate(Integer doctorid){
        //  (Total nunber of star / total number of persons who review * 5 ) * 5

        Integer total=0;
        Integer counter=0;
        List<Comment> comment=commentRepository.findAllByDoctorId(doctorid);
        for(int i=0;i<comment.size()-1;i++){
            Comment currentcomment=comment.get(i);
            Integer rate=currentcomment.getRate();
            total=+rate;
            counter++;}
        double rate1=((total/(counter*5))*5);
        return rate1;}


    public Patient getPatientByEmail(String email) {
        return patientRepository.findByAccount_Email(email);
    }
}


