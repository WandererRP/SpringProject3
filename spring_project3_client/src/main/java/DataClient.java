
import dto.MeasurementDTO;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roland Pilpani 15.09.2022
 */
public class DataClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        MeasurementDTO[] measurementDTOS = restTemplate.getForObject("http://localhost:8080/measurements", MeasurementDTO[].class);
        if(measurementDTOS!=null) {
            List<MeasurementDTO> langList = new ArrayList<MeasurementDTO>(Arrays.asList(measurementDTOS));
            langList.forEach(measurementDTO -> System.out.println(measurementDTO));
        }


        Integer rainyDaysCount = restTemplate.getForObject("http://localhost:8080/measurements/rainyDaysCount", Integer.class);
        System.out.println("Количество дождливых дней: " + rainyDaysCount);

       /* JSONResponse jsonResponse = restTemplate.getForObject(url, JSONResponse.class);

        if (jsonResponse != null && !jsonResponse.getMeasurements().isEmpty()) {
            for (MeasurementDTO measurementDTO : jsonResponse.getMeasurements()) {
                System.out.println(measurementDTO.toString());
            }
        }*/

    }
}
