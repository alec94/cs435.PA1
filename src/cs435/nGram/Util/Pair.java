package cs435.nGram.Util;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by Alec on 2/19/2017.
 * used to hold bigram pairs for profiles 2A and 2B
 */
public class Pair implements WritableComparable {
    private Text firstString;
    private Text secondString;

    public Pair(Text firstString, Text secondString){
        setPair(firstString, secondString);
    }

    private void setPair(Text firstString, Text secondString){
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public Text firstString(){
        return firstString;
    }

    public Text getSecondString(){
        return secondString;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        firstString.readFields(in);
        secondString.readFields(in);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        firstString.write(out);
        secondString.write(out);
    }

    @Override
    public String toString() {
        return firstString + " " + secondString;
    }

    @Override
    public int hashCode(){
        return firstString.hashCode()*163 + secondString.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Pair){
            Pair tp = (Pair) o;
            return firstString.equals(tp.firstString) && secondString.equals(tp.secondString);
        }
        return false;
    }

    @Override
    public int compareTo(Object tp) {
        int cmp = firstString.compareTo(((Pair) tp).firstString);

        if (cmp != 0) {
            return cmp;
        }

        return secondString.compareTo(((Pair) tp).secondString);
    }
}
