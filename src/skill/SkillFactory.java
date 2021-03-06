package skill;

import attack.AttackType;
import attack.Property;
import utils.DialogUtils;

public class SkillFactory {
	
	public static Skill makeSkill(String skillName) {
		switch(skillName) {
		case "일반공격":
			return new NormalSkill("hpIncreasing", "일반공격증가", 10, "일반공격이다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "HP증가":
			return new HpIncreasingSkill("hpIncreasing", "HP증가", 10, "최대 HP가 영구적으로 증가한다");
		case "파워스트라이크":
			return new PowerStrikeSkill("powerStrike", "파워스트라이크", 10, "적에게 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "아이언바디":
			return new IronBodySkill("ironBody", "아이언바디", 20, "일정 시간동안 물리,마법방어력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "검마스터리":
			return new SwordMasterySkill("swordMastery", "검마스터리", 20, "검의 숙련도와 명중률을 증가시킨다");
		case "피지컬트레이닝":
			return new PhysicalTrainingSkill("physicalTraining", "피지컬트레이닝", 10, "STR을 영구히 증가시킨다");
		case "분노":
			return new RageSkill("rage", "분노", 20, "일정 시간동안 물리공격력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "브랜디쉬":
			return new BrandishSkill("brandish", "브랜디쉬", 20, "적에게 두번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "콤보어택":
			return new ComboAttackSkill("comboAttack", "콤보어택", 10, "공격시 일정 확률로 콤보어택이 생성되어 고급 기술을 사용할 수 있다. 또한 콤보 시너지와 연계하여 공격력을 증가시킬 수 있다.");
		case "플레임차지":
			return new FlameChargeSkill("flameCharge", "플레임차지", 20, "무기에 일시적으로 불속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_FIRE);
		case "블리자드차지":
			return new BlizzardChargeSkill("blizzardCharge", "블리자드차지", 20, "무기에 일시적으로 얼음속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_ICE);
		case "엘리멘탈차지":
			return new ElementalChargeSkill("elementalCharge", "엘리멘탈차지", 10, "차지 스킬을 사용한 직후 다른 차지스킬을 사용할때 엘리멘탈 차지가 충전된다. 충전할때 마다 강력한 방어 능력을 가질수 있다.");
		case "피어싱쓰루":
			return new PiercingDriveSkill("piercingDrive", "피어싱쓰루", 20, "적에게 암흑 속성의 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_DARK);
		case "창마스터리":
			return new SpearMasterySkill("spearMastery", "창마스터리", 20, "창의 숙련도와 명중률을 증가시킨다");
		case "아이언월":
			return new IronWillSkill("ironWill", "아이언월", 20, "일정 시간동안 물리방어력과 마법방어력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "하이퍼바디":
			return new HyperBodySkill("hyperBody", "하이퍼바디", 10, "일정 시간동안 최대 HP와 최대 MP를 일정량 증가시킨다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "브레이브슬래시":
			return new IntrepidSlashSkill("intrepidSlash", "브레이브슬래시", 30, "적에게 세번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "패닉":
			return new PanicSkill("panic", "패닉", 30, "콤보어택을 사용하여 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 3);
		case "샤우트":
			return new ShoutSkill("shout", "샤우트", 20, "콤보어택을 사용하여 강력한 포효로 적에게 데미지를 주고 일정 확률로 적을 기절시킨다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 2);
		case "콤보시너지":
			return new ComboSynergySkill("comboSynergy", "콤보시너지", 20, "공격시 콤보어택을 얻을 수있는 확률를 높이고 콤보어택 개수마다 물리 데미지를 일정량 증가시킨다");
		case "찬스어택":
			return new ChanceAttackSkill("chanceAttack", "찬스어택", 20, "영구히 크리티컬 확률을 증가시킨다");
		case "실드마스터리":
			return new ShieldMasterySkill("shieldMastery", "실드마스터리", 20, "방패 착용시 방패 방어 효과가 증가되고 물리 공격력, 속성저항 내성이 증가된다.");
		case "라이트닝차지":
			return new LightningChargeSkill("lightningCharge", "라이트닝차지", 30, "무기에 일시적으로 전기속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_THUNDER);
		case "위협":
			return new ThreatenSkill("threaten", "위협", 20, "적을 위협하여 일정 확률로 물리마법 공격력, 물리마법방어력, 적중률을 감소시킨다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 2);
		case "컴뱃오더스":
			return new CombatOrdersSkill("combatOrders", "컴뱃오더스", 30, "일정 시간동안 모든 스킬포인트 증가시킨다. 또한 플레임차지와 라이트닝 차지의 효과를 영구적으로 증대시킨다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 5);
		case "블레싱아머":
			return new DivineShieldSkill("divineShield", "블레싱아머", 20, "피격시 일정확률로 보호막을 생성하고 보호막 가동시 물리공격력과 데미지 무시율이 증가한다.");
		case "라만차스피어":
			return new LaManchaSpearSkill("laManchaSpear", "라만차스피어", 30, "거대한 창을 휘둘러 시전시에 약간의 데미지를 준후 강력한 한번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "비홀더쇼크": 
			return new EvilEyeShockSkill("evilEyeShock", "비홀더쇼크", 30, "비홀더가 강력한 포효를 내지르며 강력한 데미지를 준다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 3);
		case "크로스오버체인":
			return new CrossSurgeSkill("crossSurge", "크로스오버체인", 20, "일정 시간동안 HP비율에 따라 데미지가 증가하고 받은 피해를 감소시킨다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "로드오브다크니스":
			return new LordOfDarknessSkill("lordOfDarkness", "로드오브다크니스", 20, "크리티컬 확률이 증가하고 현재 HP비율에 따라 효과가 증대된다");
		case "비홀더스버프":
			return new EvilEyeBuffSkill("evilEyeBuff", "비홀더스버프", 20, "일정 턴을 주기로 비홀더가 플레이어에게 버프를 건다");
		case "레이징블로우":
			return new RagingBlowSkill("ragingBlow", "레이징블로우", 30, "적에게 다섯번의 일격을 가한다. 인레이지 스킬로 강화할 수 있다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "매직크래쉬":
			return new MagicCrashSkill("magicCrash", "매직크래쉬", 20, "적의 모든 버프 효과를 제거하고 일정시간 버프 사용을 제한한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 3);
		case "어드밴스드콤보":
			return new AdvancedComboSkill("advancedCombo", "어드밴스드콤보", 20, "콤보어택 최대 충전개수를 늘리고 일정확률로 콤보어택을 2개 충전시킬 수 있다. 또한 무기숙련도를 증가시킨다.");
		case "인레이지":
			return new EnrageSkill("enrage", "인레이지", 20, "일정시간동안 크리티컬 확률과 크리티컬 데미지를 증가시킨다. 또한 레이징블로우 스킬을 강화한다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "인사이징":
			return new IncisingSkill("incising", "인사이징", 30, "적에게 네번의 일격을 가한후 일정확률로 적에게 치명적인 피해를 주어 디버프를 건다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 2);
		case "어드밴스드차지":
			return new AdvancedChargeSkill("advancedCharge", "어드밴스드차지", 10, "엘리멘탈 차지의 갯수에따라 물리데미지를 증가한다. 또한 영구적으로 차지스킬의 공격 횟수를 증가시킨다.");
		case "팔라딘엑스퍼트":
			return new PaladinExpertSkill("paladinExpert", "팔라딘엑스퍼트", 30, "무기 숙련도, 방어력, 크리티컬 확률, 크리티컬 데미지가 영구적으로 증가한다.");
		case "디바인차지":
			return new DivineChargeSkill("divineCharge", "디바인차지", 30, "무기에 일시적으로 성속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPARTY_HOLY, 2);
		case "엘리멘탈포스":
			return new ElementalForceSkill("elementalForce", "엘리멘탈포스", 30, "플레임차지, 블리자드 차지, 라이트닝 차지를 영구적으로 강화한다.");
		case "어드밴스드웨폰마스터리":
			return new AdvancedWeaponMasterySkill("advancedWeaponMastery", "어드밴스드웨폰마스터리", 20, "창무기 착용시 숙련도 물리공격력 크리티컬 데미지를 강화한다.");
		case "다크임페일":
			return new DarkImpaleSkill("darkImpale", "다크임페일", 30, "빠른 속도로 전방의 적을 공격한다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "비홀더스리벤지":
			return new RevengeOfTheEvilEyeSkill("revengeOfTheEvilEye", "비홀더스리벤지", 20, "피격시 비홀더가 적에게 반격한후 플레이어의 체력을 회복시킨다.");
		case "궁그닐디센트":
			return new GungnirDescentSkill("gungnirDescent", "궁그닐디센트", 30, "거대한 창을 적의 머리위에 떨어뜨려 피해를 입힌다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 4);
		} 
		DialogUtils.showErrorDialog("SkillFactory.makeSkill("+skillName+") 새로운 스킬 생성 실패!");
		return null;
	}

}
