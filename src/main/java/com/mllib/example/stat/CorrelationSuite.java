/**
* @Title: CorrelationSuite.java
* @Description: TODO(相关系数example)
* @author tovin/xutaota2003@163.com 
* @date 2014年10月10日 上午9:07:46 
 */
package com.mllib.example.stat;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.stat.Statistics;

import com.google.common.collect.Lists;

public class CorrelationSuite {
	public static void main(String[] args) {		
		JavaSparkContext sc = new JavaSparkContext("local", "CorrelationSuite");
		//计算(1.0,2.0,3.0)、(2.0,3.0,4.0)的皮尔逊相关系数
		JavaRDD r1 = sc.parallelize(Lists.newArrayList(1.0,2.0,3.0));		
		JavaRDD r2 = sc.parallelize(Lists.newArrayList(2.0,3.0,4.0));
		System.out.println(Statistics.corr(r1.rdd(), r2.rdd(),"pearson"));
		System.out.println(Statistics.corr(r1.rdd(), r2.rdd(),"spearman"));

		
		//计算矩阵的皮尔逊\spearman相关系数
		//(1.0,2.0,4.0)
		//(2.0,1.0,4.0)
		//(2.0,3.0,5.0)
		JavaRDD<Vector> r3 = sc.parallelize(Lists.newArrayList("1.0,2.0,4.0","2.0,1.0,4.0","3.0,4.0,5.0")).map(
			new Function<String, Vector>() {
				public Vector call(String v1) throws Exception {
					String[] s = v1.split(",");
					double[] d = new double[s.length];
					for(int i=0; i<s.length; i++)
					{
						d[i] = Double.valueOf(s[i]);
					}
					return Vectors.dense(d);
				}
			});
		
		System.out.println(Statistics.corr(r3.rdd(), "pearson"));
		System.out.println(Statistics.corr(r3.rdd(), "spearman"));
	}
}

