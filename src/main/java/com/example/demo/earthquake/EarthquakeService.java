package com.example.demo.earthquake;

import java.util.List;

public interface EarthquakeService {
    List<Earthquake> getEarthQuakes(String country, Integer countOfDays);
}
