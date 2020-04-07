package dependenceinversion;

public class JavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("study java");
    }
}
