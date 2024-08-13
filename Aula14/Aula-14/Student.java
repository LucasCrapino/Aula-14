public class Student {
    private String discipline;
    private double gradeOne, gradeTwo;
    private int absents;

    public Student(){
        
    }
    
    public Student(String discipline, double gradeOne, double gradeTwo, int absents) {
        this.discipline = discipline;
        this.gradeOne = gradeOne;
        this.gradeTwo = gradeTwo;
        this.absents = absents;
    }

    public String getDiscipline() {
        return discipline;
    }
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    public double getGradeOne() {
        return gradeOne;
    }
    public void setGradeOne(double gradeOne) {
        this.gradeOne = gradeOne;
    }
    public double getGradeTwo() {
        return gradeTwo;
    }
    public void setGradeTwo(double gradeTwo) {
        this.gradeTwo = gradeTwo;
    }
    public int getAbsents() {
        return absents;
    }
    public void setAbsents(int absents) {
        this.absents = absents;
    }

    

}
