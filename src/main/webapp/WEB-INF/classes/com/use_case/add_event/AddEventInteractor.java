package com.use_case.add_event;

import java.util.Date;

public class AddEventInteractor implements AddEventInputBoundary {
    private AddEventOutputBoundary presenter;
    private AddEventDataAccessInterface dao;
    public AddEventInteractor(AddEventOutputBoundary presenter, AddEventDataAccessInterface dao) {
        this.presenter = presenter;
        this.dao = dao;
    }

    public void execute(AddEventInputData inputData) {
        // get information from inputData
        String buildingCode = inputData.getBuildingCode();
        String title = inputData.getTitle();
        String organizer = inputData.getOrganizer();
        String room = inputData.getRoom();
        Date time = inputData.getTime();
        String description = inputData.getDescription();

        // call dao to add event to the json files
        dao.addEvent(buildingCode, title, organizer, room, time, description);

        // send back to presenter.
        AddEventOutputData outputData = new AddEventOutputData();
        presenter.execute(outputData);
    }
}
