import java.util.Scanner;

public class Laundry {

	int type;
	int cost;
	int quantity;
	String bno;
	boolean status;

	public void setDetails () {
		status=true;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter type of wash (1/2/3)");
			type = in.nextInt();
		System.out.println("Enter quantity of clothes");
			quantity = in.nextInt();
			
		if(type==1)
			cost=50;
		else {
			if(type==2)
				cost=100;
		else {
			if(type==3)
				cost=150;
		else
			cost=0;
			}
		}
	}

	public int getTotalCost () {
		return quantity*cost;
	}

	public boolean getStatus () {
		return status;
	}
}
