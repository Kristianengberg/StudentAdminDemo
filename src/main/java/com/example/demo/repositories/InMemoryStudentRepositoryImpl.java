package com.example.demo.repositories;

import com.example.demo.models.Student;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class InMemoryStudentRepositoryImpl implements IStudentRepository{
    private List<Student> inMemoryDatabase;

    public InMemoryStudentRepositoryImpl(){
        this.inMemoryDatabase = new ArrayList<Student>(
                Arrays.asList(

                )
        );
    }
/*
    @Override
    public boolean create(Student student) {
        System.out.println(student.toString());
        inMemoryDatabase.add(student);



        return false;
    }

 */

    @Override
    public boolean create(Student student) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = sdf.format(student.getEnrollmentDate());
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date startDate = formatter.parse(dateStr);
            student.setEnrollmentDate(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        inMemoryDatabase.add(student);
        return false;
    }

    @Override
    public Student read(int id) {
        for(Student stu : inMemoryDatabase){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @Override
    public List<Student> readAll() {
        return inMemoryDatabase;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        System.out.println(id);
        for (Student student : inMemoryDatabase){
            if(student.id == id){
                System.out.println(id);
                inMemoryDatabase.remove(student);
                return true;
            }


        }
        return false;
    }
}
