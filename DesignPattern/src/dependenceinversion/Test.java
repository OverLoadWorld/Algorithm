package dependenceinversion;

public class Test {
    public static void main(String[] args) {

        /*
        ShitGay shitGay = new ShitGay();
        shitGay.studyJavaCourse();
        shitGay.studyFeCourse();*/
        //by interface
/*        ShitGay shitGay = new ShitGay();
        shitGay.studyCourse(new JavaCourse());
        shitGay.studyCourse(new FeCourse());*/
// by construction
        /*ShitGay shitGay = new ShitGay(new JavaCourse());
        shitGay.studyCourse();
        ShitGay shitGay1 = new ShitGay(new FeCourse());
        shitGay1.studyCourse();*/

        // by set method
        ShitGay shitGay = new ShitGay();
        shitGay.setCourse(new JavaCourse());
        shitGay.studyCourse();
        shitGay.setCourse(new FeCourse());
        shitGay.studyCourse();
    }
}
