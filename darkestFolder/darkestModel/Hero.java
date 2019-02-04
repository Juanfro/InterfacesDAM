package darkestModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Hero {

	private enum Type {
		ABOMINATION, ANTIQUARIAN, ARBALEST, BOUNTY_HUNTER, CRUSADER, GRAVE_ROBBER_HELLION, HIGHWAYMAN, HOUNDMASTER,
		JESTER, LEPER, MAN_AT_ARMS, OCCULTIST, PLAGUE_DOCTOR, VESTAL
	}

	private StringProperty name;
	private Type type;
	private IntegerProperty armorValue;
	private IntegerProperty weaponValue;
	// private List

}
