package ru.rutmiit.lsm.controllers;

import ru.rutmiit.lsm.repositories.DatabaseHandler;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IssuedBooksController implements Initializable {

    DatabaseHandler databaseHandler;

    @FXML
    private TableView<IssuedBook> tableView;
    @FXML
    private TableColumn<IssuedBook, String> BookIDCol;
    @FXML
    private TableColumn<IssuedBook, String> MemberCol;
    @FXML
    private TableColumn<IssuedBook, String> TimeCol;
    @FXML
    private TableColumn<IssuedBook, Integer> RenewCol;

    ObservableList<IssuedBook> list = FXCollections.observableArrayList();

    public static class IssuedBook {
        private final SimpleStringProperty bookId;
        private final SimpleStringProperty memberId;
        private final SimpleStringProperty issueTime;
        private final SimpleIntegerProperty renew;

        public IssuedBook(String bookId, String memberId, String issueTime,Integer renew) {
            this.bookId = new SimpleStringProperty(bookId);
            this.memberId = new SimpleStringProperty(memberId);
            this.issueTime = new SimpleStringProperty(issueTime);
            this.renew = new SimpleIntegerProperty(renew);
        }

        public String getBookId() {
            return bookId.get();
        }

        public String getMemberId() {
            return memberId.get();
        }

        public Integer getRenew() {
            return renew.get();
        }

        public String getIssueTime() {
            return issueTime.get();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }

    private void initCol() {
        BookIDCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        MemberCol.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("issueTime"));
        RenewCol.setCellValueFactory(new PropertyValueFactory<>("renew"));
    }

    private void loadData() {
        databaseHandler= DatabaseHandler.getInstance();
        String qu = "SELECT * FROM \"issuedBooks\"";
        ResultSet rs = databaseHandler.execQuery(qu);
        try {
            while (rs.next()) {
                String bookId = rs.getString("bookID");
                String memberId = rs.getString("memberID");
                Timestamp issuedTime=rs.getTimestamp("issueTime");
                String issueTime = issuedTime.toString();
                Integer  renew = rs.getInt("renew_count");

                list.add(new IssuedBook(bookId, memberId, issueTime, renew));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableView.setItems(list);
    }

    void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
