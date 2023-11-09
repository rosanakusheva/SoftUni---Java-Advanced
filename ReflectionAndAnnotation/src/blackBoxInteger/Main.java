package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        while(!command.equals("END")) {
            //command = "{command name}_{value}"
            String methodName = command.split("_")[0]; //метода, който трябва да изпълня
            int argument = Integer.parseInt(command.split("_")[1]); //стойността, с която изпълняваме метода

            Method method = clazz.getDeclaredMethod(methodName, int.class); //достъпваме метод с въведеното име
            method.setAccessible(true); //мога да изпълня метода
            //blackBoxInt.add(argument);
            method.invoke(blackBoxInt, argument); //изпълняваме метода с дадения аргумент


            Field innerValueField = clazz.getDeclaredField("innerValue"); //взимаме числото в кутията
            innerValueField.setAccessible(true);
            System.out.println(innerValueField.get(blackBoxInt)); //стойността на полето

            command = scanner.nextLine();
        }

   }
}
