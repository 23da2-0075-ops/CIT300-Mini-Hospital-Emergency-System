package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        TreatmentHistoryStack treatmentStack =
                new TreatmentHistoryStack();

        TreatmentRecord treatment1 =
                new TreatmentRecord(
                        "T001",
                        "P102",
                        "Kamala Silva",
                        "2026-08-30",
                        "Dr. Perera",
                        "Chest pain examination and medication"
                );

        TreatmentRecord treatment2 =
                new TreatmentRecord(
                        "T002",
                        "P105",
                        "Nimal Perera",
                        "2026-08-30",
                        "Dr. Fernando",
                        "Fever treatment and prescribed medicine"
                );

        TreatmentRecord treatment3 =
                new TreatmentRecord(
                        "T003",
                        "P110",
                        "Saman Fernando",
                        "2026-08-30",
                        "Dr. Silva",
                        "Leg fracture treatment and bandaging"
                );

        treatmentStack.push(treatment1);
        treatmentStack.push(treatment2);
        treatmentStack.push(treatment3);

        System.out.println("\nInitial Treatment Stack:");
        treatmentStack.displayTreatmentRecords();

        TreatmentRecord removedTreatment =
                treatmentStack.pop();

        if (removedTreatment != null) {
            System.out.println(
                    "\nMost Recently Completed Treatment Removed: "
                            + removedTreatment.getTreatmentId()
            );
        }

        System.out.println("\nStack After First Pop:");
        treatmentStack.displayTreatmentRecords();

        treatmentStack.pop();
        treatmentStack.pop();

        TreatmentRecord recordFromEmptyStack =
                treatmentStack.pop();

        if (recordFromEmptyStack == null) {
            System.out.println(
                    "\nCannot pop: Treatment stack is empty."
            );
        }

        treatmentStack.displayTreatmentRecords();
    }
}