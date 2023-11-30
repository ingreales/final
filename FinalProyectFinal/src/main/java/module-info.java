module co.edu.cue.finalproyect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
/*
    exports co.edu.cue.finalproyect;
    exports co.edu.cue.finalproyect.controller to javafx.fxml;
    exports co.edu.cue.finalproyect.model to javafx.fxml;

    opens co.edu.cue.finalproyect.model to javafx.base;
    opens co.edu.cue.finalproyect.controller to javafx.fxml;
    opens co.edu.cue.finalproyect to javafx.graphics;*/
    opens co.edu.cue.finalproyect to javafx.fxml;
    opens co.edu.cue.finalproyect.model to javafx.fxml;
    opens co.edu.cue.finalproyect.controller to javafx.fxml;

    exports co.edu.cue.finalproyect;
    exports co.edu.cue.finalproyect.controller;
    exports co.edu.cue.finalproyect.model;
}