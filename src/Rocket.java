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
	
	public Rocket(String idCode, double[] listJetMaxPower) {
		this.idCode=idCode;
		creationPropellersWithMaxPower(listJetMaxPower);
	}
	
	private void creationPropellers(int numJetPropellers) {
		
		for (int i = 0; i< numJetPropellers; i++) {
			
			addJetPropeller();
		}
		
	}
	
	private void creationPropellersWithMaxPower(double[] listJetMaxPower) {

		for (int i = 0; i < listJetMaxPower.length; i++) {

			addJetPropeller(listJetMaxPower[i]);
		}

	}
	
	public void setTargetPowerToPropellers(double[] listTargetPowerPropeller) throws Exception{
		
		if (listPropellers==null  ) {//No jetPropellers stored
			
			throw new Exception ("No jetPropellers stored");
			
		}else if ((listPropellers.size() != listTargetPowerPropeller.length  )) {//The size of the List and the Array are different
			throw new Exception ("The size of the list of max power of propellers is different than the one of list of target powers");
			
		}else {//The size of the List and the Array are the same
					
			int count =0;
			
			for (JetPropeller jetPropeller:listPropellers) {
				
				if (listTargetPowerPropeller[count] <= jetPropeller.getJetMaxPower()) {
					
					jetPropeller.setTargetJetPower(listTargetPowerPropeller[count]);
					count++;
					
				}else {
					
					throw new Exception ("At least one target power of one of the propeller list exceeds its respective max power");
					
				}
				
			}
			
		}	
		
	}
	
	
	public void startPropellers ()throws Exception {
		
             if (listPropellers==null  ) {//No jetPropellers stored
			
			throw new Exception ("No jetPropellers stored");
			
             }else {
            	 
					for (JetPropeller jetPropeller : listPropellers) {//setting states of the set of Jet Propellers

						if (jetPropeller.getCurrentJetPower() == jetPropeller.getTargetJetPower()) {

							jetPropeller.setStatePropeller("nothing");
							
						} else if (jetPropeller.getCurrentJetPower() < jetPropeller.getTargetJetPower()) {

							jetPropeller.setStatePropeller("acceleration");
						} else {

							jetPropeller.setStatePropeller("deceleration");
						}

					}
					
					
					for (JetPropeller jetPropeller : listPropellers) {//Starting the set of Jet Propellers
						
						jetPropeller.start();
						
					}
            	 
             }
		
		
		
	}
	
	public void killThreadsJetPropellers() throws Exception{
           if (listPropellers==null  ) {//No jetPropellers stored
			
			throw new Exception ("No jetPropellers stored");
           }else {
          	 
				for (JetPropeller jetPropeller : listPropellers) {
					
					jetPropeller.setStatePropeller("dead");
					
				}
					
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
	
	public void addJetPropeller(double jetMaxPower) {
		listPropellers.add(new JetPropeller(jetMaxPower));
	}
		
	public int getNumberJetPropellers() {
		 return listPropellers.size();
	}

	public String getListJetMaxPowers() {
		
		String listJetMaxPower="[ ";
		for (JetPropeller jetPropeller:listPropellers) {
			listJetMaxPower= listJetMaxPower+ Double.toString(jetPropeller.getJetMaxPower())+" ";
			
		}
		
		listJetMaxPower=listJetMaxPower+"]";
		 return listJetMaxPower;
	}
	

    public String getListTargetJetPowers() {
		
		String listTargetJetPowers="[ ";
		for (JetPropeller jetPropeller:listPropellers) {
			listTargetJetPowers= listTargetJetPowers+ Double.toString(jetPropeller.getTargetJetPower())+" ";
			
		}
		
		listTargetJetPowers=listTargetJetPowers+"]";
		 return listTargetJetPowers;
	}
	
	
}
