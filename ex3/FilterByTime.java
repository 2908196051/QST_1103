package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		Locale locale = Locale.US; // 语言信息美国化
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale);
		String filePath = "C:\\Users\\郑\\Desktop\\20161102\\access.log.txt";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]* [^ ]*)\\] \"[^ ]+ ([^ ]+) .*\" \\d+ \\d+ \"(.*)\" \"(.*)\"";
		Pattern p = Pattern.compile(pattern);
		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			/*
			 * String[] tokens=line.split(" "); String strIp = tokens[0]; String
			 * strTime = tokens[3];
			 */

			Matcher m = p.matcher(line);
			if (m.find()) {
				String strIp = m.group(1);
				String strTime = m.group(2);
				Date dateTime = inputFormat.parse(strTime);
				if (dateTime.before(endDate) && dateTime.after(beginDate)) {
					System.out.println(strIp + "\t" + regularFormat.format(dateTime));
				}
			}

			// 对在时间区间内的数据进行输出

		}
	}

}
