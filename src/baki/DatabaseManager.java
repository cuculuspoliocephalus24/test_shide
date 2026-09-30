package baki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DatabaseManager {

	private static final String URL =
	        "jdbc:sqlite:baki.db";
	
	public static Connection connect()
	        throws SQLException {

	    Connection connection =
	            DriverManager.getConnection(URL);

	    return connection;
	}
	public static void createTables()
	        throws SQLException {

	    String fighterSql =
	            "CREATE TABLE IF NOT EXISTS fighters ("
	            + "id INTEGER PRIMARY KEY, "
	            + "name TEXT NOT NULL"
	            + ")";

	    String sceneCardSql =
	            "CREATE TABLE IF NOT EXISTS scene_cards ("
	            + "id INTEGER PRIMARY KEY, "
	            + "name TEXT NOT NULL"
	            + ")";

	    String equipmentSql =
	            "CREATE TABLE IF NOT EXISTS equipments ("
	            + "id INTEGER PRIMARY KEY, "
	            + "name TEXT NOT NULL"
	            + ")";
	    
	    String supporterSql =
	            "CREATE TABLE IF NOT EXISTS supporters ("
	            + "id INTEGER PRIMARY KEY, "
	            + "name TEXT NOT NULL"
	            + ")";
	    
	    String trainingRecordSql =
	            "CREATE TABLE IF NOT EXISTS training_records ("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
	            + "fighter_id INTEGER NOT NULL, "

	            + "start_strength INTEGER NOT NULL DEFAULT 0, "
	            + "start_stamina INTEGER NOT NULL DEFAULT 0, "
	            + "start_technique INTEGER NOT NULL DEFAULT 0, "
	            + "start_toughness INTEGER NOT NULL DEFAULT 0, "
	            + "start_agility INTEGER NOT NULL DEFAULT 0, "
	            + "start_mental INTEGER NOT NULL DEFAULT 0, "

	            + "strength INTEGER NOT NULL DEFAULT 0, "
	            + "stamina INTEGER NOT NULL DEFAULT 0, "
	            + "technique INTEGER NOT NULL DEFAULT 0, "
	            + "toughness INTEGER NOT NULL DEFAULT 0, "
	            + "agility INTEGER NOT NULL DEFAULT 0, "
	            + "mental INTEGER NOT NULL DEFAULT 0, "

	            + "total_status INTEGER NOT NULL, "
	            + "note TEXT, "
	            + "created_at TEXT DEFAULT CURRENT_TIMESTAMP"
	            + ")";
	    
	    String trainingSceneCardSql =
	            "CREATE TABLE IF NOT EXISTS training_scene_cards ("
	            + "training_record_id INTEGER NOT NULL, "
	            + "slot INTEGER NOT NULL, "
	            + "scene_card_id INTEGER NOT NULL, "
	            + "PRIMARY KEY (training_record_id, slot)"
	            + ")";
	   
	    String trainingSupporterSql =
	            "CREATE TABLE IF NOT EXISTS training_supporters ("
	            + "training_record_id INTEGER NOT NULL, "
	            + "slot INTEGER NOT NULL, "
	            + "supporter_id INTEGER NOT NULL, "
	            + "PRIMARY KEY (training_record_id, slot)"
	            + ")";
	    
	    String trainingSubAbilitySql =
	            "CREATE TABLE IF NOT EXISTS training_sub_abilities ("
	            + "training_record_id INTEGER NOT NULL, "
	            + "equipment_slot INTEGER NOT NULL, "
	            + "ability_slot INTEGER NOT NULL, "
	            + "ability_name TEXT NOT NULL, "
	            + "ability_value REAL NOT NULL, "
	            + "PRIMARY KEY "
	            + "(training_record_id, equipment_slot, ability_slot)"
	            + ")";
	    
	    String trainingEquipmentSql =
		        "CREATE TABLE IF NOT EXISTS training_equipments ("
		        + "training_record_id INTEGER NOT NULL, "
		        + "slot INTEGER NOT NULL, "
		        + "equipment_id INTEGER NOT NULL, "
		        + "PRIMARY KEY (training_record_id, slot)"
		        + ")";
		
	    
	    try (Connection connection = connect();
	         Statement statement = connection.createStatement()) {

	        statement.execute(fighterSql);
	        statement.execute(sceneCardSql);
	        statement.execute(equipmentSql);
	        statement.execute(supporterSql);
	        statement.execute(trainingRecordSql);
	        statement.execute(trainingSceneCardSql);
	        statement.execute(trainingSupporterSql);
	        statement.execute(trainingEquipmentSql);
	        statement.execute(trainingSubAbilitySql);
	        
	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN strength INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN stamina INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN technique INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN toughness INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN agility INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN mental INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }
	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_strength INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_stamina INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_technique INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_toughness INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_agility INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }

	        try {
	            statement.execute(
	                    "ALTER TABLE training_records "
	                    + "ADD COLUMN start_mental INTEGER NOT NULL DEFAULT 0"
	            );
	        } catch (SQLException ex) {
	            // すでに列がある場合は何もしない
	        }
	    }
	}
	
	
	public static void insertFighter(Fighter fighter)
	        throws SQLException {

	    String sql =
	            "INSERT INTO fighters (id, name) VALUES (?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(1, fighter.getId());
	        statement.setString(2, fighter.getName());
	        statement.executeUpdate();
	    }
	    
	}
	public static void insertSceneCard(SceneCard sceneCard)
	        throws SQLException {

	    String sql =
	            "INSERT INTO scene_cards (id, name) VALUES (?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                sceneCard.getId()
	        );

	        statement.setString(
	                2,
	                sceneCard.getName()
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static void insertEquipment(Equipment equipment)
	        throws SQLException {

	    String sql =
	            "INSERT INTO equipments (id, name) VALUES (?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                equipment.getId()
	        );

	        statement.setString(
	                2,
	                equipment.getName()
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static void insertSupporter(Supporter supporter)
	        throws SQLException {

	    String sql =
	            "INSERT INTO supporters (id, name) VALUES (?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                supporter.getId()
	        );

	        statement.setString(
	                2,
	                supporter.getName()
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static void initializeSupporters()
	        throws SQLException {

	    ArrayList<Supporter> dbSupporters =
	            getSupporters();

	    // DBにすでにサポーターがあれば何もしない
	    if (!dbSupporters.isEmpty()) {
	        return;
	    }

	    // SupporterData.java から初期データを取得
	    ArrayList<Supporter> initialSupporters =
	            SupporterData.getSupporters();

	    // SQLiteへ1人ずつ保存
	    for (Supporter supporter : initialSupporters) {

	        insertSupporter(supporter);
	    }
	}
	
	public static int insertTrainingRecord(
	        Fighter fighter,

	        int startStrength,
	        int startStamina,
	        int startTechnique,
	        int startToughness,
	        int startAgility,
	        int startMental,

	        int strength,
	        int stamina,
	        int technique,
	        int toughness,
	        int agility,
	        int mental,

	        int totalStatus,
	        String note
	        )
	        throws SQLException {

	    String sql =
	            "INSERT INTO training_records "
	            + "(fighter_id, "
	            + "start_strength, start_stamina, start_technique, "
	            + "start_toughness, start_agility, start_mental, "
	            + "strength, stamina, technique, "
	            + "toughness, agility, mental, "
	            + "total_status, note) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(
	                         sql,
	                         Statement.RETURN_GENERATED_KEYS
	                 )) {

	        statement.setInt(
	                1,
	                fighter.getId()
	        );

	        // ====================
	        // 開始時6ステータス
	        // ====================

	        statement.setInt(
	                2,
	                startStrength
	        );

	        statement.setInt(
	                3,
	                startStamina
	        );

	        statement.setInt(
	                4,
	                startTechnique
	        );

	        statement.setInt(
	                5,
	                startToughness
	        );

	        statement.setInt(
	                6,
	                startAgility
	        );

	        statement.setInt(
	                7,
	                startMental
	        );


	        // ====================
	        // 終了時6ステータス
	        // ====================

	        statement.setInt(
	                8,
	                strength
	        );

	        statement.setInt(
	                9,
	                stamina
	        );

	        statement.setInt(
	                10,
	                technique
	        );

	        statement.setInt(
	                11,
	                toughness
	        );

	        statement.setInt(
	                12,
	                agility
	        );

	        statement.setInt(
	                13,
	                mental
	        );


	        // 総戦力
	        statement.setInt(
	                14,
	                totalStatus
	        );

	        // 備考
	        statement.setString(
	                15,
	                note
	        );

	        statement.executeUpdate();

	        // 自動で作られた育成記録IDを取得
	        try (ResultSet resultSet =
	                     statement.getGeneratedKeys()) {

	            if (resultSet.next()) {

	                return resultSet.getInt(1);
	            }
	        }
	    }

	    throw new SQLException(
	            "育成記録IDを取得できませんでした"
	    );
	}
	
	public static void insertTrainingSceneCard(
	        int trainingRecordId,
	        int slot,
	        SceneCard sceneCard)
	        throws SQLException {

	    String sql =
	            "INSERT INTO training_scene_cards "
	            + "(training_record_id, slot, scene_card_id) "
	            + "VALUES (?, ?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        statement.setInt(
	                2,
	                slot
	        );

	        statement.setInt(
	                3,
	                sceneCard.getId()
	        );

	        statement.executeUpdate();
	    }
	}
	public static void insertTrainingSupporter(
	        int trainingRecordId,
	        int slot,
	        Supporter supporter)
	        throws SQLException {

	    String sql =
	            "INSERT INTO training_supporters "
	            + "(training_record_id, slot, supporter_id) "
	            + "VALUES (?, ?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        statement.setInt(
	                2,
	                slot
	        );

	        statement.setInt(
	                3,
	                supporter.getId()
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static void insertTrainingEquipment(
	        int trainingRecordId,
	        int slot,
	        Equipment equipment)
	        throws SQLException {

	    String sql =
	            "INSERT INTO training_equipments "
	            + "(training_record_id, slot, equipment_id) "
	            + "VALUES (?, ?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        statement.setInt(
	                2,
	                slot
	        );

	        statement.setInt(
	                3,
	                equipment.getId()
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static void insertTrainingSubAbility(
	        int trainingRecordId,
	        int equipmentSlot,
	        int abilitySlot,
	        String abilityName,
	        double abilityValue)
	        throws SQLException {

	    String sql =
	            "INSERT INTO training_sub_abilities "
	            + "(training_record_id, equipment_slot, "
	            + "ability_slot, ability_name, ability_value) "
	            + "VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        statement.setInt(
	                2,
	                equipmentSlot
	        );

	        statement.setInt(
	                3,
	                abilitySlot
	        );

	        statement.setString(
	                4,
	                abilityName
	        );

	        statement.setDouble(
	                5,
	                abilityValue
	        );

	        statement.executeUpdate();
	    }
	}
	
	public static ArrayList<TrainingRecord> getTrainingRecords()
	        throws SQLException {

	    ArrayList<TrainingRecord> records =
	            new ArrayList<>();

	    String sql =
	            "SELECT "
	            + "tr.id, "
	            + "tr.start_strength, "
	            + "tr.start_stamina, "
	            + "tr.start_technique, "
	            + "tr.start_toughness, "
	            + "tr.start_agility, "
	            + "tr.start_mental, "
	            + "tr.strength, "
	            + "tr.stamina, "
	            + "tr.technique, "
	            + "tr.toughness, "
	            + "tr.agility, "
	            + "tr.mental, "
	            + "tr.total_status, "
	            + "tr.note, "
	            + "tr.created_at, "
	            + "f.id AS fighter_id, "
	            + "f.name AS fighter_name "
	            + "FROM training_records tr "
	            + "JOIN fighters f "
	            + "ON tr.fighter_id = f.id "
	            + "ORDER BY tr.id DESC";
	    
	    try (Connection connection = connect();
	         Statement statement =
	                 connection.createStatement();
	         ResultSet resultSet =
	                 statement.executeQuery(sql)) {

	        while (resultSet.next()) {

	            int id =
	                    resultSet.getInt("id");

	            int fighterId =
	                    resultSet.getInt("fighter_id");

	            String fighterName =
	                    resultSet.getString("fighter_name");

	         // ====================
	         // 育成開始時ステータス
	         // ====================

	         int startStrength =
	                 resultSet.getInt(
	                         "start_strength"
	                 );

	         int startStamina =
	                 resultSet.getInt(
	                         "start_stamina"
	                 );

	         int startTechnique =
	                 resultSet.getInt(
	                         "start_technique"
	                 );

	         int startToughness =
	                 resultSet.getInt(
	                         "start_toughness"
	                 );

	         int startAgility =
	                 resultSet.getInt(
	                         "start_agility"
	                 );

	         int startMental =
	                 resultSet.getInt(
	                         "start_mental"
	                 );
	            
	            int strength =
	                    resultSet.getInt("strength");

	            int stamina =
	                    resultSet.getInt("stamina");

	            int technique =
	                    resultSet.getInt("technique");

	            int toughness =
	                    resultSet.getInt("toughness");

	            int agility =
	                    resultSet.getInt("agility");

	            int mental =
	                    resultSet.getInt("mental");
	            
	            int totalStatus =
	                    resultSet.getInt("total_status");

	            String note =
	                    resultSet.getString("note");

	            String createdAt =
	                    resultSet.getString("created_at");


	            Fighter fighter =
	                    new Fighter(
	                            fighterId,
	                            fighterName
	                    );


	            TrainingRecord record =
	                    new TrainingRecord(
	                            id,
	                            fighter,

	                            startStrength,
	                            startStamina,
	                            startTechnique,
	                            startToughness,
	                            startAgility,
	                            startMental,

	                            strength,
	                            stamina,
	                            technique,
	                            toughness,
	                            agility,
	                            mental,

	                            totalStatus,
	                            note,
	                            createdAt
	                    );
	            records.add(record);
	        }
	    

	    return records;
	}
	}
	public static ArrayList<SceneCard> getTrainingSceneCards(
	        int trainingRecordId)
	        throws SQLException {

	    ArrayList<SceneCard> sceneCards =
	            new ArrayList<>();

	    String sql =
	            "SELECT sc.id, sc.name "
	            + "FROM training_scene_cards tsc "
	            + "JOIN scene_cards sc "
	            + "ON tsc.scene_card_id = sc.id "
	            + "WHERE tsc.training_record_id = ? "
	            + "ORDER BY tsc.slot";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        try (ResultSet resultSet =
	                     statement.executeQuery()) {

	            while (resultSet.next()) {

	                int id =
	                        resultSet.getInt("id");

	                String name =
	                        resultSet.getString("name");

	                SceneCard sceneCard =
	                        new SceneCard(
	                                id,
	                                name
	                        );

	                sceneCards.add(
	                        sceneCard
	                );
	            }
	        }
	    }

	    return sceneCards;
	}
	
	public static ArrayList<Supporter> getTrainingSupporters(
	        int trainingRecordId)
	        throws SQLException {

	    ArrayList<Supporter> supporters =
	            new ArrayList<>();

	    String sql =
	            "SELECT s.id, s.name "
	            + "FROM training_supporters ts "
	            + "JOIN supporters s "
	            + "ON ts.supporter_id = s.id "
	            + "WHERE ts.training_record_id = ? "
	            + "ORDER BY ts.slot";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        try (ResultSet resultSet =
	                     statement.executeQuery()) {

	            while (resultSet.next()) {

	                int id =
	                        resultSet.getInt("id");

	                String name =
	                        resultSet.getString("name");

	                Supporter supporter =
	                        new Supporter(
	                                id,
	                                name
	                        );

	                supporters.add(
	                        supporter
	                );
	            }
	        }
	    }

	    return supporters;
	}
	
	public static ArrayList<Equipment> getTrainingEquipments(
	        int trainingRecordId)
	        throws SQLException {

	    ArrayList<Equipment> equipments =
	            new ArrayList<>();

	    String sql =
	            "SELECT e.id, e.name "
	            + "FROM training_equipments te "
	            + "JOIN equipments e "
	            + "ON te.equipment_id = e.id "
	            + "WHERE te.training_record_id = ? "
	            + "ORDER BY te.slot";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        try (ResultSet resultSet =
	                     statement.executeQuery()) {

	            while (resultSet.next()) {

	                int id =
	                        resultSet.getInt("id");

	                String name =
	                        resultSet.getString("name");

	                Equipment equipment =
	                        new Equipment(
	                                id,
	                                name
	                        );

	                equipments.add(
	                        equipment
	                );
	            }
	        }
	    }

	    return equipments;
	}
	
	public static ArrayList<TrainingSubAbility> getTrainingSubAbilities(
	        int trainingRecordId)
	        throws SQLException {

	    ArrayList<TrainingSubAbility> subAbilities =
	            new ArrayList<>();

	    String sql =
	            "SELECT "
	            + "equipment_slot, "
	            + "ability_slot, "
	            + "ability_name, "
	            + "ability_value "
	            + "FROM training_sub_abilities "
	            + "WHERE training_record_id = ? "
	            + "ORDER BY equipment_slot, ability_slot";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(
	                1,
	                trainingRecordId
	        );

	        try (ResultSet resultSet =
	                     statement.executeQuery()) {

	            while (resultSet.next()) {

	                int equipmentSlot =
	                        resultSet.getInt(
	                                "equipment_slot"
	                        );

	                int abilitySlot =
	                        resultSet.getInt(
	                                "ability_slot"
	                        );

	                String abilityName =
	                        resultSet.getString(
	                                "ability_name"
	                        );

	                double abilityValue =
	                        resultSet.getDouble(
	                                "ability_value"
	                        );

	                TrainingSubAbility subAbility =
	                        new TrainingSubAbility(
	                                equipmentSlot,
	                                abilitySlot,
	                                abilityName,
	                                abilityValue
	                        );

	                subAbilities.add(
	                        subAbility
	                );
	            }
	        }
	    }

	    return subAbilities;
	}
	
	public static void deleteTrainingRecord(
	        int trainingRecordId)
	        throws SQLException {

	    Connection connection = null;

	    try {

	        connection = connect();

	        // 自動コミットをOFF
	        // → 全部成功したときだけ確定する
	        connection.setAutoCommit(false);


	        // ====================
	        // サブ能力を削除
	        // ====================

	        String subAbilitySql =
	                "DELETE FROM training_sub_abilities "
	                + "WHERE training_record_id = ?";

	        try (PreparedStatement statement =
	                     connection.prepareStatement(
	                             subAbilitySql
	                     )) {

	            statement.setInt(
	                    1,
	                    trainingRecordId
	            );

	            statement.executeUpdate();
	        }


	        // ====================
	        // 補助器具を削除
	        // ====================

	        String equipmentSql =
	                "DELETE FROM training_equipments "
	                + "WHERE training_record_id = ?";

	        try (PreparedStatement statement =
	                     connection.prepareStatement(
	                             equipmentSql
	                     )) {

	            statement.setInt(
	                    1,
	                    trainingRecordId
	            );

	            statement.executeUpdate();
	        }


	        // ====================
	        // サポーターを削除
	        // ====================

	        String supporterSql =
	                "DELETE FROM training_supporters "
	                + "WHERE training_record_id = ?";

	        try (PreparedStatement statement =
	                     connection.prepareStatement(
	                             supporterSql
	                     )) {

	            statement.setInt(
	                    1,
	                    trainingRecordId
	            );

	            statement.executeUpdate();
	        }


	        // ====================
	        // シーンカードを削除
	        // ====================

	        String sceneCardSql =
	                "DELETE FROM training_scene_cards "
	                + "WHERE training_record_id = ?";

	        try (PreparedStatement statement =
	                     connection.prepareStatement(
	                             sceneCardSql
	                     )) {

	            statement.setInt(
	                    1,
	                    trainingRecordId
	            );

	            statement.executeUpdate();
	        }


	        // ====================
	        // 育成記録本体を削除
	        // ====================

	        String recordSql =
	                "DELETE FROM training_records "
	                + "WHERE id = ?";

	        try (PreparedStatement statement =
	                     connection.prepareStatement(
	                             recordSql
	                     )) {

	            statement.setInt(
	                    1,
	                    trainingRecordId
	            );

	            statement.executeUpdate();
	        }


	        // 全削除成功
	        connection.commit();


	    } catch (SQLException ex) {

	        // 途中で失敗したら全部取り消す
	        if (connection != null) {

	            try {

	                connection.rollback();

	            } catch (SQLException rollbackEx) {

	                rollbackEx.printStackTrace();
	            }
	        }

	        throw ex;


	    } finally {

	        if (connection != null) {

	            try {

	                connection.setAutoCommit(true);
	                connection.close();

	            } catch (SQLException ex) {

	                ex.printStackTrace();
	            }
	        }
	    }
	}
	
	public static ArrayList<Supporter> getSupporters()
	        throws SQLException {

	    ArrayList<Supporter> supporters =
	            new ArrayList<>();

	    String sql =
	            "SELECT id, name FROM supporters ORDER BY id";

	    try (Connection connection = connect();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

	        while (resultSet.next()) {

	            int id =
	                    resultSet.getInt("id");

	            String name =
	                    resultSet.getString("name");

	            Supporter supporter =
	                    new Supporter(id, name);

	            supporters.add(supporter);
	        }
	    }

	    return supporters;
	}
	
	public static ArrayList<Equipment> getEquipments()
	        throws SQLException {

	    ArrayList<Equipment> equipments =
	            new ArrayList<>();

	    String sql =
	            "SELECT id, name FROM equipments ORDER BY id";

	    try (Connection connection = connect();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

	        while (resultSet.next()) {

	            int id =
	                    resultSet.getInt("id");

	            String name =
	                    resultSet.getString("name");

	            Equipment equipment =
	                    new Equipment(id, name);

	            equipments.add(equipment);
	        }
	    }

	    return equipments;
	}
	public static void initializeEquipments()
	        throws SQLException {

	    ArrayList<Equipment> dbEquipments =
	            getEquipments();

	    // DBにすでに補助器具があれば何もしない
	    if (!dbEquipments.isEmpty()) {
	        return;
	    }

	    // EquipmentData.java から初期データを取得
	    ArrayList<Equipment> initialEquipments =
	            EquipmentData.getEquipments();

	    // SQLiteへ1個ずつ保存
	    for (Equipment equipment : initialEquipments) {

	        insertEquipment(equipment);
	    }
	}
	
	public static ArrayList<SceneCard> getSceneCards()
	        throws SQLException {

	    ArrayList<SceneCard> sceneCards =
	            new ArrayList<>();

	    String sql =
	            "SELECT id, name FROM scene_cards ORDER BY id";

	    try (Connection connection = connect();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

	        while (resultSet.next()) {

	            int id =
	                    resultSet.getInt("id");

	            String name =
	                    resultSet.getString("name");

	            SceneCard sceneCard =
	                    new SceneCard(id, name);

	            sceneCards.add(sceneCard);
	        }
	    }

	    return sceneCards;
	}
	public static void initializeSceneCards()
	        throws SQLException {

	    ArrayList<SceneCard> dbSceneCards =
	            getSceneCards();

	    // DBにすでにシーンカードがあれば何もしない
	    if (!dbSceneCards.isEmpty()) {
	        return;
	    }

	    // SceneCardDataから初期シーンカードを取得
	    ArrayList<SceneCard> initialSceneCards =
	            SceneCardData.getSceneCards();

	    // SQLiteへ1枚ずつ保存
	    for (SceneCard sceneCard : initialSceneCards) {

	        insertSceneCard(sceneCard);
	    }
	}
	
	public static ArrayList<Fighter> getFighters()
	        throws SQLException {

	    ArrayList<Fighter> fighters =
	            new ArrayList<>();
	    String sql =
	            "SELECT id, name FROM fighters ORDER BY id";
	    try (Connection connection = connect();
	    	     Statement statement = connection.createStatement();
	    	     ResultSet resultSet = statement.executeQuery(sql)) {

	    	    while (resultSet.next()) {

	    	        int id = resultSet.getInt("id");
	    	        String name = resultSet.getString("name");

	    	        Fighter fighter =
	    	                new Fighter(id, name);

	    	        fighters.add(fighter);
	    	       
	    	    }
	    	} 
	    return fighters;
	    
	}	
	public static void deleteFighter(int id)
	        throws SQLException {

	    String sql =
	            "DELETE FROM fighters WHERE id = ?";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(1, id);

	        statement.executeUpdate();
	        
	    }
	    
	}
	
	public static void deleteSceneCard(int id)
	        throws SQLException {

	    String sql =
	            "DELETE FROM scene_cards WHERE id = ?";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(1, id);

	        statement.executeUpdate();
	    }
	}
	
	public static void deleteEquipment(int id)
	        throws SQLException {

	    String sql =
	            "DELETE FROM equipments WHERE id = ?";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(1, id);

	        statement.executeUpdate();
	    }
	}
	
	public static void deleteSupporter(int id)
	        throws SQLException {

	    String sql =
	            "DELETE FROM supporters WHERE id = ?";

	    try (Connection connection = connect();
	         PreparedStatement statement =
	                 connection.prepareStatement(sql)) {

	        statement.setInt(1, id);

	        statement.executeUpdate();
	    }
	}
	
	public static void initializeFighters()
	        throws SQLException {

	    ArrayList<Fighter> dbFighters =
	            getFighters();

	    // すでにDBにキャラが入っていたら何もしない
	    if (!dbFighters.isEmpty()) {
	        return;
	    }

	    // FighterData.java に登録してある初期キャラを取得
	    ArrayList<Fighter> initialFighters =
	            FighterData.getFighters();

	    // SQLiteへ1人ずつ保存
	    for (Fighter fighter : initialFighters) {
	        insertFighter(fighter);
	    }
	}
}
