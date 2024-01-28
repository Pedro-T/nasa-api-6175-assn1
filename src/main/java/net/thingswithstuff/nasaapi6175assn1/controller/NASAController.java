package net.thingswithstuff.nasaapi6175assn1.controller;

import net.thingswithstuff.nasaapi6175assn1.APOD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class NASAController {
    private static final String requestURL = "https://api.nasa.gov/planetary/apod";

    @GetMapping("/NASA_APOD")
    public ResponseEntity<List<APOD>> NASA_APOD(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String start_date,
            @RequestParam(required = false) String end_date,
            @RequestParam(required = false) String count,
            @RequestParam(required = false) String thumbs,
            @RequestParam(required = false) String api_key
            ) {
        final RestTemplate template = new RestTemplate();
        final String url = String.format("%s%s%s%s%s%s%s",
                requestURL,
                api_key != null ? String.format("?api_key=%s", api_key) : "",
                date != null ? String.format("&date=%s", date) : "",
                start_date != null ? String.format("&start_date=%s", start_date) : "",
                end_date != null ? String.format("&end_date=%s", end_date) : "",
                count != null ? String.format("&count=%s", count) : "",
                thumbs != null ? String.format("&thumbs=%s", thumbs) : "");

        if (start_date == null && end_date == null && count == null) {
            // apod api returns an array if any of these values are provided, since they cause multiple results
            // if that's the case, handle the response a little differently
            return ResponseEntity.ok(Collections.singletonList(template.getForObject(url, APOD.class)));
        }
        return ResponseEntity.ok(Arrays.asList(template.getForObject(url, APOD[].class)));
    }
}