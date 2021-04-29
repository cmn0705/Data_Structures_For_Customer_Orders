import java.util.StringTokenizer;

public class Order {
	int num;
	String city,state,zip,amount,date,email;

	public Order(String line){
		StringTokenizer st = new StringTokenizer(line, ","); 
		num =  Integer.parseInt(st.nextToken(","));
		city = st.nextToken(",");
		state = st.nextToken(",");
		zip = st.nextToken(",");
		amount = st.nextToken(",");
		date = st.nextToken(",");
		email = st.nextToken(",");
	}
	
	public int getOrder() {return num;}
	public String getState() {return state;}
	public void print() {System.out.println(num+","+city+","+state+","+zip+","+amount+","+email);}
	
	
}
