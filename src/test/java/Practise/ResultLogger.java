package Practise;

public class ResultLogger {
	
	
	
	

		private Map<String, Object> resultData = new HashMap<>();

	    public void log(String key, Object value) 
	    {
	        resultData.put(key, value);
	    }

	    public void saveResult(String filePath) 
	    {
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            objectMapper.writeValue(new File(filePath), resultData);
	            System.out.println("Test result saved to " + filePath);
	        } 
	        catch (IOException e) 
	        {
	            System.err.println("Error saving test result: " + e.getMessage());
	        }
	    }
		
	   
		
	}


