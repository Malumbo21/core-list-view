/**
 * @author XDSSWAR
 * Created on 06/27/2024
 */
module nfx.list {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    exports xss.it.nfx.list;
    opens xss.it.nfx.list;
    exports xss.it.nfx.list.event;
    opens xss.it.nfx.list.event;
    exports xss.it.nfx.list.misc;
    opens xss.it.nfx.list.misc;
}