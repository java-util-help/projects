import java.util.Scanner;

public class HotelRoomService  {

	int type;
	int cost;
	int quantity;
	String bno;
	boolean status;

	public void setDetails () {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter type of repast \n 1-) Breakfast \n 2-) Lunch \n 3-) Dinner ");
			type = in.nextInt();
		System.out.println("Enter number of portion [ Single(1) || Double(2) ] )");
			quantity = in.nextInt();

		if(type==1)
			cost=10;
		else {
			if(type==2)
				cost=25;
		else {
			if(type==3)
				cost=30;
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
