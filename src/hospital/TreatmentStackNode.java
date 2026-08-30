package hospital;

public class TreatmentStackNode {

    TreatmentRecord treatmentRecord;
    TreatmentStackNode next;

    public TreatmentStackNode(
            TreatmentRecord treatmentRecord) {

        this.treatmentRecord = treatmentRecord;
        this.next = null;
    }
}