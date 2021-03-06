package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import utils.MusicUtils;

public class IronBodyAttack extends PlayerAttack {
	
	public IronBodyAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		
		MusicUtils.startEffectSound("ironBody");
		attacker.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		attacker.updateStateBox();
		
		this.attacker.attackBackMotion();
		afterAttackDelay();
		
		wakeUpThread();
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리마법 방어력을 강화시키는 버프를 걸었다.";
	}

}
