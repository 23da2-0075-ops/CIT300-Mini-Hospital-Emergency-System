package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        PatientBST patientBST = new PatientBST();

        Patient patient1 = new Patient(
                "P105", "Nimal Perera", 35,
                "0771234567", "High Fever"
        );

        Patient patient2 = new Patient(
                "P102", "Kamala Silva", 62,
                "0712345678", "Chest Pain"
        );

        Patient patient3 = new Patient(
                "P110", "Saman Fernando", 48,
                "0751234567", "Leg Fracture"
        );

        patientBST.insert(patient1);
        patientBST.insert(patient2);
        patientBST.insert(patient3);

        boolean duplicateInserted = patientBST.insert(
                new Patient(
                        "P105", "Duplicate Patient", 40,
                        "0700000000", "Unknown"
                )
        );

        if (!duplicateInserted) {
            System.out.println("\nDuplicate Patient ID P105 was rejected.");
        }

        patientBST.displayInOrder();
    }
}