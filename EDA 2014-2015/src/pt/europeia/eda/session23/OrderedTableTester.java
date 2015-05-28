package pt.europeia.eda.session23;

public class OrderedTableTester {

    public static void main(final String[] arguments) {
        final BstOrderedTable<String, Integer> table = new BstOrderedTable<String, Integer>();

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
        
        int[] values = {8, 5, 4, 9, 7, 6, 10, 3, 2};
        int i = 0;
        for (String key : table.keys()) {
            assert table.valueFor(key).intValue() == values[i];
            assert table.rankOf(key) == i;
            assert table.keyWithRank(i).equals(key);
            i++;
        }

        assert table.contains("Ten");
        assert !table.contains("Zero");
        assert table.size() == 9;
        assert !table.isEmpty();
        
        assert table.minimum().equals("Eight");
        assert table.maximum().equals("Two");
        
        table.deleteMinimum();
        table.deleteMaximum();
        
        assert table.minimum().equals("Five");
        assert table.maximum().equals("Three");
        
        assert table.sizeOfRange("Nine", "Six") == 3;
        assert table.sizeOfRange("Geek", "Tangram") == 3;
        
        assert table.floorOf("Fanfarre") == null;
        assert table.floorOf("Five").equals("Five");
        assert table.floorOf("Geek").equals("Four");
        assert table.floorOf("Uber").equals("Three");
        
        assert table.ceilingOf("Fanfarre").equals("Five");
        assert table.ceilingOf("Five").equals("Five");
        assert table.ceilingOf("Geek").equals("Nine");
        assert table.ceilingOf("Uber") == null;
        
        values = new int[] {9, 7, 6, 10, 3};
        i = 0;
        for (String key : table.keysInRange("Geek", "Uber")) {
            assert table.valueFor(key).intValue() == values[i];
            assert table.rankOf(key) == i + 2;
            assert table.keyWithRank(i + 2).equals(key);
            i++;
        }

        table.delete("Zero");
        table.delete("One");
        table.delete("Two");
        table.delete("Three");
        table.delete("Four");
        table.delete("Five");
        table.delete("Six");
        table.delete("Seven");
        table.delete("Eight");
        table.delete("Nine");
        table.delete("Ten");
        table.delete("Ten");

        assert table.size() == 0;
        assert table.isEmpty();
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