package hospital;

public class EmergencyPatientQueue {

    private EmergencyQueueNode front;
    private EmergencyQueueNode rear;
    private int size;

    public EmergencyPatientQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public boolean enqueue(Patient patient) {
        if (patient == null) {
            return false;
        }

        EmergencyQueueNode newNode =
                new EmergencyQueueNode(patient);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        return true;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            return null;
        }

        Patient removedPatient = front.patient;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return removedPatient;
    }

    public void displayWaitingPatients() {
        if (isEmpty()) {
            System.out.println(
                    "Emergency queue is empty. No patient is waiting."
            );
            return;
        }

        System.out.println("\nPatients Currently Waiting");
        System.out.println("==========================");

        EmergencyQueueNode current = front;
        int position = 1;

        while (current != null) {
            System.out.println("Queue Position: " + position);
            System.out.println(current.patient);
            System.out.println("--------------------------");

            current = current.next;
            position++;
        }

        System.out.println("Total Waiting Patients: " + size);
    }
}