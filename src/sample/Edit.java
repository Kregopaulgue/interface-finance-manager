package sample;

import Exceptions.WrongImportanceInputException;
import Exceptions.WrongMoneyInputException;
import ExpenceEntries.*;
import HelperTypes.ExpenceEntryType;
import HelperTypes.FoodType;
import HelperTypes.TechnicType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;
import XMLLibrary.DateHelper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.*;
import javafx.stage.Stage;

import javax.xml.bind.TypeConstraintException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Master on 05.12.2017.
 */
public class Edit implements Initializable{

    public static OtherExpenceEntry entryToEdit;
    public static OtherExpenceEntry entryToAdd;

    @FXML TextArea descriptionField;
    @FXML TextField moneySpentTextField, importanceTextField;
    @FXML ChoiceBox expenceEntryComboBox;

    @FXML ChoiceBox specificationComboBox;

    @FXML Button sendButton, cancelButton, getSpecific;

    @FXML DatePicker datePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        expenceEntryComboBox.setItems(FXCollections.observableArrayList(
                ExpenceEntryType.FOOD, ExpenceEntryType.CLOTH, ExpenceEntryType.SERVICE, ExpenceEntryType.BILL,
                ExpenceEntryType.TECHNIC, ExpenceEntryType.ENTERTAINMENT, ExpenceEntryType.OTHER));
    }

    @FXML public void setSpecification(ActionEvent event) {
        specificationComboBox.getItems().clear();
        ExpenceEntryType expenceTypeDescription = (ExpenceEntryType)expenceEntryComboBox.getSelectionModel().getSelectedItem();
        switch(expenceTypeDescription.toString()) {
            case "FOOD":
                specificationComboBox.setItems(FXCollections.observableArrayList(
                    FoodType.MAIN_FOOD, FoodType.WATER, FoodType.SWEETS, FoodType.UNIMPORTANT_FOOD, FoodType.OTHER)
                );
                break;
            case "TECHNIC":
                specificationComboBox.setItems(FXCollections.observableArrayList(
                    TechnicType.APPLIANCE, TechnicType.AUDIO_SYSTEM, TechnicType.COMPUTER, TechnicType.GAMING_HARDWARE, TechnicType.HARDWARE,
                        TechnicType.OTHER)
                );
                break;
            default:
                specificationComboBox.setItems(FXCollections.observableArrayList("Write what u want in description", "Really"));
                break;
        }
    }

    @FXML public void createEntry(ActionEvent event) {
        entryToAdd = new OtherExpenceEntry();

        OtherExpenceEntry newEntry = new OtherExpenceEntry();

        Double allMoneySpent = 0.0;
        Integer importance = -1;

        try {
                allMoneySpent = Double.valueOf(moneySpentTextField.getText());
                importance = Integer.valueOf(importanceTextField.getText());
                if(allMoneySpent <= 0) {
                    throw new WrongMoneyInputException();
                }

                if(importance < 0 || importance > 10) {
                    throw new WrongImportanceInputException();
                }
        } catch (WrongMoneyInputException | WrongImportanceInputException | NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            if(e instanceof NumberFormatException) {
                alert.setHeaderText("Wrong data input");
            } else {
                alert.setHeaderText(e.toString());
            }
            alert.showAndWait();
            Stage stage = (Stage) sendButton.getScene().getWindow();
            stage.close();
        }

        String comment = descriptionField.getText();
        LocalDate date = datePicker.getValue();
        ExpenceEntryType expenceTypeDescription =
                (ExpenceEntryType)expenceEntryComboBox.getSelectionModel().getSelectedItem();
        String specialTypeDescription = specificationComboBox.getSelectionModel().getSelectedItem().toString();

        OtherExpenceEntry returnedEntry = new OtherExpenceEntry();
        try {
            switch(expenceTypeDescription.toString()) {
                case "FOOD":
                    returnedEntry = new FoodExpenceEntry(allMoneySpent, importance,
                            comment, date, FoodType.valueOf(specialTypeDescription), specialTypeDescription);
                    break;
                case "TECHNIC":
                    returnedEntry = new TechnicExpenceEntry(allMoneySpent, importance,
                            comment, date, TechnicType.valueOf(specialTypeDescription), specialTypeDescription);
                    break;
                case "CLOTH":
                    returnedEntry = new ClothExpenceEntry(allMoneySpent, importance,
                            comment, date, specialTypeDescription);
                    break;
                case "ENTERTAINMENT":
                    returnedEntry = new EntertainmentExpenceEntry(allMoneySpent, importance,
                            comment, date, specialTypeDescription);
                case "BILL":
                    returnedEntry = new BillExpenceEntry(allMoneySpent, importance,
                            comment, date, specialTypeDescription);
                case "SERVICE":
                    returnedEntry = new ServiceExpenceEntry(allMoneySpent, importance,
                            comment, date, specialTypeDescription);
                case "OTHER":
                    returnedEntry = new OtherExpenceEntry(allMoneySpent, importance,
                            comment, date, specialTypeDescription);
            }
        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Some field is not fulfilled");
            alert.showAndWait();
            Stage stage = (Stage) sendButton.getScene().getWindow();
            stage.close();
        }
        this.entryToAdd = returnedEntry;
        Stage stage = (Stage) sendButton.getScene().getWindow();
        stage.close();
    }

}
