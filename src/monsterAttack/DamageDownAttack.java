package monsterAttack;

import buff.BuffFactory;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class DamageDownAttack extends MonsterAttack {
	
	public DamageDownAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		MusicUtils.startEffectSound("monsterBuff");
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("공격력약화", monsterSkill.getSkillPoint()));
		this.opponent.updateStateBox(); 
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 물리, 마법공격력을 약화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 10 * monsterSkill.getSkillPoint();
	}
}
