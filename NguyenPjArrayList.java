import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NguyenPjArrayList {
	public static void main(String[] args) {
		 
		 String line; 
		 StringTokenizer st; 
		 BufferedReader infile; 
		 Scanner input=new Scanner(System.in);
		 
		 Runtime r = Runtime.getRuntime();
		 double memUsed0= r.totalMemory()-r.freeMemory();
		 
	//Build ArrayList
		 ArrayList<Order>orderAL = new ArrayList<Order>();
		 try { 
		 infile = new BufferedReader(new FileReader("pjData.csv")); 
		 while ((line = infile.readLine()) != null){ 
			 orderAL.add(new Order(line)); 
		 }
		 infile.close(); 
		 } catch (IOException x) { System.err.println(x); }  
	//Build ArrayList End 

		 double memUsed1= r.totalMemory()-r.freeMemory();
		 System.out.println("MEMORY (Mb) USED TO READ DATA INTO ARRAYlIST: " + (memUsed1-memUsed0)/1024);
		 
	// Search ArrayList
		String cons = "y";
		while (cons.equals("y")) {
		 /*System.out.println("Enter Order to search: ");*/
		 /*int or=input.nextInt();*/
		 int or=265566;
		 long startTime = System.currentTimeMillis();		 	 
		 for(int i=0;i<1000;i++) {for (Order o:orderAL) if (o.getOrder()==or) /*o.print()*/o.getOrder(); }
		 long t=System.currentTimeMillis() - startTime;
		 /*System.out.println("Enter State to search: ");*/
		 /*String s=input.next();*/
		 String s="MO";
		 startTime = System.currentTimeMillis();
		 for(int i=0;i<100;i++) {for (Order o:orderAL) if (o.getState().equals(s)) /*o.print()*/o.getOrder(); }
		 System.out.println("TIME USED TO SEARCH BY THIS ORDER 1000 TIMES: "+ t + " ms");
		 System.out.println("TIME USED TO SEARCH BY THIS STATE 100 TIMES: "+ (System.currentTimeMillis() - startTime) + " ms");
		 System.out.println("Continue? y/n: ");
		 cons=input.next();
		}
	// Search ArrayList end
		 
	 
	}
}
