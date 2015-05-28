package pt.europeia.eda.session23;

import static java.lang.System.out;

// 
public class BstTestForDebuggerTracing {

    public static void main(final String[] arguments) {
        final BstOrderedTable<String, String> table = new BstOrderedTable<String, String>();

        table.put("S", "0");
        table.put("E", "1");
        table.put("R", "2");
        table.put("X", "3");
        table.put("A", "4");
        table.put("H", "5");
        table.put("M", "6");
        table.put("C", "7");

        table.put("G", "8");

        table.put("W", "9");

        out.println(table.size());
        
        out.println(table.keys());
    }

}

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 */