/**
 * 
 */
import java.util.List;
import java.util.ArrayList;

/**
 * @author stefano
 *
 */
public class JetPropeller {
	
	private float jetMaxPower;
	
	public JetPropeller() {
		jetMaxPower= 0;
	}
	
	public  JetPropeller(float jetMaxPower) {
		this.jetMaxPower= jetMaxPower;
	}
	
	public void setJetMaxPower(float jetMaxPower) {
		this.jetMaxPower= jetMaxPower;
	}
	
	public float getJetMaxPower() {
		return jetMaxPower;
	}
	
}
