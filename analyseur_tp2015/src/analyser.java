import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class analyser {
	String inverse_z;

	
	  
	static String tabledessymboles[][]=new String[6][9];
	private static String aa1;
	private static String xx;
	private static int k;
	private static String b;
	
	public void table_analyse(){
		int i,j;

  		for( i=0;i<=5;i++)
  		{
  			for(j=0;j<=8;j++)
  			
  				{ tabledessymboles[i][j]="e";
  				}
  			}
  		// ligne des formules logique
  		tabledessymboles[0][0]="  ";
  		tabledessymboles[0][1]="n";
  		tabledessymboles[0][2]="+";
  		tabledessymboles[0][3]="m";
  		tabledessymboles[0][4]="*";
  		tabledessymboles[0][5]="d";
  		tabledessymboles[0][6]="(";
  		tabledessymboles[0][7]=")";
  		tabledessymboles[0][8]="$";
  		
  		
		//remplir la colonne 0 ac les terminaux de la grammaire
  		tabledessymboles[1][0]="D";
  		tabledessymboles[2][0]="T";
  		tabledessymboles[3][0]="R";
  		tabledessymboles[4][0]="H";
  		tabledessymboles[5][0]="K";
  		
  		
  		// remplacé les epsilonne pas des vide
  		
  		tabledessymboles[2][8]="";
  		tabledessymboles[2][7]="";
  		tabledessymboles[4][2]="";
  		tabledessymboles[4][3]="";
  		tabledessymboles[4][7]="";
  		tabledessymboles[4][8]="";
  		
  		
  		
  		//remplir la table
  		tabledessymboles[1][1]="RT";
  		tabledessymboles[1][6]="RT";
  		
  		
  		tabledessymboles[2][2]="+RT";
  		tabledessymboles[2][3]="mRT";
  		
  		
  		tabledessymboles[3][1]="KH";
  		tabledessymboles[3][6]="KH";
  		
  		
  		tabledessymboles[4][4]="*KH";
  		tabledessymboles[4][5]="dKH";
  		
  		
  		tabledessymboles[5][1]="n";
  		tabledessymboles[5][6]="(D)";
  		
  		
		}
	

	void affiche(){
        int i ,j;  
   for(  i=0;i<=5;i++)
	   
	{
	   System.out.println();
		for( j=0;j<=8;j++)
			
		   System.out.print("  "+tabledessymboles[i][j]+"    | ");   

	}

   
   
   
   } 
	
	
	

	
	
	
	
	public String pile()
	
	{Stack<String> pile_danalyse=new Stack<String>();
	
	if(pile_danalyse.empty()){
	pile_danalyse.push("$");}
	pile_danalyse.push("D");
		return pile_danalyse.peek();
		
		
		
		
	}
	
	
	
	
	public int indice_colonne(char tc)
	{
	

		  if(tc=='n') return 1;
			else
			if (tc=='+') return 2;
			else
			 if((tc=='m'))return 3;
			  else
				if(tc=='*') return 4;
				  else
					if(tc=='d') return 5;
					else
						if(tc=='(') return 6;
						else
						
	                       if(tc==')') return 7;
	                       
	                    	 else
	                    		 if(tc=='$') return 7;
	                    		 else
	             				    return 0;
	             					
	}
	
	public int indice_ligne(String tc)
	{
	

		  if(tc.equals("D")) return 1;
			else
			if (tc.equals("T")) return 2;
			else
			 if(tc.equals("R"))return 3;
			  else
				if(tc.equals("H")) return 4;
				  else
					if(tc.equals("K")) return 5;
	                    else
	             			return 0;
	             					
	}
	 public Stack inverse(String inter,Stack<String> pile_danalyse){
		 

		 String x = new StringBuilder(inter).reverse().toString();
		 
		
		 for (int i = 0; i < x.length(); i++) {
			 pile_danalyse.push(Character.toString(x.charAt(i)));
			
		
		}
		 
		 
		return pile_danalyse;
		 
	 }
	
	
	 
	public static void main(String[] args){
		
		
		analyser h=new analyser ();
		
		
		
	}


	
}
