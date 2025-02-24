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

package com.xss.it.nfx.list.internals;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * @author XDSSWAR
 * Created on 06/22/2024
 */
public final class VirtualPane extends Region {
    /**
     * Returns the list of children nodes.
     * @return the observable list of children nodes
     */
    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    /**
     * Lays out the children nodes within the control.
     */
    @Override
    protected void layoutChildren() {}
}
