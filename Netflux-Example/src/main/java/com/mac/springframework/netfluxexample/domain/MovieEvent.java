package com.mac.springframework.netfluxexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {
    private String movieId;
    private Date date;
}
