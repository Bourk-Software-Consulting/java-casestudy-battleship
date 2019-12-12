public class Position
{
    /// <summary>
    /// Initializes a new instance of the <see cref="Position"/> class.
    /// </summary>
    /// <param name="column">
    /// The column.
    /// </param>
    /// <param name="row">
    /// The row.
    /// </param>
    public Position(Letters column, int row)
    {
        Column = column;
        Row = row;
    }

    /// <summary>
    ///     Initializes a new instance of the <see cref="Position" /> class.
    /// </summary>
    public Position()
    {
    }

    /// <summary>
    ///     Gets or sets the column.
    /// </summary>
    public Letters Column;

    /// <summary>
    ///     Gets or sets the row.
    /// </summary>
    public int Row;


    /// <summary>
    /// The equals.
    /// </summary>
    /// <param name="obj">
    /// The obj.
    /// </param>
    /// <returns>
    /// The <see cref="bool"/>.
    /// </returns>
    public Boolean Equals(Position obj)
{
    if (obj == null)
    {
        return false;
    }

    return obj.Column == Column && obj.Row == Row;
}

}

