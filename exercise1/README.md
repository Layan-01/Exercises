MiniShell Project Report

1. General Description of the Project
-------------------------------------
This project is a small Java application that works like a command line (Terminal).
The user can write commands like:
pwd, mkdir, ls, cd, touch, help, exit
The program understands the commands and gives results directly, using the real file system on the computer.

The goals of this project are:
1. Use Object-Oriented Programming (OOP): use classes, objects, variables, and methods.
2. Work with files and folders using `java.io.File`.
3. Build an interactive user interface using `Scanner` and loops.
4. Add comments in the code and research how Java works with files.
5. Learn how to use Git and GitHub and upload the project with technical documentation.

* Why we used `java.io.File`
---------------------------
In this project, we used the `java.io.File` class because:

- It is part of Java’s **standard library**, so no extra setup or libraries are needed.  
- It allows us to interact with the **real file system** easily: create files, create folders, check if they exist, list contents, and more.  
- The methods in `File` are **simple and clear**, which makes it great for learning and small terminal-based projects.  
- While newer APIs like `java.nio.file` exist, `File` is more than enough for the commands we wanted to support, like `mkdir`, `touch`, and `ls`.

Using `java.io.File` helped us focus on learning logic, file operations, and object-oriented programming — without getting lost in complex syntax.

2. How to Compile and Run the Project
-------------------------------------
1. Make sure Java Development Kit (JDK) is installed on your computer.
2. Open the terminal (CMD or PowerShell).
3. Go to the project folder using the `cd` command.
4. Then write these commands:

    javac src/*.java
    java src.MiniShell

3. Example of Running Commands
------------------------------
Welcome to MiniShell! Type 'help' for a list of commands.

C:/Users/student/Desktop/MiniShell > pwd
C:/Users/student/Desktop/MiniShell

C:/Users/student/Desktop/MiniShell > mkdir test
Directory created: [test]

C:/Users/student/Desktop/MiniShell > cd test

C:/Users/student/Desktop/MiniShell/test > touch file.txt
File created: [file.txt]

C:/Users/student/Desktop/MiniShell/test > ls
[FILE] file.txt

C:/Users/student/Desktop/MiniShell/test > cd ..
C:/Users/student/Desktop/MiniShell > ls
[DIR]  test

C:/Users/student/Desktop/MiniShell > cd notexist
Directory not found: [notexist]

C:/Users/student/Desktop/MiniShell > help
Supported commands :
pwd             - Show current directory path
ls              - List contents of the current directory
cd [dir]        - Change to directory (.. to go back)
mkdir [dir]     - Create a new directory
touch [file]    - Create a new file
help            - Show this help message
exit            - Exit the shell

4. Comments in the Code Explain Each Method
-------------------------------------------
Inside the file `ShellCommandHandler.java`, there are clear comments explaining what each method does:

// Shows the full path of the current folder
public void printWorkingDirectory() {
    System.out.println(currentDirectory.getAbsolutePath());
}

// Lists the contents of the current folder (files and folders)
public void listDirectory() {
    // ...
}

// Changes the current folder to a new one or ".." to go back
public void changeDirectory(String name) {
    // ...
}

// Creates a new folder inside the current folder
public void makeDirectory(String name) {
    // ...
}

// Creates a new file inside the current folder
public void createFile(String name) {
    // ...
}

// Prints all available commands with a description
public void printHelp() {
    // ...
}
