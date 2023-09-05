import java.lang.reflect.*;
import java.lang.annotation.*;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    public class Calculator1 {
        @Math(num1 =100, num2=200)
        public void mathSum(int num1, int num2){
            int sum = num1+num2;
            System.out.println(sum);

        }
        public static void main(String[] args) {
            Calculator1 calc = new Calculator1();


            try{
                Method method = calc.getClass().getMethod("mathSum", int.class, int.class);
Math annotation = method.getAnnotation(Math.class);
if(annotation!=null){
    int num1 = annotation.num1();
    int num2 = annotation.num2();
    method.invoke(calc,num1,num2);


} else{
    System.out.println("Аннотація @Math не знайдена.");
}



            } catch (NoSuchMethodException| IllegalAccessException| InvocationTargetException exception){
                System.out.println("Помилка: " + exception.getMessage());


            }
        }


    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Math{

        int num1();
        int num2();

    }



