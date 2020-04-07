package openclose;

public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1, "shit", 100d);
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) iCourse;
        System.out.println("id:"+iCourse.getId()+".name:"+iCourse.getName()+".price:"+iCourse.getPrice());
        System.out.println("id:"+javaDiscountCourse.getId()+".name:"+javaDiscountCourse.getName()
                +".price:"+javaDiscountCourse.getPrice()+".origin price:"+javaDiscountCourse.getOriginPrice());
    }
}
