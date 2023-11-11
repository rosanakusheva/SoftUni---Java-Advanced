package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
         Class clazz = Class.forName()
	}
}
