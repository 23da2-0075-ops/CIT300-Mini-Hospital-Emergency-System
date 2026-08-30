package hospital;

public class EmergencyQueueNode {

    Patient patient;
    EmergencyQueueNode next;

    public EmergencyQueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}