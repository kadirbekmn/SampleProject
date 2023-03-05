package com.example.demo.earthquake.clientmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    private String type;
    private Property properties;
    private Geometry geometry;
    private String id;
}
