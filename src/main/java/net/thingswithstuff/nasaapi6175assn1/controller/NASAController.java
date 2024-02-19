package net.thingswithstuff.nasaapi6175assn1.controller;

import net.thingswithstuff.nasaapi6175assn1.domain.ApodResponse;
import net.thingswithstuff.nasaapi6175assn1.service.apod.ApodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NASAController {

    @Autowired
    private ApodService apodService;

    @GetMapping("/NASA_APOD")
    public List<ApodResponse> NASA_APOD(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String start_date,
            @RequestParam(required = false) String end_date,
            @RequestParam(required = false) String count,
            @RequestParam(required = false) String thumbs,
            @RequestParam(required = false) String api_key
            ) {
        return apodService.getApod(date, start_date, end_date, count, thumbs, api_key);
    }
}
