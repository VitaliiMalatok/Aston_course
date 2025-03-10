package com.gmail.vitali.malatok;

import com.gmail.vitali.malatok.service.RunTaskService;
import com.gmail.vitali.malatok.service.RunTaskServiceImpl;

public class Main {
    public static void main(String[] args) {
        RunTaskService runTask = new RunTaskServiceImpl();
        runTask.runTaskService();
    }
}