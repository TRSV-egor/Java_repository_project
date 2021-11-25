import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw5part3task1 {

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
			System.out.print("What do you want to do? :");
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
