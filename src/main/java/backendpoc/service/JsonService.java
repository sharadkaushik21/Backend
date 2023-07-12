package backendpoc.service;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface JsonService {

    Object getJson( String key, String skey) throws FileNotFoundException, ParseException;

}
