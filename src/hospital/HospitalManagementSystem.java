package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        Patient patient = new Patient(
                "P105",
                "Nimal Perera",
                35,
                "0771234567",
                "High Fever"
        );

        VisitHistoryList visitHistory =
                patient.getVisitHistory();

        visitHistory.addVisit(new Visit(
                "V001",
                "2026-05-10",
                "Dr. Silva",
                "Common Cold",
                "Prescribed cold medicine"
        ));

        visitHistory.addVisit(new Visit(
                "V002",
                "2026-06-15",
                "Dr. Fernando",
                "Back Pain",
                "Pain relief medication"
        ));

        visitHistory.addVisit(new Visit(
                "V003",
                "2026-08-30",
                "Dr. Perera",
                "High Fever",
                "Fever treatment and medicine"
        ));

        boolean duplicateAdded =
                visitHistory.addVisit(new Visit(
                        "V002",
                        "2026-08-31",
                        "Dr. Test",
                        "Test Diagnosis",
                        "Test Treatment"
                ));

        if (!duplicateAdded) {
            System.out.println(
                    "\nDuplicate Visit ID V002 was rejected."
            );
        }

        System.out.println(
                "\nVisit history for "
                        + patient.getPatientId()
                        + " - "
                        + patient.getPatientName()
        );

        visitHistory.displayVisits();

        System.out.println("\nSearching for Visit V002");
        System.out.println("------------------------");

        Visit foundVisit =
                visitHistory.searchVisit("V002");

        if (foundVisit != null) {
            System.out.println(foundVisit);
        }

        Visit missingVisit =
                visitHistory.searchVisit("V999");

        if (missingVisit == null) {
            System.out.println("\nVisit V999 was not found.");
        }

        boolean removed =
                visitHistory.removeVisit("V002");

        if (removed) {
            System.out.println(
                    "\nVisit V002 removed successfully."
            );
        }

        System.out.println("\nHistory After Removing V002:");
        visitHistory.displayVisits();

        Patient secondPatient = new Patient(
                "P110",
                "Saman Fernando",
                48,
                "0751234567",
                "Leg Fracture"
        );

        System.out.println(
                "\nVisit history for "
                        + secondPatient.getPatientId()
                        + " - "
                        + secondPatient.getPatientName()
        );

        secondPatient.getVisitHistory().displayVisits();
    }
}