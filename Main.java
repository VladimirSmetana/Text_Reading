import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class txtDriver
{
    private
    float table[][];
    int rows;
    int cols;
    txtDriver(String filename) throws IOException
    {
        File file = new File(filename);
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        ArrayList<String> strings = new ArrayList<String>();

        while (line != null)
        {
            strings.add(line);
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        strings.remove(0);
        strings.remove(0);
        rows = strings.size();
        cols = strings.get(0).split("\t").length-1;
        table = new float[rows][cols];
        for (int j = 0; j < strings.size(); j++)
        {
            String words[] = strings.get(j).split("\t");
            for (int i = 1; i < words.length; i++)
            {

                table[j][i-1] = Float.parseFloat(words[i]);
            }

        }


    }
    public
    float get_value(int row, int col)
    {
        return table[row-1][col-1];
    }
    int rows_count()
    {
        return rows;
    }
    int cols_count()
    {
        return cols;
    }

    ArrayList<Float> get_string_by_id(int id)
    {
        ArrayList<Float> out = new ArrayList<Float>();

        for(int i = 0; i<cols; i++){
            out.add(table[id-1][i]);
        }

        return out;
    }

}
public class Main
{
    public static void main(String[] args) throws IOException
    {
        txtDriver mytxt = new txtDriver("BD.txt");

        ArrayList<Float> mass = mytxt.get_string_by_id(1);



        for (int i=0;i<mass.size();i++) System.out.println(mass.get(i));

    }
}