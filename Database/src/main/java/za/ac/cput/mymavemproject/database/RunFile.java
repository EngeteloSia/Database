package za.ac.cput.mymavemproject.database;

/**
 *
 * @author Engetelo
 */
public class RunFile {

    public static void main(String[] args) {

        new RunFile();
        VehicleDAO db = new VehicleDAO();

        try {

            db.addValues(1, "Car 1");
            db.addValues(2, "Car 1");
            db.addValues(3, "Car 1");
            db.addValues(4, "Car 1");
            db.addValues(5, "Car 1");
            db.updateVehicles(0);

        } catch (Exception io) {
            System.out.println("Error here");

        }

    }

}//end of project
