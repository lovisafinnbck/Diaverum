import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        Connection connection = main.createDbConnection();
        String line;
        String fileName = "Software Developer Test - Appendix Q12.txt";
        int lineNumber = 1;

        // read file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null){
                if (lineNumber > 4){
                    main.separator(connection, line);
                }
                lineNumber++;
            }

            // call method to print the data from db
            main.printFromDb(connection);

            bufferedReader.close();
            connection.close();

        } catch (FileNotFoundException e){
            System.err.println("File: " + fileName + " - not found");
        } catch (IOException e){
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        } catch (SQLException e){
            System.err.println("Could not close db connection");
            e.printStackTrace();
        }



    }

    // method, separate the line to 16 parts
    public void separator(Connection connection, String line){
        Patient patient = null;

        String[] dataParts = line.split("[|]", 16);
        for (int i = 0; i < dataParts.length; i++){
            patient = new Patient(dataParts[0], dataParts[1], dataParts[2], dataParts[3], dataParts[4], dataParts[5], dataParts[6], dataParts[7], dataParts[8], dataParts[9], dataParts[10], dataParts[11], dataParts[12], dataParts[13], dataParts[14], dataParts[15]);

        }
        insertIntoDatabase(connection, patient);
    }

    // method for creating connection to db
    public Connection createDbConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diaverum", "root", "root");
            return connection;
        } catch (SQLException e){
            System.err.println("Connection to database failed");
            e.printStackTrace();
            return null;
        }
    }

    // method for inserting data into database
    public void insertIntoDatabase(Connection connection, Patient patient){
        try {
            Statement query = connection.createStatement();

            // insert query
            query.executeUpdate("INSERT INTO patientinfo (clinicno, barcode, patientid, patientname, dob, gender, collectiondate, collectiontime, testcode, testname, result, unit, refrangelow, refrangehigh, note, nonspecrefs)" +
                    "VALUES ('"+patient.getClinicNo()+"', '"+patient.getBarcode()+"', '"+patient.getPatientId()+"', '"+patient.getPatientName()+"', '"+patient.getDob()+"', '"+patient.getGender()+"', '"+patient.getCollectionDate()+"', '"+patient.getCollectionTime()+"', '"+patient.getTestCode()+"', '"+patient.getTestName()+"', '"+patient.getResult()+"', '"+patient.getUnit()+"', '"+patient.getRefRangeLow()+"', '"+patient.getRefRangeHigh()+"', '"+patient.getNote()+"', '"+patient.getNonSpecRefs()+"')");

        } catch (SQLException e){
            System.err.println("Insert into query failed");
        }
    }

    // method, read from db and print the data to console
    public void printFromDb(Connection connection){
        try {
            Statement query = connection.createStatement();

            ResultSet resultSet = query.executeQuery("SELECT * FROM patientinfo");

            // save all column values from db to attributes
            while (resultSet.next()){
                String clinicNo = resultSet.getString("clinicno");
                String barcode = resultSet.getString("barcode");
                String patientId = resultSet.getString("patientid");
                String patientName = resultSet.getString("patientname");
                String dob = resultSet.getString("dob");
                String gender = resultSet.getString("gender");
                String collectionDate = resultSet.getString("collectiondate");
                String collectionTime = resultSet.getString("collectiontime");
                String testCode = resultSet.getString("testcode");
                String testName = resultSet.getString("testname");
                String result = resultSet.getString("result");
                String unit = resultSet.getString("unit");
                String refRangeLow = resultSet.getString("refrangelow");
                String refRangeHigh = resultSet.getString("refrangehigh");
                String note = resultSet.getString("note");
                String nonSpecRefs = resultSet.getString("nonspecrefs");

                // print data to console
                System.out.println(clinicNo + ", " + barcode + ", " + patientId + ", " + patientName + ", " + dob +
                        ", " + gender + ", " + collectionDate + ", " + collectionTime + ", " + testCode + ", " +
                        testName + ", " + result + ", " + unit + ", " + refRangeLow + ", " + refRangeHigh + ", " +
                        note + ", " + nonSpecRefs);
            }

        } catch (SQLException e){
            System.err.println("Select query failed");
            e.printStackTrace();
        }
    }
}
