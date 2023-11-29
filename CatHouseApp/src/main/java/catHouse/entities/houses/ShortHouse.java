package catHouse.entities.houses;

public class ShortHouse extends BaseHouse{
    private static final int SHORTHOUSE_DEFAULT_CAPACITY = 15;
    public ShortHouse(String name) {
        super(name, SHORTHOUSE_DEFAULT_CAPACITY);
    }
}
