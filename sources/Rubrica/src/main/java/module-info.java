module it.unisa.diem.rubrica.rubrica {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.unisa.diem.group07.rubrica to javafx.fxml;
    exports it.unisa.diem.group07.rubrica;
}
