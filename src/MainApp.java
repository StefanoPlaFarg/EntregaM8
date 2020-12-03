/**
 * 
 */

/**
 * @author stefano
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		double listMaxPower[] = { 80, 30, 10 };
		
		Rocket rocket = new Rocket("32WESSDS", listMaxPower);

		System.out.format("%s: Max Power Propeller List: %s %n", rocket.getIdCode(), rocket.getListJetMaxPowers());

		
		rocket.setCurrentSpeed(0);
		rocket.setTargetSpeed(200);
		System.out.format("%s: Current Speed: %f Target Speed: %f %n",rocket.getIdCode(), rocket.getCurrentSpeed(), rocket.getTargetSpeed());
		
		try {
			rocket.setTotalPowerToPropellers(rocket.getTargetSpeed());
			System.out.format("%s: Target Power Propeller List: %s %n", rocket.getIdCode(), rocket.getListTargetJetPowers());

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			System.out.println("Launching Rocket");
			rocket.startPropellers();

		} catch (Exception e) {

			e.printStackTrace();
		}
         
		
		while (rocket.sumCurrentPowerAllJetPropellers()<rocket.getTotalPower()) {
			
			//rocket.updateCurrentSpeed();
			//System.out.println("Current Speed: " + rocket.getCurrentSpeed());
		}
		
				
		try {			
			rocket.killThreadsJetPropellers();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	     rocket.updateCurrentSpeed();
		System.out.println("The current speed is: " + rocket.getCurrentSpeed());
		//System.out.println("The program is over");

	}

}
