package Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import models.UserModel;

public class dataRepository {
    
    private String path = "Data\\data.txt";
    private File data;

    public dataRepository()
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

    public void WriteToFile(String userText, String pass, String  choice)
    {
        try {
            Files.write(Paths.get("Data\\data.txt"),(userText + "-" + pass + "-"+ choice + "\n").getBytes(),StandardOpenOption.APPEND);

          } catch (IOException err) {
            System.out.println("An error occurred while trying to write in file.");
            err.printStackTrace();
          }

    }

    private UserModel[] GetAll()
    {
        UserModel[] users = new UserModel[0];
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
            int lines = 0;
            while (reader.readLine() != null) lines++;
            users = new UserModel[lines];
            lines=0;
			while (line != null) {
				String[] tempStr = line.split("-");
                users[lines]= new UserModel(tempStr[0],tempStr[1],tempStr[2]);
                lines++;
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return users;
    }

    public boolean CheckCredentials(String username, String password)
    {
        UserModel[] users = GetAll();

        for (UserModel us : users) {
            if(us.GetUsername().equals(username) && us.GetPass().equals(password))
            {
                return true;
            }
        }

        return false;
    }

}
