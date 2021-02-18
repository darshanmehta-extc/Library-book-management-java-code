import java.util.*;
class Publication
{	protected String title,e;
	protected float price;
	protected int copies;
	public void saleCopy()
	{	System.out.println(title+"\t"+price+"\t"+e+"\t"+copies);
	}
}
class Book extends Publication
{	private String author;
	Scanner sc=new Scanner(System.in);
	public void orderCopies()
	{	System.out.print("Enter title,author,edition,price and number of copies:");
		title=sc.nextLine();
		author=sc.nextLine();
		e=sc.nextLine();
		price=sc.nextFloat();
		copies=sc.nextInt();
		System.out.println("-> Book ordered successfully!");
	} 
}
class Magazine extends Publication
{	int c;
	Scanner sc=new Scanner(System.in);
	public void orderQty()
	{	System.out.print("Enter title, price and copies:");
		title=sc.nextLine();
		price=sc.nextFloat();
		copies=sc.nextInt();
		System.out.println("Order:\n1.Current issue\n2.Other issue\nEnter your choice:");
		c=sc.nextInt();
		if (c==1) currentIssue();
		if(c==2) recieveIssue(); 
	}
	public void currentIssue()
	{	System.out.println("-> Current issue ordered succesfully!");
		e="Current";
	}
	public void recieveIssue()
	{	int i;
		System.out.print("Enter issue number: ");
		e=sc.next();
		System.out.println("->Issue No."+e+" ordered succesfully!");
	}
}
public class Test
{	public static void main(String arg[])
	{	int i=0,j=0,n=0,c=0,k=0;
		float t=0;
		Scanner sc=new Scanner(System.in);
		Book b[]=new Book[100];
		Magazine m[]=new Magazine[100]; 
		do{
			System.out.print("1.Order Book\n2.Order magazine\n3.Display Order\n4.Display sales of Publication\n5.Exit\nEnter your choice:");
			i=sc.nextInt();
			switch(i)
			{	case 1:System.out.print("Enter number of books to be ordered: ");
					n=sc.nextInt();
					for(j=0;j<=n-1;j++)
					{	b[j]=new Book();
						b[j].orderCopies();
						k=k+b[j].copies;
						t=t+b[j].copies*b[j].price;
					}
					break;
				case 2:System.out.print("Enter number of magazines to be ordered: ");
					c=sc.nextInt();
					for(j=0;j<=c-1;j++)
					{	m[j]=new Magazine();
						m[j].orderQty();
						k=k+m[j].copies;
						t=t+m[j].copies*m[j].price;
					}
					break;
				case 3:System.out.println("Title\tPrice\tEdition/Issue\tCopies");
					for(j=0;j<=c-1;j++)
					{	m[j].saleCopy();
					}
					for(j=0;j<=n-1;j++)
					{	b[j].saleCopy();
					}
					break;
				case 4:	System.out.println("Total sales:\nBooks\tRS.\n"+k+"\t INR "+t);
					break;
				case 5:break;
				default:System.out.println("Invalid Choice");
			}
		}while(i!=5);
	}
}