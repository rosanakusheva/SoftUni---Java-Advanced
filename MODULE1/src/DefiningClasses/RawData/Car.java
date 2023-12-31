package DefiningClasses.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public void extract(String command) {
        if (command.equals("fragile")){
            for (Tire tire : tires){
                double pressure = tire.getPressure();
                if (pressure < 1 ){
                    System.out.println(model);
                    break;
                }
            }

        } else if (command.equals("flamable")) {
            int enginePower = engine.getEnginePower();
            if (enginePower > 250){
                System.out.println(model);
            }
        }
    }
}
