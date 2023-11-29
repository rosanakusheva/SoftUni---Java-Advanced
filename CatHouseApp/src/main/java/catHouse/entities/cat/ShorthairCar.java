package catHouse.entities.cat;

public class ShorthairCar extends BaseCat{
    private static final int SHORTHAIR_CAT_KILOGRAMS= 7;
    public ShorthairCar(String name, String breed, double price) {
        super(name, breed, SHORTHAIR_CAT_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }
}
