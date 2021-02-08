import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
public class WordCountMapper extends MapReduceBase implements
            Mapper<LongWritable, Text, Text, IntWritable> {
            // hadoop supported data types --- IntWritable and Text
            private final static IntWritable one = new IntWritable(1);
            private Text word = new Text();
            // map method does tokenizer job and constructs the key-value pairs
            public void map(LongWritable key, Text value,
            OutputCollector<Text, IntWritable> output, Reporter reporter)
            throws IOException {
            // taking one line at a time and tokenizing it
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            // iterate through all words in line and forms key-value pair
            while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            // To output collector which passes this to reducer
            output.collect(word, one);
        }
    }
}