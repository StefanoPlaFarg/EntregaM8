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
	
	public void JetPropeller() {
		jetMaxPower= 0;
	}
	
	public void JetPropeller(float jetMaxPower) {
		this.jetMaxPower= jetMaxPower;
	}
	
	public void setJetmaxPower(float jetMaxPower) {
		this.jetMaxPower= jetMaxPower;
	}
	
	public float getJetmaxPower() {
		return jetMaxPower;
	}
	
}
