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
		
		double listMaxPower[] = { 10, 30, 80 };
		double listTargetPower[] = { 5, 15, 40 };
		Rocket rocket1 = new Rocket("32WESSDS", listMaxPower);

		System.out.format("%s: List Max Power: %s %n", rocket1.getIdCode(), rocket1.getListJetMaxPowers());

		try {
			rocket1.setTargetPowerToPropellers(listTargetPower);
			System.out.format("%s: List Target Power: %s %n", rocket1.getIdCode(), rocket1.getListTargetJetPowers());

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			System.out.println("Launching Rocket1");
			rocket1.startPropellers();

		} catch (Exception e) {

			e.printStackTrace();
		}

		/*
		 * try { System.out.println ("Finishing program");
		 * rocket1.killThreadsJetPropellers();
		 * 
		 * }catch(Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

}
