import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class intrface extends JFrame implements ActionListener{
	
	private JPanel pnord,pcentre,pnordcentre2,pcentrecentre2,pcentrebouton;
	private JPanel pcentre1, pcentre2,pcentrecentre2h,pcentrecentre2b;
	private JTextArea texteanalyser, texteresultat,textepile,textchaine;
	private JScrollPane scroleanalyse,scroleresultat,scrolpile;
	private JButton banalyse,bquiter,btable;
	
	
	private String texte;
	int i=0,colonne,ligne;
	char x,a;
	String somet;
	String production=null;
	Stack<String> pile_danalyse =new Stack<String>();
	char production_1;
	private String chaine;
	
	private static String aa1;
	private static String xx;
	private static int k;
	private static String b;
	

	public intrface() {
		super(" Interface");
		setSize(700,500);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		pnord=new JPanel ();
		add(pnord,BorderLayout.NORTH);
		
		
		
		pcentre=new JPanel();
		add(pcentre,BorderLayout.CENTER);
		pcentre.setLayout(new GridLayout(1,2));
		
		
		
		pcentre1=new JPanel();
		pcentre.add(pcentre1);
		pcentre1.setLayout(new GridLayout(2,1));
		
		pcentrecentre2h=new JPanel();
		pcentre1.add(pcentrecentre2h);
		pcentrecentre2h.setBorder(BorderFactory.createTitledBorder("chaine a analyser"));
		pcentrecentre2h.setLayout(new BorderLayout());
		
		texteanalyser=new JTextArea(10,50);
		scroleanalyse=new JScrollPane(texteanalyser);
		pcentrecentre2h.add(scroleanalyse);
			    boolean vrap=!texteanalyser.getLineWrap();
				texteanalyser.setLineWrap(vrap);
		
		 
		
		pcentrebouton=new JPanel();
		pcentrecentre2h.add(pcentrebouton,BorderLayout.SOUTH);
		banalyse= new JButton(" Analyser");
		pcentrebouton.add(banalyse);
		banalyse.setFont(new Font("Cambria",Font.BOLD | Font.ITALIC ,13) );
		banalyse.setForeground(Color.BLUE);
		banalyse.addActionListener(this);
		
		bquiter= new JButton(" Quitter   ");
		pcentrebouton.add(bquiter);
		bquiter.setFont(new Font("Cambria",Font.BOLD | Font.ITALIC ,13) );
		bquiter.setForeground(Color.BLUE);
		bquiter.addActionListener(this);
		
		
		btable=new JButton("Voir la table");
		pcentrebouton.add(btable);
		btable.setFont(new Font("Cambria",Font.BOLD | Font.ITALIC ,13) );
		btable.setForeground(Color.BLUE);
		btable.addActionListener(this);
		
		pcentrecentre2b=new JPanel();
		pcentre1.add(pcentrecentre2b);
		pcentrecentre2b.setBorder(BorderFactory.createTitledBorder("resultat"));
		pcentrecentre2b.setLayout(new BorderLayout());
		
		texteresultat=new JTextArea(7,20);
		scroleresultat=new JScrollPane(texteresultat);
		pcentrecentre2b.add(scroleresultat);
		texteresultat.setEditable(false);
		
		
		pcentre2=new JPanel();
		pcentre.add(pcentre2);
		
		pcentre2.setLayout(new GridLayout(1,2));
		
		JPanel p=new JPanel(); pcentre2.add(p);p.setLayout(new BorderLayout());
		JPanel p1=new JPanel();pcentre2.add(p1); p1.setLayout(new BorderLayout());
		
		
		
		p.setBorder(BorderFactory.createTitledBorder("pile d'analyse"));
		textepile=new JTextArea(27,24);
		scrolpile=new JScrollPane(textepile);
		p.add(scrolpile);
		textepile.setEditable(false);
		
		
		p1.setBorder(BorderFactory.createTitledBorder("La chaine"));
		textchaine=new JTextArea(27,24);
		JScrollPane scrolchaine=new JScrollPane(textchaine);
		p1.add(scrolchaine);
		textchaine.setEditable(false);
		
		
		    
		   
			
			 
	}
	
	public static void main(String[] args) {
		
		intrface an=new intrface();
		an.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getSource()==banalyse) {
			texte=texteanalyser.getText();
			
			texteresultat.setText(" ");
			textepile.setText(" ");
			textchaine.setText(" ");
			i=0;
			
			
			//System.out.println("texte "+texte);
			
			analyser a=new analyser();
			//
			
			a.table_analyse();
			a.affiche();
	//---------------------------------------------------------------	
			
	//--------------------------------------------------------------------		
			
			chaine=texte;
			texte=texte+"$";
			
			//texte=texte.replaceAll("\\s", "" );
			System.out.println(texte);
			
			//pile_danalyse.removeAllElements();
			if(pile_danalyse.empty())	{	
				
				pile_danalyse.push("$");
			    pile_danalyse.push("D"); }
			
			
			
			
			
			textepile.setText("Empiler   $"+"\n");
			textepile.setText(getText()+"Empiler   D"+"\n");
			
			textchaine.setText(getText1()+" La chaine est  : "+chaine+"\n");
			textchaine.setText(getText1()+"\n");
				
			   // textepile.setText(poi+"\n");
				
				
				do{
				//recuperation du 1er elt de la chaine
				x=texte.charAt(i);
				System.out.println(" lelement de la chaine est "+x);
				
				
			    // recuperation du  sommet de pile 
				somet=pile_danalyse.peek();
				System.out.println(" le somet de pile haurt "+somet);
				
				String x_to_str=Character.toString(x);
				//tester si le sommet de pile est egale au premier elt de la cahaine
				
				if( somet.equals(x_to_str)  ){
					i++;
					System.out.println("je rentre ds la comparaison du somet");
					System.out.println("somet de pile= "+somet);
					System.out.println(" g depilé");
					pile_danalyse.pop();
					
					
					textepile.setText(getText()+"Somet_P = Caractère_CH"+"\n");
					textepile.setText(getText()+"Depiler  "+somet+"\n");
					textchaine.setText(getText1()+"\n");
			

					
					
				}
				else{
					//juste
				//recuperation des indice
				colonne = a.indice_colonne(x);
				ligne=a.indice_ligne(somet);
				
				
			
				
				//juste
				//tester ssi l'element de la chaine existe dans la table des symbole
				if((colonne==0) ||(ligne==0))
					
					{//System.out.println("erreur lexical carctère");
					System.out.println("la ligne,colonne recupéré est "+ligne+","+colonne);
					production="e";}
				
				
				
				
				//juste
				else{
					System.out.println("la ligne,colonne recupéré est "+ligne+","+colonne);
				production=a.tabledessymboles[ligne][colonne];
				System.out.println("le z est "+production);
				
				
				
				if(production.equals("")){
					pile_danalyse.pop();
					System.out.println("g depilé epsilone");
					
					
					
				}
				 else{
					//2 cas se presente alors 
				production_1=production.charAt(0);
				System.out.println("le somet de la production  est : "+production_1);
				
				String somet_production=Character.toString(production_1);
				int ind_colone=a.indice_colonne(production_1);
				
				
				//la 1ere lettre de z est un terminal 
				if(somet_production.equals(a.tabledessymboles[0][ind_colone])){
					
					
					
				System.out.println("la 1ere lettre du z est un terminal");
					//on depile
					pile_danalyse.pop();
					System.out.println("le sommet 2 est "+pile_danalyse.peek());
					System.out.println("le z ici est "+production);
				
					
					
					String poi= new StringBuilder(production).reverse().toString();
					textepile.setText(getText()+"Empiler  "+poi+"\n");
					a.inverse(production, pile_danalyse);
					
					
					
				}
				else{//la 1er lettre est un non terminale(grande lettre)
					textepile.setText(getText()+"Depiler   "+pile_danalyse.peek()+"\n");
					pile_danalyse.pop();
					
					a.inverse(production, pile_danalyse);
					
					
			//-----------------------------------------
					String poi= new StringBuilder(production).reverse().toString();
					textepile.setText(getText()+"Empiler  "+poi+"\n");
					
			//---------------------------------------------------
					
					System.out.println("le sommet est egal ds les iteration a "+pile_danalyse.peek());
					
					
				}
					
				}
				
				}}
				
				
				if(pile_danalyse.empty()){
					b="true";
				}
				else{
					//sion je laisse b a false et je reboucle
				System.out.println("le dernier sommet avt de reboucler  est "+pile_danalyse.peek());
				 
			
				x=texte.charAt(i);
				System.out.println("la chaine est arrivé a "+x);
				textchaine.setText(getText1()+"Le caractere est : "+x+"\n");
				
				
				
					b="false";}
				System.out.println("le b est "+b);
			} 
				 while ((production!="e") && (b.equals("false")));
				
				
				if(production.equals("e")){ //la chaine est eroné
					
					texteresultat.setText(texteresultat.getText()+" "+"\n");
					
					String txt="                        --LA CHAINE EST ERRONE--" ;
					
					texteresultat.setText(texteresultat.getText()+txt+"\n");
					texteresultat.setText(texteresultat.getText()+" "+"\n");
					
					texteresultat.setText(texteresultat.getText()+" L'erreure est dans le caractère N°: "+(i+1)+"\n");
					texteresultat.setText(texteresultat.getText()+" Le carctère est : "+x+"\n");
					
					for (int h = 0; h <4 ; h++) {
						texteresultat.setText(texteresultat.getText()+"\n");
					}
					texteresultat.setText(texteresultat.getText()+"                   POUR ANALYSER UNE AUTRE"+"\n");
					texteresultat.setText(texteresultat.getText()+"INSERER UNE AUTRE CHAINE ET CLIQUER SUR ANALYSER "+"\n");
					
} else  {           //la chaine est accepté
				if(((x=='$')) && (pile_danalyse.empty())) {
					
					
					texteresultat.setText(" ");
					

					texteresultat.setText(texteresultat.getText()+" "+"\n");
					String txt="                     -- LA CHAINE EST ACCEPTE --" ;
					texteresultat.setText(texteresultat.getText()+txt+"\n");
					
					for (int h = 0; h <4 ; h++) {
						texteresultat.setText(texteresultat.getText()+"\n");
					}
					texteresultat.setText(texteresultat.getText()+"                   POUR ANALYSER UNE AUTRE"+"\n");
					texteresultat.setText(texteresultat.getText()+"INSERER UNE AUTRE CHAINE ET CLIQUER SUR ANALYSER "+"\n");
					
					
				    	 
				    	 }
					}
				}
				
		if (e.getSource()==btable){
            afichetab(); }	
				

			if (e.getSource()==bquiter){
               System.exit(0);	 }	
			
			}

	
	private String getText() {
		 String a =textepile.getText();
		return a;
	}
	
	private String getText1() {
		 String a =textchaine.getText();
		return a;
	}
	
	private void afichetab(){
		
		analyser a=new analyser();
		a.table_analyse();
		
		texteresultat.setText(" ");
		texteresultat.setText(texteresultat.getText()+" "+"\n");
		texteresultat.setText(texteresultat.getText()+"                     LA TABLE D'ANAYSE     "+"\n");
		
		 for( int  k=0;k<=5;k++)
			   
			{
			  texteresultat.setText(texteresultat.getText()+" "+"\n");
				for( int j=0;j<=8;j++) {
					
				  texteresultat.setText(texteresultat.getText()+a.tabledessymboles[k][j]+"    |     ");
				    
                       }
			}
		 
		 texteresultat.setText(texteresultat.getText()+" "+"\n"); texteresultat.setText(texteresultat.getText()+" "+"\n");
		
		
	}
	
	
}
