/**
* @Title: ChiSquaredSuite.java
* @Description: TODO(pearson卡方检验example)
* @author tovin/xutaota2003@163.com 
* @date 2014年10月11日 下午3:22:46 
 */
package com.mllib.example.stat;

import org.apache.spark.mllib.linalg.DenseVector;
import org.apache.spark.mllib.linalg.Matrices;
import org.apache.spark.mllib.linalg.Matrix;
import org.apache.spark.mllib.stat.Statistics;


public class ChiSquaredSuite {

	public static void main(String[] args) {		
			//Goodness of Fit test
			System.out.println(Statistics.chiSqTest(new DenseVector(new double[]{1.0,2.0,3.0})));
			
			System.out.println(Statistics.chiSqTest(
					new DenseVector(new double[]{1.0,2.0,3.0}),
					new DenseVector(new double[]{10.0,3.0,1.0})));
			
			//independence test
			System.out.println(Statistics.chiSqTest(Matrices.dense(2, 2, new double[]{1.0,2.0,2.0,4.0})));
	}
}

