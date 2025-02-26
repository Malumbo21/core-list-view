

/**
 * @author XDSSWAR
 * Created on 02/23/2025
 */
module nfx.demo {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires nfx.list;
    requires org.json;

    exports xss.it.demo;
    opens xss.it.demo;
    exports xss.it.demo.controller;
    opens xss.it.demo.controller;
    exports xss.it.demo.data.entity;
    opens xss.it.demo.data.entity;
    exports xss.it.demo.data.model;
    opens xss.it.demo.data.model;

}