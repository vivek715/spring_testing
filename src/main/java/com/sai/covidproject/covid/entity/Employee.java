package com.sai.covidproject.covid.entity;

import javax.persistence.*;

    import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "tbl_empdetails")
    public class Employee {

        private long id;
        private String firstName;
        private String lastName;
        @Column(name = "classname")
        public int getClassname() {
            return classname;
        }

        public void setClassname(int classname) {
            this.classname = classname;
        }

        private int classname;

        public Employee() {

        }

        public Employee(String firstName, String lastName, int classname) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.classname=classname;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "first_name")
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Column(name = "last_name")
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + classname
                    + "]";
        }

    }

