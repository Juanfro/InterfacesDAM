package darkestPackage.darkestModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hero {

	public enum HeroClassEnum {
		ABOMINATION, ANTIQUARIAN, ARBALEST, BOUNTY_HUNTER, CRUSADER, GRAVE_ROBBER, HELLION, HIGHWAYMAN, HOUNDMASTER,
		JESTER, LEPER, MAN_AT_ARMS, OCCULTIST, PLAGUE_DOCTOR, VESTAL
	}

	private StringProperty heroName;
	// private HeroClassEnum type;
	private StringProperty heroClass;
	private IntegerProperty level;
	private IntegerProperty armorTier;
	private IntegerProperty weaponTier;
	// private ListProperty<String> trinkets;
	// private BooleanProperty survived;
	// private BooleanProperty isAlive;

	// private ObjectProperty<LocalDate> deathDate;
	// private Location deathLocation;
	// private ObjectProperty<Location> deathLocation2;
	// private List

	/**
	 * Contructor por defecto
	 */
	public Hero() {
		this(null, null);
	}

	/**
	 * Contructor con datos iniciales
	 * 
	 * @param heroName
	 * @param heroClass
	 * @param level
	 * @param armorTier
	 * @param weaponTier
	 */

	public Hero(String heroName, String heroClass) {
		this.heroName = new SimpleStringProperty(heroName);
		this.heroClass = new SimpleStringProperty(heroClass);

		// Datos de prueba
		this.level = new SimpleIntegerProperty(3);
		this.armorTier = new SimpleIntegerProperty(2);
		this.weaponTier = new SimpleIntegerProperty(1);
	}

	// GETTERS & SETTERS

	// Nombre
	public String getHeroName() {
		return heroName.get();
	}

	public void setHeroName(String heroName) {
		this.heroName.set(heroName);
	}

	public StringProperty heroNameProperty() {
		return heroName;
	}

	// Clase
	public String getHeroClass() {
		return heroClass.get();
	}

	public void setHeroClass(String heroClass) {
		this.heroClass.set(heroClass);
	}

	public StringProperty heroClassProperty() {
		return heroClass;

	}

	// Level

	public int getLevel() {
		return level.get();
	}

	public void setLevel(int level) {
		this.level.set(level);
	}

	public IntegerProperty getLevelProperty() {
		return level;
	}

	// Armor

	public int getArmorTier() {
		return armorTier.get();
	}

	public void setArmorTier(int armorTier) {
		this.armorTier.set(armorTier);
	}

	public IntegerProperty getArmorTierProperty() {
		return armorTier;
	}

	// Weapon

	public int getWeaponTier() {
		return weaponTier.get();
	}

	public void setWeaponTier(int weaponTier) {
		this.weaponTier.set(weaponTier);
	}

	public IntegerProperty getWeaponTierProperty() {
		return weaponTier;
	}

}
