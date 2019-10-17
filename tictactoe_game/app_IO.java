package app_oving;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class app_IO implements app_loading{

	@Override
	public void save(String filename, Turn player) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter(filename);
		String fileText = String.format("%d,%d",player.getScoreX(),player.getScoreO());
		System.out.println(fileText);
		writer.print(fileText);
		writer.close();
	}

	@Override
	public app_objectloader load(String filename) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File(filename));
		String[] player = scanner.nextLine().split(",");
		Turn player1 = new Turn(Integer.parseInt(player[0]), Integer.parseInt(player[1]));
		scanner.close();
		
		app_objectloader loader = new app_objectloader();
		loader.player = player1;
		return loader;
	}

}

