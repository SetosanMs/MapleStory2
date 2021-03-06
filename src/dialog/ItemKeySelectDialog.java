package dialog;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import character.Adventurer;
import component.MapleButton;
import utils.FontUtils;
import utils.ResourceLoader;

public class ItemKeySelectDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 480;
	private static final int DIALOG_HEIGHT = 200;
	private ImageIcon quickQButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickQButtonBasic.png"));
	private ImageIcon quickQButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickQButtonEntered.png"));
	private ImageIcon quickWButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickWButtonBasic.png"));
	private ImageIcon quickWButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickWButtonEntered.png"));
	private ImageIcon quickEButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickEButtonBasic.png"));
	private ImageIcon quickEButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickEButtonEntered.png"));
	private ImageIcon quickRButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickRButtonBasic.png"));
	private ImageIcon quickRButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickRButtonEntered.png"));
	private ImageIcon quickTButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickTButtonBasic.png"));
	private ImageIcon quickTButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickTButtonEntered.png"));
	private ImageIcon quickYButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickYButtonBasic.png"));
	private ImageIcon quickYButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickYButtonEntered.png"));
	private FontMetrics fm;
	private MapleButton[] button = new MapleButton[Adventurer.QUICK_ITEM_ARRAY_SIZE];
	private ImageIcon[] basicIcon = { quickQButtonBasicImage, quickWButtonBasicImage,
			quickEButtonBasicImage, quickRButtonBasicImage,  quickTButtonBasicImage, quickYButtonBasicImage};
	private ImageIcon[] enteredIcon = { quickQButtonEnteredImage, quickWButtonEnteredImage,
			quickEButtonEnteredImage, quickRButtonEnteredImage,  quickTButtonEnteredImage, quickYButtonEnteredImage};
	private int returnIndex = -1;

	public ItemKeySelectDialog() {
		setTitle("key select");
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		this.fm = getFontMetrics(FontUtils.generalFont);
		int width = this.fm.stringWidth("키를 선택해주세요.");
		int height = this.fm.getHeight();
		JLabel label = new JLabel("키를 선택해주세요.");
		label.setFont(FontUtils.generalFont);
		label.setBounds((DIALOG_WIDTH - width) / 2, 10, width, height);
		getContentPane().add(label);
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			final int index = i;
			this.button[i] = new MapleButton(this.basicIcon[i], this.enteredIcon[i]);
			this.button[i].setBounds(40 + 70 * i, 60, 50, 50);
			this.button[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					returnIndex = index;
					end();
				}
			});
			getContentPane().add(this.button[i]);
		}
	}

	public void end() {
		dispose();
	}

	public int getReturnIndex() {
		return this.returnIndex;
	}

	public void setReturnIndex(int returnIndex) {
		this.returnIndex = returnIndex;
	}

	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}
}
