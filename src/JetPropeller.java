/**
 * 
 */
import java.util.List;
import java.util.ArrayList;

/**
 * @author stefano
 *
 */
public class JetPropeller extends Thread {
	
	private float currentJetPower;
	private float targetJetPower;
	private float jetMaxPower;
	private String statePropeller;
	
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
	

	/**
	 * @return the targetJetPower
	 */
	public float getTargetJetPower() {
		return targetJetPower;
	}

	/**
	 * @param targetJetPower the targetJetPower to set
	 */
	public void setTargetJetPower(float targetJetPower) {
		this.targetJetPower = targetJetPower;
	}


	
	/**
	 * @return the currentJetPower
	 */
	public float getCurrentJetPower() {
		return currentJetPower;
	}

	/**
	 * @param currentJetPower the currentJetPower to set
	 */
	public void setCurrentJetPower(float currentJetPower) {
		this.currentJetPower = currentJetPower;
	}

	public void setStatePropeller(String statePropeller) {
		this.statePropeller= statePropeller;
	}
	
	public String getStatePropeller() {
		
		return statePropeller;
	}
	
	
	@Override
	public void run() {
		
		if (getStatePropeller().equals("acceleration")) {
			accelerate(); 
			isTargetPowerReached();
		}else if (getStatePropeller().equals("deceleration")) {
			decelerate();
			isTargetPowerReached();
			
		}else {
			//Do nothing
		}
		
	private void acclerate 	()
	
	
		
	}
	
	
	
	
	
}
