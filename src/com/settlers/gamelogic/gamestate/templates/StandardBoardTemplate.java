package com.settlers.gamelogic.gamestate.templates;

public class StandardBoardTemplate {
	private int i = 0;
	private int j = 0;
	private int[][] template = 
		{  {0,0,0,0,0,0},
            {0,0,0,0,0},
		   {0,0,0,0,0,0},
		    {0,0,1,0,0},
		   {0,0,1,1,0,0},
		    {0,1,1,1,0},
		   {0,0,1,1,0,0},
		    {0,1,1,1,0},
		   {0,0,1,1,0,0},
		    {0,1,1,1,0},
		   {0,0,1,1,0,0},
		    {0,0,1,0,0},
		   {0,0,0,0,0,0},
		    {0,0,0,0,0} };
	public int nextTile() {
		int value;
		if(i<template.length) {
			value = template[i][j++];
			if(j>=template[i].length) {
				j=0;
				i++;
			}
		} else {
			value = 0;
		}
		
		return value;
	}
}
