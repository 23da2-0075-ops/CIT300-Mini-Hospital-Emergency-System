package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        PatientBST patientBST = new PatientBST();

        patientBST.insert(new Patient(
                "P105", "Nimal Perera", 35,
                "0771234567", "High Fever"
        ));

        patientBST.insert(new Patient(
                "P102", "Kamala Silva", 62,
                "0712345678", "Chest Pain"
        ));

        patientBST.insert(new Patient(
                "P110", "Saman Fernando", 48,
                "0751234567", "Leg Fracture"
        ));

        boolean duplicateInserted = patientBST.insert(new Patient(
                "P105", "Duplicate Patient", 40,
                "0700000000", "Unknown"
        ));

        if (!duplicateInserted) {
            System.out.println(
                    "\nDuplicate Patient ID P105 was rejected."
            );
        }

        System.out.println("\nSearching for Patient P102");
        System.out.println("--------------------------");

        Patient foundPatient = patientBST.search("P102");

        if (foundPatient != null) {
            System.out.println(foundPatient);
        } else {
            System.out.println("Patient P102 was not found.");
        }

        System.out.println("\nSearching for Patient P999");
        System.out.println("--------------------------");

        Patient missingPatient = patientBST.search("P999");

        if (missingPatient == null) {
            System.out.println("Patient P999 was not found.");
        }

        System.out.println("\nBefore deleting Patient P105:");
        patientBST.displayInOrder();

        boolean deleted = patientBST.delete("P105");

        if (deleted) {
            System.out.println("\nPatient P105 deleted successfully.");
        } else {
            System.out.println("\nPatient P105 was not found.");
        }

        System.out.println("\nAfter deleting Patient P105:");
        patientBST.displayInOrder();
    }
}