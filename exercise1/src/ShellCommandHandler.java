import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        // TODO: Initialize currentDirectory to the user's current working directory
        // Hint: Use System.getProperty("user.dir")
        currentDirectory = new File (System.getProperty("user.dir") );
    }

    public void printWorkingDirectory() {
        // TODO: Print the absolute path of the current directory
        // This function is gonna print the path like: PS C:\Users\layan\Desktop>
        System.out.println(currentDirectory.getAbsolutePath());
    }

    public void listDirectory() {
        File[] files = currentDirectory.listFiles();
        if(files==null||files.length == 0){
            System.out.println("The directory is empty or cannot be read.");
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[DIR]  " + file.getName());
            } else if (file.isFile()) {
                System.out.println("[FILE] " + file.getName());
            } else {
                System.out.println("[UNKNOWN] " + file.getName());
            }
        }
        // TODO: List all files and directories in the current directory
        // For directories, prefix with "[DIR] "
        // For files, prefix with "[FILE]"
    }

    public void changeDirectory(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Usage: cd [directory_name]");
            return;
        }

        File changeDir;

        if (name.equals("..")) {
            changeDir = currentDirectory.getParentFile();
            if (changeDir == null) {
                System.out.println("No parent directory.");
                return;
            }
        } else {
            changeDir = new File(currentDirectory, name);
        }

        if (changeDir.exists() && changeDir.isDirectory()) {
            currentDirectory = changeDir;
        } else {
            System.out.println("Directory not found: [" + name + "]");

        }

        // TODO: Implement the change directory command
        // If name is null, show usage message: "Usage: cd [directory_name]"
        // If name is "..", move to parent directory if possible
        // Otherwise, try to move to the specified directory
        // If directory doesn't exist, print error message: "Directory not found: [name]"
    }

    public void makeDirectory(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }

        File newDirectory = new File(currentDirectory, name);

        if (newDirectory.exists()) {
            System.out.println("Directory already exists.");
            return;
        }

        if (newDirectory.mkdir()) {
            System.out.println("Directory created: [" + name + "]");
        } else {
            System.out.println("Failed to create directory.");
        }

        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        // If directory already exists, print: "Directory already exists."
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
    }

    public void createFile(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Usage: touch [file_name]");
            return;
        }

        File newFile = new File(currentDirectory, name);

        if (newFile.exists()) {
            System.out.println("File already exists.");
            return;
        }

        try {
            if (newFile.createNewFile()) {
                System.out.println("File created: [" + name + "]");
            } else {
                System.out.println("Failed to create file.");
            }
        } catch (IOException excep) {
            System.out.println("Error creating file: " + excep.getMessage());
        }
        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        // If file already exists, print: "File already exists."
        // If file creation is successful, print: "File created: [name]"
        // If file creation fails, print error message with exception details
    }

    public void printHelp() {

        System.out.println("Supported commands : ");
        System.out.println("pwd             - Show current directory path");
        System.out.println("ls              - list contents of the current directory");
        System.out.println("cd [dir]        - Change to directory (.. to go back)");
        System.out.println("mkdir [dir]     - Create a new directory");
        System.out.println("touch [file]    - Create a new file");
        System.out.println("help            - Show this help message");
        System.out.println("exit            - Exit the shell");


        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions
    }

    public File getCurrentDirectory() {
        // TODO: Return the current directory
        return currentDirectory; // Replace this with your implementation
    }
}
