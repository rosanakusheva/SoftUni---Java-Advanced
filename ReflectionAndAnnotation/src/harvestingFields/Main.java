package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Field>> fieldsMap = getFieldsMap();
        Consumer<Field> printerField = field -> System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());


        String command = scanner.nextLine();

        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    fieldsMap.get("private").forEach(field -> printerField.accept(field) );

                    break;
                case "public":
                    fieldsMap.get("public").forEach(field -> printerField.accept(field));
                    break;
                case "protected":
                    fieldsMap.get("protected").forEach(field -> printerField.accept(field));
                    break;
                case "all":
                    fieldsMap.get("all").forEach(field -> printerField.accept(field));
                    break;
            }


            command = scanner.nextLine();
        }

    }

    private static Map<String, List<Field>> getFieldsMap() {
        Map<String, List<Field>> map = new HashMap<>();
        map.put("private", new ArrayList<>());
        map.put("public", new ArrayList<>());
        map.put("protected", new ArrayList<>());

        List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
        map.put("all", allFields);

        allFields.forEach(field -> {
            String modifier = Modifier.toString(field.getModifiers());
            switch (modifier) {
                case "public":
                    map.get("public").add(field);
                    break;
                case "private":
                    map.get("private").add(field);
                    break;
                case "protected":
                    map.get("protected").add(field);
                    break;
            }
        });
        return map;
    }
}
