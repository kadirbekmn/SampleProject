package com.example.demo.earthquake;

import com.example.demo.earthquake.clientmodels.EarthquakeResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeServiceImpl implements EarthquakeService {
  private final RestTemplate restTemplate;

  @Override
  public List<Earthquake> getEarthQuakes(final String country, final Integer countOfDays) {
    final var endDate = LocalDate.now();
    final var startDate = LocalDate.now().minusDays(countOfDays);
    final var earthQuakeResponseBody =
        restTemplate.getForObject(
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="
                + startDate
                + "&endtime="
                + endDate,
            EarthquakeResponseBody.class);
    final var features =
        earthQuakeResponseBody.getFeatures().stream()
            .filter(
                feature ->
                    feature.getProperties().getPlace() != null
                        && feature.getProperties().getPlace().endsWith(country))
            .toList();
    if (features.size() == 0) {
      throw new RuntimeException("No Earthquakes were recorded past " + countOfDays + " days!");
    }
    return features.stream()
        .map(
            feature ->
                new Earthquake(
                    country,
                    feature.getProperties().getPlace(),
                    feature.getProperties().getMag(),
                    Instant.ofEpochMilli(Long.parseLong(feature.getProperties().getTime()))
                        .toString()))
        .toList();
  }
}
