package assault.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class LobbyListener implements Listener {
public static LobbyListener instance = null;
	
	public LobbyListener() {
		instance = this;
	}
		
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
		
//	@EventHandler
//	public void onEntityDamage(EntityDamageEvent e) {
//		Entity ent = e.getEntity();
//		e.setCancelled(true);
//		if(e.getCause() == DamageCause.VOID) {
//			Bukkit.getScheduler().runTaskLater(TSWMain.get(), new Runnable() {
//				
//				@Override
//				public void run() {
//					ent.teleport(TSWMain.getCfg().getSpawn());
//				}
//			}, 1L);
//		}
//	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e) {
		e.setCancelled(true);

	}
	
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler 
    public void onPlayerInteract(PlayerInteractEvent e) {
		e.setCancelled(true);
    }
        
	@EventHandler
	public void onDropItem(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		e.setCancelled(true);
	}
}
