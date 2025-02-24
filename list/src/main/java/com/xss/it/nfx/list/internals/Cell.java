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

import javafx.scene.Node;

/**
 * @author XDSSWAR
 * Created on 06/22/2024
 */
public interface Cell<T, N extends Node> {
    /**
     * Wraps a node in a Cell.
     * @param <T> the type of the item
     * @param <N> the type of the node
     * @param node the node to be wrapped
     * @return a Cell containing the given node
     */
    static <T, N extends Node> Cell<T, N> wrap(N node){
        return new Cell<>() {
            @Override
            public N getNode() {
                return node;
            }

            @Override
            public String toString() {
                return node.toString();
            }
        };
    }

    /**
     * Returns the node of this cell.
     * @return the node
     */
    N getNode();
}
