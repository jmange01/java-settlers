package com.settlers.util;

import java.awt.Point;

public class Calculator2d {
	public static double getDistance(Point a, Point b) {
		double xDist = Math.abs(a.getX() - b.getX());
		double yDist = Math.abs(a.getY() - b.getY());
		return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
	}
}
