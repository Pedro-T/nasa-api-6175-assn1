package net.thingswithstuff.nasaapi6175assn1.service.impl.apod;

import net.thingswithstuff.nasaapi6175assn1.domain.ApodResponse;
import net.thingswithstuff.nasaapi6175assn1.service.apod.ApodService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ApodServiceImpl implements ApodService {

    private static final String requestURL = "https://api.nasa.gov/planetary/apod";

    @Value("${apod.api.key}")
    private String defaultKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ApodResponse> getApod(String date, String start_date, String end_date, String count, String thumbs, String api_key) {

        final String url = String.format("%s%s%s%s%s%s%s",
                requestURL,
                String.format("?api_key=%s", api_key != null ? api_key : defaultKey),
                date != null ? String.format("&date=%s", date) : "",
                start_date != null ? String.format("&start_date=%s", start_date) : "",
                end_date != null ? String.format("&end_date=%s", end_date) : "",
                count != null ? String.format("&count=%s", count) : "",
                thumbs != null ? String.format("&thumbs=%s", thumbs) : "");

        if (start_date == null && end_date == null && count == null) {
            // APOD api returns an array if any of these values are provided, since they cause multiple results
            return Collections.singletonList(restTemplate.getForObject(url, ApodResponse.class));
        }
        return Arrays.asList(restTemplate.getForObject(url, ApodResponse[].class));
    }

}
