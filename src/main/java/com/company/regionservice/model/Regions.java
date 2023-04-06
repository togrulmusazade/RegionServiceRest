package com.company.regionservice.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
public class Regions {

    @Id
    private String id;

    private Date create_date = new Date();

    private String name;


    @jakarta.persistence.Id
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



}



