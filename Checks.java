import java.util.ArrayList;

import javax.swing.*;  
public class Checks {

	public static String ValidID(String userInput, ArrayList<Program> programs) {
		boolean valid =true;
		String msg="";
		if(userInput == null) {
			return null;
		}
		if(userInput.isEmpty()) {
			valid=false;
			msg="ID cannot be empty.";
		}
		else{
			for (Program p : programs) {
				if(p.getProgramID().equals(userInput)) {
					valid = false;
					msg="ID already used.";
					break;
				}
			}
		}
		if(valid) {
			return userInput;	
		}else {
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			userInput = JOptionPane.showInputDialog(frame, msg+" try again.");
		    
		    userInput=Checks.ValidID(userInput, programs);
			return userInput;
		}
	}

	public static String ValidTitle(String userInput, ArrayList<Program> programs) {
		boolean valid =true;
		String msg="";
		if(userInput == null) {
			return null;
		}
		if(userInput.isEmpty()) {
			valid=false;
			msg="Title cannot be empty.";
		}
		else{
			for (Program p : programs) {
				if(p.getProgramTitle().equals(userInput)) {
					valid = false;
					msg="Title already used.";
					break;
				}
			}
		}
		
		if(valid) {
			return userInput;	
		}else {
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			userInput = JOptionPane.showInputDialog(frame, msg+" try again.");
		    
		    userInput=Checks.ValidTitle(userInput, programs);
			return userInput;
		}
	}
	public static String ValidIDC(String userInput, ArrayList<Course> courses) {
		boolean valid =true;
		String msg="";
		if(userInput == null) {
			return null;
		}
		if(userInput.isEmpty()) {
			valid=false;
			msg="ID cannot be empty.";
		}
		else{
			for (Course c : courses) {
				if(c.get_id().equals(userInput)) {
					valid = false;
					msg="ID already used.";
					break;
				}
			}
		}
		if(valid) {
			return userInput;	
		}else {
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			userInput = JOptionPane.showInputDialog(frame, msg+" try again.");
		    
		    userInput=Checks.ValidIDC(userInput, courses);
			return userInput;
		}
	}

	public static String ValidTitleC(String userInput, ArrayList<Course> courses) {
		boolean valid =true;
		String msg="";
		if(userInput == null) {
			return null;
		}
		if(userInput.isEmpty()) {
			valid=false;
			msg="Title cannot be empty.";
		}
		else{
			for (Course c : courses) {
				if(c.get_title().equals(userInput)) {
					valid = false;
					msg="Title already used.";
					break;
				}
			}
		}
		
		if(valid) {
			return userInput;	
		}else {
			JFrame frame = new JFrame();
			frame.setAlwaysOnTop(true);
			userInput = JOptionPane.showInputDialog(frame, msg+" try again.");
		    
		    userInput=Checks.ValidTitleC(userInput, courses);
			return userInput;
		}
	}

	public static void canceled() {
		JOptionPane.showMessageDialog(null, "Process canceled.");
	}
}
