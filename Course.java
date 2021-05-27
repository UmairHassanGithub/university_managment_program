import java.util.ArrayList;
import java.io.*;

public class Course implements Serializable {
	String title = "";
	String year = "";
	String descr = "";
	String id = "";
	private ArrayList<String> pre_req;
	private ArrayList<String> mutually_exclusive;

	public Course()
	{
		//maybe load stuff from a file?
		pre_req = new ArrayList<String>();
		mutually_exclusive = new ArrayList<String>();
	}	
	
	public void set_title(String title)
	{
		this.title = title;
	}

	public String get_title()
	{
		return this.title;
	}

	public void set_year(String year)
	{
		this.year = year;
	}

	public String get_year()
	{
		return this.year;
	}

	public void set_descr(String descr)
	{
		this.descr = descr;
	}

	public String get_descr()
	{
		return this.descr;
	}

	public void set_id(String id)
	{
		this.id = id;
	}

	public String get_id()
	{
		return this.id;
	}

	public void add_mutually_exclusive(String name)
	{
		mutually_exclusive.add(name);
	}

	public void list_mutually_exclusive()
	{
		//for now just displays on terminal
		if(mutually_exclusive.size()==0)
		{
			System.out.println("there are no electives");
		}

		else
		{
			for(int i=0;i<mutually_exclusive.size();i++)
			{
				System.out.println(mutually_exclusive.get(i));
			}
		}
	}

	public void remove_mutually_exclusive(String name)
	{
		if(mutually_exclusive.contains(name))
		{
			mutually_exclusive.remove(name);
		}
/*
		else
		{
			//should display a message on a window but for now its just outputs to terminal
			System.out.println("\nMutually_exclusive course "+name+" was not found.");
			System.out.println("Make sure you spelled it correctly.");
		}*/
		//save?
	}

	public ArrayList<String> get_mutually_exclusive()
	{
		return mutually_exclusive;
	}	
	
	public void add_pre_req(String name)
	{
		pre_req.add(name);
	}

	public void list_pre_req()
	{
		//for now just displays on terminal
		if(pre_req.size()==0)
		{
			System.out.println("there are no electives");
		}

		else
		{
			for(int i=0;i<pre_req.size();i++)
			{
				System.out.println(pre_req.get(i));
			}
		}
	}

	public void remove_pre_req(String name)
	{
		if(pre_req.contains(name))
		{
			pre_req.remove(name);
		}
/*
		else
		{
			//should display a message on a window but for now its just outputs to terminal
			System.out.println("\nPre-requisite "+name+" was not found.");
			System.out.println("Make sure you spelled it correctly.");
		}*/
		//save?
	}

	public ArrayList<String> get_pre_reqs()
	{
		return pre_req;
	}

	public void removeAllPreReqs(){
		pre_req.clear();
	}

	public void removeAllMutEx(){
		mutually_exclusive.clear();
	}

	
	public void displayCourse()
	{
		System.out.println("\nID: " + get_id());

		System.out.println("Year: " + get_year());

		System.out.println("Title: " + get_title());

		System.out.println("Description: " + get_descr());

		System.out.print("Mutually exclusive courses: " );
		for(String e: mutually_exclusive)
			System.out.print(e + ", ");
		System.out.println();

		System.out.print("Pre-requisite courses: " );
		for(String e: pre_req)
			System.out.print(e + ", ");
		System.out.println();
	}
}
