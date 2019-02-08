package darkestModel;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Hero {

	private enum Type {
		ABOMINATION, ANTIQUARIAN, ARBALEST, BOUNTY_HUNTER, CRUSADER, GRAVE_ROBBER_HELLION, HIGHWAYMAN, HOUNDMASTER,
		JESTER, LEPER, MAN_AT_ARMS, OCCULTIST, PLAGUE_DOCTOR, VESTAL
	}

	private StringProperty name;
	private Type type;
	private IntegerProperty level;
	private IntegerProperty armorValue;
	private IntegerProperty weaponValue;
	private ListProperty<String> trinkets;
	private BooleanProperty survived;
	private BooleanProperty isAlive;
	private ObjectProperty<LocalDate> deathDate;
	private Location deathLocation;
	private ObjectProperty<Location> deathLocation2;
	// private List

}
