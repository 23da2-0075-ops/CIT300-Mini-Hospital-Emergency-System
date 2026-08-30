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