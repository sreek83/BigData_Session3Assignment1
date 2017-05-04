package test.hadoop.practice;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class HadoopAssignment3_Task2 {
	
	
	
	public static void displayFiles (FileSystem fileSystem,Path dirpath,int noOfFiles) {
	
	System.out.println("HadoopAssignment3_Task2  --> displayFiles -->Start");
		
		try
		{
		FileStatus[] fileStatus=fileSystem.listStatus(dirpath);
		
		for (FileStatus fStat : fileStatus) {
		
			if (fStat.isDirectory()) {
				System.out.println("Directory: " + fStat.getPath());
				displayFiles(fileSystem,fStat.getPath(),noOfFiles);
			}
			else if (fStat.isFile()) {
				System.out.println("File: " + fStat.getPath());
				noOfFiles = noOfFiles+1;
			}
		
		}
		//System.out.println("HadoopAssignment4 Total files"+noOfFiles);
		System.out.println("HadoopAssignment3_Task2  --> displayFiles -->End");
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("HadoopAssignment3_Task2  --> Start");
		Path path = new Path(args[0]);
		int noOfFiles = 0;
		try
		{
			Configuration conf = new Configuration();
			FileSystem fileSystem = FileSystem.get(new URI("hdfs://localhost:9000"), conf);
			System.out.println("HadoopAssignment3_Task2  ---->args"+args[0]);
			displayFiles (fileSystem,path,noOfFiles);
			System.out.println("HadoopAssignment3_Task2  --> End");			
		
		}
		catch (Exception e)
		{
            e.printStackTrace();
		}
	}
}