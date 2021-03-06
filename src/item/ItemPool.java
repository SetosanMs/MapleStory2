package item;

import java.util.ArrayList;
import java.util.HashMap;

import character.Resistance;
import character.SexType;
import character.Status;
import character.Strength;
import skill.Skill;
import utils.DialogUtils;

public class ItemPool {
	private static HashMap<String, Item> items = new HashMap<String, Item>();
	private static int[] startPrice = {140, 140, 170, 130, 130, 110, 110};
	private static int[][] priceTable = new int[7][20];
	//상의, 하의, 무기, 방패, 핼멧, 신발, 장갑
	
	static {
		for(int i = 0; i < 7; i++) {
			calCostItem(i);
		}
		initWeaponItem();
		initClothsItem();
		initPantsItem();
		initComsumableItem();
		initShoesItem();
		initHelmetItem();
		initGloveItem();
		initTitleItem();
		initMaterialItem();
		initshieldItem();
	}
	
	public static int getPrice(int type, int level) {
		return priceTable[type][level/5];
	}

	private static void calCostItem(int type) {
		double price = startPrice[type];
		double rate = 2.0;
		priceTable[type][0] = (int)price;
		for(int i = 1; i < 20; i++) {
			priceTable[type][i] = (int)(price * rate);
			price = priceTable[type][i];
			rate -= 0.05;
		}
		for(int i = 0; i < 20; i++) {
			int copyTable = priceTable[type][i];
			int r = 0;
			while(copyTable != 0) {
				r++;
				copyTable /= 10;
			}
			for(int j = 0; j < r - 2; j++) {
				priceTable[type][i] /= 10;
			}
			for(int j=0; j<r-2; j++) {
				priceTable[type][i] *= 10;
			}
		}
	}
	
	
	private static void initshieldItem() {
		items.put("우드버클러", new EquipmentItem("우드버클러", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 10), "woodBuckler", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 10, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("강철방패", new EquipmentItem("강철방패", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 15), "steelShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("미스릴버클러", new EquipmentItem("미스릴버클러", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 20), "mithrilBuckler", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("빨간삼각방패", new EquipmentItem("빨간삼각방패", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 25), "redSquareShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("레드크로스실드", new EquipmentItem("레드크로스실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 30), "redCrossShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("배틀실드", new EquipmentItem("배틀실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 35), "battleShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 0, 0, 35, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("타워실드", new EquipmentItem("타워실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 40), "towerShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 40, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("레전드실드", new EquipmentItem("레전드실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 50), "legendShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 50, 10, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("에이전트실드", new EquipmentItem("에이전트실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 60), "aentShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 60, 15, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("아퀼라실드", new EquipmentItem("아퀼라실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 70), "aquilaShield", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 70, 20, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, false));
		items.put("타임리스카이트실드", new EquipmentItem("타임리스카이트실드", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHIELD, 80), "timelessKiteShield", 1, 
				new Strength(new Resistance(0, 0, 10, 10, 10, 0), 80, 0, 0, 0, 0, 140, 90, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHIELD, SexType.ALL, true));
	}


	private static void initWeaponItem() {
		items.put("검", new WeaponItem("검", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 1), "sword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 17, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("도루커대거", new WeaponItem("도루커대거", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 5), "dorkerDagger", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 22, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		
		
		items.put("카알대검", new WeaponItem("카알대검", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 10), "carlGreatsword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 27, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("샤브르", new WeaponItem("샤브르", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 15), "saber", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 32, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("바이킹소드", new WeaponItem("바이킹소드", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 20), "vikingSword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 37, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("일룬", new WeaponItem("일룬", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 25), "lllun", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 42, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("글라디우스", new WeaponItem("글라디우스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 30), "gradius", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 47, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("커틀러스", new WeaponItem("커틀러스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 35), "cutlass", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 52, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("트라우스", new WeaponItem("트라우스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 40), "trous", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 57, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("네오코라", new WeaponItem("네오코라", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 45), "neokora", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 45, 0, 0, 62, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("쥬얼쿠아다라", new WeaponItem("쥬얼쿠아다라", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 50), "jeweledQuadra", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 67, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("스파타", new WeaponItem("스파타", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 55), "spata", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 55, 0, 0, 75, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("레드카타나", new WeaponItem("레드카타나", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 60), "redKatana", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 83, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("프라우테", new WeaponItem("프라우테", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 70), "praote", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 98, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("타임리스엑서큐서너스", new WeaponItem("타임리스엑서큐서너스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 80), "timelessXercucinus", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 80, 0, 0, 123, 0, 0, 0, 0, 0, 5), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, true, WeaponType.SWORD));
	
		items.put("삼지창", new WeaponItem("삼지창", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 25), "trident", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 47, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("제코", new WeaponItem("제코", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 30), "jeko", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 52, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("장팔사모", new WeaponItem("장팔사모", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 35), "jangpalsamo", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 57, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("나카마키", new WeaponItem("나카마키", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 40), "nakamaki", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 62, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("십자창", new WeaponItem("십자창", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 45), "reticle", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 45, 0, 0, 67, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("스페판", new WeaponItem("스페판", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 50), "spapan", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 75, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("호진공창", new WeaponItem("호진공창", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 55), "hojingongchang", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 55, 0, 0, 83, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("페어프로즌", new WeaponItem("페어프로즌", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 60), "fairFrozen", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 98, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("피나카", new WeaponItem("피나카", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 70), "pinaka", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 105, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SPEAR));
		items.put("타임리스알슈피스", new WeaponItem("타임리스알슈피스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 80), "timelessAlSchpis", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 80, 0, 0, 130, 0, 0, 0, 0, 0, 5), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, true, WeaponType.SWORD));
	}

	private static void initClothsItem() {
		items.put("하얀반팔면티(남)", new EquipmentItem("하얀반팔면티(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 1), "shortSleeveCottonMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("노란반팔면티(여)", new EquipmentItem("노란반팔면티(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 1), "shortSleeveCottonWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("파란색원라인티셔츠(남)", new EquipmentItem("파란색원라인티셔츠(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 5), "blueOneLineTshirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("분홍별무늬티셔츠(여)", new EquipmentItem("분홍별무늬티셔츠(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 5), "pinkStarTshirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("로리카아머(남)", new EquipmentItem("로리카아머(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 10), "loricaArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("스퀘이머(여)", new EquipmentItem("스퀘이머(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 10), "squemmerWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("코퍼럴", new EquipmentItem("코퍼럴", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 15), "corporal", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
		items.put("서전트(남)", new EquipmentItem("서전트(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 20), "sergeantMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 40, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("라멜(여)", new EquipmentItem("라멜(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 20), "ramelWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 40, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("마스터서전트(남)", new EquipmentItem("마스터서전트(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 25), "masterSergeantMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 50, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("샤크(여)", new EquipmentItem("샤크(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 25), "sharkWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 50, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("지장의", new EquipmentItem("지장의", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 30), "giGang", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 60, 0, 0, 0, 35, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
		items.put("자진일갑주(남)", new EquipmentItem("자진일갑주(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 40), "jaJinwongArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 80, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("흑진월갑주(여)", new EquipmentItem("흑진월갑주(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 40), "blackjinwongArmorWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 80, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("숄더메일(남)", new EquipmentItem("숄더메일(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 50), "shoulderMailMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 100, 0, 0, 0, 55, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("숄더메일(여)", new EquipmentItem("숄더메일(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 50), "shoulderMailWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 100, 0, 0, 0, 55, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("오리엔타이칸(남)", new EquipmentItem("오리엔타이칸(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 60), "orientTaikanMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 120, 0, 0, 0, 65, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("트란도트(여)", new EquipmentItem("트란도트(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 60), "trandotWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 120, 0, 0, 0, 65, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("플라티나", new EquipmentItem("플라티나", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 70), "platinum", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 140, 0, 0, 0, 75, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
		
		items.put("네오스", new EquipmentItem("네오스", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 80), "neos", 1,
				new Strength(new Resistance(10, 10, 0, 0, 0, 0), 80, 250, 50, 0, 0, 100, 25, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, true));
	}

	private static void initPantsItem() {
		items.put("파란청반바지(남)", new EquipmentItem("파란청반바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 1), "blueShortsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("빨간미니스커트(여)", new EquipmentItem("빨간미니스커트(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 1), "redMiniSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("로리카바지(남)", new EquipmentItem("로리카바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 10), "loricaPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 12, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("소피아바지(여)", new EquipmentItem("소피아바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 10), "sophiaPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 12, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("코퍼럴바지", new EquipmentItem("코퍼럴바지", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 15), "corporalPants", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 16, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.ALL, false));
		items.put("서전트치마(남)", new EquipmentItem("서전트치마(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 20), "sergeantSkirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("라멜치마(여)", new EquipmentItem("라멜치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 20), "ramelSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("마스터서전트치마(남)", new EquipmentItem("마스터서전트치마(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 25), "masterSergeantSkirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 24, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("샤크치마(여)", new EquipmentItem("샤크치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 25), "sharkSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 24, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("홍무바지", new EquipmentItem("홍무바지", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 30), "honguPants", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 28, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.ALL, false));
		items.put("백진일갑주바지(남)", new EquipmentItem("백진일갑주바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 40), "baeJinilArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 36, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("황진월갑주바지(여)", new EquipmentItem("황진월갑주바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 40), "hwangJinwolArmorWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 36, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("숄더메일바지(남)", new EquipmentItem("숄더메일바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 50), "shoulderMailPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("숄더메일바지(여)", new EquipmentItem("숄더메일바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 50), "shoulderMailPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("오리엔타이칸바지(남)", new EquipmentItem("오리엔타이칸바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 60), "orientTaikanPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 52, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("트란도트치마(여)", new EquipmentItem("트란도트치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 60), "TrandotSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 52, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("플라티나바지(남)", new EquipmentItem("플라티나바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 70), "platinPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("플라티나바지(여)", new EquipmentItem("플라티나바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 70), "PlatinumPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
	}

	private static void initComsumableItem() {
		items.put("초보모험가의빨간포션",new HealItem("초보모험가의빨간포션", 12, "newbieRedPortion", 1, new Heal(50, 0), 1));
		items.put("초보모험가의파란포션", new HealItem("초보모험가의파란포션", 25, "newbieBluePortion", 1, new Heal(0, 50), 1));
		items.put("빨간포션", new HealItem("빨간포션", 25, "redPortion", 1, new Heal(100, 0), 5));
		items.put("파란포션", new HealItem("파란포션", 50, "bluePortion", 1, new Heal(0, 100), 5));
		items.put("레몬", new HealItem("레몬", 75, "remon", 1, new Heal(0, 150), 10));
		items.put("마나엘릭서", new HealItem("마나엘릭서", 150, "manaElixir", 1, new Heal(0, 300), 15));
		items.put("주황포션", new HealItem("주황포션", 75, "orangePortion", 1, new Heal(300, 0), 10));
		items.put("하얀포션", new HealItem("하얀포션", 125, "whitePortion", 1, new Heal(500, 0), 15));
		items.put("맑은물", new HealItem("맑은물", 250, "freshWater", 1, new Heal(0, 500), 20));
		items.put("팥빙수", new HealItem("팥빙수", 1000, "shavedIce", 1, new Heal(0, 2000), 30));
		items.put("새우튀김", new HealItem("새우튀김", 190, "friedShrimp", 1, new Heal(750, 0), 15));
		items.put("장어구이", new HealItem("장어구이", 250, "grilledEel", 1, new Heal(1000, 0), 20));
		items.put("쭈쭈바", new HealItem("쭈쭈바", 500, "pencilBar", 1, new Heal(2000, 0), 25));
		items.put("살살녹는치즈", new HealItem("살살녹는치즈", 1000, "goodCheese", 1, new Heal(4000, 0), 30));
		
		items.put("엘릭서",new HealItem("엘릭서", 2500, "elixir", 1, new Heal(0, 0, 50, 50), 50));
		items.put("파워엘릭서", new HealItem("파워엘릭서", 5000, "powerElixir", 1, new Heal(0, 0, 100, 100), 60));
		
		items.put("전사의물약", new BuffItem("전사의물약", 250, "warriorPower", 1, 10, new Strength(new Resistance(), 0, 0, 0, 5, 0, 0, 0, 0, 0, 0), 5));
		items.put("명사수의물약", new BuffItem("명사수의물약", 250, "shooterPower", 1, 10, new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 5, 0, 0), 5));
		items.put("민첩함의물약", new BuffItem("민첩함의물약", 250, "agilityPower", 1, 10, new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 0, 5, 0), 5));
		items.put("전사의알약", new BuffItem("전사의알약", 500, "warriorTablet", 1, 20, new Strength(new Resistance(), 0, 0, 0, 5, 0, 0, 0, 0, 0, 0), 10));
		items.put("사미인탕", new BuffItem("사미인탕", 1000, "samiInSoup", 1, 30, new Strength(new Resistance(), 0, 0, 0, 7, 0, 0, 0, 0, 0, 0), 15));
		items.put("블레이즈캡슐", new BuffItem("블레이즈캡슐", 4000, "blazeCapsule", 1, 40, new Strength(new Resistance(30, 0, 0, 0, 0, 0), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 15));
		items.put("글레이스캡슐", new BuffItem("글레이스캡슐", 4000, "glaceCapsule", 1, 40, new Strength(new Resistance(0, 30, 0, 0, 0, 0), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 15));
		items.put("코카콜라알약", new BuffItem("코카콜라알약", 2000, "coke", 1, 50, new Strength(new Resistance(), 0, 0, 0, 0, 0, 100, 100, 0, 0, 0), 15));
		items.put("코카콜라제로알약", new BuffItem("코카콜라제로알약", 3000, "cokeZero", 1, 60, new Strength(new Resistance(), 0, 0, 0, 0, 0, 150, 150, 0, 0, 0), 15));	
		items.put("최상급영웅의비약", new BuffItem("최상급영웅의비약", 20000, "greatestHeroSecretPortion", 1, 80, new Strength(new Resistance(), 0, 0, 0, 24, 24, 200, 200, 10, 10, 10), 20));
		
		items.put("마을귀환주문서", new WarpItem("마을귀환주문서", 200, "villegeReturn", 1, 1, "가까운 마을로 이동할 수 있는 주문서이다"));
		
		items.put("만병통치약", new AbnormalRecoveryItem("만병통치약", 1000, "panacea", 1, 30, "전체"));
		
		//스킬북
		items.put("3차스킬북", new SkillBookItem("3차스킬북", 100, "skillBook", 1, 40, "3차 전직을 할 수 있는 스킬북이다."));
		items.put("4차스킬북", new SkillBookItem("4차스킬북", 100, "skillBook", 1, 70, "4차 전직을 할 수 있는 스킬북이다."));
	}
	
	private static void initTitleItem() {
		items.put("페리온을구한자", new EquipmentItem("페리온을구한자", 50000, "savePellion", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 100, 0, 2, 0, 0, 0, 1, 0, 0), EquipmentItem.EQUIPMENT_TYPE_TITLE, SexType.ALL, false));
		items.put("엘나스를구한자", new EquipmentItem("엘나스를구한자", 50000, "saveElnath", 1,
				new Strength(new Resistance(0, 10, 0, 0, 0, 0), 40, 0, 0, 0, 0, 50, 50, 0, 0, 2), EquipmentItem.EQUIPMENT_TYPE_TITLE, SexType.ALL, false));
		items.put("리프레의영웅", new EquipmentItem("리프레의영웅", 300000, "heroOfLeafre", 1,
				new Strength(new Resistance(20, 20, 0, 0, 0, 0), 80, 150, 150, 0, 0, 80, 80, 5, 5, 5), EquipmentItem.EQUIPMENT_TYPE_TITLE, SexType.ALL, true));
		items.put("메이플월드의영웅", new EquipmentItem("메이플월드의영웅", 1000000, "heroOfMapleWorld", 1,
				new Strength(new Resistance(20, 20, 20, 20, 20, 20), 90, 300, 300, 0, 0, 150, 150, 10, 10, 10), EquipmentItem.EQUIPMENT_TYPE_TITLE, SexType.ALL, true));
	}

	private static void initGloveItem() {
		items.put("미셀", new EquipmentItem("미셀", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 30), "micelle", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 13, 0, 1, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("브리건", new EquipmentItem("브리건", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 35), "briggan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 0, 0, 15, 0, 2, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("너클", new EquipmentItem("너클", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 35), "knuckle", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 16, 0, 3, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("브리스트", new EquipmentItem("브리스트", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 50), "birst", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 21, 0, 4, 0, 1), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("클랜치", new EquipmentItem("클랜치", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 60), "clanchi", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 24, 0, 5, 0, 2), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("허스크", new EquipmentItem("허스크", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 70), "husk", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 29, 0, 6, 0, 3), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
	}

	private static void initHelmetItem() {
		items.put("풀헬름", new EquipmentItem("풀헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 15), "fullHelm", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("디펜더헬멧", new EquipmentItem("디펜더헬멧", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 20), "defenderHelmet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("버거넷헬름", new EquipmentItem("버거넷헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 25), "ironBurgerNet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("주스창", new EquipmentItem("주스창", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 30), "juSting", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 35, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("노르만헬름", new EquipmentItem("노르만헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 40), "normanHelm", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("돔", new EquipmentItem("돔", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 50), "dom", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("오리엔트헬멧", new EquipmentItem("오리엔트헬멧", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 60), "orientHelmet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 75, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		
		items.put("휀넬", new EquipmentItem("휀넬", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 80), "fennel", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 15), 80, 0, 0, 0, 0, 120, 20, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, true, new Status(3, 2, 0, 0)));
	}

	private static void initShoesItem() {
		items.put("고무장화", new EquipmentItem("고무장화", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 1), "rubberBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("스틸그리브", new EquipmentItem("스틸그리브", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 15), "steelGrease", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 9, 0, 0, 1, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("워부츠", new EquipmentItem("워부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 25), "warBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 15, 0, 0, 2, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("배틀그리브", new EquipmentItem("배틀그리브", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 35), "battleGrease", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 0, 0, 21, 0, 0, 3, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("힐던부츠", new EquipmentItem("힐던부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 45), "hildanBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 45, 0, 0, 0, 0, 30, 0, 0, 4, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("카젠부츠", new EquipmentItem("카젠부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 55), "hildanBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 55, 0, 0, 0, 0, 42, 0, 0, 5, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("리버스부츠", new EquipmentItem("리버스부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 65), "reverseBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 65, 0, 0, 0, 0, 48, 0, 0, 6, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
	}

	private static void initMaterialItem() {
		//메이플 아일랜드
		items.put("파란달팽이의껍질", new MaterialItem("파란달팽이의껍질", 10, "blueSnailSkin", 1, "파란 달팽이의 껍질을 벗긴것이다"));
		items.put("빨간달팽이의껍질", new MaterialItem("빨간달팽이의껍질", 20, "redSnailSkin", 1, "빨간 달팽이의 껍질을 벗긴것이다"));
		//빅토리아 아일랜드
		items.put("돼지의리본", new MaterialItem("돼지의리본", 30, "pigRibbon", 1, "리본돼지의 리본을 끊은 것이다"));
		items.put("주황버섯의갓", new MaterialItem("주황버섯의갓", 40, "orangeMushroomCap", 1, "주황 버섯의 갓이다"));
		items.put("초록버섯의갓", new MaterialItem("초록버섯의갓", 50, "greenMushroomCap", 1, "초록 버섯의 갓이다"));
		items.put("나뭇가지", new MaterialItem("나뭇가지", 60, "branch", 1, "스텀프의 나뭇가지이다"));
		items.put("장작", new MaterialItem("장작", 70, "firewood", 1, "엑스텀프에서 떼어난 고품질 장작이다"));
		items.put("동물의가죽", new MaterialItem("동물의가죽", 500, "animalLeather", 1, "동물의 가죽을 잘라온 것이다"));
		items.put("와일드보어의송곳니", new MaterialItem("와일드보어의송곳니", 90, "wildBoarCanine", 1, "와일드보어의 송곳니를 잘라온것이다"));
		items.put("파이어보어의송곳니", new MaterialItem("파이어보어의송곳니", 100, "fireBoarCanine", 1, "파이어보어의 송곳니를 잘라온것이다"));
		items.put("아이언호그의철발굽", new MaterialItem("아이언호그의철발굽", 110, "ironHoof", 1, "아이언 호그의 다리를 감싸고 있는 강철로 된 발굽이다"));
		items.put("아이언보어의갑옷조각", new MaterialItem("아이언보어의갑옷조각", 120, "armorPiece", 1, "아이언보어가 입고있던 갑옷에서 얻어낸 것이다"));
		items.put("목판", new MaterialItem("목판", 130, "woodPan", 1, "우드 마스크가 쓰고 다니는 나무 판자이다"));
		items.put("석판", new MaterialItem("석판", 140, "stonePan", 1, "스톤 마스크가 쓰고 다니는 석판이다"));
		items.put("스켈독의뼈", new MaterialItem("스켈독의뼈", 130, "skelDogBone", 1, "스켈독의 몸에서 떨어진 뼈이다"));
		items.put("더러운붕대", new MaterialItem("더러운붕대", 140, "dirtyBandage", 1, "머미독의 몸을 감고 있던 더러운 붕대이다"));
		items.put("갈비뼈", new MaterialItem("갈비뼈", 150, "rib", 1, "스켈레톤 사병의 갈비뼈이다"));
		items.put("골반뼈", new MaterialItem("골반뼈", 160, "pelvicBone", 1, "스켈레톤 장교의 골반뼈이다"));
		items.put("말머리뼈", new MaterialItem("말머리뼈", 200, "horseHeadBone", 1, "스켈레톤 지휘관이 타고다니는 말의 머리뼈이다"));
		//엘나스 산맥
		items.put("스타픽시의별조각", new MaterialItem("스타픽시의별조각", 220, "starPixieStarPiece", 1, "스타픽시가 떨어뜨린 별조각이다 아름다운 빛을 내고있다"));
		items.put("루나픽시의달조각", new MaterialItem("루나픽시의달조각", 230, "moonPixieMoonPiece", 1, "루나픽시가 떨어뜨린 별조각이다 아름다운 빛을 내고있다"));
		items.put("러스터픽시의태양조각", new MaterialItem("러스터픽시의태양조각", 240, "lusterPixieSunpiece", 1, "러스터픽시가 떨어뜨린 별조각이다 아름다운 빛을 내고있다"));
		items.put("라이오너의꼬리", new MaterialItem("라이오너의꼬리", 250, "lionerTail", 1, "라이오너의 꼬리를 잘라온 것이다. 매우 부드러우며 만져보면 전기가 일어난다"));
		items.put("그류핀의꼬리", new MaterialItem("그류핀의꼬리", 260, "grupinTail", 1, "그류핀의 꼬리를 잘라온 것이다. 매우 부드러우며 만져보면 무척 차갑다"));
		items.put("샐리온의꼬리", new MaterialItem("샐리온의꼬리", 270, "cellionTail", 1, "샐리온의 꼬리를 잘라온 것이다. 매우 부드러우며 만져보면 무척 뜨겁다"));
		items.put("루이넬의꼬리", new MaterialItem("루이넬의꼬리", 280, "lucidaTail", 1, "샐리온의 꼬리를 잘라온 것이다. 사악한 기운이 가득차있다."));
		items.put("뻣뻣한깃털", new MaterialItem("뻣뻣한깃털", 600, "stiffFeather", 1, "뻣뻣하고 거친 깃털이다"));
		items.put("스톤볼의돌조각", new MaterialItem("스톤볼의돌조각", 300, "sentinelStone", 1, "스톤볼의 몸의 일부분을 이루고 있던 단단한 돌조각이다"));
		items.put("화이트팽의꼬리", new MaterialItem("화이트팽의꼬리", 310, "whiteFangTail", 1, "화이트팽의 꼬리를 잘라온것이다. 흰색의 매우 부드러운 털이다."));
		items.put("헥터의꼬리", new MaterialItem("헥터의꼬리", 320, "hectorTail", 1, "헥터의 꼬리를 잘라온것이다. 갈색의 거칠거칠한 털이다."));
		items.put("페페의부리", new MaterialItem("페페의부리", 330, "pepeBeak", 1, "페페의 부리를 잘라온 것이다. 황금빛의 단단한 부리이다."));
		items.put("다크페페의부리", new MaterialItem("다크페페의부리", 340, "darkpepeBeak", 1, "다크페페의 부리를 잘라온 것이다. 검은빛의 단단한 부리이다."));
		items.put("예티의뿔", new MaterialItem("예티의뿔", 350, "yetiHorn", 1, "예티의 뿔을 잘라온것이다. 매우단단하여 잘 부서지지 않는다."));
		items.put("다크예티의뿔", new MaterialItem("다크예티의뿔", 360, "darkyetiHorn", 1, "다크예티의 뿔을 잘라온것이다. 매우단단하여 잘 부서지지 않는다."));
		items.put("웨어울프의발톱", new MaterialItem("웨어울프의발톱", 370, "werewolfToenail", 1, "웨어울프의 발톱을 잘라온것이다. 매우 날카로워 조심히 다뤄야한다."));
		items.put("라이칸스로프의발톱", new MaterialItem("라이칸스로프의발톱", 380, "lycanthropeToenail", 1, "라이칸스로프의 발톱을 잘라온것이다. 매우 날카로워 조심히 다뤄야한다."));
		items.put("불독의송곳니", new MaterialItem("불독의송곳니", 400, "cerebesHorn", 1, "불독의송곳니를 잘라온것이다. 매우 길고 커서 흉기가 될 수도 있을것같다."));
		items.put("파이어독의목걸이", new MaterialItem("파이어독의목걸이", 400, "bainNecklace", 1, "파이어독의 목걸이를 빼온것이다. 뾰족한 징이 잔뜩박혀 있어 흉기가 될 수도 있을것같다."));
		//니할사막
		items.put("선인장의가시", new MaterialItem("선인장의가시", 420, "cactusThorn", 1, "선인장의 뾰족한 가시이다. 독은 없지만 찔리면 아프다."));
		items.put("카투스의꽃", new MaterialItem("카투스의꽃", 430, "cactusFlower", 1, "로얄카투스에게서 얻을 수 있는 꽃이다. 꽃잎의 수액이 달아서 차의 재료로도 쓰인다."));
		items.put("뱀방울", new MaterialItem("뱀방울", 450, "snakeBell", 1, "벨라모아가 달고다니던 방울이다. 방울을 흔들면 벨라모아가 나타날지도 모른다."));
		items.put("귀마개", new MaterialItem("귀마개", 460, "earplug", 1, "귀를 추위로부터 보호하는 장신구다. 낡아서 보풀이 껴있다."));
		items.put("키요의부리", new MaterialItem("키요의부리", 470, "kiyoBeak", 1, "키요의 길고 구부러진 부리이다. 매우 단단하다."));
		items.put("전갈의독침", new MaterialItem("전갈의독침", 480, "scorpionSting", 1, "스콜피온의 꼬리에 있는 독침이다. 예리한 꼬리 끝에 독이 묻어있다."));
		items.put("금모래가루", new MaterialItem("금모래가루", 500, "goldSandPowder", 1, "반짝이는 고운 모래가루이다. 사막에서 오랜 세월 풍화를 거쳐서 생성된 모래다."));
		items.put("젤라틴", new MaterialItem("젤라틴", 510, "gelatin", 1, "투명하고 탱탱한 젤라틴의 덩어리다."));
		items.put("플라스크", new MaterialItem("플라스크", 520, "flask", 1, "실험도구로 사용했던 플라스크다."));
		items.put("강철파편", new MaterialItem("강철파편", 530, "steelDebris", 1, "아이언 뮤테를 구성하고 있던 강철의 파편이다."));
		items.put("강철파편강화형", new MaterialItem("강철파편강화형", 540, "reinforcedSteelDebris", 1, "강화형 아이언 뮤테를 구성하고 있던 강철의 파편이다."));
		items.put("미스릴파편", new MaterialItem("미스릴파편", 550, "mithrilFragments", 1, "미스릴 뮤테를 구성하고 있던 미스릴의 파편이다."));
		items.put("미스릴파편강화형", new MaterialItem("미스릴파편강화형", 560, "reinforcedMithrilFragments", 1, "강화형 미스릴 뮤테를 구성하고 있던 미스릴의 파편이다."));
		items.put("전선다발", new MaterialItem("전선다발", 570, "wires", 1, "로이드의 본체 일부를 이루고 있는 전선다발이다."));
		items.put("콘센트", new MaterialItem("콘센트", 580, "consent", 1, "네오 휴로이드와 동력원을 연결하는 콘센트이다."));
		items.put("출입증", new MaterialItem("출입증", 600, "laboratoryPass", 1, "연구소 출입을 위한 출입증이다."));
		items.put("5월의이슬", new MaterialItem("5월의이슬", 610, "fiveMonthDew", 1, "호문쿨루 연금에 사용했던 재료이다."));
		items.put("호문스큘러의흙", new MaterialItem("호문스큘러의흙", 620, "homunsculloSoil", 1, "호문스큘러의 몸을 구성하고 있던 흙이다. 희미하게 약품 냄새가 풍긴다."));
		//미나르 숲
		items.put("레쉬의털뭉치", new MaterialItem("레쉬의털뭉치", 630, "rashWool", 1, "레쉬의 몸에서 떨어진 털뭉치다."));
		items.put("다크레쉬의털뭉치", new MaterialItem("다크레쉬의털뭉치", 640, "darkRashWool", 1, "다크레쉬의 몸에서 떨어진 털뭉치다."));
		items.put("비틀의뿔", new MaterialItem("비틀의뿔", 650, "beetleHorn", 1, "비틀의 머리에 달린 뿔이다. 날카롭고 단단하다."));
		items.put("듀얼비틀의뿔", new MaterialItem("듀얼비틀의뿔", 660, "dualBeetleHorn", 1, "듀얼비틀의 머리에 달린 뿔이다. 날카롭고 단단하다."));
		items.put("헹키의팬플롯", new MaterialItem("헹키의팬플롯", 670, "hankieFanplot", 1, "헹키가 연주했던 팬플룻이다."));
		items.put("하프의꼬리깃털", new MaterialItem("하프의꼬리깃털", 680, "harpTailFeather", 1, "하프의 몸에서 떨어진 꼬리깃털이다. 아름다워서 장식용으로 쓰이기도 한다."));
		items.put("블러드하프의머리관", new MaterialItem("블러드하프의머리관", 700, "bloodHarpTailFeather", 1, "블러드 하프가 쓰고 다니는 머리관이다. 부드럽고 포근한 느낌이다."));
		items.put("켄타우로스의불꽃", new MaterialItem("켄타우로스의불꽃", 710, "kentaurusFire", 1, "켄타우로스의 힘의 근원이다."));
		items.put("와이번의아가미", new MaterialItem("와이번의아가미", 720, "wyverngill", 1, "블루 와이번의 얼굴 양쪽에 달려있는 작은 아가미다."));
		items.put("해골어깨보호대", new MaterialItem("해골어깨보호대", 720, "skeletonShoulderProtector", 1, "코니언의 어깨 갑주이다. 해골로 만들어져서 보는 이로 하여금 공포를 느끼게 한다."));
		items.put("와이번의발톱", new MaterialItem("와이번의발톱", 730, "wyvernToenail", 1, "다크 와이번의 날개 끝에 달려있는 작고 날카로운 발톱이다."));
		//시간의 신전
		items.put("녹색고깔모자", new MaterialItem("녹색고깔모자", 750, "greenConeHat", 1, "추억의 신관이 쓰고있던 모자이다."));
		items.put("푸른고깔모자", new MaterialItem("푸른고깔모자", 770, "blueConeHat", 1, "후회의 신관이 쓰고있던 모자이다."));
		items.put("붉은고깔모자", new MaterialItem("붉은고깔모자", 790, "redConeHat", 1, "망각의 신관이 쓰고있던 모자이다."));
		items.put("녹색심장", new MaterialItem("녹색심장", 800, "greenHeart", 1, "추억의 수호대장을 이루고 있던 심장이다."));
		items.put("푸른심장", new MaterialItem("푸른심장", 810, "blueHeart", 1, "후회의 수호대장을 이루고 있던 심장이다."));
		items.put("붉은심장", new MaterialItem("붉은심장", 820, "redHeart", 1, "망각의 수호대장을 이루고 있던 심장이다."));
		items.put("고래의투구", new MaterialItem("고래의투구", 8300, "whalePitching", 1, "시간의 고래, 도도가 쓰고 있던 투구이다."));	
		items.put("나이트의가면", new MaterialItem("나이트의가면", 8400, "knightMask", 1, "아이스 나이트, 릴리노흐가 쓰고 있던 가면이다."));
		items.put("수호수의뿔", new MaterialItem("수호수의뿔", 8500, "guardianHorn", 1, "수호수, 라이카의 머리에 달려 있던 뿔이다."));
		items.put("검은갑옷조각", new MaterialItem("검은갑옷조각", 900, "blackArmorPiece", 1, "수호병사의 어깨를 감싸고 있던 갑옷의 조각이다."));
		
		//퀘스트 아이템
		items.put("스카이롬", new MaterialItem("스카이롬", 150, "skyrom", 1, "하늘의 힘을 가졌다고 알려진 보석이다. 정확히 어떤 힘이 있는지는 아무도 모른다.", false));
		items.put("가짜스카이롬", new MaterialItem("가짜스카이롬", 150, "skyrom", 1, "가짜 스카이롬이다.", false));
		items.put("궁전출입자격증", new MaterialItem("궁전출입자격증", 100, "palaceCertificateOfEntry", 1, "궁전에 출입할 자격이 있음을 알리는 종이조각이다.", false));
		items.put("연금술사의돌", new MaterialItem("연금술사의돌", 100, "alchemistStone", 1, "연금술사의 특별한 힘이 응축된 돌이다. 장비를 합성하는데 반드시 필요하다.", false));
		items.put("비밀문서", new MaterialItem("비밀문서", 100, "confidentialDocument", 1, "알카드노 비밀 연구소에 숨겨져있던 문서이다. 실험에 대한 기밀내용이 적혀져있다.", false));
	}

	

	public static Item getItem(String itemName, int num) {
		Item item = (Item) items.get(itemName);
		if ((item instanceof WeaponItem)) {
			WeaponItem item2 = (WeaponItem) item;
			WeaponItem e = new WeaponItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getStrength(), item2.getType(), item2.getSex(), item2.isRare(), item2.getWeaponType());
			return e;
		}
		if ((item instanceof EquipmentItem)) {
			EquipmentItem item2 = (EquipmentItem) item;
			EquipmentItem e = new EquipmentItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getStrength(), item2.getType(), item2.getSex(), item2.isRare(), item2.getStatus());
			return e;
		}
		if (item instanceof BuffItem) {
			BuffItem item2 = (BuffItem) item;
			BuffItem e = new BuffItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(), item2.getStrength(),
					item2.getLastTime());
			return e;
		}
		if (item instanceof HealItem) {
			HealItem item2 = (HealItem) item;
			HealItem e = new HealItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getHeal(),
					item2.getLevel());
			return e;
		}
		if (item instanceof AbnormalRecoveryItem) {
			AbnormalRecoveryItem item2 = (AbnormalRecoveryItem) item;
			AbnormalRecoveryItem e = new AbnormalRecoveryItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(),
					item2.getAbormalRecoveryList());
			return e;
		}
		if (item instanceof WarpItem) {
			WarpItem item2 = (WarpItem) item;
			WarpItem e = new WarpItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(), item2.getItemInfor());
			return e;
		}
		if (item instanceof SkillBookItem) {
			SkillBookItem item2 = (SkillBookItem) item;
			SkillBookItem e = new SkillBookItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(), item2.getItemInfor());
			return e;
		}
		if (item instanceof MasteryBookItem) {
			MasteryBookItem item2 = (MasteryBookItem) item;
			MasteryBookItem e = new MasteryBookItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(), item2.getSkillName(), item2.getSkillLevel());
			return e;
		}
		if (item instanceof MaterialItem) {
			MaterialItem item2 = (MaterialItem) item;
			MaterialItem e = new MaterialItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getInfor(), item2.isSellable());
			return e;
		}
		DialogUtils.showErrorDialog("ItemPool.getItem("+itemName+")을 찾지못함! 아이템 이름이 잘못되었거나 해당하는 아이템이 존재하지 않음.");
		return null;
	}
}