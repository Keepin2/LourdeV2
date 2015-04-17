package net.keepin.ui;

import javax.swing.JTextField;
import javax.swing.JLabel;

import net.keepin.application.Bdd;
import net.keepin.table.Batiment;

import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class AjoutBatiment{
	private JTextField textFieldLibelle;

	public AjoutBatiment() {
		Conteneur ajoutBatiment = new Conteneur("Ajouter un b�timent");
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		textFieldLibelle.setBounds(500, 350, 160, 25);
		ajoutBatiment.getContentPane().add(textFieldLibelle);
		
		JLabel labelLibelle = new JLabel("Libell\u00E9:");
		labelLibelle.setLabelFor(textFieldLibelle);
		labelLibelle.setBounds(350, 350, 56, 25);
		ajoutBatiment.getContentPane().add(labelLibelle);
		
		final JLabel labelInformation = new JLabel("");
		labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		labelInformation.setBounds(288, 463, 518, 50);
		ajoutBatiment.getContentPane().add(labelInformation);
		
		Bouton boutonAjouter = new Bouton("Ajouter", 630, 0, 128);
		boutonAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String libelle = textFieldLibelle.getText().trim();
				Bdd.openConnexion();
				// V�rifier si le b�timent n'existe pas d�j�:
				String SQLQueryVerif = "SELECT COUNT(*) AS total FROM batiment WHERE Upper(bat_libelle) = '" + libelle.toUpperCase() +"'";
				ResultSet SQLResultVerif = Bdd.executeQuery(SQLQueryVerif);
				try{
					SQLResultVerif.next();
					if(SQLResultVerif.getInt("total")!=0){
						labelInformation.setText("Ce b�timent existe d�j�, veuillez rentrez un autre libell�.");
					}else{
						// On rajoute � la base de donn�es
						String SQLAjout = "INSERT INTO batiment (bat_libelle) VALUES ('" + libelle +"')";
						int retVal = Bdd.executeUpdate(SQLAjout);
						labelInformation.setText("Le b�timent a bien �t� ajout�.");
					}
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
				Bdd.closeConnexion();
			}
			
			
		});
		ajoutBatiment.getContentPane().add(boutonAjouter);
		
		Bouton boutonAnnuler = new Bouton("Annuler", 350, 128, 0);
		ajoutBatiment.getContentPane().add(boutonAnnuler);
		
		
		
		ajoutBatiment.setVisible(true);

	}
}
