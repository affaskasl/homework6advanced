import java.lang.annotation.*;
public class Main1 {
    public static void main(String[] args) {
        Subclass subclass = new Subclass();


        subclass.MyMethod();


        AnnotationExample annotationExample = new AnnotationExample();
        System.out.println(annotationExample.toString());
    }



}



    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface MyInheritedAnnotation{

        String value();

    }
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyNonInheritedAnnotation{

        String value();
    }
@MyInheritedAnnotation(value = "Успадкована анотація з батьківського класу.")
    class Superclass{

        public void MyMethod(){

            System.out.println("Метод у батьківському класі.");
        }
    }

class Subclass extends Superclass{
@Override
    public void MyMethod(){
System.out.println("Метод у субкласі.");


}


}
@MyNonInheritedAnnotation(value = "Неуспадкований метод.")
class AnnotationExample{
        @Deprecated
    @SuppressWarnings("unchecked")
    @Override
    @MyInheritedAnnotation(value = "Успадкована аннотація з методу")
public String toString (){
            return "AnnotationExample class";



    }






}



