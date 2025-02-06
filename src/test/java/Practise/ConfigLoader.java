package Practise;

public class ConfigLoader {
	
	private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) 
        {
            properties.load(fis);
        } catch (IOException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    public static String get(String key)
    {
        return properties.getProperty(key);
    }

}
