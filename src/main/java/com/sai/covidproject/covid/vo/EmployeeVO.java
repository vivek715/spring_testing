package com.sai.covidproject.covid.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class EmployeeVO {
    public String Lastname;
    public String Firstname;
    public Integer id;
    public LocalDateTime Doj;
    public Integer salary;
    public String fathername;
    public String mothername;
    public String address;
    public Integer strength;
}
