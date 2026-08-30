package hospital;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" Mini Hospital Emergency Management System");
        System.out.println("============================================");

        EmergencyPatientQueue emergencyQueue =
                new EmergencyPatientQueue();

        Patient patient1 = new Patient(
                "P102", "Kamala Silva", 62,
                "0712345678", "Chest Pain"
        );

        Patient patient2 = new Patient(
                "P105", "Nimal Perera", 35,
                "0771234567", "High Fever"
        );

        Patient patient3 = new Patient(
                "P110", "Saman Fernando", 48,
                "0751234567", "Leg Fracture"
        );

        emergencyQueue.enqueue(patient1);
        emergencyQueue.enqueue(patient2);
        emergencyQueue.enqueue(patient3);

        System.out.println("\nInitial Emergency Queue:");
        emergencyQueue.displayWaitingPatients();

        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {
            System.out.println(
                    "\nNext Patient Sent for Treatment: "
                            + nextPatient.getPatientId()
                            + " - "
                            + nextPatient.getPatientName()
            );
        }

        System.out.println("\nQueue After First Dequeue:");
        emergencyQueue.displayWaitingPatients();

        emergencyQueue.dequeue();
        emergencyQueue.dequeue();

        Patient patientFromEmptyQueue =
                emergencyQueue.dequeue();

        if (patientFromEmptyQueue == null) {
            System.out.println(
                    "\nCannot dequeue: Emergency queue is empty."
            );
        }

        emergencyQueue.displayWaitingPatients();
    }
}