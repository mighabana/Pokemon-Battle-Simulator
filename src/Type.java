import java.io.Serializable;

/**
 * Interface of the types of Pokemon ensures that the types have methods to get their weaknesses, ineffective and not effective types
 * @author Miguel Habana
 *
 */
public interface Type extends Serializable {

	
	public String getName();
	
	public String[] getWeakness();
	public String[] getIneffective();
	public String[] getNotEffective();
}
