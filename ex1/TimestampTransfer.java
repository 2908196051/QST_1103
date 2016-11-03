package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//获取控制台输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置输入日期格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置输出日期格式
		while (scanner.hasNext()){//有输入则执行while
			String line = scanner.nextLine();// 用String类型的line接住输入
			Date lineDate = null;//定义Date类型的lineDate，初始值e为null
			long lineTimestamp;//定义long类型的lineTimestamp
			try {
				lineDate = inputFormat.parse(line);//给lineDate赋值为输入的日期格式
				lineTimestamp = lineDate.getTime();//获取时间戳
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//打印更改格式后的时间和时间戳
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
