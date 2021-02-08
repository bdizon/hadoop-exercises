import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
public class WordCountReducer extends MapReduceBase implements
    Reducer<Text, IntWritable, Text, IntWritable> {
    /*
    * reduce method accepts Key-Value pairs from mappers and does
    * aggregation based on keys and produces final result
    */
    public void reduce(Text key, Iterator<IntWritable> values,
    OutputCollector<Text, IntWritable> output, Reporter reporter)
    throws IOException {
    int sum = 0;
    /*
    * Reducer iterates through all values available with a key and sums to give
    * final result as key and sum of its values i.e. [key, sum(keys)]
    */
    while (values.hasNext()) {
        sum += values.next().get();
        }
        output.collect(key, new IntWritable(sum));
        }
   }