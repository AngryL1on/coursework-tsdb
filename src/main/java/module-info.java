module ru.rutmiit.lsm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens ru.rutmiit.lsm to javafx.fxml;
    exports ru.rutmiit.lsm;
    exports ru.rutmiit.lsm.controllers;
    opens ru.rutmiit.lsm.controllers to javafx.fxml;
}