package attackImage;

import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class PowerStrikeUseImage extends SkillImage {
	public PowerStrikeUseImage(Hunt hunt, StateBox attacker, StateBox opponent) {
		super("playerSkillImage/powerStrikeUse", hunt, attacker, opponent, 60);
	}

	public void run() {
		MusicUtils.startEffectSound("powerStrikeUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isDead = true;
	}
}