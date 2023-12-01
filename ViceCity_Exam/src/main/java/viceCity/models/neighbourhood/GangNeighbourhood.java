package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player tommyVercetti, Collection<Player> civilPlayers) {
        Repository<Gun> tommyGunRepository = tommyVercetti.getGunRepository();
        Deque<Gun> tommyGuns = new ArrayDeque<>(tommyGunRepository.getModels());
        Deque<Player> players = new ArrayDeque<>(civilPlayers);

        Player player = players.poll();
        Gun gun = tommyGuns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int shot = gun.fire();
                player.takeLifePoints(shot);
            }

            if (gun.canFire()) {
                player = players.poll();
            } else {
                gun = tommyGuns.poll();
            }

        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Repository<Gun> civilPlayerGunRepository = civilPlayer.getGunRepository();
                Deque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayerGunRepository.getModels());

                Gun civilPayerGun = civilPlayerGuns.poll();
                while (civilPayerGun != null) {
                    while (civilPayerGun.canFire() && tommyVercetti.isAlive()) {
                        int shot = civilPayerGun.fire();
                        tommyVercetti.takeLifePoints(shot);
                    }

                    if (tommyVercetti.isAlive()){
                        return;
                    }
                    civilPayerGun = civilPlayerGuns.poll();
                }
            }
        }
    }
}
