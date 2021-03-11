package com.by;

import com.by.model.CanvasInstance;
import com.by.utils.RrHttpHeaderUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class PlatScpoRedriverMigrationUtilityApplication {

    public static void main(String[] args) {

        System.out.println("Hello");
        String baseUrl = "http://localhost:7001/jda";
        String allDashboardUrls = baseUrl + "/restapi/platform/api/v2/canvases/names";
        String token = args[0];
        HttpHeaders httpHeaders = RrHttpHeaderUtils.getHttpHeaders(token);
        HttpEntity entity = new HttpEntity(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CanvasInstance[]> responseEntity = restTemplate.exchange(allDashboardUrls, HttpMethod.GET, entity, CanvasInstance[].class);
            CanvasInstance[] instances = responseEntity.getBody();
            for (CanvasInstance instance : instances) {
                System.out.println(instance.getInstanceName());
            }
        } catch (HttpClientErrorException errorException) {
            errorException.getStackTrace();
        }
    }

}
