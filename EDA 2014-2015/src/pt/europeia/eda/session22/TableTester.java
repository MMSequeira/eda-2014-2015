package pt.europeia.eda.session22;

import static java.lang.System.out;

public class TableTester {

    public static void main(final String[] arguments) {
        final SequentialSearchTable<String, Integer> table = new SequentialSearchTable<String, Integer>();

        assert table.size() == 0;
        assert table.isEmpty();

        table.put("Zero", 10);
        table.put("One", 1);
        table.put("Two", 2);
        table.put("Three", 3);
        table.put("Four", 4);
        table.put("Five", 5);
        table.put("Six", 6);
        table.put("Seven", 7);
        table.put("Eight", 8);
        table.put("Nine", 9);
        table.put("Ten", 0);
        table.put("Ten", 10);
        table.delete("Zero");
        table.put("One", null);
        
        int position = 10;
        for (String key : table.keys()) {
            assert table.valueFor(key) == position;
            position--;
        }

        assert table.contains("Ten");
        assert !table.contains("Zero");
        assert table.size() == 9;
        assert !table.isEmpty();
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