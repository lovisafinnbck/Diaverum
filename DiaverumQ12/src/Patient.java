public class Patient {

    // attributes
    private String clinicNo, barcode, patientId, patientName, dob, gender, collectionDate, collectionTime, testCode,
            testName, result, unit, refRangeLow, refRangeHigh, note, nonSpecRefs;

    // constructor
    public Patient(String clinicNo, String barcode, String patientId, String patientName, String dob, String gender,
                   String collectionDate, String collectionTime, String testCode, String testName, String result,
                   String unit, String refRangeLow, String refRangeHigh, String note, String nonSpecRefs) {
        this.clinicNo = clinicNo;
        this.barcode = barcode;
        this.patientId = patientId;
        this.patientName = patientName;
        this.dob = dob;
        this.gender = gender;
        this.collectionDate = collectionDate;
        this.collectionTime = collectionTime;
        this.testCode = testCode;
        this.testName = testName;
        this.result = result;
        this.unit = unit;
        this.refRangeLow = refRangeLow;
        this.refRangeHigh = refRangeHigh;
        this.note = note;
        this.nonSpecRefs = nonSpecRefs;
    }

    // getters for all attributes
    public String getClinicNo() {
        return clinicNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getTestName() {
        return testName;
    }

    public String getResult() {
        return result;
    }

    public String getUnit() {
        return unit;
    }

    public String getRefRangeLow() {
        return refRangeLow;
    }

    public String getRefRangeHigh() {
        return refRangeHigh;
    }

    public String getNote() {
        return note;
    }

    public String getNonSpecRefs() {
        return nonSpecRefs;
    }
}
