package main.java;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private static ArrayList<Module> modules = new ArrayList<>();

    public static void main(String[] args) {
        File moduleSave = new File("C:\\Users\\Public\\Documents\\NUSchedule\\moduleSave.txt");
        try {
            if (moduleSave.createNewFile()){
                System.out.println("Your chosen modules will be saved at " + moduleSave.getPath());
            } else {
                System.out.println("Loading your saved modules saved at " + moduleSave.getPath());

                Scanner Reader = new Scanner(moduleSave);
                while (Reader.hasNextLine()){
                    String md = Reader.nextLine();
                    String[] InfoOfMd = md.split(" ");
                    String ModuleCode = InfoOfMd[0];
                    String PreferredTime = InfoOfMd[1];
                    int Priority = Integer.parseInt(InfoOfMd[2]);
                    AddModule(ModuleCode, PreferredTime, Priority);
                }
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }



        Scanner scan = new Scanner(System.in);

        System.out.print("Hello! What can I do for ya?\n");

        while (true) {

            String chooseFunction = scan.nextLine().toLowerCase();

            if (chooseFunction.equals("list")) {
                ModuleCheck();

            } else if (chooseFunction.equals("add module")) {
                System.out.println("What module would you like to add?");
                System.out.println("Module Code:");
                String ModuleCode = scan.nextLine();
                System.out.println("Preferred Time Slot:");
                String PreferredTime = scan.nextLine();
                System.out.println("Priority:");
                int Priority = Integer.parseInt(scan.nextLine());
                AddModule(ModuleCode, PreferredTime, Priority);
                System.out.print( ModuleCode + " is successfully added.\n");

            } else if (chooseFunction.equals("delete module")) {
                boolean isDeleted = false;
                ModuleCheck();
                System.out.println("Which Module would you like to delete?");
                String ModuleCode = scan.nextLine();
                isDeleted = DeleteModule(ModuleCode);
                if (isDeleted) System.out.println("Successfully deleted!");

             } else if (chooseFunction.equals("bye")) {
                System.out.print("Thank you for using! Bye-bye.\n");
                return;

            } else if (chooseFunction.equals("save")){
                if(SaveModule(moduleSave)){
                    System.out.println("Your modules has been saved.");
                }else {
                    System.out.println("An error occurred when saving.");
                }

            } else {
                System.out.print("I don't understand what you're saying.\n");
            }
            System.out.print("What else can I do for ya?\n");
        }
    }



    public static void ModuleCheck(){
        System.out.println("Here are the modules you added.");
        for (int i = 0; i < modules.size(); i++){
            System.out.println(modules.get(i).getModuleCode());
        }
    }

    public static void AddModule(String ModuleCode, String PreferredTime, int Priority) {
        Module md = new Module(ModuleCode, PreferredTime, Priority);
        modules.add(md);
    }

    public static boolean DeleteModule(String ModuleCode) {
        Module md = new Module();
        boolean found = false;
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getModuleCode().equals(ModuleCode)) {
                md = modules.get(i);
                found = true;
            }
        }
        if (found) {
            modules.remove(md);
            return true;
        } else {
            System.out.println( ModuleCode + " is not found!");
            return false;
        }
    }

    public static boolean SaveModule(File moduleSave) {
        try{
            FileWriter fileWriter = new FileWriter(moduleSave);
            for (int i = 0; i < modules.size(); i++) {
                String ModuleCode = modules.get(i).getModuleCode();
                String TimeSlots = modules.get(i).getTimeSlots();
                String Priority = Integer.toString(modules.get(i).getPriority());
                fileWriter.write(ModuleCode + " " + TimeSlots + " " + Priority + "\n");
            }

            fileWriter.close();
            return true;

        } catch(IOException e) {
            return false;
        }
    }
}

