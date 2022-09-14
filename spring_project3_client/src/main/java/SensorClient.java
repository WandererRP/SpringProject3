import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Roland Pilpani 15.09.2022
 */
public class SensorClient {
    private static final String url1 = "http://localhost:8080/sensors/registration";
    private static final String url2 = "http://localhost:8080/measurements/add";


    public static void main(String[] args) {
        String sensorName = "Sensor1";
        register(sensorName);


        Random random = new Random();

        double minTemperature = -50.0;
        double maxTemperature = 50.0;

        for (int i = 0; i < 500; i++) {
            System.out.println(i);
            sendMeasurement(minTemperature + random.nextDouble() * (maxTemperature - minTemperature),
                    random.nextBoolean(), sensorName);
        }


    }

    private static void register(String sensorName) {
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("name", sensorName);
        makePostRequest(url1, jsonData);
    }


    private static void sendMeasurement(double value, boolean raining, String sensorName) {

        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("value", value);
        jsonData.put("raining", raining);
        jsonData.put("sensor", Map.of("name", sensorName));
        makePostRequest(url2, jsonData);
    }

    private static void makePostRequest(String url, Map<String, Object> jsonData) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("Измерение отправлено");
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
        }
    }
}

