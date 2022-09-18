package abc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

//Abstract class
abstract class User{
	//protected
	protected String Id;
	protected String password;
	protected String username;
	protected String EmailId;
	protected String address;
	public void User(String name,String password) {
		this.username= name;
		this.password = password;
	}
	public void Check_login() {
		
	}

	public void Register(int custarr, String name, String pass) {
		
	}
	 
}
//Iheritance class diagram

class Customer extends User{
	public String customer_name;
	public String customer_Id;
	public String phone;
	protected String cpassword;
	public Customer(String username,String customer_name,String customer_id,String ph,String cpassword,
			String EmailId,String address) {
		this.username=username;
		this.address=address;
		this.cpassword=cpassword;
		this.customer_Id=customer_id;
		this.customer_name=customer_name;
		this.EmailId=EmailId;
		this.phone=ph;
	}
	
public void Register(int custarr,String username,String cpassword) {
		customer_Id="C"+custarr;
		String choice;
		int i=0;
		Scanner scan1=new Scanner(System.in);
		System.out.println("Welcome to the #");
		System.out.println("Do you want to Fill up ur account details Y/N");
		choice=scan1.next();
		while(i==0)
		{
		if(choice=="Y"||choice=="y") {
			System.out.println("Enter your name: ");
			this.customer_name=scan1.next();
			System.out.println("Enter your Address: ");
			this.address=scan1.next();
			System.out.println("Enter your EmailId: ");
			this.EmailId=scan1.next();
			System.out.println("Enter your Phoone Number: ");
			this.phone=scan1.next();
			i=1;
		}
		else if(choice=="N"||choice=="n") {
			i=1;
		}
		else
		{
			System.out.println("Please enter Y/N");
		}
		
		}
	}
	
	
	public boolean Check_login(String inputus, String inpass) {
		if(this.username==inputus&&this.cpassword==inpass)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public void Check_login() {
		System.out.println("Welcome "+this.customer_name);
	}
}

//inheritance class diagram
class Admin extends User{
	public String admin_Id;
	public String admin_name;
	public String admin_password;
	public String access_code;
	public Admin(String username, String name, String id, String passw, String code) {
		this.username=username;
		this.admin_name=name;
		this.admin_Id=id;
		this.admin_password=passw;
		this.access_code=code;
	}
	public void Service() {
		   
	}
}

class ProductList{
	//Arraylist
	public ArrayList<product> prdtt= new ArrayList<product>();
	public int prdt_no;
	public String sizes_available; 
	public double rating;
	public ProductList(ArrayList<product> pr) {
		prdtt = new ArrayList<product>(pr);
	}

	
	
	public void filter() {
		
		
	}
	public void sort() {
		
	}

}

//Comparable Interface
class product implements Comparable<product>{
	public String prdt_name;
	public int prdt_id;
	public String prdt_size;
	public int price;
	
	public void carting() {
		
	}

	public product(int item_no, String item_name, String item_size, int item_price) {
		this.prdt_id=item_no;
		this.prdt_name=item_name;
		this.prdt_size=item_size;
		this.price=item_price;
		
	}
	public int getprice() {
		return price;
	}

	@Override public String toString()
    {
        return "name:"+this.prdt_name+" "+"price: "+this.price;
    }
	
	@Override
	public int compareTo(product ppd) {
		int compareage
        = ((product)ppd).getprice();

    //  For Ascending order
    return this.price - compareage;
	}

}

class StockList {
	public int item_no;
	public String item_name;
	public String item_type;
	public char item_gender;
	public String item_size;
	public int no_of_items;
	public int item_price;
	public StockList(int i, String string, String string2, char c, String string3, int j, int d) {
		this.item_no=i;
		this.item_type=string2;
		this.item_name=string;
		this.item_gender=c;
		this.item_size=string3;
		this.no_of_items=j;
		this.item_price=d;
		
	}

}

class cart {
	public int price;
	public int cart_id;
	public int cart_quantity;
	public int prdt_quantity;
	public String size;
	public void insert(int price2, int prdt_id) {
		price=price2;
		cart_id=prdt_id;
	}
	public void modify() {
		
	}
	public void buy() {
		
	}

}
//inheritance
class bill extends cart implements buyingPortal {
	public int bill_id;
	public float bill_amount;
	public String name;
	public int quant;
@Override
public int voucher(int total,String redeem) {
	int tot=0;
	if(redeem.equals("abcdef")||redeem.equals("abcdefg")) {
		tot=total-(total/10);//10%
		System.out.println("Redeemed 10% ("+total/10+") of the Total price!!");
	}
	
	if(redeem.equals("wxyz")||redeem.equals("xyz")) {
		tot=total-(total/5);//20%
		System.out.println("Redeemed 20% ("+total/5+") of the Total price!!");
	}
		
	
	return tot;	
}

public void buy(int i) {
	this.bill_id=i;
	System.out.println("Bill Id: "+bill_id);
	System.out.println("Product Name: "+name);
	System.out.println("Quantity: "+quant);
	System.out.println("Price: "+bill_amount*quant);
	
}
public void insertbill(int price, String cname, int prdt_id, int cid) {
	// TODO Auto-generated method stub
	this.bill_amount=price;
	this.cart_id=prdt_id;
	this.name=cname;
	this.quant=cid;
}

}

//Interface
interface buyingPortal {
	public int voucher(int total, String redeem) ;
	

}

//Dependency class
class payment {
String payment_type;

public void addUPI(upi upi) {
	
	if(upi.ok==1) {
		System.out.println("UPI Payment successful and Order is placed");
	}
}

public void addcard(card card) {
	if(card.ok==1) {
		System.out.println("CARD Payment successful and order is placed");
	}
}

}

//getter and setter
class upi {
private String upi_address;
int ok;
public void setadd(String add) {
	this.upi_address=add;
}
public String getok() {
	return upi_address;
}
public void check(String addr) {
	setadd(addr);
if (getok()!=null) {
	ok=1;
}}
}

//private
class card {
private String cardno;
private String cvv;
int ok;
public void setno(String add) {
	this.cardno=add;
}
public void setcvv(String add) {
	this.cvv=add;
}

public String getok1() {
	return cardno;
}
public String getok2() {
	return cvv;
}
public void check(String card,String cvv) {
	setno(card);
	setcvv(cvv);
if (getok1()!=null&&getok2()!=null) {
	ok=1;
}}


}

class orders {
String cust_id;
int order_id;
int quant;
String delivery_date;
public void insorders(String o,int cid, int quant2) {
	cust_id = o;
	order_id = cid;
	quant=quant2;
}
}







public class project {
	public static void main(String[] args) {
		
		
		
		
		int start=0;
		while(start==0) {
		int custarr=4,adminarr=3;
		String custId = null;
		
		
		
		Customer[] cust= new Customer[7];
		//File handling
		//Exception
		File hello = new File("cust.txt");///reading from the text file///
		Scanner custreader;
		try {
			custreader = new Scanner(hello);
			String ax,bx,cx,dx,ex,fx,gx;
			int index=0;
		while(custreader.hasNext())
		{
			ax=custreader.nextLine();
			bx=custreader.nextLine();
			cx=custreader.nextLine();
			dx=custreader.nextLine();
			ex=custreader.nextLine();
			fx=custreader.nextLine();
			gx=custreader.nextLine();
			
			cust[index]=new Customer(ax,bx,cx,dx,ex,fx,gx);
			index=index+1;
		}
		custreader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		/*PrintStream writer;
		try {
			writer = new PrintStream(new FileOutputStream("cust.txt"));
			int index=0;
			while(index<cust.length)
			{
				if(cust[index]!=null)
				{
					writer.println(cust[index].username);
					writer.println(cust[index].customer_name);
					writer.println(cust[index].customer_Id);
					writer.println(cust[index].phone);
					writer.println(cust[index].cpassword);
					writer.println(cust[index].EmailId);
					writer.println(cust[index].address);
				}
				index=index+1;
			}
			writer.close();*/
		
				
		
		
		Admin[] admin= new Admin[4];
		admin[0]=new Admin("admin1","Ashok","a0","ashok123","access@123");
		admin[1]=new Admin("admin2","Pritham","a1","pri1942","access@234");
		admin[2]=new Admin("addoff03","Vignesh","a2","ragu12viggy","access@345");
		admin[3]=new Admin("addoff04","Sidharth","a3","sidd123","access@456");
		ArrayList<StockList> stockad = new ArrayList<StockList>();
		int stocktot=20;
		StockList b=new StockList(0,"Desert Sun Solid Full Sleeve Shirt","Shirts",'M',"123",3,799);//1-S,2-M,3-L,4-XL
		stockad.add(b);
		StockList b01=new StockList(1,"Printed Mandarin Collar Full Shirt","Shirts",'M',"123",3,599);
		stockad.add(b01);
		StockList b2=new StockList(2,"Modern Noise Red Checks Shirts","Shirts",'M',"123",3,999);
		stockad.add(b2);
		StockList b3=new StockList(3,"Black Solid Half Sleeve Shirt","Shirts",'M',"123",3,599);
		stockad.add(b3);
		StockList b4=new StockList(4,"Blue Regular Fit Jeans","Pants",'M',"123",3,1099);
		stockad.add(b4);
		StockList b5=new StockList(5,"Olive Solid Joggers","Pants",'M',"123",3,899);
		stockad.add(b5);
		StockList b6=new StockList(6,"Dusty Blue Twill Chino","Pants",'M',"123",3,1299);
		stockad.add(b6);
		StockList b7=new StockList(7,"Cloud Cream Chino","Pants",'M',"123",3,1299);
		stockad.add(b7);
		StockList b8=new StockList(8,"'Black AOP Half Street wear T-shirt","T-Shirts",'M',"123",3,599);
		stockad.add(b8);
		StockList b9=new StockList(9,"'Never Mind Stripe Half Sleeve T-shirt","T-Shirts",'M',"123",3,799);
		stockad.add(b9);
		StockList b10=new StockList(10,"Make Tracks T-shirt","T-Shirts",'M',"123",3,799);
		stockad.add(b10);
		StockList b11=new StockList(11,"Iron Man of War T-Shirt","T-Shirts",'M',"123",3,499);
		stockad.add(b11);
		StockList b12=new StockList(12,"India Ink Raw Hem Shorts","Shorts",'M',"123",3,799);
		stockad.add(b12);
		StockList b13=new StockList(13,"Killer Brown Color Block Shorts","Shorts",'M',"123",3,649);
		stockad.add(b13);
		StockList b14=new StockList(14,"White Pride Side Color Binding Shorts","Shorts",'M',"123",3,749);
		stockad.add(b14);
		StockList b15=new StockList(15,"Indigo Chino Shorts","Shorts",'M',"123",3,849);
		stockad.add(b15);
		StockList b16=new StockList(16,"Twice As Pretty Sweater Top","Shirts",'F',"123",3,2499);
		stockad.add(b16);
		StockList b17=new StockList(17,"Green Flaunt Your Style Top","Shirts",'F',"123",3,1599);
		stockad.add(b17);
		StockList b18=new StockList(18,"Red Look At You Cute Sweater","Shirts",'F',"123",3,2299);
		stockad.add(b18);
		StockList b19=new StockList(19,"Green Look At You Cute Sweater Top","Shirts",'F',"123",3,3199);
		stockad.add(b19);
		StockList b20=new StockList(20,"Black Solid Flared Jeans","Pants",'F',"123",3,1499);
		stockad.add(b20);
		StockList b21=new StockList(21,"Women Brown Solid Flared Jeans","Pants",'F',"123",3,1299);
		stockad.add(b21);
		StockList b22=new StockList(22,"Blue Solid Flared Jeans","Pants",'F',"123",3,999);
		stockad.add(b22);
		StockList b23=new StockList(23,"Women Brown Solid Flared Jeans","Pants",'F',"123",3,1399);
		stockad.add(b23);
		StockList b24=new StockList(24,"Choose Colors That Never Fade Dress","T-Shirts",'F',"123",3,1099);
		stockad.add(b24);
		StockList b25=new StockList(25,"Happy Days Like These Dress","T-Shirts",'F',"123",3,659);
		stockad.add(b25);
		StockList b26=new StockList(26,"Red Look At You Cute t-shirt","T-Shirts",'F',"123",3,899);
		stockad.add(b26);
		StockList b27=new StockList(27,"'Green Look At You Cute t-shirt","T-Shirts",'F',"123",3,999);
		stockad.add(b27);
		StockList b28=new StockList(28,"Super sport sports","Shorts",'F',"123",3,1299);
		stockad.add(b28);
		StockList b29=new StockList(29,"Slim fit beige shorts","Shorts",'F',"123",3,659);
		stockad.add(b29);
		StockList b30=new StockList(30,"Jean style shorts","Shorts",'F',"123",3,799);
		stockad.add(b30);
		StockList b31=new StockList(31,"thug fit shots","Shorts",'F',"123",3,899);
		stockad.add(b31);
		int stockint=19;
		//final keyword
		final int pdtlist=7;
		ProductList[] prdt=new ProductList[8];
		ArrayList<product> pr= new ArrayList<product>();

		int x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Shirts")&&stockad.get(j).item_gender=='M') {
					x=x+1;
					product pr1=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr1);
					
				}
			}
			prdt[0]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Pants")&&stockad.get(j).item_gender=='M') {
					x=x+1;
					product pr2=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr2);
					
				}
			}
			prdt[1]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("T-Shirts")&&stockad.get(j).item_gender=='M') {
					x=x+1;
					product pr3=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr3);
					
				}
			}
			prdt[2]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Shorts")&&stockad.get(j).item_gender=='M') {
					x=x+1;
					product pr4=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr4);
					
				}
			}
			prdt[3]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Shirts")&&stockad.get(j).item_gender=='F') {
					x=x+1;
					product pr5=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr5);
					
				}
			}
			prdt[4]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Pants")&&stockad.get(j).item_gender=='F') {
					x=x+1;
					product pr6=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr6);
					
				}
			}
			prdt[5]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("T-Shirts")&&stockad.get(j).item_gender=='F') {
					x=x+1;
					product pr7=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr7);
					
				}
			}
			prdt[6]=new ProductList(pr);
			pr.clear();
			x=-1;
			for(int j=0;j<stockad.size();j++) {
				if(stockad.get(j).item_type.equals("Shorts")&&stockad.get(j).item_gender=='F') {
					x=x+1;
					product pr8=new product(stockad.get(j).item_no,stockad.get(j).item_name,stockad.get(j).item_size,stockad.get(j).item_price);
					pr.add(pr8);
					
				}
			}
			prdt[7]=new ProductList(pr);
			pr.clear();
		
		
		ArrayList<cart> carts = new ArrayList<cart>();
		ArrayList<bill> bills = new ArrayList<bill>();
		ArrayList<orders> orders= new ArrayList<orders>();
		ArrayList<Integer> no= new ArrayList<Integer>();
		ArrayList<Integer> sno= new ArrayList<Integer>();
		Scanner scan=new Scanner(System.in);
		
		int xyz=0;
	
		while(xyz==0)
		
{
			
			int login=0;
		System.out.println("Welcome to the website");
		System.out.println("1. Login 2. SignUp");
		int loging = scan.nextInt();
		carts.clear();
        bills.clear();
		if(loging==1||loging==2) {
			
			
			
		while(login==0)
		{
		
		if(loging==1) {
			System.out.println("Username: ");
			String name=scan.next();
			System.out.println("Password: ");
			String pass=scan.next();
			for(int i=0;i<=custarr;i++)
			{
				
				if(cust[i].username.equals(name)&&cust[i].cpassword.equals(pass))
				{
					System.out.println("+++ Welcome "+cust[i].customer_name+" +++");
					custId=cust[i].customer_Id;
					
					login=3;
					break;
				}
				else {
					
					
				}
			}
			if(login==0)
			{
				System.out.println("Wrong Credentials");
				System.out.println("Do you want to try again(y/n)?");
				char choice=scan.next().charAt(0);
				if(choice=='n'||choice=='N')
				{
					System.exit(0);
				}
			}
		}
		else if(loging==2){
			System.out.println("Username: ");
			String name=scan.next();
			String pass=null;
			int passno=1;
			while(passno==1)
			{
			System.out.println("Password: ");
			pass=scan.next();
			System.out.println("Confirm password: ");
			String passcheck=scan.next();
			if(pass.equals(passcheck))
			{
				passno=0;
			}
			else {
				System.out.println("Enter the password again");
			}
			
			}
			custarr+=1;
			
			//cust[custarr].customer_Id="C"+custarr;
			System.out.println("Enter your Mobile number");
			String ph=scan.next();
			System.out.println("Enter Your name");
			String cname=scan.next();
			System.out.println("Enter Your Email ID");
			String email=scan.next();
			System.out.println("Enter your Address");
			String add=scan.next();
			cust[custarr]=new Customer(name,cname,"c"+custarr,ph,pass,email,add);
			custId=cust[custarr].customer_Id;
			System.out.println("Welcome "+cust[custarr].customer_name);
			login=2;			
			
			
			
		}
		else {
			System.out.println("Enter No 1 or 2");
		}
		
		}
		
		int menuno=0,genno=0,finalno=0,checkno=0,loopcheck=0,menuchoose=0;
		
		System.out.println("Please select from the given menu:");
		superouter:
		while(menuno==0)
		{
			genno=0;
			finalno=0;
			checkno=0;
			
				System.out.println("1. Product List");
				System.out.println("2. Cart");
				System.out.println("3. Orders");
				System.out.println("4. Logout");
				menuchoose=scan.nextInt();

				
			outer:
		
		if(menuchoose==1)
		{
			System.out.println("Which section you want to cruise into?(1/2)");
			while(genno==0)
			{int catno=0,prno=0;
				System.out.println("1. Male");
				System.out.println("2. Female");
				System.out.println("3. Back");
				int genchoose=scan.nextInt();
				if(genchoose==1)
				{
					
					int close=0;
					while(close==0) {
					System.out.println("Choose from the Categories:(1/2/3/4)");
					System.out.println("1. Shirts");
					System.out.println("2. Pants");
					System.out.println("3. T-Shirts");
					System.out.println("4. Shorts");
					System.out.println("5. Back");
					int catchoose=scan.nextInt();
					if(catchoose==1) {///PANTS FOR MEN/// -1
						
						for(int i=0;i<prdt[0].prdtt.size();i++) {
							no.add(prdt[0].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[0].prdtt.get(i).prdt_name+" - "+prdt[0].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)//Price Filter
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[0].prdtt.size();i++)
							{
								if(prdt[0].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[0].prdtt.get(i).prdt_name+" - "+prdt[0].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {//SIZE sort
							pr = new ArrayList<product>(prdt[0].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[0].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {//Back
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[0].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[0].prdtt.size();l++)
										if(prdt[0].prdtt.get(l).prdt_id==ind)
											val=l;
							
								c1.insert(prdt[0].prdtt.get(val).price,prdt[0].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[0].prdtt.size();l++)
										if(prdt[1].prdtt.get(l).prdt_id==ind)
											val=l;
									c2.insert(prdt[0].prdtt.get(val).price,prdt[0].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
									
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
								
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
						
						
					}
					else if(catchoose==2) {	///PANTS FOR MEN/// -1
						
						for(int i=0;i<prdt[1].prdtt.size();i++) {
							no.add(prdt[1].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[1].prdtt.get(i).prdt_name+" - "+prdt[1].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)//Price Filter
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[1].prdtt.size();i++)
							{
								if(prdt[1].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[1].prdtt.get(i).prdt_name+" - "+prdt[1].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {//SIZE sort
							pr = new ArrayList<product>(prdt[1].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[1].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {//Back
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[1].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[1].prdtt.size();l++)
										if(prdt[1].prdtt.get(l).prdt_id==ind)
											val=l;
							
								c1.insert(prdt[1].prdtt.get(val).price,prdt[1].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[1].prdtt.size();l++)
										if(prdt[1].prdtt.get(l).prdt_id==ind)
											val=l;
									c2.insert(prdt[1].prdtt.get(val).price,prdt[1].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
									
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
								
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
						
						
					}
					else if(catchoose==3) {	///T-shirts for MEN///
						System.out.println("T-Shirts:");
						for(int i=0;i<prdt[2].prdtt.size();i++) {
							no.add(prdt[2].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[2].prdtt.get(i).prdt_name+" - "+prdt[2].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[2].prdtt.size();i++)
							{
								if(prdt[2].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[2].prdtt.get(i).prdt_name+" - "+prdt[2].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {
							pr = new ArrayList<product>(prdt[2].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[2].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[2].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[2].prdtt.size();l++)
										if(prdt[2].prdtt.get(l).prdt_id==ind)
											val=l;
								
								c1.insert(prdt[2].prdtt.get(val).price,prdt[2].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[2].prdtt.size();l++)
										if(prdt[2].prdtt.get(l).prdt_id==ind)
											val=l;
								
									c2.insert(prdt[2].prdtt.get(val).price,prdt[2].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
						
					}
					else if(catchoose==4) {///Shorts for men///
						System.out.println("Shorts");
						for(int i=0;i<prdt[3].prdtt.size();i++) {
							no.add(prdt[3].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[3].prdtt.get(i).prdt_name+" - "+prdt[3].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[3].prdtt.size();i++)
							{
								if(prdt[3].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[3].prdtt.get(i).prdt_name+" - "+prdt[3].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {
							pr = new ArrayList<product>(prdt[3].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[3].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {
						
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[3].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[3].prdtt.size();l++)
										if(prdt[3].prdtt.get(l).prdt_id==ind)
											val=l;
								
								c1.insert(prdt[3].prdtt.get(val).price,prdt[3].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[3].prdtt.size();l++)
										if(prdt[3].prdtt.get(l).prdt_id==ind)
											val=l;
								
									c2.insert(prdt[3].prdtt.get(val).price,prdt[3].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
						
					}
					else if(catchoose==5) {////Back////
						close=1;
					}
					else
					{
						System.out.println("Please enter numbers between 1 to 5");
					}
					}
					}
				
				else if(genchoose==2) {///WOMEN SECTION///
					int close=0;
					while(close==0) {
					System.out.println("choose from the Categories: ");
					System.out.println("1. Shirts");
					System.out.println("2. Pants");
					System.out.println("3. T-Shirts");
					System.out.println("4. Shorts");
					System.out.println("5. Back");
					int catchoose=scan.nextInt();
					if(catchoose==1) {
						System.out.println("Shirts:");////Women Shirts////
						for(int i=0;i<prdt[4].prdtt.size();i++) {
							no.add(prdt[4].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[4].prdtt.get(i).prdt_name+" - "+prdt[4].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[4].prdtt.size();i++)
							{
								if(prdt[4].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[4].prdtt.get(i).prdt_name+" - "+prdt[4].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {
							pr = new ArrayList<product>(prdt[4].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[4].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[4].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[4].prdtt.size();l++)
										if(prdt[4].prdtt.get(l).prdt_id==ind)
											val=l;
								
								c1.insert(prdt[4].prdtt.get(val).price,prdt[4].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[4].prdtt.size();l++)
										if(prdt[4].prdtt.get(l).prdt_id==ind)
											val=l;
								
									c2.insert(prdt[4].prdtt.get(val).price,prdt[4].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
						
					}
					else if(catchoose==2) {
						System.out.println("Pants:");////Women Pants////
						for(int i=0;i<prdt[5].prdtt.size();i++) {
							no.add(prdt[5].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[5].prdtt.get(i).prdt_name+" - "+prdt[5].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[5].prdtt.size();i++)
							{
								if(prdt[5].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[5].prdtt.get(i).prdt_name+" - "+prdt[5].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {
							pr = new ArrayList<product>(prdt[5].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[5].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[5].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[5].prdtt.size();l++)
										if(prdt[5].prdtt.get(l).prdt_id==ind)
											val=l;
								
								c1.insert(prdt[5].prdtt.get(val).price,prdt[5].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[5].prdtt.size();l++)
										if(prdt[5].prdtt.get(l).prdt_id==ind)
											val=l;
								
									c2.insert(prdt[5].prdtt.get(val).price,prdt[5].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
					}
					else if(catchoose==3) {
							System.out.println("T-Shirts:");
							for(int i=0;i<prdt[6].prdtt.size();i++) {
								no.add(prdt[6].prdtt.get(i).prdt_id);
								System.out.println(i+". "+prdt[6].prdtt.get(i).prdt_name+" - "+prdt[6].prdtt.get(i).price);
								checkno=0;
							}
							System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
							int aaa=scan.nextInt();
							if(aaa==1)
							{
								System.out.println("Enter max price:");
								int max=scan.nextInt();
								for(int i=0;i<prdt[6].prdtt.size();i++)
								{
									if(prdt[6].prdtt.get(i).price<max)
										System.out.println(i+". "+prdt[6].prdtt.get(i).prdt_name+" - "+prdt[6].prdtt.get(i).price);
									
									
								}
							}
							else if(aaa==2) {
								pr = new ArrayList<product>(prdt[6].prdtt);
								Collections.sort(pr);
								int q=-1;
								for (product str : pr) {
									q+=1;;
									sno.add(prdt[6].prdtt.get(q).prdt_id);
									System.out.println(q);
						            System.out.println(str);
						            checkno=1;
						        }
							}
							else if(aaa==3) {
								
							}
							else
							{
								System.out.println("Please enter digits 1 or 2");
							}
							System.out.println("Enter the digit of the product: ");
							prno=scan.nextInt();
							int ind=0,val=0;
							for(int i=0;i<prdt[6].prdtt.size();i++) {
								if(prno==i) {
									cart c1= new cart();
									cart c2= new cart();
									if(checkno==0) {
										ind=no.get(i);
										for(int l=0;l<prdt[6].prdtt.size();l++)
											if(prdt[6].prdtt.get(l).prdt_id==ind)
												val=l;
									
									c1.insert(prdt[6].prdtt.get(val).price,prdt[6].prdtt.get(val).prdt_id);
									carts.add(c1);}
									if(checkno==1) {
										ind=sno.get(i);
										for(int l=0;l<prdt[6].prdtt.size();l++)
											if(prdt[6].prdtt.get(l).prdt_id==ind)
												val=l;
									
										c2.insert(prdt[6].prdtt.get(val).price,prdt[6].prdtt.get(val).prdt_id);
										carts.add(c2);}
									System.out.println("The product number "+val+ " has been added to the cart.");
									System.out.println("Continue shopping (y/n)");
									char c =scan.next().charAt(0);
									if(c=='Y'||c=='y')
									{
										;
										
									}
									else if (c=='N'||c=='n')
									{
										loopcheck=1;
										break outer;
									}
								}
							}
							pr.clear();
							no.clear();
							sno.clear();
						}
					
					else if(catchoose==4) {
						System.out.println("Shorts:");
						for(int i=0;i<prdt[7].prdtt.size();i++) {
							no.add(prdt[7].prdtt.get(i).prdt_id);
							System.out.println(i+". "+prdt[7].prdtt.get(i).prdt_name+" - "+prdt[7].prdtt.get(i).price);
							checkno=0;
						}
						System.out.println("Do u want to 1. Filter(acc to price) 2. Sort(price) or 3.To continue");
						int aaa=scan.nextInt();
						if(aaa==1)
						{
							System.out.println("Enter max price:");
							int max=scan.nextInt();
							for(int i=0;i<prdt[7].prdtt.size();i++)
							{
								if(prdt[7].prdtt.get(i).price<max)
									System.out.println(i+". "+prdt[7].prdtt.get(i).prdt_name+" - "+prdt[7].prdtt.get(i).price);
								
								
							}
						}
						else if(aaa==2) {
							pr = new ArrayList<product>(prdt[7].prdtt);
							Collections.sort(pr);
							int q=-1;
							for (product str : pr) {
								q+=1;;
								sno.add(prdt[7].prdtt.get(q).prdt_id);
								System.out.println(q);
					            System.out.println(str);
					            checkno=1;
					        }
						}
						else if(aaa==3) {
							
						}
						else
						{
							System.out.println("Please enter digits 1 or 2");
						}
						System.out.println("Enter the digit of the product: ");
						prno=scan.nextInt();
						int ind=0,val=0;
						for(int i=0;i<prdt[7].prdtt.size();i++) {
							if(prno==i) {
								cart c1= new cart();
								cart c2= new cart();
								if(checkno==0) {
									ind=no.get(i);
									for(int l=0;l<prdt[7].prdtt.size();l++)
										if(prdt[7].prdtt.get(l).prdt_id==ind)
											val=l;
								
								c1.insert(prdt[7].prdtt.get(val).price,prdt[7].prdtt.get(val).prdt_id);
								carts.add(c1);}
								if(checkno==1) {
									ind=sno.get(i);
									for(int l=0;l<prdt[7].prdtt.size();l++)
										if(prdt[7].prdtt.get(l).prdt_id==ind)
											val=l;
								
									c2.insert(prdt[7].prdtt.get(val).price,prdt[7].prdtt.get(val).prdt_id);
									carts.add(c2);}
								System.out.println("The product number "+val+ " has been added to the cart.");
								System.out.println("Continue shopping (y/n)");
								char c =scan.next().charAt(0);
								if(c=='Y'||c=='y')
								{
									;
									
								}
								else if (c=='N'||c=='n')
								{
									loopcheck=1;
									break outer;
								}
							}
						}
						pr.clear();
						no.clear();
						sno.clear();
					}
					else if(catchoose==5) {
						close=1;
					}
					else {
						System.out.println("Please Choose between 1 to 5");
					}
					}
				}
				else if (genchoose==3)	{
					genno=1;
				}
				else{
					System.out.println("Please Choose between 1 to 3");
				}
			
			}
			
		}
		else if(menuchoose==2) {
			System.out.println("Cart quantity: "+carts.size());
			for(int i=0;i<carts.size();i++) {
				String cname = null;
				int cid=0;
				for(int j=0;j<pdtlist;j++){
				for(int k=0;k<prdt[j].prdtt.size();k++) {
					
					if(carts.get(i).cart_id==prdt[j].prdtt.get(k).prdt_id) {
						cname=prdt[j].prdtt.get(k).prdt_name;
						cid=carts.get(i).cart_id;
					}
				}
				
			}
				System.out.println(i+". "+cname+" "+carts.get(i).price);
				System.out.println("Quantity: ");
				int quant=scan.nextInt();
				carts.get(i).prdt_quantity=quant;
				System.out.println("Do you want this product to bill Y/N");
				String yn=scan.next();
				if(yn.equals("Y")||yn.equals("y")) {
					
				}
				else if(yn.equals("N")||yn.equals("n")) {
					carts.remove(i);
				}
				else {
					System.out.println("Please enter Y or N");
				}
				System.out.println("Do you want to add this item to the bill");
				String ynn=scan.next();
				if(ynn.equals("Y")||ynn.equals("y")) {
					bill b1= new bill();
					//new
					orders o1=new orders();
					o1.insorders(custId,cid,quant);
					orders.add(o1);
					b1.insertbill(carts.get(i).price,cname,cid,carts.get(i).prdt_quantity);
					bills.add(b1);
					
					
					
				}
				else if(ynn.equals("N")||ynn.equals("n")) {
					System.out.println("Not added");
				}
				else {
					System.out.println("Please enter Y or N");
				}
				
				}
			
			System.out.println("Your Bill");
			int total=0;
			for(int i=0;i<bills.size();i++) {
				bills.get(i).buy(i);
				total+=bills.get(i).bill_amount*bills.get(i).quant;
			}
			System.out.println("TOTAL PRICE: "+total);
			System.out.println("Choose from the below");
			
			
				System.out.println("1.BUY  2.voucher redeem");
				int get=scan.nextInt();
				if(get==1) {
					
				}else if(get==2) {
					System.out.println("Enter the redeem code");
					String redeem=scan.next();
					total=bills.get(0).voucher(total,redeem);
				}
			
			System.out.println("TOTAL PRICE: "+total);
		
		payment buy=new payment();
		System.out.println("Choose which mode of transaction you need:");
		System.out.println("1.UPI  2.CARD  3.COD");
		int payment=scan.nextInt();
		if(payment==1) {
			upi upi=new upi();
			System.out.println("Please enter the upi address");
			String upiaddress=scan.next();
			upi.check(upiaddress);
			buy.addUPI(upi);
		}else if(payment==2) {
			card card=new card();
			System.out.println("Please enter the card number");
			String cardno=scan.next();
			System.out.println("Please enter cvv number");
			String cvv=scan.next();
			card.check(cardno, cvv);
			buy.addcard(card);
		}
		else if(payment==3){
			System.out.println("order placed through COD");
		}
		else {
			System.out.println("Please enter between 1 to 3");
		}
		
		
		
		
		
		
		
		
		}
			
		
			
		else if(menuchoose==3) {////ORDERS////
			for(int i=0;i<orders.size();i++) {
				if(custId==orders.get(i).cust_id) {
					for(int j=0;j<pdtlist;j++){
						for(int k=0;k<prdt[j].prdtt.size();k++) {
							
							if(orders.get(i).order_id==prdt[j].prdtt.get(k).prdt_id) {
								System.out.println("Product name: "+prdt[j].prdtt.get(k).prdt_name);
								System.out.println("quant: "+ orders.get(i).quant);
							}
						}
				}
				
				
			}
			}
			{try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {} 
	        }
			
			
			
		}
		else if(menuchoose==4) {////Logout////
			menuno=1;
		}
		else {
			System.out.println("Please selct between 1 to 4");
		}
		
		
		}
		
		}//***********ADMIN PART***********
else if(loging==1234567890) {
			
			int adlogin=0;
			while(adlogin==0) {		
				int slogin=0;
			String adminId;
			while(slogin==0) {
				
				System.out.println("Username: ");
				String name=scan.next();
				System.out.println("Password: ");
				String pass=scan.next();
				for(int i=0;i<4;i++)
				{
					//System.out.println(admin[i].username+name);
					if(admin[i].username.equals(name)&&admin[i].admin_password.equals(pass))
					{
						System.out.println("Welcome "+admin[i].admin_name);
						adminId=admin[i].admin_Id;
						
						slogin=3;
						break;
					}
					else {
						
						
					}
				}
				if(slogin==0)
				System.out.println("Enter the details again");
				
			}
			int amenu1=0;
			while(amenu1==0) {
			System.out.println("Operations: ");
			System.out.println("1. View orders");
			System.out.println("2. Modify products");
			System.out.println("3. Check availability");
			System.out.println("4. Logout");
			System.out.println("5. Close Admin pannel");
			int achoose=scan.nextInt();
			if(achoose==1) {
				for(int i=0;i<orders.size();i++) {
					System.out.println("Customer ID"+"  "+"Product ID"+"  "+"quantity");
					System.out.println("\t"+orders.get(i).cust_id+"\t"+orders.get(i).order_id+"\t"+orders.get(i).quant);
					
				}
			}
			else if(achoose==2) {
				System.out.println("Enter the product ID to modify");
				int prdti=scan.nextInt();
				
				for(int j=0;j<pdtlist;j++){
					for(int k=0;k<prdt[j].prdtt.size();k++) {
						
						if(prdti==prdt[j].prdtt.get(k).prdt_id) {
							System.out.println("Product details: "+prdt[j].prdtt.get(k).prdt_name);
							System.out.println(prdt[j].prdtt.get(k).prdt_id);
							System.out.println(prdt[j].prdtt.get(k).price);
							System.out.println("What do you want to change 1.product name 2.product_price");
							int ch=scan.nextInt();
							if(ch==1) {
								System.out.println("Enter the name that is to be changed");
								String namec=scan.next();
								prdt[j].prdtt.get(k).prdt_name=namec;
							}else if(ch==2) {
								System.out.println("Enter the price that is to be changed");
								int pricea=scan.nextInt();
								prdt[j].prdtt.get(k).price=pricea;
							}
						}
					}
			}
			
			
			
			}
			else if(achoose==3) {
				System.out.println("Enter the product ID to search");
				int prdti=scan.nextInt();
				
				for(int j=0;j<pdtlist;j++){
					for(int k=0;k<prdt[j].prdtt.size();k++) {
						
						if(prdti==prdt[j].prdtt.get(k).prdt_id) {
							System.out.println("Product details: "+prdt[j].prdtt.get(k).prdt_name);
							System.out.println(prdt[j].prdtt.get(k).prdt_id);
							System.out.println(prdt[j].prdtt.get(k).price);
							System.out.println("Available");
							
						}else {
							
						}
					}
			}
				
			}
			else if(achoose==4) {
				amenu1=1;
				slogin=1;
			}
			else if(achoose==5) {
				amenu1=1;
				slogin=1;
				adlogin=1;
			}
			else if(achoose==6) {
				amenu1=1;
				slogin=1;
				adlogin=1;
				start=1;
			}
				
			}
			
			
			
		}
		
}
		
		
		
		
		
		
		
		

		}

	}
}
}
