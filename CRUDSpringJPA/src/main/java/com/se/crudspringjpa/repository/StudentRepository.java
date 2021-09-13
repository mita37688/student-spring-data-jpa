package com.se.crudspringjpa.repository;

import com.se.crudspringjpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = ?2 where s.studentId = ?1")
    public void updateById(Long id, String newFirstName);

    @Query("select s from Student s where s.studentId = ?1")
    public Student findByStudentId(Long id);

    @Transactional
    @Modifying
    @Query("delete from Student s where s.studentId = ?1")
    public void deleteEmployeeById(Long id);

    @Query(value = "select * from tbl_student where email = ?1", nativeQuery = true)
    public Student findStudentByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update tbl_student set last_name = ?2 where student_id = ?1", nativeQuery = true)
    public void updateStudentLastName(Long id, String newLastName);

    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where student_id = ?1", nativeQuery = true)
    public void deleteStudent(Long id);
}
