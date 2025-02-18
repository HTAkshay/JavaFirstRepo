package HTWebsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {

	private String dbUrl;
    private String dbUser;
    private String dbPass;

    public DatabaseHelper(String host, String port, String dbName, String user, String pass) {
        this.dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        this.dbUser = user;
        this.dbPass = pass;
    }

    public String getOTP(String mobileNumber) {
        String otp = null;
        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT otp_code FROM user_otp WHERE mobile_no='" + mobileNumber + "'");

            if (rs.next()) {
                otp = rs.getString("otp_code");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }
	
	
}
