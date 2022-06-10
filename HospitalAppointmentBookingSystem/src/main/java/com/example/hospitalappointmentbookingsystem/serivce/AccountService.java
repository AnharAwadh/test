//package com.example.hospitalappointmentbookingsystem.serivce;
//
//import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
//import com.example.hospitalappointmentbookingsystem.model.*;
//import com.example.hospitalappointmentbookingsystem.repostory.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AccountService {
//
//   private final AccountRepository accountRepository;
//   private final AdminRepository adminRepository;
//   private final PatientRepository patientRepository;
//   private final DoctorRepository doctorRepository;
//
//    public void addAccount(Account account){
//        Account acc=new Account(account.getId(),account.getEmail(),account.getPassword(),account.getRole(),null,null);
//        accountRepository.save(acc);
//
//
//    }
//
//    public void addPatanit(Patient patient){
//
//      //  Patient patient1=new Patient(p)
//
//
//    }
//    public void addAdmin(Admin admin){
//
//       adminRepository.save(admin);
//    }
//
//    public Admin updateAdmin(Integer id){
//       Admin newAdmin=adminRepository.findById(id).orElseThrow(()-> new InvalidIdException("ID invild"));
//
//        //newAdmin.setPassword(newAdmin.getPassword());
//        newAdmin.setUsername(newAdmin.getUsername());
//        return adminRepository.save(newAdmin);
//
//    }
//    public void deletePatientByAdmin(Integer patientId){
//
//        Patient newPatient=patientRepository.findById(patientId).
//                orElseThrow(()->
//                        new InvalidIdException("ID invild"));
//        patientRepository.delete(newPatient);
//
//    }
//    public void deleteDoctorByAdmin(Integer doctorId){
//        Doctor newDoctor=doctorRepository.findById(doctorId).
//                orElseThrow(()->
//                        new InvalidIdException("ID invild"));
//
//                        doctorRepository.delete(newDoctor);
//
//
//    }
////
////    public void deleteCommentByAdmin(Integer commentId){
////       Comment comment=commentRepository.findById(commentId).
////                orElseThrow(()->
////                        new InvalidIdException("ID invild"));
////
////        commentRepository.delete(comment);
////
////
////    }
//
//
//}
