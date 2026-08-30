package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        Patient samplePatient = new Patient(
                "P105",
                "Nimal Perera",
                35,
                "0771234567",
                "High Fever"
        );

        System.out.println("\nSample Patient Record");
        System.out.println("---------------------");
        System.out.println(samplePatient);
    }
}