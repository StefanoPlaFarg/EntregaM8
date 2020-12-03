/**
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author stefano
 *
 */
public class JetPropeller extends Thread {
	
	private double currentJetPower;
	private double targetJetPower;
	private double jetMaxPower;
	private String statePropeller;
	private AtomicBoolean threadAlive  ;
	
	public JetPropeller() {
		currentJetPower=0;
		jetMaxPower= 0;
		statePropeller="nothing";
		threadAlive = new AtomicBoolean(false);
	}
	
	public  JetPropeller(double jetMaxPower) {
		this();
		this.jetMaxPower= jetMaxPower;
		
	}
	
	public JetPropeller(double jetMaxPower, String  statePropeller ) {
		this.jetMaxPower= jetMaxPower;
		this.statePropeller=statePropeller;
	}
	
	/**
	 * @return the threadAlive
	 */
	public boolean getThreadAlive() {
		return threadAlive.get();
	}

	/**
	 * @param threadAlive the threadAlive to set
	 */
	public void setThreadAlive(boolean threadAlive) {
		this.threadAlive.set(threadAlive);
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
	public void setTargetJetPower(double targetJetPower) {
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
	public void setCurrentJetPower(double currentJetPower) {
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

		while (getThreadAlive()) {
			
			if (getStatePropeller().equals("acceleration")) {
				printThreadPowerStatus();
				accelerateToTargetPower();
				if (isTargetPowerReached()) {
					printThreadPowerStatus();
				}
				
				
				
			} else if (getStatePropeller().equals("deceleration")) {
				printThreadPowerStatus();
				decelerateToTargetPower();
				if (isTargetPowerReached()) {
					printThreadPowerStatus();
				}
				
				
				
			} else if (getStatePropeller().equals("nothing")) {// Thread sleep
				//setStatePropeller("nothing");
				
			} 
		}

	}
	
	private void accelerateToTargetPower() {
		
		
		if (difference (targetJetPower,currentJetPower)>=1) {
			currentJetPower=currentJetPower+1;			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
		else {
			
			currentJetPower=currentJetPower + difference (targetJetPower,currentJetPower);
			
		}
	}
	
   private void decelerateToTargetPower() {
	   
		
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
	
	private void printThreadPowerStatus() {
		System.out.println ("Thread: " + Thread.currentThread().getId()+" " + "Current power: " + currentJetPower + " " +"Target power: " + targetJetPower);
		
	}
	
	
}
