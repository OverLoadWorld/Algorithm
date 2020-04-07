package dependenceinversion;

public class ShitGay {
    private ICourse iCourse;

    public ShitGay() {
    }

    public ShitGay(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void studyCourse() {
        iCourse.study();
    }

    public void setCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }
}
