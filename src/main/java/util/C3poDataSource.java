package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3poDataSource {

    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            InputStream input = C3poDataSource.class.getClassLoader().getResourceAsStream("dbConfig.properties");

            Properties prop = new Properties();
            prop.load(input);

            cpds.setDriverClass(prop.getProperty("db.DriverClass"));
            cpds.setJdbcUrl(prop.getProperty("db.JdbcUrl"));
            cpds.setUser(prop.getProperty("db.User"));
            cpds.setPassword(prop.getProperty("db.Password"));

        } catch (FileNotFoundException e) {
            System.err.println("Unable to find file dbConfig.properties");
            e.printStackTrace();
        } catch(IOException e) {
            System.err.println("Error occurred when reading from the input stream in file dbConfig.properties");
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            System.err.println("C3PO error with connection to DB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private C3poDataSource(){}
}
