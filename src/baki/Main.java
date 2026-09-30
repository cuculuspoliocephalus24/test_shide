package baki;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
			
		try {

		    Connection connection =
		            DatabaseManager.connect();

		    System.out.println(
		            "SQLite接続成功！"
		    );

		    connection.close();
		    
		    DatabaseManager.createTables();

		    System.out.println(
		            "テーブル作成成功！"
		    );
//		    DatabaseManager.deleteFighter(999);
		    DatabaseManager.initializeFighters();
		    DatabaseManager.initializeSceneCards();
		    DatabaseManager.initializeEquipments();
		    DatabaseManager.initializeSupporters();
		    
//		    Fighter testFighter =
//		            new Fighter(999, "SQLiteテスト");
//
//		    DatabaseManager.insertFighter(testFighter);
//
//		    System.out.println(
//		            "キャラクター登録成功！"
//		    );
		    
		    ArrayList<Fighter> dbFighters =
		            DatabaseManager.getFighters();

		    for (Fighter fighter : dbFighters) {

		        System.out.println(
		                fighter.getId()
		                + "："
		                + fighter.getName()
		        );
		    }
		    
		} catch (SQLException e) {

		    System.out.println(
		            "SQLite接続失敗"
		    );

		    e.printStackTrace();
		}
		
		new MainFrame();
		
		}
}

