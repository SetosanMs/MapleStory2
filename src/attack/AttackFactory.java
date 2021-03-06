package attack;

import component.StateBox;
import hunt.HuntComponent.Hunt;
import monsterAttack.AccuracyRateDownAttack;
import monsterAttack.AccuracyRateUpAttack;
import monsterAttack.AdvancedFlameShootAttack;
import monsterAttack.ArmageddonAttack;
import monsterAttack.BatSweamAttack;
import monsterAttack.BlazingExtinctionAttack;
import monsterAttack.BlizzardAttack;
import monsterAttack.BlowBeastAttack;
import monsterAttack.BuffRemoveAttack;
import monsterAttack.ChainLightningAttack;
import monsterAttack.ColdBeamAttack;
import monsterAttack.CombatSwitchingAttack;
import monsterAttack.DamageDownAttack;
import monsterAttack.DamageUpAttack;
import monsterAttack.DefenceDownAttack;
import monsterAttack.DefenceUpAttack;
import monsterAttack.DevilScytheAttack;
import monsterAttack.DoublePiercingAttack;
import monsterAttack.DoubleShootAttack;
import monsterAttack.DoubleSlashAttack;
import monsterAttack.EtherealFormAttack;
import monsterAttack.EvasionRateDownAttack;
import monsterAttack.EvasionRateUpAttack;
import monsterAttack.FlameBarrierAttack;
import monsterAttack.FlameBiteAttack;
import monsterAttack.FlameShootAttack;
import monsterAttack.FlashAttack;
import monsterAttack.GenesisAttack;
import monsterAttack.HpHealAttack;
import monsterAttack.HumanityInAttack;
import monsterAttack.IceStrikeAttack;
import monsterAttack.InfinityAttack;
import monsterAttack.ManaBurstAttack;
import monsterAttack.MassiveFireAttack;
import monsterAttack.MassiveSplashAttack;
import monsterAttack.MonsterAttack;
import monsterAttack.MoonlightSpearAttack;
import monsterAttack.PlainChargeDriveAttack;
import monsterAttack.PoisonBreathAttack;
import monsterAttack.PoisonMistAttack;
import monsterAttack.PoisonNovaAttack;
import monsterAttack.PowerTransferAttack;
import monsterAttack.RocketPunchAttack;
import monsterAttack.ShadowShellAttack;
import monsterAttack.ShiningBusterAttack;
import monsterAttack.SkillLockAttack;
import monsterAttack.SoulEndureAttack;
import monsterAttack.SwordAttack;
import monsterAttack.TackleAttack;
import monsterAttack.UnforgettableNightmareAttack;
import monsterAttack.WindCircleAttack;
import playerAttack.NormalAttack;
import playerAttack.PlayerAttack;
import skill.MonsterSkill;
import skill.NormalSkill;
import utils.DialogUtils;

public class AttackFactory {
	public static MonsterAttack makeMonsterAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "몸통박치기":
			return new TackleAttack(hunt, attacker, opponents, new MonsterSkill("몸통박치기", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "플래쉬":
			return new FlashAttack(hunt, attacker, opponents, new MonsterSkill("플래쉬", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "공격력강화":
			return new DamageUpAttack(hunt, attacker, opponents, new MonsterSkill("공격력강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "방어력강화":
			return new DefenceUpAttack(hunt, attacker, opponents, new MonsterSkill("방어력강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "적중률강화":
			return new AccuracyRateUpAttack(hunt, attacker, opponents, new MonsterSkill("적중률강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "회피율강화":
			return new EvasionRateUpAttack(hunt, attacker, opponents, new MonsterSkill("회피율강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "공격력약화":
			return new DamageDownAttack(hunt, attacker, opponents, new MonsterSkill("공격력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "방어력약화":
			return new DefenceDownAttack(hunt, attacker, opponents, new MonsterSkill("방어력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "적중률약화":
			return new AccuracyRateDownAttack(hunt, attacker, opponents, new MonsterSkill("적중률약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "회피율약화":
			return new EvasionRateDownAttack(hunt, attacker, opponents, new MonsterSkill("회피율약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "베기":
			return new SwordAttack(hunt, attacker, opponents, new MonsterSkill("베기", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "더블슬래쉬":
			return new DoubleSlashAttack(hunt, attacker, opponents, new MonsterSkill("더블슬래쉬", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "플레임샷":
			return new FlameShootAttack(hunt, attacker, opponents, new MonsterSkill("플레임샷", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "안티매직쉘":
			return new ShadowShellAttack(hunt, attacker, opponents, new MonsterSkill("안티매직쉘", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "데빌사이더":
			return new DevilScytheAttack(hunt, attacker, opponents, new MonsterSkill("데빌사이더", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "스킬잠금":
			return new SkillLockAttack(hunt, attacker, opponents, new MonsterSkill("스킬잠금", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "샤이닝버스터":
			return new ShiningBusterAttack(hunt, attacker, opponents, new MonsterSkill("샤이닝버스터", Property.PROPARTY_HOLY, skillPoint, AttackType.OPPONENT));
		case "체력회복":
			return new HpHealAttack(hunt, attacker, opponents, new MonsterSkill("체력회복", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "콜드빔":
			return new ColdBeamAttack(hunt, attacker, opponents, new MonsterSkill("콜드빔", Property.PROPERTY_ICE, skillPoint, AttackType.OPPONENT));
		case "맹수의일격":
			return new BlowBeastAttack(hunt, attacker, opponents, new MonsterSkill("맹수의일격", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "강화된플레임샷":
			return new AdvancedFlameShootAttack(hunt, attacker, opponents, new MonsterSkill("강화된플레임샷", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "베츠스웜":
			return new BatSweamAttack(hunt, attacker, opponents, new MonsterSkill("베츠스웜", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "녹스피어":
			return new MoonlightSpearAttack(hunt, attacker, opponents, new MonsterSkill("녹스피어", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "버프해제":
			return new BuffRemoveAttack(hunt, attacker, opponents, new MonsterSkill("버프해제", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "여의선인":
			return new HumanityInAttack(hunt, attacker, opponents, new MonsterSkill("여의선인", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "더블피어싱":
			return new DoublePiercingAttack(hunt, attacker, opponents, new MonsterSkill("더블피어싱", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "서클오브마나":
			return new ManaBurstAttack(hunt, attacker, opponents, new MonsterSkill("서클오브마나", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "더블샷":
			return new DoubleShootAttack(hunt, attacker, opponents, new MonsterSkill("더블샷", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "파워트랜스퍼":
			return new PowerTransferAttack(hunt, attacker, opponents, new MonsterSkill("파워트랜스퍼", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "체인라이트닝":
			return new ChainLightningAttack(hunt, attacker, opponents, new MonsterSkill("체인라이트닝", Property.PROPERTY_THUNDER, skillPoint, AttackType.OPPONENT));
		case "컴뱃스위칭":
			return new CombatSwitchingAttack(hunt, attacker, opponents, new MonsterSkill("컴뱃스위칭", Property.PROPERTY_THUNDER, skillPoint, AttackType.OPPONENT));
		case "매시브파이어":
			return new MassiveFireAttack(hunt, attacker, opponents, new MonsterSkill("매시브파이어", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "포이즌미스트":
			return new PoisonMistAttack(hunt, attacker, opponents, new MonsterSkill("포이즌미스트", Property.PROPERTY_POSION, skillPoint, AttackType.OPPONENT));
		case "윈드서클":
			return new WindCircleAttack(hunt, attacker, opponents, new MonsterSkill("윈드서클", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "매시브스플래쉬":
			return new MassiveSplashAttack(hunt, attacker, opponents, new MonsterSkill("매시브스플래쉬", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "로켓펀치":
			return new RocketPunchAttack(hunt, attacker, opponents, new MonsterSkill("로켓펀치", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "인피니티":
			return new InfinityAttack(hunt, attacker, opponents, new MonsterSkill("인피니티", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "잊혀지지않는악몽":
			return new UnforgettableNightmareAttack(hunt, attacker, opponents, new MonsterSkill("잊혀지지않는악몽", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "플레임바이트":
			return new FlameBiteAttack(hunt, attacker, opponents, new MonsterSkill("플레임바이트", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "플레임배리어":
			return new FlameBarrierAttack(hunt, attacker, opponents, new MonsterSkill("플레임배리어", Property.PROPERTY_FIRE, skillPoint, AttackType.MYSELF));
		case "플레인차지드라이브":
			return new PlainChargeDriveAttack(hunt, attacker, opponents, new MonsterSkill("플레인차지드라이브", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "블레이징익스팅션":
			return new BlazingExtinctionAttack(hunt, attacker, opponents, new MonsterSkill("블레이징익스팅션", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "포이즌브레스":
			return new PoisonBreathAttack(hunt, attacker, opponents, new MonsterSkill("포이즌브레스", Property.PROPERTY_POSION, skillPoint, AttackType.OPPONENT));
		case "소울인듀어":
			return new SoulEndureAttack(hunt, attacker, opponents, new MonsterSkill("소울인듀어", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "아이스스트라이크":
			return new IceStrikeAttack(hunt, attacker, opponents, new MonsterSkill("아이스스트라이크", Property.PROPERTY_ICE, skillPoint, AttackType.OPPONENT));
		case "에테리얼폼":
			return new EtherealFormAttack(hunt, attacker, opponents, new MonsterSkill("에테리얼폼", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "포이즌노바":
			return new PoisonNovaAttack(hunt, attacker, opponents, new MonsterSkill("포이즌노바", Property.PROPERTY_POSION, skillPoint, AttackType.OPPONENT));
		case "블리자드":
			return new BlizzardAttack(hunt, attacker, opponents, new MonsterSkill("블리자드", Property.PROPERTY_ICE, skillPoint, AttackType.OPPONENT));
		case "아마겟돈":
			return new ArmageddonAttack(hunt, attacker, opponents, new MonsterSkill("아마겟돈", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "제네시스":
			return new GenesisAttack(hunt, attacker, opponents, new MonsterSkill("제네시스", Property.PROPARTY_HOLY, skillPoint, AttackType.OPPONENT));
		}
		DialogUtils.showErrorDialog("AttackFactory.makeMonsterAttack("+attackName+") 몬스터 공격 실패!");
		return null;
	}
	
	public static PlayerAttack makeAdventurerAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "일반공격":
			return new NormalAttack(hunt, attacker, opponents, new NormalSkill(null, "일반공격", 0, "일반공격이다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING));
		}
		DialogUtils.showErrorDialog("AttackFactory.makeAdventurerAttack(...) 플레이어 공격 실패!");
		return null;
	}
	
}
