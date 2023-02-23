package com.tugba.controller;

import com.tugba.model.GeoIp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tugba.service.GeoIPLocationService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class GeoIPController {

    boolean result;
    private GeoIPLocationService locationService;

    public GeoIPController() throws IOException {
        locationService = new GeoIPLocationService();
    }

    @PostMapping("/GeoIPTest")
    public GeoIp getLocation(
            @RequestParam(value="ipAddress", required=true) String ipAddress
    ) throws Exception {


        GeoIPLocationService locationService
                = new GeoIPLocationService();
        return locationService.getLocation(ipAddress);
    }
}
