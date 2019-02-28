package darkestPackage.darkestModel;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase helper para envolver la lista de heroes.<br>
 * Se usa para guardar la lista de heroes en formato XML
 * 
 * @author Juan Antonio Rodriguez
 *
 */
@XmlRootElement(name = "heroes")
public class HeroListWrapper {

	private List<Hero> heroes;

	@XmlElement(name = "hero")
	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

}
