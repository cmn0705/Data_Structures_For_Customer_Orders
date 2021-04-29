import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NguyenPjBtree {
	public static void main(String[] args) {
 
		 String line; 
		 StringTokenizer st; 
		 BufferedReader infile;
		 Order temp;
 		 Scanner input=new Scanner(System.in);
		 
		 Runtime r = Runtime.getRuntime();
		 double memUsed0= r.totalMemory()-r.freeMemory();
		 
	//Build BinaryTree
		 OrderBTree orderTreeO = new OrderBTree();
		 OrderBTree orderTreeS = new OrderBTree();
		 try { 
		 infile = new BufferedReader(new FileReader("pjData.csv")); 
		 while ((line = infile.readLine()) != null){
			temp=new Order(line);
		 	orderTreeO.addOr(temp);
		 	orderTreeS.addSt(temp);
		 }
		 infile.close(); 
		 } catch (IOException x) { System.err.println(x); }  
	//Build BinaryTree End 

		 double memUsed1= r.totalMemory()-r.freeMemory();
		 System.out.println("MEMORY (Mb) USED TO READ DATA INTO BINARYTREE: " + (memUsed1-memUsed0)/1024);
		 
	// Search BinaryTree
		String cons = "y";
		while (cons.equals("y")) {
		 /*System.out.println("Enter Order to search: ");*/
		 /*int or=input.nextInt();*/
		 int or=265566;
 		 long startTime = System.currentTimeMillis();		 	 
 		 for(int i=0;i<1000000;i++) orderTreeO.searchByOrder(or);
		 long t=System.currentTimeMillis() - startTime;
		 /*System.out.println("Enter State to search: ");*/
		 /*String s=input.next();*/
		 String s="MO";
 		 startTime = System.currentTimeMillis();
 		 for(int i=0;i<1000;i++) orderTreeS.searchByState(s);
		 System.out.println("TIME USED TO SEARCH BY ORDER "+or+" 1000000 TIMES: "+ t + " ms");
		 System.out.println("TIME USED TO SEARCH BY STATE "+s+" 1000 TIMES: "+ (System.currentTimeMillis() - startTime) + " ms");
		 System.out.println("Continue? y/n: ");
		 cons=input.next();
		}
	// Search BinaryTree end
		 
	 
	}
}
