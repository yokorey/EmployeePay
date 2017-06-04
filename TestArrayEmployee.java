import java.util.Scanner;
public class TestArrayEmployee
{
	public static void main( String[] args)
	{
		Employee [] emps= new Employee[5];
	
		for(int i = 0; i <2; i++)
		{			
			emps[i] = new Employee();
			emps[i].readPInfo();
			emps[i].readPayInfo();
			System.out.print("\n");
		}
		for(int i = 0;i<2;i++)
		{
			System.out.print("\n");
			emps[i].printPInfo();
			emps[i].printPayInfo();
			
		}
	}
}
class Employee
{
	private String firstName;
	private String lastName;

	private int idNumber;
	private Date birthDay;
	private Date dateHired;
	private double basePay;
	public double inTax;
	public double computeTax;
	
	int m,d,y;
	public Employee()
	{
		firstName = " ";
		lastName = " ";
		idNumber = 999999;
		birthDay = new Date(1,1,1960);
		dateHired = new Date(1,1,2011);
		basePay = 0.00;
	}
	public Employee(String fname, String lname, int id, Date bday, Date hired, double bpay)
	{
		firstName = fname;
		lastName = lname;
		idNumber = id;
		birthDay = bday;
		dateHired = hired;
		basePay = bpay;
	}
	
	
	void printPInfo()
	{
		System.out.print(" First Name: " + firstName + "\n Last Name:" + lastName+ "\n ID Number: "+ idNumber + "\nBirthday:");
		birthDay.outputDate();
		System.out.print("Date Hired: ");
		dateHired.outputDate();
	}
	void readPInfo()
	{
	Scanner input = new Scanner(System.in);
	System.out.println("\n Enter First Name");
	firstName = input.next();
	System.out.println("\n Enter Last Name");
	lastName = input.next();
	System.out.println("\n Enter ID Number");
	idNumber = input.nextInt();
	System.out.println("\n Enter Birthday (month day year(1234))");
	m = input.nextInt();
	d = input.nextInt();
	y = input.nextInt();
	birthDay = new Date(m,d,y);
	System.out.println("\n Enter Date of hire(month day year(1234))");
	
	
	m = input.nextInt();
	d = input.nextInt();
	y = input.nextInt();
	dateHired = new Date(m,d,y);
	}
	void readPayInfo()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter base pay");
		basePay = input.nextInt();
	
	}
	double getBpay()
	{
		return(basePay);
	}
	double getGpay()
	{
		double GrossPay = basePay;
		return (GrossPay);
	}
	double computeTax()
	{
		if(basePay >= 1000)
			{
			inTax =  .2;
			}
		else if(800<= basePay && basePay < 1000)
			{
				inTax= .18;
			}
		else if ( 600<= basePay && basePay < 800)
			{
				inTax = basePay * .15;
			}
		else if (basePay<600)
			{
				inTax = basePay *.1;
			}
		return(inTax);
	}
	void printPayInfo()
	{
		getBpay();
		getGpay();
		computeTax();
		System.out.println("gross pay: "+ basePay +"\ntax deduction: "+ inTax+"\nnet pay: " +(basePay - (basePay*inTax)));
	}
}
class Date
{
	private int month;
	private int day;
	private int year;
	Scanner input = new Scanner(System.in);
	private void checkDate()
	{	
		final int daysPerMonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if( (month< 1) || (month> 12) ||(day< 1)|| ( day > daysPerMonth[ month ])||(year < 1960)||(year>2015) )
		{
			System.out.println("Invalid Text: "+month+"/"+day+"/"+year);
			System.exit(1);
		}
	}
	public Date()
	{
		month = 1;
		day = 1;
		year = 1960;
	}
	public Date(int newMonth,int newDay, int newYear)
	{
		month = newMonth;
		day = newDay;
		year = newYear;
		checkDate();	
	}
	public void inputDate( )
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Input the date");
		month= input.nextInt();
		day= input.nextInt();
		year= input.nextInt();
		checkDate();
	}
	public void outputDate()
	{
		System.out.println( month + "/" + day + "/" + year);	
	}
	public boolean isEqualTo( Date obj)
	{
		return( month == obj.month && day == obj.day && year == obj.year);
	}
	public int getMonth()
	{
		return ( month);
	}
	public int getDay()
	{
		return( day);
	}
	public int getYear()
	{
		return( year);
	}
	public boolean isGreaterThan( Date obj1, Date obj2)
	{  
		if(obj1.year > obj2.year)
   		{
       			return true;
   		}
   		else if(obj1.year==obj2.year && obj1.month>obj2.month)
   		{
   			return true;
   		}
  		else if(obj1.year==obj2.year && obj1.month==obj2.month && obj1.day>obj2.day)
   		{
       			return true;
   		}
   		else
			return false;
	}
}
	