import java.util.*;

public class UI
{

	private ArrayList<Program> programs;
	private ArrayList<Course> courses;
	private Scanner input;
	private FileIO f = new FileIO();

	public UI()
	{
		boolean quit = false;
		int selection;
		input = new Scanner(System.in);
		//programs = new ArrayList<Program>();
		//courses = new ArrayList<Course>();

		System.out.println("Welcome to the program management system");
		programs = f.fileProgramLoad();
		courses = f.fileCourseLoad();

		//Run the main menu until the users quits the application
		while(!quit)
		{
			//Main menu
			System.out.println("\nPlease Enter your selection from the following:\n");
			System.out.println("1: List all programs");
			System.out.println("2: Add a program");
			System.out.println("3: Edit a program");
			System.out.println("4: Quit the application\n");

			selection = input.nextInt();

			//Go to option user selected
			switch(selection)
			{
				case 1: listPrograms();
						break;
				case 2: try {
					addProgram();
				} catch (Exception e) {
					System.out.println("Adding program was canceled.");
				}
						break;
				case 3: try {
					editProgram();
				} catch (Exception e) {
					System.out.println("Editing program was canceled.");
				}
						break;
				case 4:
					System.out.println("Checking for program save ...");
					if (f.exitCheck("programSave")) {
						f.fileProgramSave(programs);
					} else {
									System.out.println("Do you want to overwrite your current program save? (Y/N) ");
									input = new Scanner(System.in);
									String overwrite = input.nextLine().toUpperCase();
									if (overwrite.equals("Y")) {
													f.fileProgramSave(programs);
									}
					}
					System.out.println("Checking for course save ...");
					if (f.exitCheck("courseSave")) {
						f.fileCourseSave(courses);
					} else {
									System.out.println("Do you want to overwrite your current course save? (Y/N) ");
									input = new Scanner(System.in);
									String overwrite = input.nextLine().toUpperCase();
									if (overwrite.equals("Y")) {
													f.fileCourseSave(courses);
									}
					}
					quit = true;
						break;
				default: System.out.println("Invalid selection");
						break;
			}
		}
	}

	//Display information about all programs
	public void listPrograms()
	{
		//Notify users if no programs exist
		if(programs.size() == 0)
			System.out.println("\nNo programs added yet");

		//Display all programs
		for(Program p: programs)
			p.displayProgram();
	}

	//Add a new program
	public void addProgram() throws Exception
	{
		String userInput;
		Program program = new Program();

		//Get ID for program
		System.out.println("\nEnter the ID of the program");
		input.nextLine();
		userInput = input.nextLine();
		userInput=Checks.ValidID(userInput, programs);
		if(userInput==null) {
			throw new Exception();
		}
		program.setProgramID(userInput);

		//Get Title for program
		System.out.println("\nEnter the title of the program");
		userInput = input.nextLine();
		userInput=Checks.ValidTitle(userInput, programs);
		if(userInput==null) {
			throw new Exception();
		}
		program.setProgramTitle(userInput);

		//Get description for program
		System.out.println("\nEnter the description of the program");
		userInput = input.nextLine();
		program.setProgramDesc(userInput);

		//Get departments program is a part of
		System.out.println("\nEnter the departments that the program belongs to separated by commas");
		userInput = input.nextLine();
		String[] departments = userInput.split(", ");
		for (String s: departments)
			program.addDepartment(s);

		//Get electives for program
		System.out.println("\nEnter the elective courses that the program offers separated by commas");
		userInput = input.nextLine();
		String[] electives = userInput.split(", ");
		for (String s: electives)
			program.add_Elective(s);

		//Get required courses for program
		System.out.println("\nEnter the required courses of the program separated by commas");
		userInput = input.nextLine();
		String[] requiredCourses = userInput.split(", ");
		for (String s: requiredCourses)
			program.addRequiredCourses(s);

		//Add the program into the list of programs
		programs.add(program);

		System.out.println("\nProgram entered succesfully");
	}

	//Edit a program
	public void editProgram() throws Exception
	{
		int selection;
		String programToEdit;
		Program currentProgram = null;
		String userInput;
		boolean main = false;

		input.nextLine();

		while(true)
		{
			System.out.println("\nPlease enter the title or ID of the course you wish to modify\n");

			programToEdit = input.nextLine();

			//Check if the program exists
			for (Program p: programs)
			{
				//System.out.println(p.getProgramID());
				//System.out.println(p.getProgramTitle());

				if (p.getProgramTitle().equals(programToEdit))
					currentProgram = p;
				else if (p.getProgramID().equals(programToEdit))
					currentProgram = p;
			}

			//Move on if valid program has been specified, otherwise let user know that no such program exists
			if (currentProgram != null)
				break;
			else
			{
				System.out.println("\nNo such program found");
				main = true;
				break;
			}
		}

		if (main == false)
			{
			System.out.println("\nPlease select what you would like to do with this program");

			//Options for editing a program
			System.out.println("1. Change the program ID");
			System.out.println("2. Change the program Title");
			System.out.println("3. Change the program Description");
			System.out.println("4. Add the program to a department");
			System.out.println("5. Remove the program from a department");
			System.out.println("6. Add an elective course to the program");
			System.out.println("7. Remove an elective course from the program");
			System.out.println("8. Add a required course to the program");
			System.out.println("9. Remove a required course from the program");
			System.out.println("0. Delete the program entirely\n");

			selection = input.nextInt();
			input.nextLine();

			//Perform user choice of editing
			switch (selection)
			{
				//Change ID
				case 1: System.out.println("\nEnter a new ID\n");
						userInput = input.nextLine();
						userInput=Checks.ValidID(userInput, programs);
						if(userInput==null) {
							System.out.println("Adding program was canceled.");
							throw new Exception();
						}
						currentProgram.setProgramID(userInput);
						break;
				//Change Title
				case 2: System.out.println("\nEnter a new Title\n");
						userInput = input.nextLine();
						System.out.println("\nEnter the title of the program");
						userInput = input.nextLine();
						userInput=Checks.ValidTitle(userInput, programs);
						if(userInput==null) {
							throw new Exception();
						}
						currentProgram.setProgramTitle(userInput);
						break;
				//Change Description
				case 3: System.out.println("\nEnter a new Description\n");
						userInput = input.nextLine();
						currentProgram.setProgramDesc(userInput);
						break;
				//Add department
				case 4: System.out.println("\nEnter the new department\n");
						userInput = input.nextLine();
						currentProgram.addDepartment(userInput);
						break;
				//Remove department
				case 5: System.out.println("\nEnter the department to remove the program from\n");
						userInput = input.nextLine();
						currentProgram.removeDepartment(userInput);
						break;
				//Add elective
				case 6: System.out.println("\nEnter the new elective\n");
						userInput = input.nextLine();
						currentProgram.add_Elective(userInput);
						break;
				//Remove elective
				case 7: System.out.println("\nEnter the elective to remove\n");
						userInput = input.nextLine();
						currentProgram.remove_Elective(userInput);
						break;
				//Add required course
				case 8: System.out.println("\nEnter the new required course\n");
						userInput = input.nextLine();
						currentProgram.addRequiredCourses(userInput);
						break;
				//Remove required course
				case 9: System.out.println("\nEnter the required course to remove\n");
						userInput = input.nextLine();
						currentProgram.removeRequiredCourses(userInput);
						break;
				//Remove course entirely
				case 0: programs.remove(currentProgram);
						System.out.println("\nProgram removed");
						break;
				default: System.out.println("\nInvalid selection");
			}
		}

	}
}
