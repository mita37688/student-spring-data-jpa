package com.se.crudspringjpa;

import com.se.crudspringjpa.entity.Student;
import com.se.crudspringjpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class CrudSpringJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test //Repo Create-Save
    public void saveEmployee(){
        Student student = Student.builder()
                .firstName("Trần")
                .lastName("Tân")
                .email("tanlun04112000@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test //Repo Read
    public void findAllEmployees(){
        List<Student> students = (List<Student>) studentRepository.findAll();
        System.out.println(students);
    }

    @Test //Repo Update
    public void updateByIdRepo(){
        Student student = studentRepository.findById(Long.valueOf(1)).get();
        student.setEmail("nguyenthao2004@gmail.com");
        student.setFirstName("Nguyễn");
        student.setLastName("Thảo");
        studentRepository.save(student);
    }


    @Test //Repo Delete
    public void delete(){
        studentRepository.deleteById(Long.valueOf(2));
        System.out.println("Delete Successfully");
    }

    @Test //JPQL Read
    public void findByEmployeeId(){
        System.out.println(studentRepository.findByStudentId(Long.valueOf(1)));
    }

    @Test //JPQL Update
    public void updateByIdJPQL(){
        studentRepository.updateById(Long.valueOf(2), "Nguyễn");
    }

    @Test //JPQL Delete
    public void deleteById(){
        studentRepository.deleteEmployeeById(Long.valueOf(3));
        System.out.println("OKEEEEE");
    }

    @Test //Native Read
    public void findEmployeeByEmail(){
        System.out.println(studentRepository.findStudentByEmail("tanlun"));
    }

    @Test //Native Update
    public void updateEmployeeLastName(){
        studentRepository.updateStudentLastName(Long.valueOf(1), "Tăn");
    }

    @Test //Native Delete
    public  void deleteEmployee(){
        studentRepository.deleteStudent(Long.valueOf(4));
    }

}
