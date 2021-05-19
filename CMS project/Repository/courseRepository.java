package Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import models.CourseModel;

public class courseRepository {
    
    private String path = "Data\\course.txt";
    private File data;

    public courseRepository()
    {
        CreateOrCheckFile();
        data = new File(path);
    }

    private void CreateOrCheckFile()
    {
        try {
            File myData = new File(path);
            if (myData.exists()) {
            System.out.println("File already exists.");
            } else {
            myData.createNewFile();
            System.out.println("File created successfuly");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void WriteToFile(String courseName, String courseText)
    {
        try {
            Files.write(Paths.get(path),(courseName + "-" + courseText + "\n").getBytes(),StandardOpenOption.APPEND);

          } catch (IOException err) {
            System.out.println("An error occurred while trying to write in file.");
            err.printStackTrace();
          }

    }

    public List GetAll()
    {
        List courses = new ArrayList<CourseModel>();
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				String[] tempStr = line.split("-");
                courses.add(new CourseModel(tempStr[0],tempStr[1]));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return courses;
    }



}
