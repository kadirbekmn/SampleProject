package com.example.demo.earthquake;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Earthquake {
    private String country;
    private String place;
    private String magnitude;
    private String date;
}
