package com.example.demo.earthquake;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EarthquakeResponse {

  private Integer totalRecords;
  private List<Earthquake> earthQuakes;

  public static EarthquakeResponse earthQuakeResponseFromEarthQuakes(
      final List<Earthquake> earthQuakes) {
    return new EarthquakeResponse(earthQuakes.size(), earthQuakes);
  }
}
