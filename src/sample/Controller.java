package sample;

import ExpenceEntries.OtherExpenceEntry;
import TotalTimeEntries.TotalDayEntries;
import TotalTimeEntries.TotalMonthEntries;
import TotalTimeEntries.TotalTimeEntry;
import TotalTimeEntries.TotalWeekEntries;
import WorkWithData.WorkWithEntryData;
import WorkWithData.WorkWithTimeData;
import XMLLibrary.DateHelper;
import XMLLibrary.XMLReader;
import XMLLibrary.XMLWriter;
import com.sun.org.apache.xpath.internal.operations.Number;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller{

    private String openedFilePath;
    private ArrayList<TotalMonthEntries> totalTimeLoadedIn;

    @FXML TreeView <TotalTimeEntry> timeTreeView;
    @FXML TreeView <OtherExpenceEntry> entriesTreeView;

    @FXML MenuBar headerMenu;

    @FXML Menu fileMenu, editMenu, aboutMenu, findMenu;

    @FXML MenuItem fileNew, fileOpen, fileClose, fileSave, fileSaveAs;
    @FXML MenuItem editAddEntry, editEditEntry, editDeleteEntry,
            editAddFullYear, editAddCurrentMonth, editDeleteSelected;
    @FXML MenuItem findMostImportant, findLessImportant, findMostExpensive, findLessExpensive;
    @FXML MenuItem helpHowToUse, helpCredits;

    @FXML TextArea timeInfoTextArea;
    @FXML TextArea entryInfoTextArea;

    @FXML Button getEntries, getEntryInfo, getTimeInfo;
    @FXML Button paintTotal, paintAverage, paintTotalSelected, paintAverageSelected;
    @FXML Button findByDate;

    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;

    @FXML LineChart<Number, Number> lineChart;

    @FXML public void doNew(ActionEvent event) {
        this.timeTreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.totalTimeLoadedIn = new ArrayList<>();
        refreshTimeView();
    }

    @FXML public void doOpen(ActionEvent event) {
        this.timeTreeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        FileChooser fileChooser = getFileChooser("Open XML-file:");
        File file;
        if((file = fileChooser.showOpenDialog(null)) != null) {
            try {
                this.openedFilePath = file.getAbsolutePath();
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

    @FXML public void doSave(ActionEvent event) {
        try {
            XMLWriter.writeFullTimeToXML(XMLWriter.convertFullTimeToXML(this.totalTimeLoadedIn), openedFilePath);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving");
        }
    }

    @FXML public void doSaveAs(ActionEvent event) {
        FileChooser fileChooser = getFileChooser("Save XML-file:");
        File file;
        if ((file = fileChooser.showSaveDialog(null)) != null) {
            try {
                openedFilePath = file.getCanonicalPath();
                XMLWriter.writeFullTimeToXML(XMLWriter.convertFullTimeToXML(this.totalTimeLoadedIn), openedFilePath);
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

    @FXML public void doDeleteEntry(ActionEvent event) {
        OtherExpenceEntry entryToDelete = this.entriesTreeView.getSelectionModel().getSelectedItem().getValue();

        LocalDate entryDate = entryToDelete.getCalendar();

        findNeededDay(entryDate).getSimpleEntries().remove(entryToDelete);
        refreshEntryView();
    }

    @FXML public void doGetEntries(ActionEvent event) {
        refreshEntryView();
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

    @FXML public void doAddFullYear(ActionEvent event) {
        LocalDate currentDate = LocalDate.now();
        int temporaryMonth = -1, temporaryYear = currentDate.getYear();
        if(this.totalTimeLoadedIn.size() != 0) {
            TotalMonthEntries firstExistedMonth = this.totalTimeLoadedIn.get(0);
            temporaryYear = firstExistedMonth.getBeggingDate().getYear();
            temporaryMonth = firstExistedMonth.getBeggingDate().getMonth().getValue();
        }
        for(int i = 1; i <= 12; i++) {
            TotalMonthEntries monthToAdd = new TotalMonthEntries(LocalDate.of(currentDate.getYear(), i, 1));
            if(monthToAdd.getBeggingDate().getYear() != temporaryYear) {
                break;
            }
            else if(monthToAdd.getBeggingDate().getMonth().getValue() != temporaryMonth) {
                this.totalTimeLoadedIn.add(monthToAdd);
            }
        }
        refreshTimeView();
    }

    @FXML public void getMostImportantEntryInfo(ActionEvent event) {

        if(timeTreeView.getSelectionModel().getSelectedItems().size() > 1) {
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheMostImportantEntry(getEntriesFromSelectedTimes());
            this.toSelectEntry(neededEntry, event);

        } else {
            TotalTimeEntry whereToSeek = timeTreeView.getSelectionModel().getSelectedItem().getValue();
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheMostImportantEntry(whereToSeek.getSimpleEntries());
            this.toSelectEntry(neededEntry, event);
        }
    }

    @FXML public void getLessImportantEntryInfo(ActionEvent event) {
        if(timeTreeView.getSelectionModel().getSelectedItems().size() > 1) {
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheLessImportantEntry(getEntriesFromSelectedTimes());
            this.toSelectEntry(neededEntry, event);

        } else {
            TotalTimeEntry whereToSeek = timeTreeView.getSelectionModel().getSelectedItem().getValue();
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheLessImportantEntry(whereToSeek.getSimpleEntries());
            this.toSelectEntry(neededEntry, event);
        }
    }

    @FXML public void getMostExpensiveEntryInfo(ActionEvent event) {
        if(timeTreeView.getSelectionModel().getSelectedItems().size() > 1) {
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheMostExpensiveEntry(getEntriesFromSelectedTimes());
            this.toSelectEntry(neededEntry, event);
            this.timeTreeView.getSelectionModel().select(new TreeItem<>(findNeededDay(neededEntry.getCalendar())));
        } else {
            TotalTimeEntry whereToSeek = timeTreeView.getSelectionModel().getSelectedItem().getValue();
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheMostExpensiveEntry(whereToSeek.getSimpleEntries());
            this.toSelectEntry(neededEntry, event);
        }
    }

    @FXML public void getLessExpensiveEntryInfo(ActionEvent event) {
        if(timeTreeView.getSelectionModel().getSelectedItems().size() > 1) {
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheLessExpensiveEntry(getEntriesFromSelectedTimes());
            this.toSelectEntry(neededEntry, event);
        } else {
            TotalTimeEntry whereToSeek = timeTreeView.getSelectionModel().getSelectedItem().getValue();
            OtherExpenceEntry neededEntry = WorkWithEntryData.findTheLessExpensiveEntry(whereToSeek.getSimpleEntries());
            this.toSelectEntry(neededEntry, event);
        }
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

    @FXML public void doPaintTotalSumForSelected(ActionEvent event) {
        ArrayList<TotalTimeEntry> selectedItems = new ArrayList<>();

        for(int i = 0; i < timeTreeView.getSelectionModel().getSelectedItems().size(); i++) {
            selectedItems.add(timeTreeView.getSelectionModel().getSelectedItems().get(i).getValue());
        }

        lineChart.getData().clear();
        lineChart.setTitle("Graphic");
        XYChart.Series series = new XYChart.Series();

        for(int i = 0; i < selectedItems.size(); i++) {
            String category = new Integer(i).toString();
            series.getData().add(new XYChart.Data( category, selectedItems.get(i).getAllMoneySpent()));
        }
        lineChart.getData().add(series);
    }

    @FXML public void doPaintAverageMoneyForSelected(ActionEvent event) {
        ArrayList<TotalTimeEntry> selectedItems = new ArrayList<>();

        for(int i = 0; i < timeTreeView.getSelectionModel().getSelectedItems().size(); i++) {
            selectedItems.add(timeTreeView.getSelectionModel().getSelectedItems().get(i).getValue());
        }

        lineChart.getData().clear();
        lineChart.setTitle("Graphic");
        XYChart.Series series = new XYChart.Series();

        for(int i = 0; i < selectedItems.size(); i++) {
            String category = new Integer(i).toString();
            series.getData().add(new XYChart.Data( category, selectedItems.get(i).getAverageMoneySpent()));
        }
        lineChart.getData().add(series);
    }

    @FXML public void doEdit(ActionEvent event) throws IOException{
        OtherExpenceEntry entryToEdit = this.entriesTreeView.getSelectionModel().getSelectedItem().getValue();

        if(entryToEdit.equals(new OtherExpenceEntry())) {
            return;
        }

        Edit.entryToEdit = entryToEdit;

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

        int index = findNeededDay(entryToEdit.getCalendar()).getCertainCimpleEntryIndexByObject(entryToEdit);
        findNeededDay(entryToEdit.getCalendar()).setCertainSimpleEntry(index, Edit.entryToAdd);
        this.refreshEntryView();
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

    public void refreshEntryView() {
        TreeItem<OtherExpenceEntry> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);
        for(OtherExpenceEntry expence :
                this.timeTreeView.getSelectionModel().getSelectedItem().getValue().getSimpleEntries()) {
            rootItem.getChildren().add(new TreeItem<>(expence));
        }
        this.entriesTreeView.setRoot(rootItem);

    }

    public void refreshTimeView() {
        TreeItem<TotalTimeEntry> rootItem = new TreeItem<TotalTimeEntry> (new TotalTimeEntry());
        if(totalTimeLoadedIn.size() == 0) {
            timeTreeView.setRoot(rootItem);
            return;
        }
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

    private ArrayList<OtherExpenceEntry> getEntriesFromSelectedTimes() {
        ArrayList<TotalTimeEntry> timeArray = new ArrayList<>();
        for(int i = 0; i < timeTreeView.getSelectionModel().getSelectedItems().size(); i++) {
            timeArray.add(timeTreeView.getSelectionModel().getSelectedItems().get(i).getValue());
        }
        ArrayList<OtherExpenceEntry> entriesArray = new ArrayList<>();
        for(int i = 0; i < timeArray.size(); i++) {
            entriesArray.addAll(timeArray.get(i).getSimpleEntries());
        }
        return entriesArray;
    }

    private void toSelectEntry(OtherExpenceEntry neededEntry, ActionEvent event) {
        this.doGetEntries(event);
        this.entryInfoTextArea.setText(neededEntry.toString());
        this.timeInfoTextArea.setText(findNeededMonth(neededEntry.getCalendar()).getInfo());

        MultipleSelectionModel msm = timeTreeView.getSelectionModel();
        int row = timeTreeView.getRow(new TreeItem<>(findNeededDay(neededEntry.getCalendar())));
        msm.select( row );

        MultipleSelectionModel secondMsm = timeTreeView.getSelectionModel();
        int secondRow = entriesTreeView.getRow(new TreeItem<>(neededEntry));
        secondMsm.select( secondRow );
    }
}
