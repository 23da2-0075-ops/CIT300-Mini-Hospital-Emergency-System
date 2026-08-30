package hospital;

public class VisitHistoryList {

    private VisitNode head;
    private int size;

    public VisitHistoryList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public boolean addVisit(Visit visit) {
        if (visit == null) {
            return false;
        }

        if (searchVisit(visit.getVisitId()) != null) {
            return false;
        }

        VisitNode newNode = new VisitNode(visit);

        if (isEmpty()) {
            head = newNode;
        } else {
            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
        return true;
    }

    public Visit searchVisit(String visitId) {
        if (visitId == null || visitId.isBlank()) {
            return null;
        }

        VisitNode current = head;
        String cleanedVisitId = visitId.trim();

        while (current != null) {
            if (current.visit.getVisitId()
                    .equalsIgnoreCase(cleanedVisitId)) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    public boolean removeVisit(String visitId) {
        if (visitId == null
                || visitId.isBlank()
                || isEmpty()) {
            return false;
        }

        String cleanedVisitId = visitId.trim();

        if (head.visit.getVisitId()
                .equalsIgnoreCase(cleanedVisitId)) {

            head = head.next;
            size--;
            return true;
        }

        VisitNode current = head;

        while (current.next != null) {
            if (current.next.visit.getVisitId()
                    .equalsIgnoreCase(cleanedVisitId)) {

                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void displayVisits() {
        if (isEmpty()) {
            System.out.println(
                    "No previous hospital visits are available."
            );
            return;
        }

        System.out.println("\nPatient Visit History");
        System.out.println("=====================");

        VisitNode current = head;
        int position = 1;

        while (current != null) {
            System.out.println("Visit Number: " + position);
            System.out.println(current.visit);
            System.out.println("---------------------");

            current = current.next;
            position++;
        }

        System.out.println("Total Visits: " + size);
    }
}