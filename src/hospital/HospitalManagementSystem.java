package hospital;

import java.util.Scanner;

public class HospitalManagementSystem {

    private static final Scanner SCANNER =
            new Scanner(System.in);

    private static final PatientBST PATIENT_BST =
            new PatientBST();

    private static final EmergencyPatientQueue EMERGENCY_QUEUE =
            new EmergencyPatientQueue();

    private static final TreatmentHistoryStack TREATMENT_STACK =
            new TreatmentHistoryStack();

    public static void main(String[] args) {
        int choice;

        do {
            displayMainMenu();
            choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> PATIENT_BST.displayInOrder();
                case 5 -> addPatientToEmergencyQueue();
                case 6 -> treatNextEmergencyPatient();
                case 7 -> EMERGENCY_QUEUE.displayWaitingPatients();
                case 8 -> addCompletedTreatment();
                case 9 -> removeLatestTreatment();
                case 10 -> TREATMENT_STACK.displayTreatmentRecords();
                case 11 -> addPatientVisit();
                case 12 -> searchPatientVisit();
                case 13 -> removePatientVisit();
                case 14 -> displayPatientVisitHistory();

                case 0 -> System.out.println(
                        "\nThank you. System closed successfully."
                );

                default -> System.out.println(
                        "\nInvalid menu choice. "
                                + "Enter a number from 0 to 14."
                );
            }

        } while (choice != 0);

        SCANNER.close();
    }

    private static void displayMainMenu() {
        System.out.println(
                "\n================================================"
        );
        System.out.println(
                " MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM"
        );
        System.out.println(
                "================================================"
        );
        System.out.println("1.  Register New Patient");
        System.out.println("2.  Search Patient");
        System.out.println("3.  Delete Patient");
        System.out.println("4.  Display All Patients");
        System.out.println("5.  Add Patient to Emergency Queue");
        System.out.println("6.  Treat Next Emergency Patient");
        System.out.println("7.  Display Emergency Queue");
        System.out.println("8.  Add Completed Treatment");
        System.out.println("9.  Remove Latest Treatment");
        System.out.println("10. Display Treatment History");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Remove Patient Visit");
        System.out.println("14. Display Patient Visit History");
        System.out.println("0.  Exit");
        System.out.println(
                "------------------------------------------------"
        );
    }

    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");

        String patientId = readRequiredText(
                "Patient ID: "
        ).toUpperCase();

        if (PATIENT_BST.search(patientId) != null) {
            System.out.println(
                    "Patient ID " + patientId
                            + " already exists."
            );
            return;
        }

        String patientName =
                readRequiredText("Patient Name: ");

        int age =
                readPositiveInteger("Age: ");

        String contactNumber =
                readRequiredText("Contact Number: ");

        String medicalCondition =
                readRequiredText("Medical Condition: ");

        Patient patient = new Patient(
                patientId,
                patientName,
                age,
                contactNumber,
                medicalCondition
        );

        if (PATIENT_BST.insert(patient)) {
            System.out.println(
                    "Patient " + patientId
                            + " registered successfully."
            );
        }
    }

    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");

        Patient patient = findRegisteredPatient();

        if (patient != null) {
            System.out.println("\n" + patient);
        }
    }

    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");

        String patientId = readRequiredText(
                "Patient ID: "
        ).toUpperCase();

        if (PATIENT_BST.delete(patientId)) {
            System.out.println(
                    "Patient " + patientId
                            + " deleted successfully."
            );
        } else {
            System.out.println(
                    "Patient " + patientId
                            + " was not found."
            );
        }
    }

    private static void addPatientToEmergencyQueue() {
        System.out.println(
                "\n--- Add Patient to Emergency Queue ---"
        );

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        EMERGENCY_QUEUE.enqueue(patient);

        System.out.println(
                "Patient " + patient.getPatientId()
                        + " added to the emergency queue."
        );
    }

    private static void treatNextEmergencyPatient() {
        System.out.println(
                "\n--- Treat Next Emergency Patient ---"
        );

        Patient patient = EMERGENCY_QUEUE.dequeue();

        if (patient == null) {
            System.out.println(
                    "Emergency queue is empty. "
                            + "No patient is waiting."
            );
            return;
        }

        System.out.println("Patient sent for treatment:");
        System.out.println(patient);
    }

    private static void addCompletedTreatment() {
        System.out.println(
                "\n--- Add Completed Treatment ---"
        );

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        String treatmentId = readRequiredText(
                "Treatment ID: "
        ).toUpperCase();

        String treatmentDate = readRequiredText(
                "Treatment Date (YYYY-MM-DD): "
        );

        String doctorName =
                readRequiredText("Doctor Name: ");

        String treatmentDescription =
                readRequiredText("Treatment Description: ");

        TreatmentRecord treatmentRecord =
                new TreatmentRecord(
                        treatmentId,
                        patient.getPatientId(),
                        patient.getPatientName(),
                        treatmentDate,
                        doctorName,
                        treatmentDescription
                );

        TREATMENT_STACK.push(treatmentRecord);

        System.out.println(
                "Treatment " + treatmentId
                        + " added successfully."
        );
    }

    private static void removeLatestTreatment() {
        System.out.println(
                "\n--- Remove Latest Treatment ---"
        );

        TreatmentRecord treatmentRecord =
                TREATMENT_STACK.pop();

        if (treatmentRecord == null) {
            System.out.println(
                    "Treatment stack is empty. "
                            + "No treatment can be removed."
            );
            return;
        }

        System.out.println(
                "Most recent treatment removed:"
        );
        System.out.println(treatmentRecord);
    }

    private static void addPatientVisit() {
        System.out.println("\n--- Add Patient Visit ---");

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        String visitId = readRequiredText(
                "Visit ID: "
        ).toUpperCase();

        String visitDate = readRequiredText(
                "Visit Date (YYYY-MM-DD): "
        );

        String doctorName =
                readRequiredText("Doctor Name: ");

        String diagnosis =
                readRequiredText("Diagnosis: ");

        String treatment =
                readRequiredText("Treatment: ");

        Visit visit = new Visit(
                visitId,
                visitDate,
                doctorName,
                diagnosis,
                treatment
        );

        if (patient.getVisitHistory().addVisit(visit)) {
            System.out.println(
                    "Visit " + visitId
                            + " added to patient "
                            + patient.getPatientId() + "."
            );
        } else {
            System.out.println(
                    "Visit ID " + visitId
                            + " already exists for this patient."
            );
        }
    }

    private static void searchPatientVisit() {
        System.out.println(
                "\n--- Search Patient Visit ---"
        );

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        String visitId = readRequiredText(
                "Visit ID: "
        ).toUpperCase();

        Visit visit =
                patient.getVisitHistory()
                        .searchVisit(visitId);

        if (visit == null) {
            System.out.println(
                    "Visit " + visitId
                            + " was not found."
            );
        } else {
            System.out.println("\n" + visit);
        }
    }

    private static void removePatientVisit() {
        System.out.println(
                "\n--- Remove Patient Visit ---"
        );

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        String visitId = readRequiredText(
                "Visit ID: "
        ).toUpperCase();

        if (patient.getVisitHistory()
                .removeVisit(visitId)) {

            System.out.println(
                    "Visit " + visitId
                            + " removed successfully."
            );
        } else {
            System.out.println(
                    "Visit " + visitId
                            + " was not found."
            );
        }
    }

    private static void displayPatientVisitHistory() {
        System.out.println(
                "\n--- Display Patient Visit History ---"
        );

        Patient patient = findRegisteredPatient();

        if (patient == null) {
            return;
        }

        System.out.println(
                "Visit history for "
                        + patient.getPatientId()
                        + " - "
                        + patient.getPatientName()
        );

        patient.getVisitHistory().displayVisits();
    }

    private static Patient findRegisteredPatient() {
        String patientId = readRequiredText(
                "Patient ID: "
        ).toUpperCase();

        Patient patient =
                PATIENT_BST.search(patientId);

        if (patient == null) {
            System.out.println(
                    "Patient " + patientId
                            + " was not found."
            );
        }

        return patient;
    }

    private static int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input =
                    SCANNER.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException exception) {
                System.out.println(
                        "Invalid input. Enter a whole number."
                );
            }
        }
    }

    private static int readPositiveInteger(
            String prompt) {

        while (true) {
            int value = readInteger(prompt);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Enter a number greater than zero."
            );
        }
    }

    private static String readRequiredText(
            String prompt) {

        while (true) {
            System.out.print(prompt);

            String value =
                    SCANNER.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }
}