import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Calculator {
    String name();

    String description();


}

class calculatorclass {


    @Calculator(name = "додавання", description = "Додавання двох чисел")

    public double add(double x, double y) {
        return x + y;

    }

    @Calculator(name = "віднімання", description = "віднімання двох чисел")
    public double substract(double x, double y) {
        return x - y;


    }
    @Calculator(name = "множення", description = "множення двух чисел між собою")
    public double multiply(double x, double y) {
        return x * y;


    }
    @Calculator(name = "ділення", description = "ділення одного числа на інше")
    public double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Ділити на нуль не можна.");
        } else {
            return x / y;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        calculatorclass calculator = new calculatorclass();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть тип калькуляторної операції, яку ви хочете провести: ");
        String a = sc.nextLine();
        try {

            Method[] methods = calculator.getClass().getMethods();


            Method selectedMethod = null;

            for(Method method : methods){
                Calculator annotation = method.getAnnotation(Calculator.class);
                if(annotation!=null && annotation.name().equalsIgnoreCase(a)){
                    selectedMethod=method;
                    break;
                }



            } if(selectedMethod!=null){

                Calculator annotation = selectedMethod.getAnnotation(Calculator.class);
                System.out.println("Калькуляторна операція: " + annotation.name());
                System.out.println("Опис: " + annotation.description());
                System.out.println("Введіть перше значення: ");
                double number = sc.nextDouble();
                System.out.println("Введіть друге значення: ");
                double number1 = sc.nextDouble();
                double result = (double) selectedMethod.invoke(calculator, number, number1);
                System.out.println("Результат: " + result);


            }
            else{


                System.out.println("Такої калькуляторної операції не існує.");
            }
        } catch (IllegalAccessException | InvocationTargetException exception  ) {

            System.out.println("Помилка: " + exception.getMessage());
        }
    }
}


  /*      Method method = calculator.getClass().getMethod(, double.class, double.class);
        Calculator annotation = method.getAnnotation(Calculator.class);
        if (annotation != null) {
        System.out.println("Калькуляторна операція: " + annotation.name());
        System.out.println("Опис: " + annotation.description());
        System.out.println("Введіть перше значення: ");
        double number = sc.nextDouble();
        System.out.println("Введіть друге значення: ");
        double number1 = sc.nextDouble();
        double result = (double) method.invoke(calculator, number, number1);
        System.out.println("Результат: " + result);
        else {
                System.out.println("Такох калькуляторної операції не знайдено.");
            }
            catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            System.out.println("Помилка: " + exception.getMessage());
        }


   */