package com.example.demo.earthquake.clientmodels;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {

    private String generated;
    private String url;
    private String title;
    private String status;
    private String api;
    private String count;
}
