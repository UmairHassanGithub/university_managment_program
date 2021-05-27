import java.util.*;
import java.io.*;

public class FileIO {

  /** Method that saves the programs and courses to a file
    * @param p  ArrayList of Program object p
    */
  public void fileProgramSave(ArrayList<Program> p) {
    Scanner input = new Scanner(System.in);
    File saveProgram;
    boolean createOrLoadFile = false;

    String fileName = "programSave";
    do {
            saveProgram = new File(fileName + ".dat");
            try {
                    saveProgram.createNewFile();
                    createOrLoadFile = true;
                    System.out.println("File created. ");
            } catch (IOException e) {
                    createOrLoadFile = false;
                    System.out.println("File could not be created.");
                    System.err.println("IOException:	"+ e.getMessage());
            }
    } while (createOrLoadFile != true);

    try {
            FileOutputStream outClear = new FileOutputStream(saveProgram);
            outClear.write(("").getBytes());
            outClear.close();

            FileOutputStream out = new FileOutputStream(saveProgram);
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeObject(p);
            System.out.println("Program file saved. ");

            writer.close();

    } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
            System.out.println("Problem with input/output.");
            System.err.println("IOException: " + e.getMessage());
    }
  }

  /** Method that saves the programs and courses to a file
    * @param c  ArrayList of Courses object c
    */
  public void fileCourseSave(ArrayList<Course> c) {
    Scanner input = new Scanner(System.in);
    File saveCourse;
    boolean createOrLoadFile = false;

    String fileName = "courseSave";
    do {
            saveCourse = new File(fileName + ".dat");
            try {
                    saveCourse.createNewFile();
                    createOrLoadFile = true;
                    System.out.println("File created. ");
            } catch (IOException e) {
                    createOrLoadFile = false;
                    System.out.println("File could not be created.");
                    System.err.println("IOException:	"+ e.getMessage());
            }
    } while (createOrLoadFile != true);

    try {
            FileOutputStream outClear = new FileOutputStream(saveCourse);
            outClear.write(("").getBytes());
            outClear.close();

            FileOutputStream out = new FileOutputStream(saveCourse);
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeObject(c);
            System.out.println("Course file saved. ");

            writer.close();

    } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
            System.out.println("Problem with input/output.");
            System.err.println("IOException: " + e.getMessage());
    }
  }

  /** Method that loads programs from a file
    * @return  Arraylist for program
    */
  public ArrayList<Program> fileProgramLoad() {
          Scanner input = new Scanner(System.in);
          File load;
          boolean createOrLoadFile = false;

          String fileName = "programSave";
          do {
                  load = new File(fileName + ".dat");
                  if (load.exists()) {
                          try {
                                  FileInputStream in = new FileInputStream(load);
                                  ObjectInputStream reader = new ObjectInputStream(in);

                                  ArrayList<Program> loadedProgram = (ArrayList<Program>)reader.readObject();
                                  reader.close();
                                  System.out.println("Progams loaded.");
                                  return(loadedProgram);
                          } catch (FileNotFoundException e) {
                                  createOrLoadFile = false;
                                  System.out.println("Problem with input/output.");
                                  System.err.println("FileNotFoundException: " + e.getMessage());
                          } catch (IOException e) {
                                  createOrLoadFile = false;
                                  System.out.println("File could not be found.");
                                  System.err.println("IOException: " + e.getMessage());
                          } catch (ClassNotFoundException e) {
                                  createOrLoadFile = false;
                                  System.out.println("Class could not be used to cast object.");
                                  System.err.println("ClassNotFoundException: " + e.getMessage());
                          }
                  }
                  createOrLoadFile = true;
          } while (createOrLoadFile != true);
          return new ArrayList<Program>();
  }

  /** Method that loads courses from a file
    * @return  Arraylist for courses
    */
  public ArrayList<Course> fileCourseLoad() {
          Scanner input = new Scanner(System.in);
          File load;
          boolean createOrLoadFile = false;

          String fileName = "courseSave";
          do {
                  load = new File(fileName + ".dat");
                  if (load.exists()) {
                          try {
                                  FileInputStream in = new FileInputStream(load);
                                  ObjectInputStream reader = new ObjectInputStream(in);

                                  ArrayList<Course> loadedCourse = (ArrayList<Course>)reader.readObject();
                                  reader.close();
                                  System.out.println("Courses loaded.");
                                  return(loadedCourse);
                          } catch (FileNotFoundException e) {
                                  createOrLoadFile = false;
                                  System.out.println("Problem with input/output.");
                                  System.err.println("FileNotFoundException: " + e.getMessage());
                          } catch (IOException e) {
                                  createOrLoadFile = false;
                                  System.out.println("File could not be found.");
                                  System.err.println("IOException: " + e.getMessage());
                          } catch (ClassNotFoundException e) {
                                  createOrLoadFile = false;
                                  System.out.println("Class could not be used to cast object.");
                                  System.err.println("ClassNotFoundException: " + e.getMessage());
                          }
                  }
                  createOrLoadFile = true;
          } while (createOrLoadFile != true);
          return new ArrayList<Course>();
  }

  /** Checks whether save files exists or not
    * @return boolean if it exists or not
    */
  public boolean exitCheck(String s) {
          Scanner input = new Scanner(System.in);
          File save;
          save = new File(s + ".dat");

          if(save.exists()) {
                  return false;
          }
          return true;
  }


}
