import java.util.Scanner;

public class Welcome{

	public static void main(String args[]) {

			int nod,type,bookingno,ld,d;
	    char ch='y';
	    double ff;
	    String name;
	    Luxury[] ly = new Luxury[10];
	    Deluxe[] dx = new Deluxe[10];
	    SuperDeluxe[] sdx= new SuperDeluxe[10];
	    Customer c[] = new Customer[30];
	    Laundry l[][][]=new Laundry[30][5][5];
	    HotelRoomService t[][][]=new HotelRoomService[30][5][5];
	    Book b[]=new Book[30];
	    int i=0,j,k;

	    for(i=0;i<10;i++) {
	    	ly[i]=new Luxury();
			ly[i].set(500,false,false,false,false,true,false,false);
	    }

	    for(i=0;i<10;i++) {
	    	dx[i]=new Deluxe();
			dx[i].set(1000,true,false,true,false,true,true,false);
	    }

	    for(i=0;i<10;i++) {
	    	sdx[i]=new SuperDeluxe();
			sdx[i].set(1500,true,false,true,true,true,true,true);
	    }

	    for(i=0;i<30;i++) {
	    	c[i]=new Customer();
	    }

	    for(i=0;i<30;i++) {
	    	b[i]=new Book();
	    }

	    for(i=0;i<30;i++) {
	    	for(j=0;j<5;j++) {
	    		for(k=0;k<5;k++) {
	    			t[i][j][k]=new HotelRoomService();
	    			l[i][j][k]=new Laundry();
	    		}
	    	}
	    }

	    String no;
	    int ic=0,ily=0,ilr=0,itr1=0,itr2=0,isdx=0,idx=0;
	    int flag1=0,flag2=0,flag3=0;

	    while(true) {
				System.out.println("");
	    	System.out.println("What do you want to do ? ");
	    	System.out.println("Book a room ( b ) ");
	    	System.out.println("Avail a service ( s ) ");
	    	System.out.println("Cancel a booked room ( c ) ");
	    	System.out.println("Exit Menu ( e ) ");

	    Scanner in = new Scanner(System.in);
			ch = in.next(".").charAt(0);

	    if(ch=='b') {

		    for(i=0;i<3;i++) {
		    	if(ly[i].getStatus()==false) {
		    		ily=i;
		    		flag1=1;
		    		break;
		    	}
					else
		    	flag1=0;
		    }

		    for(i=0;i<8;i++) {
		    	if(dx[i].getStatus()==false) {
		    		idx=i;
		    		flag2=1;
		    		break;
		    	}
					else
		    	flag2=0;
		    }

		    for(i=0;i<10;i++) {
		    	if(sdx[i].getStatus()==false) {
		    		isdx=i;
		    		flag3=1;
		    		break;
		    	}
		    	else
		    	flag3=0;
		    }
	    		c[ic].setInitialDetails(ic);
	    		b[ic].BookNew(c[ic],ly[ily],dx[idx],sdx[isdx],t,l,ily,flag1,idx,flag2,isdx,flag3);
	    		c[ic].setBookingNo(b[ic].getBookingNumber());
	    		ic++;
	    }


	    if(ch=='c') {
        ic--;
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter your booking no : ");
          no = in2.nextLine();

        int no1=(int)no.charAt(0)-48;
        int no2;

        System.out.println("Enter type \n 1-) Luxury \n 2-) Deluxe \n 3-) SuperDeluxe \n");
          no2= in2.nextInt();

        if(no2==1) {
            ly[no1].statuschange();
        }

        if(no2==2) {
            dx[no1].statuschange();
				}

        if(no2==3) {
            sdx[no1].statuschange();
        }

        System.out.println("Cancelled");
    }

		int cno;

	    if(ch=='s') {
	    	Scanner in2 = new Scanner(System.in);

	    	System.out.println("Enter your booking no : ");
					no = in2.nextLine();

	    	System.out.println("Enter your customer no : ");
	    		cno = in2.nextInt();

	    	System.out.println("Enter the service required ( HotelRoomService (1) / Laundry (2) )");
					int a = in2.nextInt();

	    	// booking no
		    itr1 = (int)(no.charAt(0))-48;

		    // single or double
		    if(no.charAt(1)=='s')
		    	itr2= (int)(no.charAt(4))-48;
		    else
		    	itr2= (int)(no.charAt(3))-48;


		    if(a==1) {
		 			t[itr1][itr2][0].setDetails();
		 			b[cno].s1=b[cno].s1+(t[itr1][itr2][0].getTotalCost());
		 			b[cno].BookDisplay(b[cno].ff,c[cno].name,b[cno].s1,b[cno].s2,no);
		    }

		    if(a==2) {
		    	l[itr1][itr2][1].setDetails();
		    	b[cno].s2=b[cno].s2+l[itr1][itr2][1].getTotalCost();
		    	b[cno].BookDisplay(b[cno].ff,c[cno].name,b[cno].s1,b[cno].s2,no);
			}
	  }

		  if(ch=='e')
		    break;
		}
	}
}
