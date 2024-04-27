package com.example.LiabraryManagementSystem.Services;

import com.example.LiabraryManagementSystem.Entities.Student;
import com.example.LiabraryManagementSystem.Repository.StudentRepository;
import com.example.LiabraryManagementSystem.RequestDtos.ModifyPhoneNoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return "the student has been saved to Db with studentId "+ savedStudent.getStudentId();
    }

    public Student FindStudentById(Integer studentId) throws Exception{
        Optional<Student> optionalStudent=studentRepository.findById(studentId);

        //validation if the studentId entered is correct or not
        if(optionalStudent.isEmpty()){
            throw  new Exception(" student id entered is incorrect");
        }
        Student student = optionalStudent.get();
        return student;
    }

    public String modifyPhoneNo(ModifyPhoneNoRequest modifyPhoneNoRequest){
        Integer studentId = modifyPhoneNoRequest.getStudentId();
        String phoneNo = modifyPhoneNoRequest.getPhoneNo();

        Student student = studentRepository.findById(studentId).get();

         student.setPhoneNo(phoneNo);
         studentRepository.save(student);

         return "phone no has been modified";
    }
}
