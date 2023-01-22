public class Pilot extends AirlineEmployees{

    private final int pilotLicenseNumber;

    public Pilot(String name, String rank, int pilotLicenseNumber){
        super(name, rank);
        this.pilotLicenseNumber = pilotLicenseNumber;
    }

    public int getPilotLicenseNumber() {
        return pilotLicenseNumber;
    }

    public String flyPlane(){
        return "...and we're off!";
    }
}
