package backendpoc.service.impl;


import backendpoc.service.JsonService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class JsonServiceImp implements JsonService {

    public Object getJson(String key, String skey) {
        ///Users/sharad/Project/BackendPOC/src/main/resources/portalFieldConfig/Customer/portal_details.json
        String path = "/Users/sharad/Project/BackendPOC/src/main/resources/portalFieldConfig";
        //portalfield_customer_portal_details
        String[] arr = key.split("[_]");
        String fileName = path + "/" + arr[1] + "/" + arr[2] + "_" + arr[3] + ".json";
        System.out.println(fileName);

        Map<String, Object> config = readFile(fileName);
        Map<String, Object> fields = new HashMap<>();
        String keyName = arr[1] + "_" + arr[2] + "_" + arr[3];
        fields.put(skey, config.get(skey));

        return fields;
    }

    private Map<String, Object> readFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            String theString = IOUtils.toString(fileInputStream, "UTF-8");
            jsonMap = mapper.readValue(theString, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            System.out.println("File Exception");
        }
        return jsonMap;
    }
}
