package co.kr.circus.sauceweb.utils;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class Utils {

    public static ResponseEntity<String> responseentity(String data){
        return new ResponseEntity<String>(data, getHttpheader(), HttpStatus.OK);
    }

    public static HttpHeaders getHttpheader(){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");

        return responseHeaders;

    }
}
