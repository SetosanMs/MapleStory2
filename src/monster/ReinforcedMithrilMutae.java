package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class ReinforcedMithrilMutae extends Monster {

	private static final long serialVersionUID = 1L;

	public ReinforcedMithrilMutae() {
		super("강화된미스릴뮤테", "reinforcedMithrilMutae",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 55, 39200, 2600, 0, 0, 650, 650, 40, 40, 0), 633, 640, 642, 653,
				700 * Main.EXP_BONUS, 1814 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "방어력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 500, "샤이닝버스터", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(500, 900, "더블샷", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}