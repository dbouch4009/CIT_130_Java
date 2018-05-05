class MultiArray
{
    public static void rows_columns(String[][] arg)
    {
        int length = arg.length;
        int row,column;
        for(row = 0; row<arg.length; row++)
        {
            for(column = 0; column < arg[row].length; column ++)
            {
                System.out.print(arg[row][column] + ", ");
            }
            System.out.println("\n");
        }
    }
    public static void columns_rows(String[][] arg)
    {
        int length = arg.length;
        int row,column;
        for(column = 0; column<arg[column].length; column++)
        {
            for(row = 0; row < arg.length; row ++)
            {
                System.out.print(arg[row][column] + ", ");
            }
            System.out.println("\n");
        }
    }

}