package com.example.demo.earthquake.clientmodels;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EarthquakeResponseBody {

    private String type;
    private Metadata metadata;
    private List<Feature> features;
    private String[] bbox;
}
