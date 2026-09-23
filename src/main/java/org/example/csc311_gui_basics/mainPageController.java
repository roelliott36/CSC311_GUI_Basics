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
    private int educationImageIndex = 0;

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

    private final String[] collegeImages = {
            "/images/farmingdaleLogo.jpg"
    };

    private final String[] highSchoolImages = {
            "/images/ciLogo.png",
            "/images/stepLogo.jpg",
            "/images/codeorgLogo.jpg",
            "/images/newsday.png"
    };

    @FXML
    public void initialize() {

        educationSwitchButton.setOnAction(event -> switchEducation());

        educationPreviousButton.setOnAction(event -> previousEducationImage());

        educationNextButton.setOnAction(event -> nextEducationImage());

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

        loadCollegeInfo();
    }

    private void loadCollegeInfo() {

        showingCollege = true;
        educationImageIndex = 0;

        educationListView.getItems().setAll(collegeInfo);
        educationSwitchButton.setText("High School");

        educationPreviousButton.setVisible(false);
        educationNextButton.setVisible(false);

        showEducationImage();
    }

    private void loadHighSchoolInfo() {

        showingCollege = false;
        educationImageIndex = 0;

        educationListView.getItems().setAll(highSchoolInfo);
        educationSwitchButton.setText("College");

        educationPreviousButton.setVisible(true);
        educationNextButton.setVisible(true);

        showEducationImage();
    }

    private void switchEducation() {

        if (showingCollege) {
            loadHighSchoolInfo();
        } else {
            loadCollegeInfo();
        }
    }

    private void previousEducationImage() {

        String[] images;

        if (showingCollege) {
            images = collegeImages;
        } else {
            images = highSchoolImages;
        }

        educationImageIndex--;

        if (educationImageIndex < 0) {
            educationImageIndex = images.length - 1;
        }

        showEducationImage();
    }

    private void nextEducationImage() {

        String[] images;

        if (showingCollege) {
            images = collegeImages;
        } else {
            images = highSchoolImages;
        }

        educationImageIndex++;

        if (educationImageIndex >= images.length) {
            educationImageIndex = 0;
        }

        showEducationImage();
    }

    private void showEducationImage() {

        String[] images;

        if (showingCollege) {
            images = collegeImages;
        } else {
            images = highSchoolImages;
        }

        Image image = new Image(
                getClass().getResource(images[educationImageIndex]).toExternalForm()
        );

        educationImageView.setImage(image);
    }
}
