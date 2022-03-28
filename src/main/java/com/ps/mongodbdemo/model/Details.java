package com.ps.mongodbdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Details {

    @JsonProperty("apicode")
    public String apicode;
    @JsonProperty("message")
    public String message;
    @JsonProperty("scoreband")
    public String scoreband;

}
