package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class OrangeMushroom extends Monster {

	private static final long serialVersionUID = 1L;

	public OrangeMushroom() {
		super("주황버섯", "orangeMushroom",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 7, 90, 10, 10, 10, 2, 2), 30, 33, 0, 0,
				12 * Main.EXP_BONUS, 21 * Main.MONEY_BONUS, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
