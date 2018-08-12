/**
 * @(#)Test.java
 *
 *
 * @author Jean-Baptiste Fromenteau
 * @version 1.0.0 2008/4/21
 */

import com.jbf.java.util.TimeListener;
import com.jbf.java.util.Chronometre;
import com.jbf.java.util.TimeEvent;


/**
 *To test easyly the chronometre.
 *
 **/

public class Test {
	
	
	/**
	 *The constructor.
	 *
	 **/
	public Test () {
		
		Chronometre c = new Chronometre();
		c.addTimeListener(new TimeListener () {
			
			//Là j'ai fais en francais pck la flème de traduire .. mdr xDD
			public void timeChanged (TimeEvent evt) {
				System.out.println("le temps a change");
			}
			
			public void timeStarted (TimeEvent evt) {
				System.out.println("le chrono a ete lance");
			}
			
			public void timeStoped (TimeEvent evt) {
				System.out.println("le chrono a ete arrete");
			}
			
			public void timeSuspended (TimeEvent evt) {
				System.out.println("le chrono a ete mit en pause");
			}
			
			public void timeResumed (TimeEvent evt) {
				System.out.println("le chrono a repris son cycle");
			}
			
			public void timeReseted (TimeEvent evt) {
				System.out.println("le chrono a ete remit a zero");
			}
			
			
			//Obligé de les mettres pck sinon ca compile pas .. u_u.. 
			public void hoursChanged (TimeEvent evt) {}
			
			public void minutesChanged (TimeEvent evt) {}
			
			public void secondsChanged (TimeEvent evt) {}
			
		});
		
		
		c.start(); //lance le chronometre
		try {
			Thread.sleep(5000);
		}catch (Exception e) {}
		c.suspend(); //pause
		c.reset(); //remise à zéro
		c.resume(); //relance
		try {
			Thread.sleep(5000);
		}catch (Exception e) {}
		c.stop(); //arrête
		
	}
	
	
	
	/**
	 *Main method.
	 *
	 **/
	public static void main (String arg[]) {
		
		new Test();
		
	}
	
}
