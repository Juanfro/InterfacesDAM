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

	public enum HeroType {
		ABOMINATION, ANTIQUARIAN, ARBALEST, BOUNTY_HUNTER, CRUSADER, GRAVE_ROBBER_HELLION, HIGHWAYMAN, HOUNDMASTER,
		JESTER, LEPER, MAN_AT_ARMS, OCCULTIST, PLAGUE_DOCTOR, VESTAL
	}

	private StringProperty name;
	private HeroType type;
	private IntegerProperty level;
	private IntegerProperty armorTier;
	private IntegerProperty weaponTier;
	// private ListProperty<String> trinkets;
	private BooleanProperty survived;
	private BooleanProperty isAlive;

	// private ObjectProperty<LocalDate> deathDate;
	// private Location deathLocation;
	// private ObjectProperty<Location> deathLocation2;
	// private List

	protected Hero(StringProperty name, HeroType type, IntegerProperty level, IntegerProperty armorTier,
			IntegerProperty weaponTier, BooleanProperty survived, BooleanProperty isAlive) {
		this.name = name;
		this.type = type;
		this.level = level;
		this.armorTier = armorTier;
		this.weaponTier = weaponTier;
		this.survived = survived;
		this.isAlive = isAlive;
	}

	protected StringProperty getName() {
		return name;
	}

	protected void setName(StringProperty name) {
		this.name = name;
	}

	protected HeroType getType() {
		return type;
	}

	protected void setType(HeroType type) {
		this.type = type;
	}

	protected IntegerProperty getLevel() {
		return level;
	}

	protected void setLevel(IntegerProperty level) {
		this.level = level;
	}

	protected IntegerProperty getArmorTier() {
		return armorTier;
	}

	protected void setArmorTier(IntegerProperty armorTier) {
		this.armorTier = armorTier;
	}

	protected IntegerProperty getWeaponTier() {
		return weaponTier;
	}

	protected void setWeaponTier(IntegerProperty weaponTier) {
		this.weaponTier = weaponTier;
	}

	protected BooleanProperty getSurvived() {
		return survived;
	}

	protected void setSurvived(BooleanProperty survived) {
		this.survived = survived;
	}

	protected BooleanProperty getIsAlive() {
		return isAlive;
	}

	protected void setIsAlive(BooleanProperty isAlive) {
		this.isAlive = isAlive;
	}

}
