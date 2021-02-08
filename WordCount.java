import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
public class WordCountDriver extends Configured implements Tool {
 public int run(String[] args) throws Exception {
 // Create a JobConf Object and assign it a name
 JobConf conf = new JobConf(getConf(), WordCountDriver.class);
 conf.setJobName("WordCount");
 // Set Config object with Data Type of output Key = Text and Value = Int
 conf.setOutputKeyClass(Text.class);
 conf.setOutputValueClass(IntWritable.class);
 // Setting conf object with mapper and reducer class
 conf.setMapperClass(WordCountMapper.class);
 conf.setReducerClass(WordCountReducer.class);
 // HDFS input & output directory would be fetched from command-line
 FileInputFormat.addInputPath(conf, new Path(args[0]));
 FileOutputFormat.setOutputPath(conf, new Path(args[1]));
// To run JobClient
 JobClient.runJob(conf);
 return 0;
 }
 // main() function which runs WordCountDriver
 public static void main(String[] args) throws Exception {
 int res = ToolRunner.run(new Configuration(), new WordCountDriver(), args);
 System.exit(res);
 }
}