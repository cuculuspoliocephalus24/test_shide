package baki;

import java.util.ArrayList;

public class EquipmentData {
	public static ArrayList<Equipment> getEquipments() {

        ArrayList<Equipment> equipments = new ArrayList<>();

        equipments.add(new Equipment(1, "テーピング"));
        equipments.add(new Equipment(2, "ボクシンググローブ"));
        equipments.add(new Equipment(3, "カンフーシューズ"));
        equipments.add(new Equipment(4, "多節棍"));
        equipments.add(new Equipment(5, "日本刀"));
        equipments.add(new Equipment(6, "黒帯"));
        equipments.add(new Equipment(7, "眼帯"));
        equipments.add(new Equipment(8, "ステロイド"));
        equipments.add(new Equipment(9, "お守り"));
        equipments.add(new Equipment(10, "勇気の瓶"));
        

        return equipments;
    }
}