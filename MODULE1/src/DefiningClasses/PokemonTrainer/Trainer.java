package DefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String trainerName;
    private int badges;
    private List<Pokemon> collectionOfPokemons;

    public Trainer(String trainerName, List<Pokemon> collectionOfPokemons) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.collectionOfPokemons = collectionOfPokemons;
    }

    public int getNumberOfBadges() {
        return badges;
    }

    public void commandExecuting(String command) {

        if (isExist(command)) {
            badges += 1;
        } else {

            for (int i = 0; i < collectionOfPokemons.size(); i++) {
                collectionOfPokemons.get(i).setHealth(collectionOfPokemons.get(i).getHealth() - 10);
                if (collectionOfPokemons.get(i).getHealth() <= 0) {
                    collectionOfPokemons.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : collectionOfPokemons) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return trainerName + " " + badges + " " + collectionOfPokemons.size();
    }
}

