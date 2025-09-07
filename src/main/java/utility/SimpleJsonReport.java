package utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class SimpleJsonReport {
	
	



	    public static void write(String testName, String status) {
	        try {
	            Map<String, Object> data = new LinkedHashMap<>();
	            data.put("testName", testName);
	            data.put("status", status);
	            data.put("timestamp", System.currentTimeMillis());

	            ObjectMapper mapper = new ObjectMapper();
	            mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(new File("test-result.json"), data);

	            System.out.println("JSON report created: test-result.json");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



