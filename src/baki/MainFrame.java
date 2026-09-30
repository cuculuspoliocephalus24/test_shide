package baki;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("ホトトギス 管理ver.1.0");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel);

        tabbedPane.addTab("育成登録", scrollPane);

        add(tabbedPane);
        
        ArrayList<Fighter> loadedFighters;

        try {

            loadedFighters =
                    DatabaseManager.getFighters();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "キャラクターデータの読み込みに失敗しました"
            );

            ex.printStackTrace();

            loadedFighters =
                    new ArrayList<>();
        }

        final ArrayList<Fighter> fighters = loadedFighters;
        
        ArrayList<Supporter> loadedSupporters;

        try {

            loadedSupporters =
                    DatabaseManager.getSupporters();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "サポーターデータの読み込みに失敗しました"
            );

            ex.printStackTrace();

            loadedSupporters =
                    new ArrayList<>();
        }

        final ArrayList<Supporter> supporters =
                loadedSupporters;
        
        ArrayList<SceneCard> loadedSceneCards;

        try {

            loadedSceneCards =
                    DatabaseManager.getSceneCards();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "シーンカードデータの読み込みに失敗しました"
            );

            ex.printStackTrace();

            loadedSceneCards =
                    new ArrayList<>();
        }

        final ArrayList<SceneCard> sceneCards =
                loadedSceneCards;
        
     // 補助器具一覧をSQLiteから読み込む
        ArrayList<Equipment> loadedEquipments;

        try {

            loadedEquipments =
                    DatabaseManager.getEquipments();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "補助器具データの読み込みに失敗しました"
            );

            ex.printStackTrace();

            loadedEquipments =
                    new ArrayList<>();
        }

        final ArrayList<Equipment> equipments =
                loadedEquipments;
        
        JTabbedPane dataTabbedPane =
                new JTabbedPane();

        JPanel fighterDataPanel =
                new JPanel();

        fighterDataPanel.setLayout(
                new BoxLayout(
                        fighterDataPanel,
                        BoxLayout.Y_AXIS
                )
        );
        JLabel fighterListLabel =
                new JLabel("登録済みキャラクター");

        fighterDataPanel.add(fighterListLabel);
        
        JComboBox<Fighter> fighterManageComboBox =
                new JComboBox<>();

        for (Fighter fighter : fighters) {
            fighterManageComboBox.addItem(fighter);
        }
        

        fighterDataPanel.add(fighterManageComboBox);
        
        JLabel newFighterLabel =
                new JLabel("追加するキャラクター名");

        fighterDataPanel.add(newFighterLabel);

        JTextField newFighterField =
                new JTextField(20);

        fighterDataPanel.add(newFighterField);
        JButton addFighterButton =
                new JButton("追加");

        fighterDataPanel.add(addFighterButton);
        
        
     // 削除ボタン
        JButton deleteFighterButton =
                new JButton("選択中のキャラを削除");

        fighterDataPanel.add(deleteFighterButton);

        
        // 他の管理画面
        JPanel sceneCardDataPanel =
                new JPanel();

        sceneCardDataPanel.setLayout(
                new BoxLayout(
                        sceneCardDataPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel sceneCardListLabel =
                new JLabel("登録済みシーンカード");

        sceneCardDataPanel.add(sceneCardListLabel);
        JComboBox<SceneCard> sceneCardManageComboBox =
                new JComboBox<>();

        for (SceneCard sceneCard : sceneCards) {
            sceneCardManageComboBox.addItem(sceneCard);
        }

        sceneCardDataPanel.add(sceneCardManageComboBox);
        JLabel newSceneCardLabel =
                new JLabel("追加するシーンカード名");

        sceneCardDataPanel.add(newSceneCardLabel);

        JTextField newSceneCardField =
                new JTextField(20);

        sceneCardDataPanel.add(newSceneCardField);
        
        JButton addSceneCardButton =
                new JButton("追加");

        sceneCardDataPanel.add(addSceneCardButton);
        
        JButton deleteSceneCardButton =
                new JButton("選択中のシーンカードを削除");

        sceneCardDataPanel.add(deleteSceneCardButton);
        
        JPanel equipmentDataPanel =
                new JPanel();
        
        equipmentDataPanel.setLayout(
                new BoxLayout(
                        equipmentDataPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel equipmentListLabel =
                new JLabel("登録済み補助器具");

        equipmentDataPanel.add(equipmentListLabel);
        
        JComboBox<Equipment> equipmentManageComboBox =
                new JComboBox<>();

        for (Equipment equipment : equipments) {
            equipmentManageComboBox.addItem(equipment);
        }

        equipmentDataPanel.add(equipmentManageComboBox);
        
        JLabel newEquipmentLabel =
                new JLabel("追加する補助器具名");

        equipmentDataPanel.add(newEquipmentLabel);

        JTextField newEquipmentField =
                new JTextField(20);

        equipmentDataPanel.add(newEquipmentField);
        
        JButton addEquipmentButton =
                new JButton("追加");

        equipmentDataPanel.add(addEquipmentButton);

        JButton deleteEquipmentButton =
                new JButton("選択中の補助器具を削除");

        equipmentDataPanel.add(deleteEquipmentButton);
     // ====================
     // サポーター管理
     // ====================

     JPanel supporterDataPanel =
             new JPanel();

     supporterDataPanel.setLayout(
             new BoxLayout(
                     supporterDataPanel,
                     BoxLayout.Y_AXIS
             )
     );

     JLabel supporterListLabel =
             new JLabel("登録済みサポーター");

     supporterDataPanel.add(supporterListLabel);

     JComboBox<Supporter> supporterManageComboBox =
             new JComboBox<>();

     for (Supporter supporter : supporters) {
         supporterManageComboBox.addItem(supporter);
     }

     supporterDataPanel.add(supporterManageComboBox);

     JLabel newSupporterLabel =
             new JLabel("追加するサポーター名");

     supporterDataPanel.add(newSupporterLabel);

     JTextField newSupporterField =
             new JTextField(20);

     supporterDataPanel.add(newSupporterField);

     JButton addSupporterButton =
             new JButton("追加");

     supporterDataPanel.add(addSupporterButton);

     JButton deleteSupporterButton =
             new JButton("選択中のサポーターを削除");

     supporterDataPanel.add(deleteSupporterButton);
        
        
        
     // 管理画面のタブ
        dataTabbedPane.addTab(
                "キャラクター",
                fighterDataPanel
        );

        dataTabbedPane.addTab(
                "シーンカード",
                sceneCardDataPanel
        );

        dataTabbedPane.addTab(
                "補助器具",
                equipmentDataPanel
        );
        dataTabbedPane.addTab(
                "サポーター",
                supporterDataPanel
        );

        tabbedPane.addTab(
                "データ管理",
                dataTabbedPane
        );
        
     // ====================
     // 育成記録タブ
     // ====================

     JPanel trainingRecordPanel =
             new JPanel();

     trainingRecordPanel.setLayout(
             new BoxLayout(
                     trainingRecordPanel,
                     BoxLayout.Y_AXIS
             )
     );

     JScrollPane trainingRecordScrollPane =
             new JScrollPane(trainingRecordPanel);

     tabbedPane.addTab(
             "育成記録",
             trainingRecordScrollPane
     );
  // ====================
  // 育成分析タブ
  // ====================

  JPanel trainingAnalysisPanel =
          new JPanel();

  trainingAnalysisPanel.setLayout(
          new BoxLayout(
                  trainingAnalysisPanel,
                  BoxLayout.Y_AXIS
          )
  );

  JScrollPane trainingAnalysisScrollPane =
          new JScrollPane(
                  trainingAnalysisPanel
          );

  tabbedPane.addTab(
          "育成分析",
          trainingAnalysisScrollPane
  );


  // ====================
  // 育成分析タイトル
  // ====================

  JLabel trainingAnalysisTitleLabel =
          new JLabel("【育成データ分析】");

  trainingAnalysisPanel.add(
          trainingAnalysisTitleLabel
  );
     
//====================
//分析対象キャラクター
//====================

JLabel analysisFighterLabel =
       new JLabel("分析対象キャラクター");

trainingAnalysisPanel.add(
       analysisFighterLabel
);

JComboBox<String> analysisFighterComboBox =
       new JComboBox<>();

//最初に「すべて」
analysisFighterComboBox.addItem(
       "すべて"
);

//登録済みキャラクターを追加
for (Fighter fighter : fighters) {

   analysisFighterComboBox.addItem(
           fighter.getName()
   );
}

trainingAnalysisPanel.add(
       analysisFighterComboBox
);


//====================
//分析するサブ能力
//====================

JLabel analysisSubAbilityLabel =
       new JLabel("分析するサブ能力");

trainingAnalysisPanel.add(
       analysisSubAbilityLabel
);

JComboBox<String> analysisSubAbilityComboBox =
       new JComboBox<>();

analysisSubAbilityComboBox.addItem(
       "究極鍛錬率"
);

trainingAnalysisPanel.add(
       analysisSubAbilityComboBox
);


//====================
//分析ボタン
//====================

JButton analysisButton =
       new JButton("分析する");

trainingAnalysisPanel.add(
       analysisButton
);
//====================
//分析結果表示欄
//====================

JTextArea analysisResultArea =
     new JTextArea(20, 45);

analysisResultArea.setEditable(false);
analysisResultArea.setLineWrap(true);
analysisResultArea.setWrapStyleWord(true);

JScrollPane analysisResultScrollPane =
     new JScrollPane(
             analysisResultArea
     );

trainingAnalysisPanel.add(
     analysisResultScrollPane
);
  
  // ====================
  // 育成記録一覧をSQLiteから読み込む
  // ====================

     ArrayList<TrainingRecord> loadedTrainingRecords;

     try {

         loadedTrainingRecords =
                 DatabaseManager.getTrainingRecords();

     } catch (SQLException ex) {

         JOptionPane.showMessageDialog(
                 this,
                 "育成記録の読み込みに失敗しました"
         );

         ex.printStackTrace();

         loadedTrainingRecords =
                 new ArrayList<>();
     }

     final ArrayList<TrainingRecord> trainingRecords =
             loadedTrainingRecords;
  // ====================
  // 育成分析ボタン
  // ====================

     analysisButton.addActionListener(e -> {

    	    String selectedFighter =
    	            (String) analysisFighterComboBox
    	                    .getSelectedItem();

    	    int recordCount = 0;
    	    int ultimateTrainingRecordCount = 0;

    	    String detailResult = "";

    	    for (TrainingRecord record : trainingRecords) {

    	        if ("すべて".equals(selectedFighter)
    	                || record.getFighter()
    	                        .getName()
    	                        .equals(selectedFighter)) {

    	            recordCount++;

    	            try {

    	                ArrayList<TrainingSubAbility> subAbilities =
    	                        DatabaseManager.getTrainingSubAbilities(
    	                                record.getId()
    	                        );

    	                boolean hasUltimateTraining = false;

    	                String ultimateDetail = "";

    	                for (TrainingSubAbility subAbility
    	                        : subAbilities) {

    	                    if ("究極鍛錬率".equals(
    	                            subAbility.getAbilityName()
    	                    )) {

    	                        hasUltimateTraining = true;

    	                        ultimateDetail +=
    	                                "  補助器具"
    	                                + subAbility.getEquipmentSlot()
    	                                + " / サブ"
    	                                + subAbility.getAbilitySlot()
    	                                + "："
    	                                + subAbility.getAbilityValue()
    	                                + "\n";
    	                    }
    	                }

    	                if (hasUltimateTraining) {

    	                    ultimateTrainingRecordCount++;

    	                    detailResult +=
    	                            "\n記録ID："
    	                            + record.getId()
    	                            + "\n";

    	                    detailResult +=
    	                            "キャラクター："
    	                            + record.getFighter().getName()
    	                            + "\n";

    	                    detailResult +=
    	                            "総戦力："
    	                            + record.getTotalStatus()
    	                            + "\n";

    	                    detailResult +=
    	                            ultimateDetail;
    	                }

    	            } catch (SQLException ex) {

    	                ex.printStackTrace();
    	            }
    	        }
    	    }


    	    String result = "";

    	    result += "【分析結果】\n\n";

    	    result += "対象キャラクター："
    	            + selectedFighter
    	            + "\n";

    	    result += "分析するサブ能力："
    	            + analysisSubAbilityComboBox
    	                    .getSelectedItem()
    	            + "\n\n";

    	    result += "対象育成記録数："
    	            + recordCount
    	            + "件\n";

    	    result += "究極鍛錬率データあり："
    	            + ultimateTrainingRecordCount
    	            + "件\n";


    	    // ====================
    	    // 究極鍛錬率の詳細
    	    // ====================

    	    result += "\n【究極鍛錬率 詳細】\n";

    	    if (ultimateTrainingRecordCount == 0) {

    	        result += "データなし\n";

    	    } else {

    	        result += detailResult;
    	    }


    	    // ====================
    	    // 結果欄へ表示
    	    // ====================

    	    analysisResultArea.setText(
    	            result
    	    );
    	});
     
//====================
//キャラクター絞り込み
//====================

JLabel trainingRecordFilterLabel =
       new JLabel("キャラクターで絞り込み");

trainingRecordPanel.add(
       trainingRecordFilterLabel
);

JComboBox<String> trainingRecordFilterComboBox =
       new JComboBox<>();

//最初は「すべて」
trainingRecordFilterComboBox.addItem("すべて");

//登録されているキャラクターを追加
for (Fighter fighter : fighters) {

   trainingRecordFilterComboBox.addItem(
           fighter.getName()
   );
}

trainingRecordPanel.add(
       trainingRecordFilterComboBox
);
  
//====================
//育成記録の並び順
//====================

JLabel trainingRecordSortLabel =
     new JLabel("並び順");

trainingRecordPanel.add(
     trainingRecordSortLabel
);

JComboBox<String> trainingRecordSortComboBox =
     new JComboBox<>();

trainingRecordSortComboBox.addItem(
     "新しい順"
);

trainingRecordSortComboBox.addItem(
     "総戦力が高い順"
);

trainingRecordSortComboBox.addItem(
     "総戦力が低い順"
);

trainingRecordPanel.add(
     trainingRecordSortComboBox
);

//====================
//育成記録選択
//====================

JLabel trainingRecordLabel =
       new JLabel("育成記録を選択");

trainingRecordPanel.add(
       trainingRecordLabel
);

JComboBox<TrainingRecord> trainingRecordComboBox =
       new JComboBox<>();

for (TrainingRecord record : trainingRecords) {

   trainingRecordComboBox.addItem(
           record
   );
}

trainingRecordPanel.add(
       trainingRecordComboBox
);
//====================
//育成記録一覧の更新処理
//====================

Runnable updateTrainingRecordList = () -> {

 String selectedFighterName =
         (String) trainingRecordFilterComboBox
                 .getSelectedItem();

 String selectedSort =
         (String) trainingRecordSortComboBox
                 .getSelectedItem();


 // 条件に合う記録を一時リストへ
 ArrayList<TrainingRecord> filteredRecords =
         new ArrayList<>();

 for (TrainingRecord record : trainingRecords) {

     if ("すべて".equals(selectedFighterName)
             || record.getFighter()
                     .getName()
                     .equals(selectedFighterName)) {

         filteredRecords.add(record);
     }
 }


 // ====================
 // 並べ替え
 // ====================

 if ("総戦力が高い順".equals(selectedSort)) {

     filteredRecords.sort(
             (a, b) -> Integer.compare(
                     b.getTotalStatus(),
                     a.getTotalStatus()
             )
     );

 } else if ("総戦力が低い順".equals(selectedSort)) {

     filteredRecords.sort(
             (a, b) -> Integer.compare(
                     a.getTotalStatus(),
                     b.getTotalStatus()
             )
     );

 } else {

     // 新しい順
     filteredRecords.sort(
             (a, b) -> Integer.compare(
                     b.getId(),
                     a.getId()
             )
     );
 }


 // コンボボックスを作り直す
 trainingRecordComboBox.removeAllItems();

 for (TrainingRecord record : filteredRecords) {

     trainingRecordComboBox.addItem(
             record
     );
 }
};


//キャラクターを変更したとき
trainingRecordFilterComboBox.addActionListener(e -> {

 updateTrainingRecordList.run();

});


//並び順を変更したとき
trainingRecordSortComboBox.addActionListener(e -> {

 updateTrainingRecordList.run();

});

//====================
//育成記録 詳細表示
//====================

JButton trainingRecordDetailButton =
     new JButton("詳細を見る");

trainingRecordPanel.add(
     trainingRecordDetailButton
);

JButton deleteTrainingRecordButton =
new JButton("選択中の育成記録を削除");

trainingRecordPanel.add(
deleteTrainingRecordButton
);

JTextArea trainingRecordDetailArea =
     new JTextArea(25, 45);

//====================
//「詳細を見る」ボタン
//====================

trainingRecordDetailButton.addActionListener(e -> {

 TrainingRecord selectedRecord =
         (TrainingRecord) trainingRecordComboBox
                 .getSelectedItem();

 if (selectedRecord == null) {

     JOptionPane.showMessageDialog(
             this,
             "育成記録を選択してください"
     );

     return;
 }

 try {

     ArrayList<SceneCard> recordSceneCards =
             DatabaseManager.getTrainingSceneCards(
                     selectedRecord.getId()
             );

     ArrayList<Supporter> recordSupporters =
             DatabaseManager.getTrainingSupporters(
                     selectedRecord.getId()
             );

     ArrayList<Equipment> recordEquipments =
             DatabaseManager.getTrainingEquipments(
                     selectedRecord.getId()
             );

     ArrayList<TrainingSubAbility> recordSubAbilities =
             DatabaseManager.getTrainingSubAbilities(
                     selectedRecord.getId()
             );


     String detail = "";

     detail += "育成記録ID："
             + selectedRecord.getId()
             + "\n";

     detail += "登録日時："
             + selectedRecord.getCreatedAt()
             + "\n\n";

     detail += "キャラクター："
             + selectedRecord.getFighter().getName()
             + "\n";

     detail += "\n【ステータス】\n\n";

  // ====================
  // 旧記録かどうか判定
  // ====================

  boolean hasStartStatus =
          selectedRecord.getStartStrength() != 0
          || selectedRecord.getStartStamina() != 0
          || selectedRecord.getStartTechnique() != 0
          || selectedRecord.getStartToughness() != 0
          || selectedRecord.getStartAgility() != 0
          || selectedRecord.getStartMental() != 0;


  if (hasStartStatus) {

      // ====================
      // 新しい記録
      // 開始 → 終了 → 増加
      // ====================

      detail += "筋力\n";
      detail += "  開始：" + selectedRecord.getStartStrength() + "\n";
      detail += "  終了：" + selectedRecord.getStrength() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainStrength()
      ) + "\n\n";


      detail += "体力\n";
      detail += "  開始：" + selectedRecord.getStartStamina() + "\n";
      detail += "  終了：" + selectedRecord.getStamina() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainStamina()
      ) + "\n\n";


      detail += "技術\n";
      detail += "  開始：" + selectedRecord.getStartTechnique() + "\n";
      detail += "  終了：" + selectedRecord.getTechnique() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainTechnique()
      ) + "\n\n";


      detail += "タフネス\n";
      detail += "  開始：" + selectedRecord.getStartToughness() + "\n";
      detail += "  終了：" + selectedRecord.getToughness() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainToughness()
      ) + "\n\n";


      detail += "俊敏性\n";
      detail += "  開始：" + selectedRecord.getStartAgility() + "\n";
      detail += "  終了：" + selectedRecord.getAgility() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainAgility()
      ) + "\n\n";


      detail += "精神力\n";
      detail += "  開始：" + selectedRecord.getStartMental() + "\n";
      detail += "  終了：" + selectedRecord.getMental() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainMental()
      ) + "\n\n";


      detail += "────────────\n";

      detail += "総戦力\n";
      detail += "  開始：" + selectedRecord.getStartTotalStatus() + "\n";
      detail += "  終了：" + selectedRecord.getTotalStatus() + "\n";
      detail += "  増加：" + formatDifference(
              selectedRecord.getGainTotalStatus()
      ) + "\n\n";

  } else {

      // ====================
      // 開始値追加前の旧記録
      // ====================

      detail += "※この記録は開始時ステータス未記録です。\n\n";

      detail += "筋力：" + selectedRecord.getStrength() + "\n";
      detail += "体力：" + selectedRecord.getStamina() + "\n";
      detail += "技術：" + selectedRecord.getTechnique() + "\n";
      detail += "タフネス：" + selectedRecord.getToughness() + "\n";
      detail += "俊敏性：" + selectedRecord.getAgility() + "\n";
      detail += "精神力：" + selectedRecord.getMental() + "\n";

      detail += "────────────\n";

      detail += "総戦力："
              + selectedRecord.getTotalStatus()
              + "\n\n";
  }

     // シーンカード
     detail += "【シーンカード】\n";

     for (int i = 0;
             i < recordSceneCards.size();
             i++) {

         detail += (i + 1)
                 + "枚目："
                 + recordSceneCards.get(i).getName()
                 + "\n";
     }


     // サポーター
     detail += "\n【サポーター】\n";

     for (int i = 0;
             i < recordSupporters.size();
             i++) {

         detail += (i + 1)
                 + "人目："
                 + recordSupporters.get(i).getName()
                 + "\n";
     }


     // 補助器具
     detail += "\n【補助器具】\n";

     for (int i = 0;
             i < recordEquipments.size();
             i++) {

         detail += "補助器具"
                 + (i + 1)
                 + "："
                 + recordEquipments.get(i).getName()
                 + "\n";

         int equipmentSlot = i + 1;

         for (TrainingSubAbility subAbility
                 : recordSubAbilities) {

             if (subAbility.getEquipmentSlot()
                     == equipmentSlot) {

                 detail += "  サブ"
                         + subAbility.getAbilitySlot()
                         + "："
                         + subAbility.getAbilityName()
                         + " "
                         + subAbility.getAbilityValue()
                         + "\n";
             }
         }
     }


     // 備考
     detail += "\n【備考】\n";

     detail += selectedRecord.getNote();

     trainingRecordDetailArea.setText(
             detail
     );

 } catch (SQLException ex) {

     JOptionPane.showMessageDialog(
             this,
             "育成記録の詳細読み込みに失敗しました"
     );

     ex.printStackTrace();
 }
});
//====================
//育成記録削除
//====================

deleteTrainingRecordButton.addActionListener(e -> {

 TrainingRecord selectedRecord =
         (TrainingRecord) trainingRecordComboBox
                 .getSelectedItem();

 if (selectedRecord == null) {

     JOptionPane.showMessageDialog(
             this,
             "削除する育成記録がありません"
     );

     return;
 }

 int answer =
         JOptionPane.showConfirmDialog(
                 this,
                 "育成記録ID "
                         + selectedRecord.getId()
                         + " を削除しますか？",
                 "削除確認",
                 JOptionPane.YES_NO_OPTION
         );

 if (answer != JOptionPane.YES_OPTION) {
     return;
 }

 try {

     DatabaseManager.deleteTrainingRecord(
             selectedRecord.getId()
     );

 } catch (SQLException ex) {

     JOptionPane.showMessageDialog(
             this,
             "育成記録の削除に失敗しました"
     );

     ex.printStackTrace();

     return;
 }

 // プルダウンからも削除
 trainingRecordComboBox.removeItem(
         selectedRecord
 );

 // 詳細表示を空にする
 trainingRecordDetailArea.setText("");

 JOptionPane.showMessageDialog(
         this,
         "育成記録を削除しました"
 );
});

trainingRecordDetailArea.setEditable(false);

trainingRecordDetailArea.setLineWrap(true);

trainingRecordDetailArea.setWrapStyleWord(true);

JScrollPane trainingRecordDetailScrollPane =
     new JScrollPane(
             trainingRecordDetailArea
     );

trainingRecordPanel.add(
     trainingRecordDetailScrollPane
);

//====================
//育成記録比較
//====================

JLabel compareTitleLabel =
     new JLabel("【育成記録比較】");

trainingRecordPanel.add(
     compareTitleLabel
);


//====================
//比較する記録A
//====================

JLabel compareALabel =
     new JLabel("比較する記録A");

trainingRecordPanel.add(
     compareALabel
);

JComboBox<TrainingRecord> compareAComboBox =
     new JComboBox<>();

for (TrainingRecord record : trainingRecords) {

 compareAComboBox.addItem(
         record
 );
}

trainingRecordPanel.add(
     compareAComboBox
);


//====================
//比較する記録B
//====================

JLabel compareBLabel =
     new JLabel("比較する記録B");

trainingRecordPanel.add(
     compareBLabel
);

JComboBox<TrainingRecord> compareBComboBox =
     new JComboBox<>();

for (TrainingRecord record : trainingRecords) {

 compareBComboBox.addItem(
         record
 );
}

trainingRecordPanel.add(
     compareBComboBox
);
//====================
//比較表示オプション
//====================

JCheckBox differencesOnlyCheckBox =
     new JCheckBox("違う項目だけ表示");

trainingRecordPanel.add(
     differencesOnlyCheckBox
);
//====================
//比較ボタン
//====================

JButton compareButton =
     new JButton("2件を比較");

trainingRecordPanel.add(
     compareButton
);


//====================
//比較結果表示欄
//====================

JTextArea compareResultArea =
     new JTextArea(15, 45);

compareResultArea.setEditable(false);
compareResultArea.setLineWrap(true);
compareResultArea.setWrapStyleWord(true);

JScrollPane compareResultScrollPane =
     new JScrollPane(
             compareResultArea
     );

trainingRecordPanel.add(
     compareResultScrollPane
);

compareButton.addActionListener(e -> {

    TrainingRecord recordA =
            (TrainingRecord) compareAComboBox
                    .getSelectedItem();

    TrainingRecord recordB =
            (TrainingRecord) compareBComboBox
                    .getSelectedItem();

    boolean differencesOnly =
            differencesOnlyCheckBox.isSelected();
    
    if (recordA == null || recordB == null) {

        JOptionPane.showMessageDialog(
                this,
                "比較する育成記録を2件選択してください"
        );

        return;
    }
    
    ArrayList<SceneCard> sceneCardsA;
    ArrayList<SceneCard> sceneCardsB;
    ArrayList<Supporter> supportersA;
    ArrayList<Supporter> supportersB;
    ArrayList<Equipment> equipmentsA;
    ArrayList<Equipment> equipmentsB;

    ArrayList<TrainingSubAbility> subAbilitiesA;
    ArrayList<TrainingSubAbility> subAbilitiesB;
    
    try {

        sceneCardsA =
                DatabaseManager.getTrainingSceneCards(
                        recordA.getId()
                );

        sceneCardsB =
                DatabaseManager.getTrainingSceneCards(
                        recordB.getId()
                );
        supportersA =
                DatabaseManager.getTrainingSupporters(
                        recordA.getId()
                );

        supportersB =
                DatabaseManager.getTrainingSupporters(
                        recordB.getId()
                );
        equipmentsA =
                DatabaseManager.getTrainingEquipments(
                        recordA.getId()
                );

        equipmentsB =
                DatabaseManager.getTrainingEquipments(
                        recordB.getId()
                );

        subAbilitiesA =
                DatabaseManager.getTrainingSubAbilities(
                        recordA.getId()
                );

        subAbilitiesB =
                DatabaseManager.getTrainingSubAbilities(
                        recordB.getId()
                );
        
    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
                this,
                "シーンカードの比較データ読み込みに失敗しました"
        );

        ex.printStackTrace();

        return;
    }


    String result = "";

    result += "記録A：ID "
            + recordA.getId()
            + " / "
            + recordA.getFighter().getName()
            + "\n";

    result += "記録B：ID "
            + recordB.getId()
            + " / "
            + recordB.getFighter().getName()
            + "\n\n";


    result += "【ステータス比較】\n\n";


 // ====================
 // 筋力
 // ====================

 int strengthDifference =
         recordB.getStrength()
         - recordA.getStrength();

 if (!differencesOnly
         || strengthDifference != 0) {

     result += "筋力\n";

     result += "A："
             + recordA.getStrength();

     result += " / B："
             + recordB.getStrength();

     result += " / 差："
             + formatDifference(
                     strengthDifference
             );

     result += "\n\n";
 }


 // ====================
 // 体力
 // ====================

 int staminaDifference =
         recordB.getStamina()
         - recordA.getStamina();

 if (!differencesOnly
         || staminaDifference != 0) {

     result += "体力\n";

     result += "A："
             + recordA.getStamina();

     result += " / B："
             + recordB.getStamina();

     result += " / 差："
             + formatDifference(
                     staminaDifference
             );

     result += "\n\n";
 }


 // ====================
 // 技術
 // ====================

 int techniqueDifference =
         recordB.getTechnique()
         - recordA.getTechnique();

 if (!differencesOnly
         || techniqueDifference != 0) {

     result += "技術\n";

     result += "A："
             + recordA.getTechnique();

     result += " / B："
             + recordB.getTechnique();

     result += " / 差："
             + formatDifference(
                     techniqueDifference
             );

     result += "\n\n";
 }


 // ====================
 // タフネス
 // ====================

 int toughnessDifference =
         recordB.getToughness()
         - recordA.getToughness();

 if (!differencesOnly
         || toughnessDifference != 0) {

     result += "タフネス\n";

     result += "A："
             + recordA.getToughness();

     result += " / B："
             + recordB.getToughness();

     result += " / 差："
             + formatDifference(
                     toughnessDifference
             );

     result += "\n\n";
 }


 // ====================
 // 俊敏性
 // ====================

 int agilityDifference =
         recordB.getAgility()
         - recordA.getAgility();

 if (!differencesOnly
         || agilityDifference != 0) {

     result += "俊敏性\n";

     result += "A："
             + recordA.getAgility();

     result += " / B："
             + recordB.getAgility();

     result += " / 差："
             + formatDifference(
                     agilityDifference
             );

     result += "\n\n";
 }


 // ====================
 // 精神力
 // ====================

 int mentalDifference =
         recordB.getMental()
         - recordA.getMental();

 if (!differencesOnly
         || mentalDifference != 0) {

     result += "精神力\n";

     result += "A："
             + recordA.getMental();

     result += " / B："
             + recordB.getMental();

     result += " / 差："
             + formatDifference(
                     mentalDifference
             );

     result += "\n\n";
 }


 // ====================
 // 総戦力
 // ====================

 int totalDifference =
         recordB.getTotalStatus()
         - recordA.getTotalStatus();

 if (!differencesOnly
         || totalDifference != 0) {

     result += "【総戦力】\n";

     result += "A："
             + recordA.getTotalStatus();

     result += " / B："
             + recordB.getTotalStatus();

     result += " / 差："
             + formatDifference(
                     totalDifference
             );

     result += "\n";
 }
    
    result += "\n\n【シーンカード比較】\n";

 // ====================
 // 育成純増加量比較
 // ====================

 boolean hasStartStatusA =
         recordA.getStartStrength() != 0
         || recordA.getStartStamina() != 0
         || recordA.getStartTechnique() != 0
         || recordA.getStartToughness() != 0
         || recordA.getStartAgility() != 0
         || recordA.getStartMental() != 0;

 boolean hasStartStatusB =
         recordB.getStartStrength() != 0
         || recordB.getStartStamina() != 0
         || recordB.getStartTechnique() != 0
         || recordB.getStartToughness() != 0
         || recordB.getStartAgility() != 0
         || recordB.getStartMental() != 0;


 result += "\n\n【育成純増加量比較】\n\n";


 if (hasStartStatusA && hasStartStatusB) {

     // 筋力
     int gainStrengthDifference =
             recordB.getGainStrength()
             - recordA.getGainStrength();

     result += "筋力\n";
     result += "A："
             + formatDifference(
                     recordA.getGainStrength()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainStrength()
             );

     result += " / 差："
             + formatDifference(
                     gainStrengthDifference
             );

     result += "\n\n";


     // 体力
     int gainStaminaDifference =
             recordB.getGainStamina()
             - recordA.getGainStamina();

     result += "体力\n";
     result += "A："
             + formatDifference(
                     recordA.getGainStamina()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainStamina()
             );

     result += " / 差："
             + formatDifference(
                     gainStaminaDifference
             );

     result += "\n\n";


     // 技術
     int gainTechniqueDifference =
             recordB.getGainTechnique()
             - recordA.getGainTechnique();

     result += "技術\n";
     result += "A："
             + formatDifference(
                     recordA.getGainTechnique()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainTechnique()
             );

     result += " / 差："
             + formatDifference(
                     gainTechniqueDifference
             );

     result += "\n\n";


     // タフネス
     int gainToughnessDifference =
             recordB.getGainToughness()
             - recordA.getGainToughness();

     result += "タフネス\n";
     result += "A："
             + formatDifference(
                     recordA.getGainToughness()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainToughness()
             );

     result += " / 差："
             + formatDifference(
                     gainToughnessDifference
             );

     result += "\n\n";


     // 俊敏性
     int gainAgilityDifference =
             recordB.getGainAgility()
             - recordA.getGainAgility();

     result += "俊敏性\n";
     result += "A："
             + formatDifference(
                     recordA.getGainAgility()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainAgility()
             );

     result += " / 差："
             + formatDifference(
                     gainAgilityDifference
             );

     result += "\n\n";


     // 精神力
     int gainMentalDifference =
             recordB.getGainMental()
             - recordA.getGainMental();

     result += "精神力\n";
     result += "A："
             + formatDifference(
                     recordA.getGainMental()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainMental()
             );

     result += " / 差："
             + formatDifference(
                     gainMentalDifference
             );

     result += "\n\n";


     // 総戦力
     int gainTotalDifference =
             recordB.getGainTotalStatus()
             - recordA.getGainTotalStatus();

     result += "【総戦力純増加】\n";

     result += "A："
             + formatDifference(
                     recordA.getGainTotalStatus()
             );

     result += " / B："
             + formatDifference(
                     recordB.getGainTotalStatus()
             );

     result += " / 差："
             + formatDifference(
                     gainTotalDifference
             );

     result += "\n";

 } else {

     result +=
             "開始時ステータス未記録のデータが含まれているため、"
             + "純増加量は比較できません。\n";
 }
    
    int sceneCardCount =
            Math.max(
                    sceneCardsA.size(),
                    sceneCardsB.size()
            );

    for (int i = 0; i < sceneCardCount; i++) {

        String cardA = "なし";
        String cardB = "なし";

        if (i < sceneCardsA.size()) {
            cardA =
                    sceneCardsA.get(i).getName();
        }

        if (i < sceneCardsB.size()) {
            cardB =
                    sceneCardsB.get(i).getName();
        }

        boolean same =
                cardA.equals(cardB);

        // 「違う項目だけ表示」がONで、
        // AとBが同じなら表示しない
        if (differencesOnly && same) {
            continue;
        }

        result += (i + 1)
                + "枚目\n";

        result += "A："
                + cardA
                + "\n";

        result += "B："
                + cardB
                + "\n";

        if (same) {

            result += "→ 同じ\n\n";

        } else {

            result += "→ ★違いあり\n\n";
        }
    }
    result += "\n【サポーター比較】\n\n";

    int supporterCount =
            Math.max(
                    supportersA.size(),
                    supportersB.size()
            );

    for (int i = 0; i < supporterCount; i++) {

        String supporterA = "なし";
        String supporterB = "なし";

        if (i < supportersA.size()) {
            supporterA =
                    supportersA.get(i).getName();
        }

        if (i < supportersB.size()) {
            supporterB =
                    supportersB.get(i).getName();
        }

        boolean same =
                supporterA.equals(supporterB);

        // 「違う項目だけ表示」がONで、
        // AとBが同じなら表示しない
        if (differencesOnly && same) {
            continue;
        }

        result += (i + 1)
                + "人目\n";

        result += "A："
                + supporterA
                + "\n";

        result += "B："
                + supporterB
                + "\n";

        if (same) {

            result += "→ 同じ\n\n";

        } else {

            result += "→ ★違いあり\n\n";
        }
    }

    result += "\n【補助器具・サブ能力比較】\n\n";

    int equipmentCount =
            Math.max(
                    equipmentsA.size(),
                    equipmentsB.size()
            );

    for (int i = 0; i < equipmentCount; i++) {

        String equipmentAName = "なし";
        String equipmentBName = "なし";

        if (i < equipmentsA.size()) {
            equipmentAName =
                    equipmentsA.get(i).getName();
        }

        if (i < equipmentsB.size()) {
            equipmentBName =
                    equipmentsB.get(i).getName();
        }

        int equipmentSlot = i + 1;

        boolean equipmentSame =
                equipmentAName.equals(
                        equipmentBName
                );


        // ====================
        // この補助器具内に
        // サブ能力の違いがあるか調べる
        // ====================

        boolean hasSubAbilityDifference = false;

        for (int abilitySlot = 1;
                abilitySlot <= 3;
                abilitySlot++) {

            TrainingSubAbility subA = null;
            TrainingSubAbility subB = null;


            // A側
            for (TrainingSubAbility subAbility
                    : subAbilitiesA) {

                if (subAbility.getEquipmentSlot()
                        == equipmentSlot
                        && subAbility.getAbilitySlot()
                        == abilitySlot) {

                    subA = subAbility;
                    break;
                }
            }


            // B側
            for (TrainingSubAbility subAbility
                    : subAbilitiesB) {

                if (subAbility.getEquipmentSlot()
                        == equipmentSlot
                        && subAbility.getAbilitySlot()
                        == abilitySlot) {

                    subB = subAbility;
                    break;
                }
            }


            // 片方だけ存在する
            if (subA == null && subB != null) {

                hasSubAbilityDifference = true;

            } else if (subA != null && subB == null) {

                hasSubAbilityDifference = true;

            } else if (subA != null && subB != null) {

                // 能力名が違う
                if (!subA.getAbilityName()
                        .equals(
                                subB.getAbilityName()
                        )) {

                    hasSubAbilityDifference = true;

                // 数値が違う
                } else if (Double.compare(
                        subA.getAbilityValue(),
                        subB.getAbilityValue()
                ) != 0) {

                    hasSubAbilityDifference = true;
                }
            }
        }


        // ====================
        // 補助器具もサブ能力も
        // 全部同じならスキップ
        // ====================

        if (differencesOnly
                && equipmentSame
                && !hasSubAbilityDifference) {

            continue;
        }


        // ====================
        // 補助器具を表示
        // ====================

        result += "【補助器具"
                + equipmentSlot
                + "】\n";

        result += "A："
                + equipmentAName
                + "\n";

        result += "B："
                + equipmentBName
                + "\n";

        if (equipmentSame) {

            if (!differencesOnly) {
                result += "→ 補助器具は同じ\n";
            }

        } else {

            result += "→ ★補助器具に違いあり\n";
        }


        // ====================
        // サブ能力1～3
        // ====================

        for (int abilitySlot = 1;
                abilitySlot <= 3;
                abilitySlot++) {

            TrainingSubAbility subA = null;
            TrainingSubAbility subB = null;


            // A側
            for (TrainingSubAbility subAbility
                    : subAbilitiesA) {

                if (subAbility.getEquipmentSlot()
                        == equipmentSlot
                        && subAbility.getAbilitySlot()
                        == abilitySlot) {

                    subA = subAbility;
                    break;
                }
            }


            // B側
            for (TrainingSubAbility subAbility
                    : subAbilitiesB) {

                if (subAbility.getEquipmentSlot()
                        == equipmentSlot
                        && subAbility.getAbilitySlot()
                        == abilitySlot) {

                    subB = subAbility;
                    break;
                }
            }


            // ====================
            // このサブ能力が同じか判定
            // ====================

            boolean subSame;

            if (subA == null && subB == null) {

                subSame = true;

            } else if (subA == null || subB == null) {

                subSame = false;

            } else {

                boolean nameSame =
                        subA.getAbilityName()
                                .equals(
                                        subB.getAbilityName()
                                );

                boolean valueSame =
                        Double.compare(
                                subA.getAbilityValue(),
                                subB.getAbilityValue()
                        ) == 0;

                subSame =
                        nameSame && valueSame;
            }


            // 違う項目だけ表示ONで
            // サブ能力が完全に同じなら飛ばす
            if (differencesOnly && subSame) {
                continue;
            }


            result += "\nサブ"
                    + abilitySlot
                    + "\n";


            // ====================
            // A側表示
            // ====================

            if (subA == null) {

                result += "A：なし\n";

            } else {

                result += "A："
                        + subA.getAbilityName()
                        + " "
                        + subA.getAbilityValue()
                        + "\n";
            }


            // ====================
            // B側表示
            // ====================

            if (subB == null) {

                result += "B：なし\n";

            } else {

                result += "B："
                        + subB.getAbilityName()
                        + " "
                        + subB.getAbilityValue()
                        + "\n";
            }


            // ====================
            // 両方存在する場合
            // ====================

            if (subA != null && subB != null) {

                if (subA.getAbilityName()
                        .equals(
                                subB.getAbilityName()
                        )) {

                    double difference =
                            subB.getAbilityValue()
                            - subA.getAbilityValue();

                    if (!differencesOnly
                            || difference != 0) {

                        result += "数値差：";

                        if (difference > 0) {
                            result += "+";
                        }

                        result += difference
                                + "\n";
                    }

                } else {

                    result +=
                            "→ ★能力名に違いあり\n";
                }

            } else {

                // AかBの片方にしか存在しない
                result +=
                        "→ ★サブ能力に違いあり\n";
            }
        }

        result += "\n";
    }
    compareResultArea.setText(
            result
    );
});
        
        JLabel fighterLabel = new JLabel("キャラクター");
        panel.add(fighterLabel);

        

        JComboBox<Fighter> fighterComboBox = new JComboBox<>();

        for (Fighter fighter : fighters) {
            fighterComboBox.addItem(fighter);
        }

        panel.add(fighterComboBox);
        
        addFighterButton.addActionListener(e -> {

            String newName =
                    newFighterField.getText();

            if (newName.isBlank()) {

                JOptionPane.showMessageDialog(
                        this,
                        "キャラクター名を入力してください"
                );

                return;
            }

            for (Fighter fighter : fighters) {

                if (fighter.getName().equals(newName)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "「" + newName + "」はすでに登録されています"
                    );

                    return;
                }
            }
            
            int newId = 1;

            for (Fighter fighter : fighters) {

                if (fighter.getId() >= newId) {
                    newId = fighter.getId() + 1;
                }
            }

            Fighter newFighter =
                    new Fighter(newId, newName);

            try {

                // ★まずSQLiteへ保存
                DatabaseManager.insertFighter(newFighter);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "データベースへの保存に失敗しました"
                );

                ex.printStackTrace();

                return;
            }


            // DB保存に成功したら画面側にも追加
            fighters.add(newFighter);

            fighterManageComboBox.addItem(newFighter);
            fighterComboBox.addItem(newFighter);

            newFighterField.setText("");
     
        });
        
        JLabel sceneCardLabel = new JLabel("シーンカード");
        panel.add(sceneCardLabel);
        

        deleteFighterButton.addActionListener(e -> {

            Fighter selectedFighter =
                    (Fighter) fighterManageComboBox.getSelectedItem();

            if (selectedFighter == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "削除するキャラクターがありません"
                );

                return;
            }

            int answer =
                    JOptionPane.showConfirmDialog(
                            this,
                            selectedFighter.getName()
                                    + " を削除しますか？",
                            "削除確認",
                            JOptionPane.YES_NO_OPTION
                    );

            if (answer != JOptionPane.YES_OPTION) {
                return;
            }

            try {

                DatabaseManager.deleteFighter(
                        selectedFighter.getId()
                );

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "データベースからの削除に失敗しました"
                );

                ex.printStackTrace();

                return;
            }


            // DB削除に成功したら画面側も削除
            fighters.remove(selectedFighter);

            fighterManageComboBox.removeItem(selectedFighter);

            fighterComboBox.removeItem(selectedFighter);
        });

        ArrayList<JComboBox<SceneCard>> sceneCardComboBoxes =
                new ArrayList<>();
        
        for (int i = 1; i <= 3; i++) {

            JLabel slotLabel =
                    new JLabel(i + "枚目");

            panel.add(slotLabel);

            JComboBox<SceneCard> sceneCardComboBox =
                    new JComboBox<>();

            for (SceneCard sceneCard : sceneCards) {
                sceneCardComboBox.addItem(sceneCard);
            }

            sceneCardComboBoxes.add(sceneCardComboBox);

            panel.add(sceneCardComboBox);
        }
        
        addSceneCardButton.addActionListener(e -> {

            String newName =
                    newSceneCardField.getText();

            // 空欄チェック
            if (newName.isBlank()) {

                JOptionPane.showMessageDialog(
                        this,
                        "シーンカード名を入力してください"
                );

                return;
            }

            // 同じ名前がないかチェック
            for (SceneCard sceneCard : sceneCards) {

                if (sceneCard.getName().equals(newName)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "「" + newName
                            + "」はすでに登録されています"
                    );

                    return;
                }
            }

            // 新しいIDを決める
            int newId = 1;

            for (SceneCard sceneCard : sceneCards) {

                if (sceneCard.getId() >= newId) {
                    newId = sceneCard.getId() + 1;
                }
            }

            // 新しいSceneCardを作る
            SceneCard newSceneCard =
                    new SceneCard(newId, newName);
            
            try {

                DatabaseManager.insertSceneCard(newSceneCard);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "シーンカードのデータベース保存に失敗しました"
                );

                ex.printStackTrace();

                return;
            }

            // 元データに追加
            sceneCards.add(newSceneCard);

            // データ管理側にも追加
            sceneCardManageComboBox.addItem(newSceneCard);

            // 育成登録側の3つ全部に追加
            for (JComboBox<SceneCard> comboBox
                    : sceneCardComboBoxes) {

                comboBox.addItem(newSceneCard);
            }

            // 入力欄を空にする
            newSceneCardField.setText("");

        });
     // ====================
     // シーンカード削除
     // ====================

     deleteSceneCardButton.addActionListener(e -> {

         SceneCard selectedSceneCard =
                 (SceneCard) sceneCardManageComboBox.getSelectedItem();

         // 削除するカードがない場合
         if (selectedSceneCard == null) {

             JOptionPane.showMessageDialog(
                     this,
                     "削除するシーンカードがありません"
             );

             return;
         }

         // 削除確認
         int answer =
                 JOptionPane.showConfirmDialog(
                         this,
                         selectedSceneCard.getName()
                                 + " を削除しますか？",
                         "削除確認",
                         JOptionPane.YES_NO_OPTION
                 );

         if (answer != JOptionPane.YES_OPTION) {
             return;
         }

         try {

        	    DatabaseManager.deleteSceneCard(
        	            selectedSceneCard.getId()
        	    );

        	} catch (SQLException ex) {

        	    JOptionPane.showMessageDialog(
        	            this,
        	            "シーンカードのデータベース削除に失敗しました"
        	    );

        	    ex.printStackTrace();

        	    return;
        	}
         
         // 元データから削除
         sceneCards.remove(selectedSceneCard);

         // データ管理側から削除
         sceneCardManageComboBox.removeItem(selectedSceneCard);

         // 育成登録側の3つから削除
         for (JComboBox<SceneCard> comboBox
                 : sceneCardComboBoxes) {

             comboBox.removeItem(selectedSceneCard);
         }

     });
        
        JLabel supporterLabel = new JLabel("サポーター");
        panel.add(supporterLabel);

        

        ArrayList<JComboBox<Supporter>> supporterComboBoxes =
                new ArrayList<>();

        for (int i = 1; i <= 5; i++) {

            JLabel slotLabel =
                    new JLabel(i + "人目");

            panel.add(slotLabel);

            JComboBox<Supporter> supporterComboBox =
                    new JComboBox<>();

            for (Supporter supporter : supporters) {
                supporterComboBox.addItem(supporter);
            }

            supporterComboBoxes.add(supporterComboBox);

            panel.add(supporterComboBox);
        }
     // ====================
     // サポーター追加
     // ====================

     addSupporterButton.addActionListener(e -> {

         String newName =
                 newSupporterField.getText();

         // 空欄チェック
         if (newName.isBlank()) {

             JOptionPane.showMessageDialog(
                     this,
                     "サポーター名を入力してください"
             );

             return;
         }


         // 同じ名前がないかチェック
         for (Supporter supporter : supporters) {

             if (supporter.getName().equals(newName)) {

                 JOptionPane.showMessageDialog(
                         this,
                         "「" + newName
                         + "」はすでに登録されています"
                 );

                 return;
             }
         }


         // 新しいIDを決める
         int newId = 1;

         for (Supporter supporter : supporters) {

             if (supporter.getId() >= newId) {
                 newId = supporter.getId() + 1;
             }
         }


         // 新しいサポーターを作る
         Supporter newSupporter =
                 new Supporter(newId, newName);


         // SQLiteへ保存
         try {

             DatabaseManager.insertSupporter(
                     newSupporter
             );

         } catch (SQLException ex) {

             JOptionPane.showMessageDialog(
                     this,
                     "サポーターのデータベース保存に失敗しました"
             );

             ex.printStackTrace();

             return;
         }


         // Java側にも追加
         supporters.add(newSupporter);

         // データ管理側にも追加
         supporterManageComboBox.addItem(
                 newSupporter
         );

         // 育成登録側の5枠にも追加
         for (JComboBox<Supporter> comboBox
                 : supporterComboBoxes) {

             comboBox.addItem(newSupporter);
         }

         // 入力欄を空にする
         newSupporterField.setText("");
     });
  // ====================
  // サポーター削除
  // ====================

  deleteSupporterButton.addActionListener(e -> {

      Supporter selectedSupporter =
              (Supporter) supporterManageComboBox
                      .getSelectedItem();

      // 削除するサポーターがない場合
      if (selectedSupporter == null) {

          JOptionPane.showMessageDialog(
                  this,
                  "削除するサポーターがありません"
          );

          return;
      }


      // 削除確認
      int answer =
              JOptionPane.showConfirmDialog(
                      this,
                      selectedSupporter.getName()
                              + " を削除しますか？",
                      "削除確認",
                      JOptionPane.YES_NO_OPTION
              );

      if (answer != JOptionPane.YES_OPTION) {
          return;
      }


      // SQLiteから削除
      try {

          DatabaseManager.deleteSupporter(
                  selectedSupporter.getId()
          );

      } catch (SQLException ex) {

          JOptionPane.showMessageDialog(
                  this,
                  "サポーターのデータベース削除に失敗しました"
          );

          ex.printStackTrace();

          return;
      }


      // Java側から削除
      supporters.remove(selectedSupporter);

      // データ管理側から削除
      supporterManageComboBox.removeItem(
              selectedSupporter
      );

      // 育成登録側の5枠から削除
      for (JComboBox<Supporter> comboBox
              : supporterComboBoxes) {

          comboBox.removeItem(selectedSupporter);
      }
  });   
     
        JLabel equipmentLabel = new JLabel("補助器具");
        panel.add(equipmentLabel);

        

        // サブ能力一覧
        ArrayList<SubAbility> subAbilities =
                SubAbilityData.getSubAbilities();

        // 補助器具のコンボボックスを保存
        ArrayList<JComboBox<Equipment>> equipmentComboBoxes =
                new ArrayList<>();

        // サブ能力のコンボボックスを保存
        ArrayList<JComboBox<SubAbility>> subAbilityComboBoxes =
                new ArrayList<>();

        // サブ能力の数値入力欄を保存
        ArrayList<JTextField> subAbilityValueFields =
                new ArrayList<>();


        // 補助器具3個
        for (int equipmentIndex = 1;
                equipmentIndex <= 3;
                equipmentIndex++) {

            JLabel equipmentSlotLabel =
                    new JLabel("補助器具" + equipmentIndex);

            panel.add(equipmentSlotLabel);

            JComboBox<Equipment> equipmentComboBox =
                    new JComboBox<>();

            for (Equipment equipment : equipments) {
                equipmentComboBox.addItem(equipment);
            }

            equipmentComboBoxes.add(equipmentComboBox);
            panel.add(equipmentComboBox);


            // 1つの補助器具につきサブ能力3個
            for (int subIndex = 1;
                    subIndex <= 3;
                    subIndex++) {

                JLabel subLabel =
                        new JLabel("サブ能力" + subIndex);

                panel.add(subLabel);

                JComboBox<SubAbility> subComboBox =
                        new JComboBox<>();

                for (SubAbility subAbility : subAbilities) {
                    subComboBox.addItem(subAbility);
                }

                subAbilityComboBoxes.add(subComboBox);
                panel.add(subComboBox);
                
                SubAbility firstAbility =
                        (SubAbility) subComboBox.getSelectedItem();

                JLabel rangeLabel = new JLabel(
                        "範囲："
                        + firstAbility.getMinValue()
                        + " ～ "
                        + firstAbility.getMaxValue()
                        + firstAbility.getUnit()
                );

                panel.add(rangeLabel);
                
                subComboBox.addActionListener(e -> {

                    SubAbility selectedAbility =
                            (SubAbility) subComboBox.getSelectedItem();

                    rangeLabel.setText(
                            "範囲："
                            + selectedAbility.getMinValue()
                            + " ～ "
                            + selectedAbility.getMaxValue()
                            + selectedAbility.getUnit()
                    );
                });
                
                JLabel valueLabel = new JLabel("値");
                panel.add(valueLabel);

                JTextField valueField =
                        new JTextField(10);

                subAbilityValueFields.add(valueField);
                panel.add(valueField);

                
            }
        }

     // ====================
     // 育成開始時ステータス
     // ====================

     JLabel startStatusTitleLabel =
             new JLabel("【育成開始時ステータス】");

     panel.add(startStatusTitleLabel);


     // 筋力
     JLabel startStrengthLabel =
             new JLabel("開始時 筋力");

     panel.add(startStrengthLabel);

     JTextField startStrengthField =
             new JTextField(15);

     panel.add(startStrengthField);


     // 体力
     JLabel startStaminaLabel =
             new JLabel("開始時 体力");

     panel.add(startStaminaLabel);

     JTextField startStaminaField =
             new JTextField(15);

     panel.add(startStaminaField);


     // 技術
     JLabel startTechniqueLabel =
             new JLabel("開始時 技術");

     panel.add(startTechniqueLabel);

     JTextField startTechniqueField =
             new JTextField(15);

     panel.add(startTechniqueField);


     // タフネス
     JLabel startToughnessLabel =
             new JLabel("開始時 タフネス");

     panel.add(startToughnessLabel);

     JTextField startToughnessField =
             new JTextField(15);

     panel.add(startToughnessField);


     // 俊敏性
     JLabel startAgilityLabel =
             new JLabel("開始時 俊敏性");

     panel.add(startAgilityLabel);

     JTextField startAgilityField =
             new JTextField(15);

     panel.add(startAgilityField);


     // 精神力
     JLabel startMentalLabel =
             new JLabel("開始時 精神力");

     panel.add(startMentalLabel);

     JTextField startMentalField =
             new JTextField(15);

     panel.add(startMentalField);
     
  // ====================
  // 開始時総戦力
  // ====================

  JLabel startTotalStatusLabel =
          new JLabel("開始時総戦力（6ステータスの合計）");

  panel.add(startTotalStatusLabel);

  JTextField startTotalStatusField =
          new JTextField(15);

  // 自動計算なので直接編集不可
  startTotalStatusField.setEditable(false);

  panel.add(startTotalStatusField);


  // ====================
  // 育成終了時ステータス
  // ====================

  JLabel endStatusTitleLabel =
          new JLabel("【育成終了時ステータス】");

  panel.add(endStatusTitleLabel);

     JLabel strengthLabel =
             new JLabel("筋力");
     panel.add(strengthLabel);

     JTextField strengthField =
             new JTextField(15);
     panel.add(strengthField);


     JLabel staminaLabel =
             new JLabel("体力");
     panel.add(staminaLabel);

     JTextField staminaField =
             new JTextField(15);
     panel.add(staminaField);


     JLabel techniqueLabel =
             new JLabel("技術");
     panel.add(techniqueLabel);

     JTextField techniqueField =
             new JTextField(15);
     panel.add(techniqueField);


     JLabel toughnessLabel =
             new JLabel("タフネス");
     panel.add(toughnessLabel);

     JTextField toughnessField =
             new JTextField(15);
     panel.add(toughnessField);


     JLabel agilityLabel =
             new JLabel("俊敏性");
     panel.add(agilityLabel);

     JTextField agilityField =
             new JTextField(15);
     panel.add(agilityField);


     JLabel mentalLabel =
             new JLabel("精神力");
     panel.add(mentalLabel);

     JTextField mentalField =
             new JTextField(15);
     panel.add(mentalField);


     // ====================
     // 総戦力
     // ====================

     JLabel totalStatusLabel =
             new JLabel("総戦力（6ステータスの合計）");

     panel.add(totalStatusLabel);

     JTextField totalStatusField =
             new JTextField(15);

     // 総戦力は自動計算するので直接編集不可
     totalStatusField.setEditable(false);

     panel.add(totalStatusField);

   //====================
   //総戦力リアルタイム自動計算
   //====================

   DocumentListener statusDocumentListener =
          new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
          updateTotals();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
          updateTotals();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
          updateTotals();
      }

      private void updateTotals() {

          // ====================
          // 開始時総戦力
          // ====================

          int startTotal =
                  getFieldValue(startStrengthField)
                  + getFieldValue(startStaminaField)
                  + getFieldValue(startTechniqueField)
                  + getFieldValue(startToughnessField)
                  + getFieldValue(startAgilityField)
                  + getFieldValue(startMentalField);

          startTotalStatusField.setText(
                  String.valueOf(startTotal)
          );


          // ====================
          // 終了時総戦力
          // ====================

          int endTotal =
                  getFieldValue(strengthField)
                  + getFieldValue(staminaField)
                  + getFieldValue(techniqueField)
                  + getFieldValue(toughnessField)
                  + getFieldValue(agilityField)
                  + getFieldValue(mentalField);

          totalStatusField.setText(
                  String.valueOf(endTotal)
          );
      }

      private int getFieldValue(
              JTextField field) {

          String text =
                  field.getText().trim();

          if (text.isEmpty()) {
              return 0;
          }

          try {

              return Integer.parseInt(text);

          } catch (NumberFormatException ex) {

              return 0;
          }
      }
   };


   //====================
   //開始時6ステータス
   //====================

   startStrengthField.getDocument().addDocumentListener(
        statusDocumentListener
   );

   startStaminaField.getDocument().addDocumentListener(
        statusDocumentListener
   );

   startTechniqueField.getDocument().addDocumentListener(
        statusDocumentListener
   );

   startToughnessField.getDocument().addDocumentListener(
        statusDocumentListener
   );

   startAgilityField.getDocument().addDocumentListener(
        statusDocumentListener
   );

   startMentalField.getDocument().addDocumentListener(
        statusDocumentListener
   );
   
// ====================
// 終了時6ステータス
// ====================

strengthField.getDocument().addDocumentListener(
        statusDocumentListener
);

staminaField.getDocument().addDocumentListener(
        statusDocumentListener
);

techniqueField.getDocument().addDocumentListener(
        statusDocumentListener
);

toughnessField.getDocument().addDocumentListener(
        statusDocumentListener
);

agilityField.getDocument().addDocumentListener(
        statusDocumentListener
);

mentalField.getDocument().addDocumentListener(
        statusDocumentListener
);
   
// ====================
// 備考
// ====================

JLabel noteLabel =
        new JLabel("備考（100文字程度）");

panel.add(noteLabel);

JTextArea noteArea =
        new JTextArea(4, 30);

noteArea.setLineWrap(true);
noteArea.setWrapStyleWord(true);

panel.add(noteArea);

        
        addEquipmentButton.addActionListener(e -> {

            String newName =
                    newEquipmentField.getText();

            // ① 空欄チェック
            if (newName.isBlank()) {

                JOptionPane.showMessageDialog(
                        this,
                        "補助器具名を入力してください"
                );

                return;
            }


            // ② 同じ名前がないかチェック
            for (Equipment equipment : equipments) {

                if (equipment.getName().equals(newName)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "「" + newName
                            + "」はすでに登録されています"
                    );

                    return;
                }
            }


            // ③ 新しいIDを決める
            int newId = 1;

            for (Equipment equipment : equipments) {

                if (equipment.getId() >= newId) {
                    newId = equipment.getId() + 1;
                }
            }


            // ④ 新しい補助器具を作る
            Equipment newEquipment =
                    new Equipment(newId, newName);

            try {

                DatabaseManager.insertEquipment(newEquipment);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "補助器具のデータベース保存に失敗しました"
                );

                ex.printStackTrace();

                return;
            }
            

            // ⑤ 元データに追加
            equipments.add(newEquipment);


            // ⑥ データ管理側にも追加
            equipmentManageComboBox.addItem(newEquipment);


            // ⑦ 育成登録側の3つ全部に追加
            for (JComboBox<Equipment> comboBox
                    : equipmentComboBoxes) {

                comboBox.addItem(newEquipment);
            }


            // ⑧ 入力欄を空にする
            newEquipmentField.setText("");

        });
        
     // ====================
     // 補助器具削除
     // ====================

     deleteEquipmentButton.addActionListener(e -> {

         Equipment selectedEquipment =
                 (Equipment) equipmentManageComboBox.getSelectedItem();

         // 削除する補助器具がない場合
         if (selectedEquipment == null) {

             JOptionPane.showMessageDialog(
                     this,
                     "削除する補助器具がありません"
             );

             return;
         }

         // 削除確認
         int answer =
                 JOptionPane.showConfirmDialog(
                         this,
                         selectedEquipment.getName()
                                 + " を削除しますか？",
                         "削除確認",
                         JOptionPane.YES_NO_OPTION
                 );

         if (answer != JOptionPane.YES_OPTION) {
             return;
         }
         try {

        	    DatabaseManager.deleteEquipment(
        	            selectedEquipment.getId()
        	    );

        	} catch (SQLException ex) {

        	    JOptionPane.showMessageDialog(
        	            this,
        	            "補助器具のデータベース削除に失敗しました"
        	    );

        	    ex.printStackTrace();

        	    return;
        	}

         // 元データから削除
         equipments.remove(selectedEquipment);

         // データ管理側から削除
         equipmentManageComboBox.removeItem(selectedEquipment);

         // 育成登録側の3つから削除
         for (JComboBox<Equipment> comboBox
                 : equipmentComboBoxes) {

             comboBox.removeItem(selectedEquipment);
         }

     });
        
        JButton selectButton = new JButton("決定");
        panel.add(selectButton);

        JTextArea resultArea = new JTextArea(6, 30);

        resultArea.setEditable(false);

        panel.add(resultArea);

        selectButton.addActionListener(e -> {

            Fighter selectedFighter =
                    (Fighter) fighterComboBox.getSelectedItem();

            String result = "";

         // ====================
         // 育成開始時ステータス
         // ====================

         int startStrength;
         int startStamina;
         int startTechnique;
         int startToughness;
         int startAgility;
         int startMental;
            int strength;
            int stamina;
            int technique;
            int toughness;
            int agility;
            int mental;

            try {
            	// ====================
            	// 開始時6ステータスを読み取る
            	// ====================

            	startStrength =
            	        Integer.parseInt(
            	                startStrengthField.getText()
            	        );

            	startStamina =
            	        Integer.parseInt(
            	                startStaminaField.getText()
            	        );

            	startTechnique =
            	        Integer.parseInt(
            	                startTechniqueField.getText()
            	        );

            	startToughness =
            	        Integer.parseInt(
            	                startToughnessField.getText()
            	        );

            	startAgility =
            	        Integer.parseInt(
            	                startAgilityField.getText()
            	        );

            	startMental =
            	        Integer.parseInt(
            	                startMentalField.getText()
            	        );
                strength =
                        Integer.parseInt(
                                strengthField.getText()
                        );

                stamina =
                        Integer.parseInt(
                                staminaField.getText()
                        );

                technique =
                        Integer.parseInt(
                                techniqueField.getText()
                        );

                toughness =
                        Integer.parseInt(
                                toughnessField.getText()
                        );

                agility =
                        Integer.parseInt(
                                agilityField.getText()
                        );

                mental =
                        Integer.parseInt(
                                mentalField.getText()
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "開始時・終了時のステータスはすべて数字で入力してください"
                );

                return;
            }

         // ====================
         // 育成による純増加量
         // ====================

         int gainStrength =
                 strength - startStrength;

         int gainStamina =
                 stamina - startStamina;

         int gainTechnique =
                 technique - startTechnique;

         int gainToughness =
                 toughness - startToughness;

         int gainAgility =
                 agility - startAgility;

         int gainMental =
                 mental - startMental;

         int startTotalStatus =
                 startStrength
                 + startStamina
                 + startTechnique
                 + startToughness
                 + startAgility
                 + startMental;
         startTotalStatusField.setText(
        	        String.valueOf(startTotalStatus)
        	);
         
                
            // ====================
            // 総戦力を自動計算
            // ====================

            int totalStatus =
                    strength
                    + stamina
                    + technique
                    + toughness
                    + agility
                    + mental;
            int gainTotalStatus =
                    totalStatus - startTotalStatus;

            // 総戦力欄にも表示
            totalStatusField.setText(
                    String.valueOf(totalStatus)
            );


            String note =
                    noteArea.getText();

            if (note.length() > 100) {

                JOptionPane.showMessageDialog(
                        this,
                        "備考は100文字以内で入力してください"
                );

                return;
            }            
            
         // ====================
         // 育成記録をSQLiteへ保存
         // ====================

         int trainingRecordId;

         try {

        	 trainingRecordId =
        		        DatabaseManager.insertTrainingRecord(
        		                selectedFighter,

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
        		                note
        		        );

         } catch (SQLException ex) {

             JOptionPane.showMessageDialog(
                     this,
                     "育成記録の保存に失敗しました"
             );

             ex.printStackTrace();

             return;
         }
         
      // シーンカード3枚をSQLiteへ保存
         try {

             for (int i = 0;
                     i < sceneCardComboBoxes.size();
                     i++) {

                 SceneCard selectedCard =
                         (SceneCard) sceneCardComboBoxes
                                 .get(i)
                                 .getSelectedItem();

                 DatabaseManager.insertTrainingSceneCard(
                         trainingRecordId,
                         i + 1,
                         selectedCard
                 );
             }

         } catch (SQLException ex) {

             JOptionPane.showMessageDialog(
                     this,
                     "シーンカードの育成記録保存に失敗しました"
             );

             ex.printStackTrace();

             return;
         }
         
      // ====================
      // サポーター5人をSQLiteへ保存
      // ====================

      try {

          for (int i = 0;
                  i < supporterComboBoxes.size();
                  i++) {

              Supporter selectedSupporter =
                      (Supporter) supporterComboBoxes
                              .get(i)
                              .getSelectedItem();

              DatabaseManager.insertTrainingSupporter(
                      trainingRecordId,
                      i + 1,
                      selectedSupporter
              );
          }

      } catch (SQLException ex) {

          JOptionPane.showMessageDialog(
                  this,
                  "サポーターの育成記録保存に失敗しました"
          );

          ex.printStackTrace();

          return;
      }
            
   // ====================
   // 補助器具3個をSQLiteへ保存
   // ====================

   try {

       for (int i = 0;
               i < equipmentComboBoxes.size();
               i++) {

           Equipment selectedEquipment =
                   (Equipment) equipmentComboBoxes
                           .get(i)
                           .getSelectedItem();

           DatabaseManager.insertTrainingEquipment(
                   trainingRecordId,
                   i + 1,
                   selectedEquipment
           );
       }

   } catch (SQLException ex) {

       JOptionPane.showMessageDialog(
               this,
               "補助器具の育成記録保存に失敗しました"
       );

       ex.printStackTrace();

       return;
   }
   
// ====================
// サブ能力9個をSQLiteへ保存
// ====================

try {

    int subPosition = 0;

    for (int equipmentIndex = 0;
            equipmentIndex < 3;
            equipmentIndex++) {

        for (int abilityIndex = 0;
                abilityIndex < 3;
                abilityIndex++) {

            SubAbility selectedSubAbility =
                    (SubAbility) subAbilityComboBoxes
                            .get(subPosition)
                            .getSelectedItem();

            String valueText =
                    subAbilityValueFields
                            .get(subPosition)
                            .getText();

            double abilityValue;

            try {

                abilityValue =
                        Double.parseDouble(valueText);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "サブ能力の値は数字で入力してください"
                );

                return;
            }

            DatabaseManager.insertTrainingSubAbility(
                    trainingRecordId,
                    equipmentIndex + 1,
                    abilityIndex + 1,
                    selectedSubAbility.getName(),
                    abilityValue
            );

            subPosition++;
        }
    }

} catch (SQLException ex) {

    JOptionPane.showMessageDialog(
            this,
            "サブ能力の育成記録保存に失敗しました"
    );

    ex.printStackTrace();

    return;
}
      
            result += "キャラクター：" + selectedFighter.getName() + "\n";

            result += "シーンカード\n";

            for (int i = 0; i < sceneCardComboBoxes.size(); i++) {

            	
            	
                SceneCard selectedCard =
                        (SceneCard) sceneCardComboBoxes
                                .get(i)
                                .getSelectedItem();

                result += (i + 1)
                        + "枚目："
                        + selectedCard.getName()
                        + "\n";
            }

            result += "サポーター\n";

            for (int i = 0; i < supporterComboBoxes.size(); i++) {

                Supporter selectedSupporter =
                        (Supporter) supporterComboBoxes
                                .get(i)
                                .getSelectedItem();

                result += (i + 1)
                        + "人目："
                        + selectedSupporter.getName()
                        + "\n";
            }
            
            result += "補助器具\n";

            int subPosition = 0;

            for (int i = 0;
                    i < equipmentComboBoxes.size();
                    i++) {

                Equipment selectedEquipment =
                        (Equipment) equipmentComboBoxes
                                .get(i)
                                .getSelectedItem();

                result += "補助器具"
                        + (i + 1)
                        + "："
                        + selectedEquipment.getName()
                        + "\n";


                for (int j = 0; j < 3; j++) {

                    SubAbility selectedSubAbility =
                            (SubAbility) subAbilityComboBoxes
                                    .get(subPosition)
                                    .getSelectedItem();

                    String valueText =
                            subAbilityValueFields
                                    .get(subPosition)
                                    .getText();
                    int value;

                    try {
                        value = Integer.parseInt(valueText);
                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(
                                this,
                                "サブ能力の値は数字で入力して"
                        );

                        return;
                    }

                    result += "  サブ"
                            + (j + 1)
                            + "："
                            + selectedSubAbility.getName()
                            + " "
                            + value
                            + selectedSubAbility.getUnit();

                    if (value == selectedSubAbility.getMaxValue()) {
                        result += " ★MAX";
                    }

                    result += "\n";

                    subPosition++;
                }
            }
            
            result += "\n総戦力："
                    + totalStatus
                    + "\n";

            result += "備考：\n"
                    + note
                    + "\n";
            
            result += "\n育成記録ID："
                    + trainingRecordId
                    + "\n";
            
            TrainingRecord newTrainingRecord =
                    new TrainingRecord(
                            trainingRecordId,
                            selectedFighter,

                            // 開始時
                            startStrength,
                            startStamina,
                            startTechnique,
                            startToughness,
                            startAgility,
                            startMental,

                            // 終了時
                            strength,
                            stamina,
                            technique,
                            toughness,
                            agility,
                            mental,

                            totalStatus,
                            note,
                            java.time.LocalDateTime.now().toString()
                    );

            trainingRecordComboBox.insertItemAt(
                    newTrainingRecord,
                    0
            );

            trainingRecordComboBox.setSelectedIndex(0);
            
            resultArea.setText(result);
        });
        setVisible(true);
    }
    private String formatDifference(int difference) {

        if (difference > 0) {

            return "+" + difference;

        }

        return String.valueOf(difference);
    }
}