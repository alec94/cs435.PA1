package cs435.nGram.Profile2A;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Alec on 2/18/2017.\
 *
 */
public class BigramYearMapper extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String[] temp = value.toString().split("<===>");
        //do not need author
        //String author = temp[0];
        String date = temp[1];
        String line = temp[2];

        date = date.replace(",", " ");
        temp = date.split("\\s+");
        String year = temp[temp.length - 1].trim();

        //remove all non-alphanumeric and convert to lowercase
        line = line.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "");
        line = "_START_ " + line + " _END_";

        String[] words = line.split("\\s+");

        for(int i = 1; i < words.length; i++) {
            if (words[i].trim().length() > 0) {
                String tmpKey = words[i - 1] + " " + words[i] + "\t" + year;
                context.write(new Text(tmpKey), new Text("one"));
            }
        }
    }
}
