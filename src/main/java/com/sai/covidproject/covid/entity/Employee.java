package com.sai.covidproject.covid.entity;


import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;


//CREATE TABLE `emp` (
//  `empId` int(11) NOT NULL,
//  `empName` varchar(20) DEFAULT NULL,
//  `EmpDoj` date DEFAULT NULL,
//  `EmpSal` float DEFAULT NULL,
//  `EmpDeptId` int(11) DEFAULT NULL,
//  PRIMARY KEY (`empId`)
//)
    @XmlRootElement(name = "Employee")
    @XmlType(propOrder = {"empId","empname","empdoj","empdeptid","empsal"})
    @Data
    @Entity
    @Table(name = "emp")
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column (name="empid")
        private Integer empId;

        @Column(name="empname")
        private String empName;

        @Column(name="empdoj")
        private Date EmpDoj;

        @Column(name="empdeptid")
        private Integer empDeptId;

        @Column(name="empsal")
        private Float EmpSal;

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", empName='" + empName + '\'' +
                    ", EmpDoj=" + EmpDoj +
                    ", empDeptId=" + empDeptId +
                    ", EmpSal=" + EmpSal +
                    '}';
        }
    }

