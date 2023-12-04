package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double NATURAL_EXPLORER_STARTING_ENERGY = 60;
    private static final double NATURAL_EXPLORER_SEARCH_ENERGY =7;

    public NaturalExplorer(String name) {
        super(name, NATURAL_EXPLORER_STARTING_ENERGY);
    }

    @Override
    public void search() {
//        if (getEnergy() <= 7) {
//            setEnergy(0);
//        } else {
//            setEnergy(getEnergy() - 7);
//        }
        setEnergy(Math.max(0, getEnergy() - NATURAL_EXPLORER_SEARCH_ENERGY));
    }
}
