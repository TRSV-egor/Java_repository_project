import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw5part2task1 {
 	public static void main(String[] args) {

 		// Создается новый список
 		ArrayList<String> ToDo = new ArrayList<>();

 		//Первоначальный вывод help
 		help();

 		// Цикл программы
 		while (true) {

 			// Главное меню

 			System.out.print("Enter the command: ");

 			// Инициализация ввода из терминала
 			Scanner scanner = new Scanner(System.in);
 			String value = scanner.nextLine();

 			// Ввели LIST, проверяем в начале ли команда
 			if (value.contains("LIST") & value.indexOf("LIST") == 0) {

 				// Проверяем не пустой ли список
 				if (ToDo.size() == 0) {
 					System.out.println("Ваш список задач пуст :( ");
 					continue;
 				}

 				// Читаем список
 				for (int i = 0; i < ToDo.size(); i++) {
 					// Добавляем к индексу +1 для удобства пользователя
 					int number = i + 1;
 					System.out.println(number + ") " + ToDo.get(i));
 				};

 				// Обратно в меню
 				continue;

 				// Ввели ADD, проверяем в начале ли команда
 			} else if (value.contains("ADD") & value.indexOf("ADD") == 0) {

 				String[] obtained = commandWithIndex("ADD", value);

 				//Проверяем наличие введенного индекса
 				if (obtained[0].isEmpty()){
 					ToDo.add(obtained[1]);
 				} else {
 					if (Integer.parseInt(obtained[0]) > ToDo.size()){
 						ToDo.add(obtained[1]);
 						System.out.println("ADDED TO THE END");
 					} else {
 						ToDo.add(Integer.parseInt(obtained[0])-1, obtained[1]);
 						System.out.println("ADDED TO THE NUMBER");
 					}

 				}


 				// Обратно в меню
 				continue;
 				//Введи DELETE, проверяем в начале ли команда
 			} else if (value.contains("DELETE") & value.indexOf("DELETE") == 0) {

 				// Убираем DELETE и пробел
 				value = value.replaceAll("DELETE?\\s+", "");
 				ToDo.remove(Integer.parseInt(value) - 1);

 				// Обратно в меню
 				continue;

 				//Вызов помощи
 			} else if ((value.contains("help") & value.indexOf("help") == 0)){
 				help();

 				// Ввели EDIT, проверяем в начале ли команда
 			} else if (value.contains("EDIT") & value.indexOf("EDIT") == 0){

 				String obtaied[] = commandWithIndex("EDIT", value);

 				ToDo.set(Integer.parseInt(obtaied[0])-1, obtaied[1]);

 				// Обратно в меню
 				continue;

 				// Ввели EXIT, проверяем в начале ли команда
 			} else if (value.contains("EXIT") & value.indexOf("EXIT") == 0) {
 				System.out.println("Bye!");
 				// Прерывания цикла while, конец работы программы
 				break;
 			}
 		}
 	}

 	static String[] commandWithIndex(String commandType, String value){

 		String[] toSent = new String[2];

 		//Ищем конструкцию commandType + пробел + число? + пробел?
 		Pattern pattern = Pattern.compile("%s \\d*\\s*".formatted(commandType));
 		String command = "";
 		Matcher matcher = pattern.matcher(value);
 		while (matcher.find()) {
 			int start=matcher.start();
 			int end=matcher.end();
 			//Сохраняем полученные значения
 			command = value.substring(start,end);
 		}

 		// Убираем что нашли, задание для добавления готово
 		toSent[1] = value.replaceAll(command, "");


 		//Извлекаем индекс
 		toSent[0] = command.trim().replaceFirst("%s\\s*".formatted(commandType), "");

 		return toSent;
 	}

 	static void help(){
 		System.out.println(
 				"LIST — выводит дела с их порядковыми номерами" +
 						"\nADD — добавляет дело или на определённое место если указать номер," +
 						"\nEDIT — заменяет дело с указанным номером," +
 						"\nDELETE — удаляет, " +
 						"\nEXIT - выход");
 	}


}
