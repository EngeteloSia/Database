package za.ac.cput.mymavemproject.database;

/**
 *
 * @author Engetelo
 */
public class RunFile {

    public static void main(String[] args) {

        new RunFile();
        VehicleDAO db = new VehicleDAO();
        System.out.println("Hello World");
        
        
        try {
           
           
            
            db.addValues("Car 1");
            db.addValues("Car 1");
            db.addValues("Car 1");
            db.addValues("Car 1");
            db.addValues("Car 1");
            System.out.println("Hello");
            
          

        } catch (Exception io) {
            System.out.println("Error here");

        }

    }

}//end of project
