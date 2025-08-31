package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Hospital_Management_System {
    private static final String url="jdbc:mysql://localhost:3306/hospital";
    private static final String userName="root";
    private static final String password="root";
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);
        try
        {
            Connection connection=DriverManager.getConnection(url, userName, password);
            Patient patient=new Patient(connection,scanner);
            Doctors doctor=new Doctors(connection);
            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM\n1. Add Patient\n2. View Patient\n3. View Doctors\n4. Book Appointment\n5. Exit\n");
                System.out.println("Enter Your Choice:");
                int choice =scanner.nextInt();
                switch (choice) {
                    case 1:
                        
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        bookAppointment(patient, doctor, connection, scanner);
                        System.out.println();
                        break;
                    case 5:
                        return;
                
                    default:
                        System.out.println("Enter valid Choice");
                }
                
            }

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    public static void bookAppointment(Patient patient,Doctors doctor,Connection connection,Scanner scanner)
    {
        System.out.println("Enter Patient ID:");
        int patientId=scanner.nextInt();
        System.out.println("Enter Doctor ID:");
        int doctorId=scanner.nextInt();
        System.out.println("Enter Appointment Date(YYYY-MM-DD):");
        String date=scanner.next();
        if(patient.getPatientById(patientId) && doctor.getPatientById(doctorId))
        {
            if (checkDoctorAvalibility(doctorId,date,connection)) {
                String appointmentQuery="INSERT INTO appointments(patient_id,doctor_id,appointment_date)VALUES(?,?,?)";
               try {
                PreparedStatement preparedStatement=connection.prepareStatement(appointmentQuery);
                preparedStatement.setInt(1,patientId);
                preparedStatement.setInt(2, doctorId);
                preparedStatement.setString(3,date);
                int rowsAffected=preparedStatement.executeUpdate();
                if(rowsAffected>0)
                {
                    System.out.println("Appointment Booked.");
                }
               } catch (SQLException e) {
               System.out.println("Failed to Book Appointment.");
               }
            }
            else
            {
                System.out.println("Doctor not avalible on this date");
            }

        }else
        {
            System.out.println("Either Doctor or Patient Exist");
        }



    }
    public static boolean checkDoctorAvalibility(int doctorId,String appointmentDate,Connection connection)
    {
        String query="SELECT COUNT(*) FROM APPOINTMENTS WHERE doctor_id=? AND appointment_date = ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
            preparedStatement.setString(2,appointmentDate);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int count=resultSet.getInt(1);
                if(count==0)
                {
                    return true;

                }
                else
                {
                    return false;
                }
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return false;
    }
}
