package com.gmail.vitali.malatok;

import com.gmail.vitali.malatok.service.Impl.RunFirstTaskServiceImpl;
import com.gmail.vitali.malatok.service.Impl.RunSecondTaskServiceImpl;
import com.gmail.vitali.malatok.service.RunFirstTaskService;
import com.gmail.vitali.malatok.service.RunSecondTaskService;

public class Main {
    public static void main(String[] args) {
        RunFirstTaskService runFirstTaskService = new RunFirstTaskServiceImpl();
        RunSecondTaskService runSecondTaskService = new RunSecondTaskServiceImpl();
        runFirstTaskService.runFirstTask();
        runSecondTaskService.runSecondTask();
    }
}