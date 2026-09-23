package org.example.csc311_gui_basics;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class mainPageController {

    @FXML
    private ListView<String> educationListView;

    @FXML
    private ToggleButton educationSwitchButton;

    @FXML
    private ImageView educationImageView;

    @FXML
    private Button educationPreviousButton;

    @FXML
    private Button educationNextButton;

    @FXML
    private ListView<String> currentPositionListView;

    @FXML
    private ListView<String> previousPositionListView;

    @FXML
    private ListView<String> previousJobListView;

    private boolean showingCollege = true;

    private final String[] collegeInfo = {
            "Farmingdale State College",
            "Major: Computer Programming and Information Systems",
            "Minor: Business Analytics",
            "Goal: Data Analytics Certification"
    };

    private final String[] highSchoolInfo = {
            "Central Islip High School",
            "Graduated in the Top 10% of my class",
            "Honor Roll",
            "Honors Society",
            "President, Science Technology Entry Program (STEP) Club",
            "STEP Club sponsored by NYIT",
            "Computer Science Ambassador for Young Women - Code.org",
            "Long Island's Extraordinary Seniors - Newsday"
    };

    @FXML
    public void initialize() {

        loadCollegeInfo();

        currentPositionListView.getItems().addAll(
                "IT Help Desk Analyst",
                "Zwanger Pesiri Radiology"
        );

        previousPositionListView.getItems().addAll(
                "Scheduler",
                "Zwanger Pesiri Radiology",
                "Duration: 1 year"
        );

        previousJobListView.getItems().addAll(
                "Team Member",
                "Chick-fil-A",
                "Duration: 2 years"
        );

        educationSwitchButton.setOnAction(event -> switchEducation());

        educationPreviousButton.setOnAction(event -> previousEducationImage());

        educationNextButton.setOnAction(event -> nextEducationImage());
    }

    private void loadCollegeInfo() {
        educationListView.getItems().setAll(collegeInfo);
        educationSwitchButton.setText("High School");
        showingCollege = true;
    }

    private void loadHighSchoolInfo() {
        educationListView.getItems().setAll(highSchoolInfo);
        educationSwitchButton.setText("College");
        showingCollege = false;
    }

    private void switchEducation() {
        if (showingCollege) {
            loadHighSchoolInfo();
        } else {
            loadCollegeInfo();
        }
    }

    private void previousEducationImage() {
        // Education image navigation will be added when images are provided.
    }

    private void nextEducationImage() {
        // Education image navigation will be added when images are provided.
    }
}