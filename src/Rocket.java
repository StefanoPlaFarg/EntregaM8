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
		creationPropellers(numJetPropellers);
	}
	
	public Rocket(String idCode, float[] listJetMaxPower) {
		this.idCode=idCode;
		creationPropellers(listJetMaxPower);
	}
	
	private void creationPropellers(int numJetPropellers) {
		
		for (int i = 0; i< numJetPropellers; i++) {
			
			addJetPropeller();
		}
		
	}
	
	private void creationPropellers(float[] listJetMaxPower) {

		for (int i = 0; i < listJetMaxPower.length; i++) {

			addJetPropeller(listJetMaxPower[i]);
		}

	}
	
	public void setIdCode(String idCode) {
		this.idCode=idCode;
	}
	
	public String getIdCode() {
		return idCode;
	}
	
	
	public void addJetPropeller() {
		listPropellers.add(new JetPropeller());
	}
	
	public void addJetPropeller(float jetMaxPower) {
		listPropellers.add(new JetPropeller(jetMaxPower));
	}
		
	public int getNumberJetPropellers() {
		 return listPropellers.size();
	}

}
