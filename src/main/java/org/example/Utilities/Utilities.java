package org.example.Utilities;

import java.awt.*;

public class Utilities {
    public static String pointToString(Point point) {
        return "(" + point.x + "," + point.y + ")";
    }

    public static Point stringToPoint(String pointString) {
        // Remove parentheses and split the string by comma
        String[] parts = pointString.replaceAll("[()]", "").split(",");

        // Parse the coordinates
        int x = Integer.parseInt(parts[0].trim());
        int y = Integer.parseInt(parts[1].trim());

        // Create a new Point object
        return new Point(x, y);
    }
}
