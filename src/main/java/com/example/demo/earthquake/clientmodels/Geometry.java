package com.example.demo.earthquake.clientmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Geometry {

    private String type;

    private String[] coordinates;
}
