package cs435.nGram.Profile1B;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Alec on 2/18/2017.
 * unigrams sorted by authors last name
 */
public class UnigramNameReducer extends Reducer<Text, Text,Text,IntWritable> {
    public void reduce(Text key, Iterable<Text> values, Reducer.Context context) throws IOException, InterruptedException {
        int count = 0;
        for (Text author: values){
           count++;
        }

        context.write(key, new IntWritable(count));


    }
}
