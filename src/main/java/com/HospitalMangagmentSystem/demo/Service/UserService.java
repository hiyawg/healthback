package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.Treatmentdto;
import com.HospitalMangagmentSystem.demo.Dto.UserDto;
import com.HospitalMangagmentSystem.demo.domain.Treatments;
import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.message.request.SignUpForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getalluser();

    User getoneuser(int id);

     List<User> getbyrole();

     User updateauser(int id, SignUpForm user);

     void delteuser(int id);



}
