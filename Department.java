import java.util.ArrayList;

public class Department
{
	String name;
	ArrayList<Program> programs;
	
	public Department(String name)
	{
		this.name = name;
		programs = new ArrayList<Program>();
	}
	
	public void addProgram(Program p)
	{
		programs.add(p);
	}
	
	public void deleteProgram(Program p)
	{
		programs.remove(p);
	}
	
	public ArrayList<Program> getPrograms()
	{
		return programs;
	}
}