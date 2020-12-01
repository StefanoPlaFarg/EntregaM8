import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author stefano
 *
 */
public class Rocket {
	
	private String idCode;
	private List<JetPropeller> listPropellers = new ArrayList<JetPropeller>();
	
	
	public Rocket() {

	}
	
	public Rocket(String idCode) {
    this.idCode=idCode;
	}
	
	public Rocket(String idCode, int numJetPropellers) {
		this.idCode=idCode;
		this.idCode=idCode;
	}
	
	public void setIdCode(String idCode) {
		this.idCode=idCode;
	}
	
	
	public void addJetPropeller() {
		listPropellers.add(new JetPropeller());
	}
		
	public int getNumberJetPropellers() {
		 return listPropellers.size();
	}

}
