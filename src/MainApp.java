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
		
		Rocket rocket1 = new Rocket ("32WESSDS",3);
		Rocket rocket2 = new Rocket ("LDSFJA32",6);
		System.out.format("El codi del primer cohet és: %s%n i disposa de %d propulsors",rocket1.getIdCode(),rocket1.getNumberJetPropellers() );
		System.out.format("El codi del segon cohet és: %s%n i disposa de %d propulsors",rocket2.getIdCode(),rocket2.getNumberJetPropellers() );

	}

}
