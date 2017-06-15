package cs435.nGram.Profile1B;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Alec on 2/18/2017.
 *Pro
 */
public class UnigramNameMapper extends Mapper<LongWritable,Text,Text,Text> {
    public void map(LongWritable key, Text value, Mapper.Context context) throws
            IOException, InterruptedException{
        String[] temp = value.toString().split("<===>");
        String authorFullName = temp[0];
        //do not need date
        //String date = temp[1];
        String line = temp[2];

        temp = authorFullName.split("\\s+");
        String authorLastName = temp[temp.length-1].trim();

        line = line.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "");

        String[] words = line.split("\\s+");
        for(String word: words) {
            if (word.trim().length() > 0) {
                context.write(new Text(word.toLowerCase() + "\t" + authorLastName), new Text("one"));
            }
        }
    }
}
