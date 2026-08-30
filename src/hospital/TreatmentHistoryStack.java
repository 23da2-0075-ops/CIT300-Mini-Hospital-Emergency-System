package hospital;

public class TreatmentHistoryStack {

    private TreatmentStackNode top;
    private int size;

    public TreatmentHistoryStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public boolean push(TreatmentRecord treatmentRecord) {
        if (treatmentRecord == null) {
            return false;
        }

        TreatmentStackNode newNode =
                new TreatmentStackNode(treatmentRecord);

        newNode.next = top;
        top = newNode;
        size++;

        return true;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            return null;
        }

        TreatmentRecord removedRecord =
                top.treatmentRecord;

        top = top.next;
        size--;

        return removedRecord;
    }

    public void displayTreatmentRecords() {
        if (isEmpty()) {
            System.out.println(
                    "Treatment stack is empty. "
                            + "No completed treatments are available."
            );
            return;
        }

        System.out.println("\nCompleted Treatment Records");
        System.out.println("===========================");

        TreatmentStackNode current = top;
        int position = 1;

        while (current != null) {
            System.out.println(
                    "Stack Position: " + position
                            + (position == 1
                            ? " - Most Recent" : "")
            );

            System.out.println(current.treatmentRecord);
            System.out.println("---------------------------");

            current = current.next;
            position++;
        }

        System.out.println(
                "Total Treatment Records: " + size
        );
    }
}