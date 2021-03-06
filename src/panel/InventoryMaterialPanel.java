package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import item.Item;
import item.ItemButton;
import item.MaterialItem;
import maplestory.Player;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventoryMaterialPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon inventoryItemSpaceButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ItemButton[] inventoryItemSpace = new ItemButton[50];
	private Player player;
	
	private ItemTooltipPanel toolTipPanel = new ItemTooltipPanel();

	public InventoryMaterialPanel(Player player) {
		this.player = player;
		toolTipPanel.setBounds(0, 0, InventoryMainPanel.INVENTORY_COMPONENT_WIDTH - 10, InventoryMainPanel.INVENTORY_COMPONENT_HEIGHT - 10);
		add(toolTipPanel);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setVisible(false);
		makeSpace();
		setMaterialItemImage();
	}

	private void makeSpace() {
		int x = 50;
		int y = 30;
		for (int i = 0; i < 50; i++) {
			final int index = i;
			this.inventoryItemSpace[i] = new ItemButton(this.inventoryItemSpaceButtonImage);
			this.inventoryItemSpace[i].setBounds(x + i % 10 * 100, y + i / 10 * 70, 50, 50);
			this.inventoryItemSpace[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					inventoryItemEvent(index);
				}
			});
			inventoryItemSpace[i].setItemToolTip(toolTipPanel);
			add(this.inventoryItemSpace[i]);
		}
	}

	public void reload() {
		setMaterialItemImage();
		repaint();
	}

	public void inventoryItemEvent(int index) {
		
	}


	private void setMaterialItemImage() {
		ArrayList<MaterialItem> materialInventory = this.player.getInventory().getMaterialInventory();
		for (int i = 0; i < materialInventory.size(); i++) {
			this.inventoryItemSpace[i].setItem((Item) materialInventory.get(i));
		}
		for (int i = materialInventory.size(); i < 50; i++) {
			this.inventoryItemSpace[i].setItem(null);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ArrayList<MaterialItem> materialInventory = this.player.getInventory().getMaterialInventory();
		for (int i = 0; i < materialInventory.size(); i++) {
			int x = this.inventoryItemSpace[i].getLocation().x + 5;
			int y = this.inventoryItemSpace[i].getLocation().y - 5;
			g.drawString("X" + ((MaterialItem) materialInventory.get(i)).getNum(), x, y);
		}
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}
