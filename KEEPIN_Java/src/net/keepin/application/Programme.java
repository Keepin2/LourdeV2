package net.keepin.application;


import javax.swing.JOptionPane;

import net.keepin.table.Service;
import net.keepin.ui.AjoutBatiment;
import net.keepin.ui.AjoutPoste;
import net.keepin.ui.Connexion;


public class Programme {

	public static void main(String[] args) {
		try
		{
			/*Connexion uneConnexion = new Connexion();
			
			uneConnexion.setVisible(true);
			if(uneConnexion.getValue()){
				//Connexion Ok
				System.out.println("User connect�");
			}else{
				System.out.println("User non connect�");
				System.exit(0);
			}
			
			Bdd.closeConnexion();*/
		
			
			new AjoutPoste();
			
			//new ModifPoste1();
			//new ModifPoste2();
			//new SupprimPoste1();
			//new SupprimPoste2();
			//new AjoutBatiment();
			//new ModifBatiment();
			//new SupprimBatiment();
			//new AjoutEtage();
			//new ModifEtage();
			//new SupprimEtage();
			//new AjoutSalle();
			//new ModifSalle1();
			//new SupprimSalle();
			//new ModifEntreprise1();
			//new ModifEntreprise2();
			//new AjoutNiveau();
			//new ModifNiveau();
			//new SupprimNiveau();
			

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showError(String pMessage) {
		JOptionPane.showMessageDialog(null, pMessage, "Erreur", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public static void showWarning(String pMessage) {
		JOptionPane.showMessageDialog(null, pMessage, "Attention!", JOptionPane.WARNING_MESSAGE);
		
	}

}


