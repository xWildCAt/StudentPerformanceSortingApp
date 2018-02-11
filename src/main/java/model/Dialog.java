package model;

import javafx.scene.control.Alert;

public class Dialog {


    public static void showError(String errorTitle, String errorHeader, String errorText) {
        if (errorTitle.equals("")) errorTitle = "Error!";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(errorTitle);
        alert.setHeaderText(errorHeader);
        alert.setContentText(errorText);
        alert.showAndWait();
    }

    public static void showInfo(String infoTitle, String infoText){
        if(infoTitle.equals("")) infoTitle="Info";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(infoTitle);
        alert.setHeaderText(null);
        alert.setContentText(infoText);

        alert.showAndWait();

    }


}
