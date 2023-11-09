import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class myClass = Reflection.class;

        Field[] fields = myClass.getDeclaredFields();
        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s%n", field.getName()));

        Method[] methods = myClass.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(System.out::println);


        Class clazz = Reflection.class;
        Method[] AllMethods = clazz.getDeclaredMethods();
        for (Method method : AllMethods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                System.out.println(method.getName() + " " + annotation.name());

            }
        }
    }


}
