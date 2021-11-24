import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class main{

	//Выводит помощь
	static void help() {
		System.out.println("LIST — выводит список email'ов" + "\nADD example@exp.net — добавление email");
	}

	//Обрабатывает введенную пользователем строку, возвращает либо чистый емейл
	// либо пустую строку если он не корректен
	static String stringConvert(String value){

		//Регвыражения для проверки емейла
		Pattern pattern = Pattern.compile("(\\S.*\\S)(@)(\\S.*\\S)(.\\S[a-z]{2,3})");

		//Убираем ADD из строки
		value = value.replaceFirst("ADD ", "");

		//Сопоставляем регвыр и строку
		Matcher matcher = pattern.matcher(value);

		//Проверяем что совпало по условию
		if (matcher.matches()) {
//			System.out.println("Full email: " + matcher.group(0));
//			System.out.println("Username: " + matcher.group(1));
//			System.out.println("Hosting Service: " + matcher.group(3));
//			System.out.println("TLD: " + matcher.group(4));
			return value;
		} else {
			return "";
		}
		

	}

	public static void main(String[] args) {
		
		//Create email base
		HashSet<String> eBase = new HashSet<>();

		//Showing help
		help();

		//Инициализация сканера и строки введенной пользователем
		Scanner scanner = new Scanner(System.in);
		String email = "";
		
		//Основной цикл программы
		while (true){
			
			//Get command from user
			System.out.print("What do you want to do? ");
			email = scanner.nextLine();

			//Если ввели ADD
			if (email.contains("ADD ") & email.indexOf("ADD ") == 0){
				email = stringConvert(email);

				if (email != ""){
					System.out.println("Added " + email);
					eBase.add(email);
				} else {
					System.out.println("E-mail incorrect");
				}

				continue;

				//Если ввели LIST
			} else if (email.contains("LIST")& email.length() == 4){
				
				if (eBase.size() == 0){
					System.out.println("The eBase is empty");
				} else {
					for(String currentEmail : eBase){
						System.out.println(currentEmail);
					}
				}
				continue;
				//Если ввели help
			} else if (email.contains("help")& email.length() == 4){
				help();
				//Если ввели комманду отличную от ADD, LIST, help
			} else{
				System.out.println("What? I don't understand...");
				continue;
			}
		}

	}
}
	
//HW5part2task1
// class main {
// 	public static void main(String[] args) {

// 		// Создается новый список
// 		ArrayList<String> ToDo = new ArrayList<>();

// 		//Первоначальный вывод help
// 		help();/

// 		// Цикл программы
// 		while (true) {

// 			// Главное меню

// 			System.out.print("Enter the command: ");

// 			// Инициализация ввода из терминала
// 			Scanner scanner = new Scanner(System.in);
// 			String value = scanner.nextLine();

// 			// Ввели LIST, проверяем в начале ли команда
// 			if (value.contains("LIST") & value.indexOf("LIST") == 0) {

// 				// Проверяем не пустой ли список
// 				if (ToDo.size() == 0) {
// 					System.out.println("Ваш список задач пуст :( ");
// 					continue;
// 				}

// 				// Читаем список
// 				for (int i = 0; i < ToDo.size(); i++) {
// 					// Добавляем к индексу +1 для удобства пользователя
// 					int number = i + 1;
// 					System.out.println(number + ") " + ToDo.get(i));
// 				};

// 				// Обратно в меню
// 				continue;

// 				// Ввели ADD, проверяем в начале ли команда
// 			} else if (value.contains("ADD") & value.indexOf("ADD") == 0) {

// 				String[] obtained = commandWithIndex("ADD", value);

// 				//Проверяем наличие введенного индекса
// 				if (obtained[0].isEmpty()){
// 					ToDo.add(obtained[1]);
// 				} else {
// 					if (Integer.parseInt(obtained[0]) > ToDo.size()){
// 						ToDo.add(obtained[1]);
// 						System.out.println("ADDED TO THE END");
// 					} else {
// 						ToDo.add(Integer.parseInt(obtained[0])-1, obtained[1]);
// 						System.out.println("ADDED TO THE NUMBER");
// 					}

// 				}


// 				// Обратно в меню
// 				continue;
// 				//Введи DELETE, проверяем в начале ли команда
// 			} else if (value.contains("DELETE") & value.indexOf("DELETE") == 0) {

// 				// Убираем DELETE и пробел
// 				value = value.replaceAll("DELETE?\\s+", "");
// 				ToDo.remove(Integer.parseInt(value) - 1);

// 				// Обратно в меню
// 				continue;

// 				//Вызов помощи
// 			} else if ((value.contains("help") & value.indexOf("help") == 0)){
// 				help();

// 				// Ввели EDIT, проверяем в начале ли команда
// 			} else if (value.contains("EDIT") & value.indexOf("EDIT") == 0){

// 				String obtaied[] = commandWithIndex("EDIT", value);

// 				ToDo.set(Integer.parseInt(obtaied[0])-1, obtaied[1]);

// 				// Обратно в меню
// 				continue;

// 				// Ввели EXIT, проверяем в начале ли команда
// 			} else if (value.contains("EXIT") & value.indexOf("EXIT") == 0) {
// 				System.out.println("Bye!");
// 				// Прерывания цикла while, конец работы программы
// 				break;
// 			}
// 		}
// 	}

// 	static String[] commandWithIndex(String commandType, String value){

// 		String[] toSent = new String[2];

// 		//Ищем конструкцию commandType + пробел + число? + пробел?
// 		Pattern pattern = Pattern.compile("%s \\d*\\s*".formatted(commandType));
// 		String command = "";
// 		Matcher matcher = pattern.matcher(value);
// 		while (matcher.find()) {
// 			int start=matcher.start();
// 			int end=matcher.end();
// 			//Сохраняем полученные значения
// 			command = value.substring(start,end);
// 		}

// 		// Убираем что нашли, задание для добавления готово
// 		toSent[1] = value.replaceAll(command, "");


// 		//Извлекаем индекс
// 		toSent[0] = command.trim().replaceFirst("%s\\s*".formatted(commandType), "");

// 		return toSent;
// 	}

// 	static void help(){
// 		System.out.println(
// 				"LIST — выводит дела с их порядковыми номерами" +
// 						"\nADD — добавляет дело или на определённое место если указать номер," +
// 						"\nEDIT — заменяет дело с указанным номером," +
// 						"\nDELETE — удаляет, " +
// 						"\nEXIT - выход");
// 	}
// }

// ДЗ 5.1 задание 3
// class main {
// public static void main(String[] args) {
// String[][] theX = {
// {"x", " ", " ", " ", " ", " ", "x"},
// {" ", "x", " ", " ", " ", "x", " "},
// {" ", " ", "x", " ", "x", " ", " "},
// {" ", " ", " ", "x", " ", " ", " "},
// {" ", " ", "x", " ", "x", " ", " "},
// {" ", "x", " ", " ", " ", "x", " "},
// {"x", " ", " ", " ", " ", " ", "x"},
// };

// for (int i=0; i < theX.length; i++){

// for (int j = 0; j < theX[i].length; j++){

// if (j == theX[i].length-1){
// System.out.println(theX[i][j]);
// } else {
// System.out.print(theX[i][j]);
// }

// }

// }

// }

// }

// ДЗ 5.1 задание 2
// class Main {
// public static void main(String[] args) {

// final int patientsCount = 30;

// final double highTempPatients = 40.0;

// final double lowTempPatients = 32.0;

// final double lowTemp = 36.2;

// final int patientsCount = 30;

// final double highTempPatients = 40.0;

// final double lowTempPatients = 32.0;

// final double lowTemp = 36.2;

// while (true){
// number = (float) Math.random() * 100;
// if (number < highTempPatients & number > lowTempPatients){
// break;
// } else {
// continue;
// }
// }

// sumTemp += number;
// patientsTemp[i]= number;

// final int patientsCount = 30;

// final double highTempPatients = 40.0;

// final double lowTempPatients = 32.0;

// final double lowTemp = 36.2;

// }

// ДЗ 5.1 задание 1
// class main{
// public static void main(String[] args) {
// String line = "Каждый охотник желает знать, где сидит фазан";
// System.out.println(line);
// String[] words = line.split("\\s");

// for (int i=0;i < words.length;i++){
// System.out.println(i + " " + words[i]);
// }

// String temp = "";

// for (int index = 0; index < (words.length-1)/2; index++){

// int lastIndex = (words.length-1)-index;

// System.out.println("Начальный индекс " + index + " конечный индекс " +
// lastIndex);

// temp = words[index];
// words[index] = words[lastIndex];
// words[lastIndex] = temp;

// }

// for (int i=0;i < words.length;i++){
// System.out.println(words[i]);
// }
// }
// }

// ДЗ 4.6 задание 1
// class main{
// public static void main(String[] args) {
// int day = 19;
// int month = 7;
// int year = 1997;

// Calendar calendar = Calendar.getInstance();
// // System.out.println(calendar.getWeekYear());
// // calendar.set(year, month, day);
// // System.out.println(calendar.getTime());
// System.out.println(calendar.getWeekYear() - year);
// // calendar.add(calendar.YEAR, 1);
// // System.out.println(calendar.getWeekYear());

// int age = calendar.getWeekYear() - year;
// DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE");

// for (int i = 0; i <= age; i++){
// calendar.set(year, month, day);
// calendar.add(calendar.YEAR, i);
// System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
// }
// }
// }

// ДЗ 4.5 задание со звёздочкой
// public class main {
// public static void main(String[] args) {
// String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234
// 5678> 8912", "***");
// System.out.println(safe);
// }

// public static String searchAndReplaceDiamonds(String text, String
// placeholder){
// String safe = text.replaceAll("<\\d+ \\d+ \\d+>", placeholder);
// return safe;
// }
// }

// ДЗ 4.5 задание 4
// class main{
// public static void main(String[] args) {

// while (true){
// System.out.print("Enter phone number: ");
// String line = (new Scanner(System.in).nextLine());
// //String line = "8-905-1234567";
// String phone = line.replaceAll("[^0-9]", "");

// if (phone.length() > 11) {
// System.out.println("Error: wrong phone lenght - too long!");
// continue;
// } else if (phone.length() == 10 & phone.charAt(0) == '9'){
// phone = "7" + phone;
// System.out.println("Added code of country. Number is " + phone);
// break;
// } else if (phone.length() < 10) {
// System.out.println("Error: wrong phone lenght - too short!");
// continue;
// }

// if (phone.charAt(0) == '8'){
// phone = phone.replaceAll("8", "7");
// System.out.println("Changed 8 to 7 " + phone);
// break;
// } else if (phone.charAt(0) != '7'){
// System.out.println("Error: wrong contry code!");
// continue;
// }
// break;
// }

// System.out.println("The number has been acepted!");
// }
// }

// ДЗ 4.5 задание 3
// class main {
// public static void main(String[] args) {

// Scanner scanner = new Scanner(System.in);
// System.out.print("Введите ФИО:");
// String line = scanner.nextLine();

// String massive[] = line.split("\\s");

// String firstName = massive[0];
// String lastName = massive [1];
// String patronymic = massive [2];

// System.out.println("Фамилия " + firstName + "\nИмя " + lastName + "\nОтчество
// " + patronymic);

// }
// }

// ДЗ 4.5 задание 2
// class main {
// public static void main(String[] args) {
// String text = "Abroad the school year begins in September; they call this
// moment like ‘back to school’. The first holidays start at the end of October.
// Students and their teachers have two weeks of having a rest.\n" +
// "\n" +
// "Then it is time for Christmas holidays. Christmas is a very important
// holiday in Europe and USA. All the family members meet together. They can see
// their parents, grandparents, uncles and aunts, cousins, and so on. The
// holiday meal lasts for a long time and they exchange gifts on the 25th of
// December. They have a vacation to have time to meet up with family. There are
// almost two weeks for it.\n" +
// "\n" +
// "In winter there are also winter holidays; these holidays are different from
// Christmas holidays. It happens in February for a week. Many people go skiing
// or snowboarding. But winter sports are very expensive, that is why not
// everyone can afford it.\n" +
// "\n" +
// "After the winter holidays, there is a spring break. It happens in March and
// it is the last vacation before the end of the school year. High school
// students have to study a lot during these holidays because they are just
// before their school finishing.\n" +
// "\n" +
// "The most anticipated moment of the year is summer holidays. These holidays
// last during two months. Boys and girls often try to work a bit to earn some
// pocket money.";
// String massive[] = text.split("\\s+");
// for (int i = 0; i < massive.length; i++){
// System.out.println(massive[i]);
// }
// }
// }

// Задание 4.5задание 1
// class main {
// public static void main(String[] args) {
// String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000
// рублей";
// Pattern pattern = Pattern.compile("\\d+");
// Matcher matcher = pattern.matcher(text);
// double sum = 0;
// while (matcher.find()){
// sum += Integer.parseInt(text.substring(matcher.start(), matcher.end()));
// }
// System.out.println("Итого: " + sum);
// }
// }

// домашнее задание 4.4 упражнение 5*
// public class main {
// public static void main(String[] args) {
// String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234
// 5678> 8912", "***");
// System.out.println(safe);
// }
//
// public static String searchAndReplaceDiamonds(String text, String
// placeholder){
// String safe = text.replace(text.substring(text.indexOf('<'),
// text.indexOf('>') + 1), placeholder);
// return safe;
// }
// }

// дз 4,4 задание 3
// public class main {
// public static void main(String[] args) {
//
// while (true) {
//
// Scanner scanner = new Scanner(System.in);
// System.out.print("Enter FIO: ");
// String fullName = scanner.nextLine();
//
// if (fullName.length() != 0){
// if (fullName.indexOf(' ') != -1){
// String familia = fullName.substring(0, fullName.indexOf(' '));
// System.out.println("Фамилия: " + familia);
// } else {
// System.out.println("Name NotFound");
// continue;
// }
//
// if ((fullName.indexOf(" ") + 1) < fullName.lastIndexOf(" ") ){
// String name = fullName.substring(fullName.indexOf(" ") + 1,
// fullName.lastIndexOf(" "));
// System.out.println("Имя: " + name);
// } else {
// System.out.println("Otchestvo Not Found");
// continue;
// }
//
// if (fullName.lastIndexOf(" ")+1 != fullName.length()){
// String otchestvo = fullName.substring(fullName.lastIndexOf(" ") + 1);
// System.out.println("Отчество: " + otchestvo);
// } else {
// System.out.println("Otchestvo Not Found");
// continue;
// }
// } else {
// System.out.println("Введите ФИО!");
// continue;
// }
// break;
// }
//
// }
// }
