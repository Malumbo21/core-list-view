/*
 * Copyright © 2024. XTREME SOFTWARE SOLUTIONS
 *
 * All rights reserved. Unauthorized use, reproduction, or distribution
 * of this software or any portion of it is strictly prohibited and may
 * result in severe civil and criminal penalties. This code is the sole
 * proprietary of XTREME SOFTWARE SOLUTIONS.
 *
 * Commercialization, redistribution, and use without explicit permission
 * from XTREME SOFTWARE SOLUTIONS, are expressly forbidden.
 */

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