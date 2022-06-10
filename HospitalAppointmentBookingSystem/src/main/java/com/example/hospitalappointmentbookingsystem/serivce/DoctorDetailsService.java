//package com.example.hospitalappointmentbookingsystem.serivce;
//
//import com.example.hospitalappointmentbookingsystem.excption.InvalidIdException;
//import com.example.hospitalappointmentbookingsystem.model.Doctor;
//import com.example.hospitalappointmentbookingsystem.repostory.CommentRepository;
//import com.example.hospitalappointmentbookingsystem.repostory.DoctorRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//
//@Service
//@RequiredArgsConstructor
//public class DoctorDetailsService implements UserDetails {
//
//    private final DoctorRepository doctorRepository;
//    private final CommentRepository commentRepository;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
