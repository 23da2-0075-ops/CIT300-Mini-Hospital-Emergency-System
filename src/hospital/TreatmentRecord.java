package hospital;

public class TreatmentRecord {

    private String treatmentId;
    private String patientId;
    private String patientName;
    private String treatmentDate;
    private String doctorName;
    private String treatmentDescription;

    public TreatmentRecord(
            String treatmentId,
            String patientId,
            String patientName,
            String treatmentDate,
            String doctorName,
            String treatmentDescription) {

        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDate = treatmentDate;
        this.doctorName = doctorName;
        this.treatmentDescription = treatmentDescription;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId + "\n"
                + "Patient ID: " + patientId + "\n"
                + "Patient Name: " + patientName + "\n"
                + "Treatment Date: " + treatmentDate + "\n"
                + "Doctor Name: " + doctorName + "\n"
                + "Treatment: " + treatmentDescription;
    }
}