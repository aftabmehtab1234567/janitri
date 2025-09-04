//package Utlities;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//public class Readconfig {
//    Properties prop;
//
//    public Readconfig() {
//        try {
//            prop = new Properties();
//            InputStream input = getClass().getClassLoader().getResourceAsStream("./Configration/config.properties");
//
//            if (input == null) {
//                throw new RuntimeException("config.properties file not found in classpath");
//            }
//            prop.load(input);
//        } catch (Exception e) {
//            System.out.println("Error loading config.properties: " + e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
//
//    public String URL() {
//        return prop.getProperty("Url");
//    }
//
//    public String Userid() {
//        return prop.getProperty("Userid");
//    }
//
//    public String Password() {
//        return prop.getProperty("Password");
//    }
//
//    public String Button() {
//        return prop.getProperty("Button");
//    }
//
//    public String Eyetoggle() {
//        return prop.getProperty("Eyetoggle");
//    }
//}
