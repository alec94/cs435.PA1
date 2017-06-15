package cs435.nGram.Profile1A;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Alec on 2/18/2017.
 *
 */
public class UnigramYearReducer extends Reducer<Text, Text,Text,IntWritable>{
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;

        for (Text year: values){
            count++;
        }

        context.write(key,new IntWritable(count));
    }
}
