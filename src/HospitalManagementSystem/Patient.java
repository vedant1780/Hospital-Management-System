package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private  Scanner scanner;
    public Patient(Connection connection, Scanner scanner)
    {
        this.connection=connection;
        this.scanner=scanner;
    
    }
    public void addPatient()
    {
        System.out.println("Enter Patint Name:");
        String name=scanner.next();
        System.out.println("Enter patirnt age:");
        int age=scanner.nextInt();
        System.out.println("Enter patient gender:");
        String gender=scanner.next();
        try
        {
            String query="INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0)
            {
                System.out.println("Patient Added Successfully");

            }else
            {
                System.out.println("Faoled to add patient");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        
        }
    }
    public void viewPatients()
    {
        String query="SELECT * FROM PATIENTS";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("Patients:");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient ID |    Patient Name    |    Age   |   Gender   |");
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String gender=resultSet.getString("gender");
                int age=resultSet.getInt("age");
                System.out.println("+------------+--------------------+----------+------------+");
                System.out.printf("|%-12s|%-20s|%-10s|%-12s|\n",id,name,age,gender);
               

                
            }
             System.out.println("+------------+--------------------+----------+------------+");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean getPatientById(int id)
    {
        String query="SELECT * FROM patients WHERE id =?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } 
        catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    } 
}
