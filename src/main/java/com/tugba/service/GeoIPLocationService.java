package com.tugba.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.tugba.model.GeoIp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
@Transactional

public class GeoIPLocationService {
    private DatabaseReader dbReader;

    public GeoIPLocationService() throws IOException {
        File database = new File("GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public GeoIp getLocation(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();

        return new GeoIp(ip, cityName, latitude, longitude);
    }
}
