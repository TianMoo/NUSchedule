package main.java;

public class Module {
    public String ModuleCode;
    public String TimeSlots;
    public int Priority;

    public Module() {

    }

    public Module(String ModuleCode, String TimeSlots, int priority){
        this.ModuleCode = ModuleCode;
        this.TimeSlots = TimeSlots;
        this.Priority = priority;
    }

    public String getModuleCode(){return this.ModuleCode;}
    public String getTimeSlots(){return this.TimeSlots;}
    public int getPriority(){return this.Priority;}
}
