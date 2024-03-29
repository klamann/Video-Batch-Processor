/*
 * Copyright (C) 2011 Sebastian Straub <sebastian-straub@gmx.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vbp.app;

import vbp.ctrl.Controller;

/**
 * Launches the application and accepts command line arguments.
 * 
 * @author Sebastian Straub <sebastian-straub@gmx.net>
 */
public class Launch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO accept project files as input!
        
        new Controller();
    }
}
