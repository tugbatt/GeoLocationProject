package com.tugba;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.tugba.service.GeoIPLocationService;

import java.io.IOException;
import java.util.Scanner;

public class GeoLocationApplication {

    public static void main(String... args) throws IOException, GeoIp2Exception {


        GeoIPLocationService service = new GeoIPLocationService();
        Scanner input = new Scanner(System.in);
        System.out.println("Ip Address:");
        String ipAddress = input.next();

        System.out.println("---------------------------------------");
        System.out.println("GeoLocationApplication");
        System.out.println("Our City: \n" +
                service.getLocation(ipAddress).getCity());
        System.out.println("Latitude: \n" +
                service.getLocation(ipAddress).getLongitude());
        System.out.println("Longitude: \n" +
                service.getLocation(ipAddress).getLatitude());
        System.out.println("---------------------------------------");

    }
}