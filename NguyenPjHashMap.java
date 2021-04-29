import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NguyenPjHashMap {
	public static void main(String[] args) {
		 String line; 
		 StringTokenizer st; 
		 BufferedReader infile; 
		 Scanner input=new Scanner(System.in);
		 
		 Runtime r = Runtime.getRuntime();
		 double memUsed0= r.totalMemory()-r.freeMemory();
		 
	//Build HashMap	 
		 HashMap<Integer,ArrayList<Order>>orderHMByOr = new HashMap<Integer,ArrayList<Order>>();
		 HashMap<String,ArrayList<Order>>orderHMBySt = new HashMap<String,ArrayList<Order>>();
		 try { 
		 infile = new BufferedReader(new FileReader("pjData.csv")); 
		 while ((line = infile.readLine()) != null){		 
			 Order temp=new Order(line);
			 if (orderHMByOr.containsKey(temp.getOrder())) {orderHMByOr.get(temp.getOrder()).add(temp);}
			 else {orderHMByOr.put(temp.getOrder(),new ArrayList<Order>()); orderHMByOr.get(temp.getOrder()).add(temp);}
			 if (orderHMBySt.containsKey(temp.getState())) {orderHMBySt.get(temp.getState()).add(temp);}
			 else {orderHMBySt.put(temp.getState(),new ArrayList<Order>());orderHMBySt.get(temp.getState()).add(temp);}
		 }
		 infile.close(); 
		 } catch (IOException x) { System.err.println(x); }  
	//Build HashMap End 

		 double memUsed1= r.totalMemory()-r.freeMemory();
		 System.out.println("MEMORY (Mb) USED TO READ DATA INTO HASHMAP: " + (memUsed1-memUsed0)/1024);
		 
	// Search HashMap
		String cons = "y";
		while (cons.equals("y")) {
		 /*System.out.println("Enter Order to search: ");*/
		 /*int or=input.nextInt();*/
		 int or=265566;
		 long startTime = System.currentTimeMillis();		 	 
		 for(int i=0;i<1000000;i++) {for(Order o:orderHMByOr.get(or)) /*o.print()*/ o.getOrder();}
		 long t=System.currentTimeMillis() - startTime;
		 /*System.out.println("Enter State to search: ");*/
		 /*String s=input.next();*/
		 String s="MO";
		 startTime = System.currentTimeMillis();
		 for(int i=0;i<1000;i++) {for(Order o:orderHMBySt.get(s))  /*o.print()*/ o.getOrder();}
		 System.out.println("TIME USED TO SEARCH BY THIS ORDER 1000000 TIMES: "+ t + " ms");
		 System.out.println("TIME USED TO SEARCH BY THIS STATE 1000 TIMES: "+ (System.currentTimeMillis() - startTime) + " ms");
		 System.out.println("Continue? y/n: ");
		 cons=input.next();
		}
	// Search HashMap end
		 
	}
}
