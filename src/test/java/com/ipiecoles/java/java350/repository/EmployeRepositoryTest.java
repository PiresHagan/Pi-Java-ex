package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootTest//@DataJpaTest
class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    @BeforeEach
    @AfterEach
    public void before(){
        employeRepository.deleteAll();
    }

    @Test
    public void testFindLastMatriculeX(){
        //Given

        //When
        String lastMatricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(lastMatricule).isNull();
    }

    @Test
    public void testFindLastMatricule3Employes(){
        //Given
        Employe e1 = new Employe("Doe", "John", "T12345", LocalDate.now(), 1500d, 1, 1.0);
        Employe e2 = new Employe("Doe", "Jane", "C45678", LocalDate.now(), 2500d, 2, 0.5);
        Employe e3 = new Employe("Doe", "Peter", "M34567", LocalDate.now(), 3500d, 1, 0.5);

        employeRepository.saveAll(Arrays.asList(e1, e2, e3));

        //When
        String lastMatricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(lastMatricule).isEqualTo("45678");
    }



}