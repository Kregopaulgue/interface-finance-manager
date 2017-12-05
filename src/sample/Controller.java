package sample;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import Generated.OtherExpenceEntriesType;
import Generated.TotalTimeType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalWeekEntries;
import XMLLibrary.XMLReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.reflect.generics.tree.Tree;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{

    private TotalTimeType totalXMLTime;
    private ArrayList<TotalMonthEntries> totalTimeLoadedIn;

    private TotalMonthEntries selectedMonthEntry;
    private TotalWeekEntries selectedWeekEntry;
    private TotalDayEntries selectedDayEntry;
    private OtherExpenceEntry selectedEntry;
    private CombinedOtherExpenceEntry selectedCombinedEntry;

    @FXML TreeView <Object> timeTreeView;

    @FXML MenuBar headerMenu;

    @FXML Menu fileMenu, editMenu, aboutMenu;

    @FXML MenuItem fileOpen, fileClose, fileSave, fileSaveAs;
    @FXML MenuItem editAddEntry, editAddCombinedEntry, editAddCurrentDay,
            editAddCurrentWeek, editAddCurrentMonth, editDeleteSelected;
    @FXML MenuItem helpHowToUse, helpCredits;

    @FXML TextArea infoTextArea;

    @FXML public void doOpen(ActionEvent event) {
        FileChooser fileChooser = getFileChooser("Open XML-file:");
        File file;
        if((file = fileChooser.showOpenDialog(null)) != null) {
            try {
                this.totalTimeLoadedIn = XMLReader.readAllFromXml(file.getAbsolutePath());
            }
            catch (IOException e) {
                System.out.println("File not found");
            }
            catch (JAXBException e) {
                System.out.println("Wrong file format");
            }
        }
        TreeItem<Object> rootItem = new TreeItem<Object> ("Total Time: ");
        rootItem.setExpanded(true);
        for (TotalMonthEntries tempMonth : this.totalTimeLoadedIn) {
            TreeItem<Object> item = new TreeItem<Object> (tempMonth.getEndDate().getMonth());
            item.setExpanded(true);
            for(TotalWeekEntries tempWeek : tempMonth.getAllWeekEntriesInMonth()) {
                TreeItem<Object> weekItem = new TreeItem<>(tempWeek.getBeggingDate().toString()
                        + tempWeek.getEndDate().toString());
                weekItem.setExpanded(true);
                for(TotalDayEntries tempDay : tempWeek.getAllDayEntriesInWeek()) {
                    TreeItem<Object> dayItem = new TreeItem<>(tempDay.getDayDate().toString());
                    weekItem.getChildren().add(dayItem);
                }
                item.getChildren().add(weekItem);
            }
            rootItem.getChildren().add(item);
        }
        timeTreeView.setRoot(rootItem);
    }

    @FXML public void doAdd(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        stage.setTitle("Adding Entry");
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(headerMenu.getScene().getWindow());
        stage.show();
    }

    @FXML public void printSelectedElement(ActionEvent event) {
        infoTextArea.setText(timeTreeView.getSelectionModel().getSelectedItem().getValue().toString());
    }

    public static FileChooser getFileChooser(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));
        fileChooser.setTitle(title);
        return fileChooser;
    }
}
