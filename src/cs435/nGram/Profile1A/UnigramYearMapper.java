package cs435.nGram.Profile1A;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Alec on 2/18/2017.
 *
 */
public class UnigramYearMapper extends Mapper<LongWritable,Text,Text,Text> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String[] temp = value.toString().split("<===>");
        //do not need author
        //String author = temp[0];
        String date = temp[1];
        String line = temp[2];
        date = date.replace(",", " ");
        temp = date.split("\\s+");
        String year = temp[temp.length - 1].trim();

        line = line.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "");

        String[] words = line.split("\\s+");

        for(String word: words) {
            if (word.trim().length() > 0) {
                context.write(new Text(word + "\t" + year), new Text("one"));
            }
        }
    }
}
