package HTWebsite;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JsonCreator {
	
	
	public static void saveTestResult(String testName, String status) {
        JSONObject testResult = new JSONObject();
        testResult.put("testName", testName);
        testResult.put("status", status);

        try (FileWriter file = new FileWriter("testResults.json")) {
            file.write(testResult.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
