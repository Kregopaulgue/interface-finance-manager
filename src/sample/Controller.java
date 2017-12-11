package sample;

import CombinedExpenceEntries.CombinedOtherExpenceEntry;
import ExpenceEntries.ExpenceEntry;
import ExpenceEntries.OtherExpenceEntry;
import Generated.OtherExpenceEntriesType;
import Generated.TotalTimeType;
import HelperTypes.ExpenceEntryType;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalTimeEntry;
import TotalTimeEntries.TotalWeekEntries;
import XMLLibrary.DateHelper;
import XMLLibrary.XMLReader;
import XMLLibrary.XMLWriter;
import XMLLibrary.XMLWriterHelpers;
import com.sun.org.apache.xpath.internal.operations.Number;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.reflect.generics.tree.Tree;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller{

    public TotalTimeType totalXMLTime;
    public ArrayList<TotalMonthEntries> totalTimeLoadedIn;

    private TotalMonthEntries selectedMonthEntry;
    private TotalWeekEntries selectedWeekEntry;
    private TotalDayEntries selectedDayEntry;
    private OtherExpenceEntry selectedEntry;
    private CombinedOtherExpenceEntry selectedCombinedEntry;

    @FXML TreeView <TotalTimeEntry> timeTreeView;
    @FXML TreeView <OtherExpenceEntry> entriesTreeView;

    @FXML MenuBar headerMenu;

    @FXML Menu fileMenu, editMenu, aboutMenu;

    @FXML MenuItem fileOpen, fileClose, fileSave, fileSaveAs;
    @FXML MenuItem editAddEntry, editAddCombinedEntry, editAddCurrentMonth, editDeleteSelected;
    @FXML MenuItem helpHowToUse, helpCredits;

    @FXML TextArea timeInfoTextArea;
    @FXML TextArea entryInfoTextArea;

    @FXML Button getEntries, getEntryInfo, getTimeInfo;
    @FXML Button paintTotal, paintAverage;

    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;

    @FXML LineChart<Number, Number> lineChart;

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
        refreshTimeView();
    }

    @FXML public void doSaveAs(ActionEvent event) {
        FileChooser fileChooser = getFileChooser("Save XML-file:");
        File file;
        if ((file = fileChooser.showSaveDialog(null)) != null) {
            try {
                XMLWriter.writeFullTimeToXML(XMLWriter.convertFullTimeToXML(this.totalTimeLoadedIn), file.getCanonicalPath());
                System.out.println("Saved successfully");
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error saving file");
            }
        }
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
        stage.showAndWait();

        try {
            findNeededDay(Edit.entryToAdd.getCalendar()).addSimpleEntry(Edit.entryToAdd);
        } catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("This day doesnt exist");
            alert.showAndWait();
            stage.close();
        }
    }

    @FXML public void doGetEntries(ActionEvent event) {
        TreeItem<OtherExpenceEntry> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);
        for(OtherExpenceEntry expence :
                this.timeTreeView.getSelectionModel().getSelectedItem().getValue().getSimpleEntries()) {
            rootItem.getChildren().add(new TreeItem<>(expence));
        }
        this.entriesTreeView.setRoot(rootItem);
    }

    @FXML public void getSelectedEntryInfo(ActionEvent event) {
        this.entryInfoTextArea.setText(entriesTreeView.getSelectionModel().getSelectedItem().toString());
    }

    @FXML public void getSelectedTimeInfo(ActionEvent event) {
        this.timeInfoTextArea.setText(timeTreeView.getSelectionModel().getSelectedItem().getValue().getInfo());
    }

    @FXML public void doAddCurrentMonth(ActionEvent event) {
        boolean currentMonthFound = false;
        for(TotalMonthEntries tempMonth : this.totalTimeLoadedIn) {
            if(tempMonth.getBeggingDate().getMonth().equals(LocalDate.now().getMonth())) {
                currentMonthFound = true;
            }
        }
        if(currentMonthFound) {
            return;
        }
        this.totalTimeLoadedIn.add(new TotalMonthEntries(LocalDate.now()));
        refreshTimeView();

    }

    @FXML public void doPaintTotalSum(ActionEvent event) {
        TotalTimeEntry selectedItem = timeTreeView.getSelectionModel().getSelectedItem().getValue();
        lineChart.getData().clear();
        yAxis.setLabel("Money spent");
        if(selectedItem instanceof TotalTimeEntry) {
            xAxis.setLabel("Month");
        }
        else if(selectedItem instanceof TotalMonthEntries) {
            xAxis.setLabel("Number of Week");
        }
        else if(selectedItem instanceof TotalWeekEntries) {
            xAxis.setLabel("Number of Day");
        }
        else if(selectedItem instanceof TotalDayEntries) {
            xAxis.setLabel("Entry during the day");
        }
        lineChart.setTitle("Graphic");
        XYChart.Series series = new XYChart.Series();
        if(!(selectedItem instanceof TotalMonthEntries) && !(selectedItem instanceof TotalWeekEntries)
                && !(selectedItem instanceof TotalDayEntries)) {
            for(int i = 0; i < this.totalTimeLoadedIn.size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data( category, this.totalTimeLoadedIn.get(i).getAllMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalMonthEntries) {
            for(int i = 0; i < ((TotalMonthEntries) selectedItem).getAllWeekEntriesInMonth().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalMonthEntries) selectedItem).getCertainWeek(i).getAllMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalWeekEntries) {
            for(int i = 0; i < ((TotalWeekEntries) selectedItem).getAllDayEntriesInWeek().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalWeekEntries) selectedItem).getCertainDay(i).getAllMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalDayEntries) {
            for(int i = 0; i < ((TotalDayEntries) selectedItem).getSimpleEntries().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalDayEntries) selectedItem).getCertainSimpleEntry(i).getMoneySpent()));
            }
        }
        lineChart.getData().add(series);

    }

    @FXML public void doPaintAverageMoney(ActionEvent event) {
        TotalTimeEntry selectedItem = timeTreeView.getSelectionModel().getSelectedItem().getValue();
        lineChart.getData().clear();
        yAxis.setLabel("Average money spent");
        if(selectedItem instanceof TotalTimeEntry) {
            xAxis.setLabel("Month");
        }
        else if(selectedItem instanceof TotalMonthEntries) {
            xAxis.setLabel("Number of Week");
        }
        else if(selectedItem instanceof TotalWeekEntries) {
            xAxis.setLabel("Number of Day");
        }
        else if(selectedItem instanceof TotalDayEntries) {
            xAxis.setLabel("Entry during the day");
        }
        lineChart.setTitle("Graphic");
        XYChart.Series series = new XYChart.Series();
        if(!(selectedItem instanceof TotalMonthEntries) && !(selectedItem instanceof TotalWeekEntries)
                && !(selectedItem instanceof TotalDayEntries)) {
            for(int i = 0; i < this.totalTimeLoadedIn.size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data( category, this.totalTimeLoadedIn.get(i).getAverageMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalMonthEntries) {
            for(int i = 0; i < ((TotalMonthEntries) selectedItem).getAllWeekEntriesInMonth().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalMonthEntries) selectedItem).getCertainWeek(i).getAverageMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalWeekEntries) {
            for(int i = 0; i < ((TotalWeekEntries) selectedItem).getAllDayEntriesInWeek().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalWeekEntries) selectedItem).getCertainDay(i).getAverageMoneySpent()));
            }
        }
        else if(selectedItem instanceof TotalDayEntries) {
            for(int i = 0; i < ((TotalDayEntries) selectedItem).getSimpleEntries().size(); i++) {
                String category = new Integer(i).toString();
                series.getData().add(new XYChart.Data(category, ((TotalDayEntries) selectedItem).getCertainSimpleEntry(i).getMoneySpent()));
            }
        }
        lineChart.getData().add(series);
    }

    @FXML public void doDeleteSelected(ActionEvent event) {
        TotalTimeEntry selectedItem;

        selectedItem = timeTreeView.getSelectionModel().getSelectedItem().getValue();

        if(!(selectedItem instanceof TotalMonthEntries) && !(selectedItem instanceof TotalWeekEntries)
                && !(selectedItem instanceof TotalDayEntries)) {
            return;
        }
        else if(selectedItem instanceof TotalMonthEntries) {
            this.totalTimeLoadedIn.remove(selectedItem);
            this.refreshTimeView();
        }
        else if(selectedItem instanceof TotalWeekEntries) {
            findNeededMonth(((TotalWeekEntries) selectedItem).getEndDate()).getAllWeekEntriesInMonth().remove(selectedItem);
            this.refreshTimeView();
        }
        else if(selectedItem instanceof TotalDayEntries) {
            findNeededWeek(((TotalDayEntries) selectedItem).getDayDate()).getAllDayEntriesInWeek().remove(selectedItem);
            this.refreshTimeView();
        }
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

    public TotalMonthEntries findNeededMonth(LocalDate date) {
        for(int i = 0; i < this.totalTimeLoadedIn.size(); i++) {
            if(DateHelper.betweenCompareDates(totalTimeLoadedIn.get(i).getBeggingDate(),
                    date, totalTimeLoadedIn.get(i).getEndDate())) {
                return totalTimeLoadedIn.get(i);
            }
        }
        return null;
    }

    public TotalWeekEntries findNeededWeek(LocalDate date) {
        TotalMonthEntries neededMonth = findNeededMonth(date);
        for(int i = 0; i < neededMonth.getAllWeekEntriesInMonth().size(); i++) {
            if(DateHelper.betweenCompareDates(neededMonth.getAllWeekEntriesInMonth().get(i).getBeggingDate(),
                    date, neededMonth.getAllWeekEntriesInMonth().get(i).getEndDate())) {
                return neededMonth.getAllWeekEntriesInMonth().get(i);
            }
        }
        return null;
    }

    public TotalDayEntries findNeededDay(LocalDate date) {
        TotalMonthEntries neededMonth = findNeededMonth(date);
        for(int i = 0; i < neededMonth.getAllDayEntriesInMonth().size(); i++) {
            if(neededMonth.getAllDayEntriesInMonth().get(i).getDayDate().equals(date)) {
                return neededMonth.getAllDayEntriesInMonth().get(i);
            }
        }
        return null;
    }

    public void refreshTimeView() {
        TreeItem<TotalTimeEntry> rootItem = new TreeItem<TotalTimeEntry> (new TotalTimeEntry());
        rootItem.setExpanded(true);
        for (TotalMonthEntries tempMonth : this.totalTimeLoadedIn) {
            TreeItem<TotalTimeEntry> item = new TreeItem<TotalTimeEntry> (tempMonth);
            item.setExpanded(true);
            for(TotalWeekEntries tempWeek : tempMonth.getAllWeekEntriesInMonth()) {
                TreeItem<TotalTimeEntry> weekItem = new TreeItem<>(tempWeek);
                weekItem.setExpanded(true);
                for(TotalDayEntries tempDay : tempWeek.getAllDayEntriesInWeek()) {
                    TreeItem<TotalTimeEntry> dayItem = new TreeItem<>(tempDay);
                    weekItem.getChildren().add(dayItem);
                }
                item.getChildren().add(weekItem);
            }
            rootItem.getChildren().add(item);
        }
        timeTreeView.setRoot(rootItem);
    }
}
