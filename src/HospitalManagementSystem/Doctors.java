package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Doctors {
     private Connection connection;
    public Doctors(Connection connection)
    {
        this.connection=connection;
    
    }
    
    public void viewDoctors()
    {
        String query="SELECT * FROM DOCTORS";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("Doctors:");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| Doctor ID  |    Doctor's Name   |   Specialization |");
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String specialization=resultSet.getString("specialization");
                System.out.println("+------------+--------------------+------------------+");
                System.out.printf("|%-12s|%-20s|%-18s|\n",id,name,specialization);
               


                
            }
            System.out.println("+------------+--------------------+------------------+");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean getPatientById(int id)
    {
        String query="SELECT * FROM DOCTORS WHERE id =?";
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
