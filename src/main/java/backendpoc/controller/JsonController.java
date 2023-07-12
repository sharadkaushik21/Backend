package backendpoc.controller;

import backendpoc.service.JsonService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class JsonController {

    @Autowired
    JsonService jsonService;

    @GetMapping("/forum/{key}/{skey}")
    public Object readJson( @PathVariable String key, @PathVariable String skey ) throws FileNotFoundException, ParseException {


        return jsonService.getJson(key, skey);
    }


}
