package hospital;

public class PatientBST {

    private PatientNode root;

    public PatientBST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean insert(Patient patient) {
        if (patient == null) {
            return false;
        }

        if (root == null) {
            root = new PatientNode(patient);
            return true;
        }

        return insertRecursive(root, patient);
    }

    private boolean insertRecursive(PatientNode current, Patient patient) {
        int comparison = patient.getPatientId()
                .compareToIgnoreCase(current.patient.getPatientId());

        if (comparison < 0) {
            if (current.left == null) {
                current.left = new PatientNode(patient);
                return true;
            }

            return insertRecursive(current.left, patient);

        } else if (comparison > 0) {
            if (current.right == null) {
                current.right = new PatientNode(patient);
                return true;
            }

            return insertRecursive(current.right, patient);

        } else {
            return false;
        }
    }

    public Patient search(String patientId) {
        if (patientId == null || patientId.isBlank()) {
            return null;
        }

        return searchRecursive(root, patientId.trim());
    }

    private Patient searchRecursive(PatientNode current, String patientId) {
        if (current == null) {
            return null;
        }

        int comparison = patientId
                .compareToIgnoreCase(current.patient.getPatientId());

        if (comparison == 0) {
            return current.patient;
        }

        if (comparison < 0) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    public boolean delete(String patientId) {
        if (patientId == null || patientId.isBlank()) {
            return false;
        }

        String cleanedPatientId = patientId.trim();

        if (search(cleanedPatientId) == null) {
            return false;
        }

        root = deleteRecursive(root, cleanedPatientId);
        return true;
    }

    private PatientNode deleteRecursive(
            PatientNode current, String patientId) {

        if (current == null) {
            return null;
        }

        int comparison = patientId
                .compareToIgnoreCase(current.patient.getPatientId());

        if (comparison < 0) {
            current.left = deleteRecursive(current.left, patientId);

        } else if (comparison > 0) {
            current.right = deleteRecursive(current.right, patientId);

        } else {
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            PatientNode successor = findMinimum(current.right);
            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    private PatientNode findMinimum(PatientNode current) {
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void displayInOrder() {
        if (isEmpty()) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\nPatients in Ascending Patient ID Order");
        System.out.println("======================================");
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(PatientNode current) {
        if (current == null) {
            return;
        }

        displayInOrderRecursive(current.left);

        System.out.println(current.patient);
        System.out.println("--------------------------------------");

        displayInOrderRecursive(current.right);
    }
}