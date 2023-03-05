package com.example.demo.earthquake;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EarthquakeApi {
  private final EarthquakeService earthQuakeService;

  @GetMapping("/earth-quakes")
  public EarthquakeResponse getEarthQuakes(
      @RequestParam final String country, @RequestParam final Integer countOfDays) {
    return EarthquakeResponse.earthQuakeResponseFromEarthQuakes(
        earthQuakeService.getEarthQuakes(country, countOfDays));
  }
}
