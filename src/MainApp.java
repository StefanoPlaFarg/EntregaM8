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
		float listMaxPower1[]= {10,30,80};
		float listMaxPower2[]= {30,40,50,50,30,10};
		Rocket rocket1 = new Rocket ("32WESSDS",listMaxPower1);
		Rocket rocket2 = new Rocket ("LDSFJA32",listMaxPower2);
		System.out.format("%s: %s %n",rocket1.getIdCode(),rocket1.getListJetMaxPowers() );
		System.out.format("%s: %s %n",rocket2.getIdCode(),rocket2.getListJetMaxPowers() );

	}

}
