package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private static ArrayList<Module> modules = new ArrayList<>();

    public static void main(String[] args) {
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


}

