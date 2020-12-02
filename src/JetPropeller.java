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
	
	private double currentJetPower;
	private double targetJetPower;
	private double jetMaxPower;
	private String statePropeller;
	
	public JetPropeller() {
		jetMaxPower= 0;
		statePropeller="nothing";
	}
	
	public  JetPropeller(double jetMaxPower) {
		this();
		this.jetMaxPower= jetMaxPower;
		
	}
	
	public JetPropeller(double jetMaxPower, String  statePropeller ) {
		this.jetMaxPower= jetMaxPower;
		this.statePropeller=statePropeller;
	}
	
	public void setJetMaxPower(double jetMaxPower) {
		this.jetMaxPower= jetMaxPower;
	}
	
	public double getJetMaxPower() {
		return jetMaxPower;
	}
	

	/**
	 * @return the targetJetPower
	 */
	public double getTargetJetPower() {
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
	public double getCurrentJetPower() {
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

		while (!getStatePropeller().equals("dead")) {
			
			if (getStatePropeller().equals("acceleration")) {
				accelerateToTargetPower();
				isTargetPowerReached();
			} else if (getStatePropeller().equals("deceleration")) {
				decelerateToTargetPower();
				isTargetPowerReached();

			} else if (getStatePropeller().equals("nothing")) {// Thread sleep
				setStatePropeller("nothing");
			} else {// Kill Thread
				setStatePropeller("dead");
			}
		}

	}
	
	private void accelerateToTargetPower() {
		System.out.println ("Thread: " + Thread.currentThread().getId() + "Current power: " + currentJetPower + "Target power: " + targetJetPower);
		
		if (difference (targetJetPower,currentJetPower)>=1) {
			currentJetPower=currentJetPower+1;			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
		else {
			
			currentJetPower=currentJetPower + difference (targetJetPower,currentJetPower);
			
		}
	}
	
   private void decelerateToTargetPower() {
	   System.out.println ("Thread: " + Thread.currentThread().getId() + "Current power: " + currentJetPower + "Target power: " + targetJetPower);
		
	   if (difference (targetJetPower,currentJetPower)<=1) {
			currentJetPower=currentJetPower-1;
		}
		
		else {
			
			currentJetPower=currentJetPower + difference (targetJetPower,currentJetPower);
			
		}
		
	}
	
	private double difference(double targetJetPower, double currentJetPower) {

		return targetJetPower - currentJetPower;
	}
   
	private boolean isTargetPowerReached() {
		boolean TargetPowerReached = false;

		if (currentJetPower == targetJetPower) {

			statePropeller = "nothing";
			TargetPowerReached = true;

		} else if (currentJetPower < targetJetPower) {

			statePropeller = "acceleration";
			TargetPowerReached = false;

		} else if (currentJetPower > targetJetPower) {

			statePropeller = "deceleration";
			TargetPowerReached = false;

		}

		return TargetPowerReached;
	}
	
	
}
