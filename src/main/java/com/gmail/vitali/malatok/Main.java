package com.gmail.vitali.malatok;

import com.gmail.vitali.malatok.service.Impl.RunTaskServiceImpl;
import com.gmail.vitali.malatok.service.RunTaskService;

public class Main {
    public static void main(String[] args) {
        RunTaskService runTaskService = new RunTaskServiceImpl();
        runTaskService.runTask();
    }
}