package com.bourksoftware;

import java.awt.*;
import java.util.ArrayList;

/// <summary>
/// The ship.
/// </summary>
public class Ship
{
    /// <summary>
    /// Gets  the name.
    /// </summary>
    public  String name;

    /// <summary>
    /// The color of the ship
    /// </summary>
    public  Color color;

    private Boolean isPlaced;

    /// <summary>
    /// Initializes a new instance of the <see cref="com.bourksoftware.Ship"/> class.
    /// </summary>
    public Ship(String name, Integer size, java.awt.Color color)
    {
        this.name = name;
        this.size = size;
        this.color = color;
        positions = new ArrayList<Position>();
    }

    /// <summary>
    /// Gets the positions.
    /// </summary>
    public ArrayList<Position> positions;


    /// <summary>
    /// Gets or sets the size.
    /// </summary>
    public Integer size;


    /// <summary>
    /// The add position.
    /// </summary>
    /// <param name="input">
    /// The input.
    /// </param>
    public void AddPosition(String input)
    {
        if (positions == null)
        {
            positions = new ArrayList<Position>();
        }

        Letters letter = Enum.valueOf(Letters.class, input.toUpperCase().substring(0, 1));

        Integer number = Integer.parseInt(input.substring(1, 2));
        positions.add(new Position(letter,  number));
    }

    public Boolean IsPlaced() {
        return isPlaced;
    }
    public void setIsPlaced(Boolean value)
    {
            if (value.equals(isPlaced)) return;
            isPlaced = value;
    }


}
