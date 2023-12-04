package com.interface_adapter.leave_review;

import com.use_case.leave_review.ReviewOutputBoundary;
import com.use_case.leave_review.ReviewOutputData;
import com.view.Building.BuildingPageServlet;

public class ReviewPresenter implements ReviewOutputBoundary {

    BuildingPageServlet buildingPageServlet;
    public ReviewPresenter(BuildingPageServlet buildingPageServlet)
    {
        this.buildingPageServlet = buildingPageServlet;
    }

    @Override
    public void prepareSuccessView(ReviewOutputData outputData) {
        try {
            buildingPageServlet.updateAfterReview(outputData.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
