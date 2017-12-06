package com.techobbyist.HouseHold;

import java.util.LinkedList;

/**
 * Created by Ramzy on 2017-11-26.
 */

public class Task {
    String tname;
    String pname;
    String deadline;
    String requiredItems;
    String note;

    public Task(){
        tname="";
        pname="";
        deadline="";
        requiredItems=new String();
        note="";
    }

    public Task(String tname,String pname,String deadline,String requiredItems,String note){
        this.pname=tname;
        this.pname=pname;
        this.deadline=deadline;
        this.requiredItems=requiredItems;
        this.note=note;
    }

    public String gettaskName(){
        return tname;
    }
    public String getpersonName(){
        return pname;
    }
    public String getDeadline(){
        return deadline;
    }
    public String getRequiredItems(){
        return requiredItems;
    }
    public String getNote(){
        return note;
    }

    void setTaskName(String tname){
        this.tname=tname;

    }
    void setPersonName(String pname){
        this.pname=pname;

    }
    void setDeadline(String deadline){
        this.deadline=deadline;

    }

    void setRequiredItems(String requiredItems){
        this.requiredItems=requiredItems;

    }

    void setNote(String note){
        this.note=note;

    }

    boolean deleteTask(){
        tname=null;
        pname=null;
        deadline=null;
        requiredItems=null;
        note=null;
        return true;
    }
}

