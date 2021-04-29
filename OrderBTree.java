public class OrderBTree {
	Order data; 
	OrderBTree left, right;
	
	public OrderBTree() { data = null; left = right = null; } 		
	public OrderBTree(Order c) { data=c; left=right=null;} 			
	public void setData(Order c) { data = c; } 			
	public Order getData() { return data; }

	public void addOr(Order newnode){ 
		if (data == null) { data = newnode;return;} 
		if (newnode.getOrder()>data.getOrder()){ 
			if (right == null) right = new OrderBTree(newnode); 
			else right.addOr(newnode); 
		} 
		else { 
			if (left == null) left = new OrderBTree(newnode); 
			else left.addOr(newnode); 
		} 
	} 
	
	public void addSt(Order newnode){ 
		if (data == null) { data = newnode;return;} 
		if (newnode.getState().compareTo(data.getState())>0){ 
			if (right == null) right = new OrderBTree(newnode); 
			else right.addSt(newnode); 
		} 
		else { 
			if (left == null) left = new OrderBTree(newnode); 
			else left.addSt(newnode); 
		} 
	}
	 
	public void searchByOrder(int i){
		if (data.getOrder()==i) {
			/*data.print();*/
			data.getOrder();
			if(left!=null) left.searchByOrder(i);	
			return;
		}
		else if (i<data.getOrder() && left != null) left.searchByOrder(i);
		else if (right != null) right.searchByOrder(i);
	}
	
	public void searchByState(String o){
		if (data.getState().equals(o)) {
			/*data.print();*/
			data.getOrder();
			if(left!=null) left.searchByState(o);	
			return;
		}
		else if ((o.compareTo(data.getState())<0) && left != null) left.searchByState(o);
		else if (right != null) right.searchByState(o);
	}
}

