package com.ps.mongodbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document("apidetails")
@Getter
@Setter
public class ApiDetails {

    @Id
    private String name;

    private Object details;
}
