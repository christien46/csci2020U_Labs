package sample;

/**
 * Created by christien on 13/03/16.
 */
public class StudentRecords {

    private String SID = "";
    private float Assignments = 0f;
    private float Midterm = 0f;
    private float FinalExam = 0f;
    private float FinalMark = 0f;
    private String LetterGrade = "";

    public StudentRecords(String SID, float Assignments, float Midterm, float FinalExam){
        this.Assignments = Assignments;
        this.SID = SID;
        this.Midterm = Midterm;
        this.FinalExam = FinalExam;
        this.FinalMark = (Midterm * 0.3f) + (Assignments * 0.2f) + (FinalExam * 0.5f);

        if (this.FinalMark < 50) {
            this.LetterGrade = "F";
        } else if (this.FinalMark < 60) {
            this.LetterGrade = "D";
        } else if (this.FinalMark < 70) {
            this.LetterGrade = "C";
        } else if (this.FinalMark < 80) {
            this.LetterGrade = "B";
        } else {
            this.LetterGrade = "A";
        }
    }


    public String getSid() {
        return SID;
    }

    public void setSid(String SID) {
        this.SID = SID;
    }

    public float getAssignments() {
        return Assignments;
    }

    public void setAssignments(float Assignments) {
        this.Assignments = Assignments;
    }

    public float getMidterm() {
        return Midterm;
    }

    public void setMidterm(float Midterm) {
        this.Midterm = Midterm;
    }

    public float getFinalExam() {
        return FinalExam;
    }

    public void setFinalExam(float FinalExam) {
        this.FinalExam = FinalExam;
    }

    public float getFinalMark() {
        return FinalMark;
    }

    public String getLetterGrade() {
        return LetterGrade;
    }



}
