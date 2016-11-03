package GID.AID;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse(args[0]);//"2015-12-31 18:00:00"
		Date endDate = regularFormat.parse(args[1]);//"2015-12-31 19:00:00"
		Locale locale = Locale.US; // 语言信息美国化
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale);
		Scanner scanner = new Scanner(System.in);
		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]* [^ ]*)\\] \"[^ ]+ ([^ ]+) .*\" \\d+ \\d+ \"(.*)\" \"(.*)\"";
		Pattern p = Pattern.compile(pattern);
		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
		Matcher m = p.matcher(line);
			if (m.find()) {
				String strIp = m.group(1);
				String strTime = m.group(2);
				Date dateTime = inputFormat.parse(strTime);
				if (dateTime.before(endDate) && dateTime.after(beginDate)) {
					System.out.println(strIp + "\t" + dateTime);
				}
			}

			// 对在时间区间内的数据进行输出

		}
	}
}
