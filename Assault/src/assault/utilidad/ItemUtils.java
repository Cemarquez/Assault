/*
* Author: Luca Bosin / Wombosvideo
* License: Creative Commons -> More info [url]http://customitem.jimdo.de/[/url]
*/
package assault.utilidad;
 
import java.util.ArrayList;
import java.util.List;
 


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import com.google.common.collect.Lists;
 
public class ItemUtils extends ItemStack {
 
//Item with same specifications like choosen itemstack
public ItemUtils(ItemStack itemStack){
this.setType(itemStack.getType());
this.setAmount(itemStack.getAmount());
this.setDurability(itemStack.getDurability());
this.setItemMeta(itemStack.getItemMeta());
}
 
//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(Material material, Short damageid, Integer amount, String displayName, List<String> lores){
this.setType(material);
this.setAmount(amount);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
im.setLore(lores);
this.setItemMeta(im);


}

//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(Material material, Short damageid, Integer amount, String displayName, String loresSplit){
this.setType(material);
this.setAmount(amount);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
List<String> lr = Lists.newArrayList();
for(String lrs : loresSplit.split("=="))
	lr.add(lrs);
im.setLore(lr);
this.setItemMeta(im);


}

//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(String skull_item_Owner, Integer amount, String displayName, String loresSplit){
this.setType(Material.SKULL_ITEM);
this.setAmount(amount);
this.setDurability((short) 3);
SkullMeta im = (SkullMeta) this.getItemMeta();
im.setDisplayName(displayName);
List<String> lr = Lists.newArrayList();
for(String lrs : loresSplit.split("=="))
	lr.add(lrs);
im.setLore(lr);
im.setOwner(skull_item_Owner);
this.setItemMeta(im);


}

//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(String skull_item_Owner, Integer amount){
this.setType(Material.SKULL_ITEM);
this.setAmount(amount);
this.setDurability((short) 3);
SkullMeta im = (SkullMeta) this.getItemMeta();
im.setOwner(skull_item_Owner);
this.setItemMeta(im);


}
 
//Item with Material and DamageId
public ItemUtils(Material material, Short damageid){
this.setType(material);
this.setDurability((short) damageid);
this.setAmount(1);


}
 
//Item with Material and Amount
public ItemUtils(Material material, Integer amount){
this.setType(material);
this.setAmount(amount);


}
 
//Item with Material and Display Name
public ItemUtils(Material material, String displayName){
this.setType(material);
this.setAmount(1);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
this.setItemMeta(im);


}
 
//Item with Material and Lores List
public ItemUtils(Material material, List<String> lores){
this.setType(material);
this.setAmount(1);
ItemMeta im = this.getItemMeta();
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, DamageId and Amount
public ItemUtils(Material material, Short damageid, Integer amount){
this.setType(material);
this.setAmount(amount);
this.setDurability((short) damageid);


}
 
//Item with Material, DamageId, Amount and Display Name
public ItemUtils(Material material, Short damageid, Integer amount, String displayName){
this.setType(material);
this.setAmount(amount);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
this.setItemMeta(im);


}
 
//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(Material material, Short damageid, Integer amount, List<String> lores){
this.setType(material);
this.setAmount(amount);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, DamageId and Display Name
public ItemUtils(Material material, Short damageid, String displayName){
this.setType(material);
this.setAmount(1);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
this.setItemMeta(im);


}
 
//Item with Material, DamageId, Display Name and Lores List
public ItemUtils(Material material, Short damageid, String displayName, List<String> lores){
this.setType(material);
this.setAmount(1);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, DamageId and Lores List
public ItemUtils(Material material, Short damageid, List<String> lores){
this.setType(material);
this.setAmount(1);
this.setDurability((short) damageid);
ItemMeta im = this.getItemMeta();
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, Amount and Display Name
public ItemUtils(Material material, Integer amount, String displayName){
this.setType(material);
this.setAmount(amount);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
this.setItemMeta(im);


}
 
//Item with Material, DamageId, Amount, Display Name and Lores List
public ItemUtils(Material material, Integer amount, String displayName, List<String> lores){
this.setType(material);
this.setAmount(amount);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, Amount and Lores List
public ItemUtils(Material material, Integer amount, List<String> lores){
this.setType(material);
this.setAmount(amount);
ItemMeta im = this.getItemMeta();
im.setLore(lores);
this.setItemMeta(im);


}
 
//Item with Material, Display Name and Lores List
public ItemUtils(Material material, String displayName, List<String> lores){
this.setType(material);
this.setAmount(1);
ItemMeta im = this.getItemMeta();
im.setDisplayName(displayName);
im.setLore(lores);
this.setItemMeta(im);


}
 
public ItemUtils getCustomItem(ItemStack itemStack){
this.setType(itemStack.getType());
this.setAmount(itemStack.getAmount());
this.setDurability(itemStack.getDurability());
this.setItemMeta(itemStack.getItemMeta());
return this;
}
 
public boolean isSameLike(ItemUtils customItem){
if(!(customItem.getType().equals(this.getType()))){
return false;
}
if(this.getItemMeta().hasDisplayName()){
if(!(customItem.getItemMeta().hasDisplayName())){
return false;
}else{
if(!(this.getItemMeta().getDisplayName().equals(customItem.getItemMeta().getDisplayName()))){
return false;
}
}
}
if(this.getItemMeta().hasLore()){
if(!(customItem.getItemMeta().hasLore())){
return false;
}
}
if(!(this.getItemMeta().getEnchants().equals(customItem.getItemMeta().getEnchants()))){
return false;
}
if(!(this.getDurability() == customItem.getDurability())){
return false;
}
return true;
}
 
public boolean isSameItemStackLike(ItemStack itemStack){
if(!(itemStack.getType().equals(this.getType()))){
return false;
}
if(this.getItemMeta().hasDisplayName()){
if(!(itemStack.getItemMeta().hasDisplayName())){
return false;
}else{
if(!(this.getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName()))){
return false;
}
}
}
if(this.getItemMeta().hasLore()){
if(!(itemStack.getItemMeta().hasLore())){
return false;
}
}
if(!(this.getItemMeta().getEnchants().equals(itemStack.getItemMeta().getEnchants()))){
return false;
}
if(!(this.getDurability() == itemStack.getDurability())){
return false;
}
return true;
}
 
//Add the Item to a Player's Inventory
public void add(Player player){
player.getInventory().addItem(this);
}
 
//Add the Item to an Inventory
public void add(Inventory inventory){
inventory.addItem(this);
}
 
//Set the Item in a Player's Inventory on a specific slot
public void set(Player player, Integer slot){
player.getInventory().setItem(slot, this);
}
 
//Set the Item in an Inventory on a specific slot
public void set(Inventory inventory, Integer slot){
inventory.setItem(slot, this);
}
 
//Sets the Item as Helmet on a Player
public void setHelmet(Player p){
p.getInventory().setHelmet(this);
}
 
//Sets the Item as Chestplate on a Player
public void setChestplate(Player p){
p.getInventory().setChestplate(this);
}
 
//Sets the Item as Leggings on a Player
public void setLeggings(Player p){
p.getInventory().setLeggings(this);
}
 
//Sets the Item as Boots on a Player
public void setBoots(Player p){
p.getInventory().setBoots(this);
}
 
//Sets the Item as PlayerInHandItem
public void setInHand(Player p){
p.getInventory().setItemInHand(this);
}
 
//Drops the Item on the specified Location
public void dropItem(Location loc){
loc.getWorld().dropItem(loc, this);
}
 
//Drops the Item naturally on the specified Location
public void dropItemNaturally(Location loc){
loc.getWorld().dropItemNaturally(loc, this);
}
 





public static ItemStack parseItem(List<String> item) {
    if (item.size() < 2) {
        return null;
    }
    
    ItemStack itemStack = null;

    try {
    	if (item.get(0).contains(":")) {
    		Material material = Material.getMaterial(item.get(0).split(":")[0].toUpperCase());
    		int amount = Integer.parseInt(item.get(1));
    		if (amount < 1) {
    			amount = 1;
    		}
    		short data = (short) Integer.parseInt(item.get(0).split(":")[1].toUpperCase());
    		itemStack = new ItemStack(material, amount, data);
    	} else {
            itemStack = new ItemStack(Material.getMaterial(item.get(0).toUpperCase()), Integer.parseInt(item.get(1)));
    	}

    	if (item.size() > 2) {
        	for (int x = 2; x < item.size(); x++) {
        		if (item.get(x).split(":")[0].equalsIgnoreCase("name")) {
        			ItemMeta itemMeta = itemStack.getItemMeta();
        	        itemMeta.setDisplayName(item.get(x).split(":")[1]);
        	        itemStack.setItemMeta(itemMeta);
        		} else {
                    itemStack.addUnsafeEnchantment(getEnchant(item.get(x).split(":")[0]), Integer.parseInt(item.get(x).split(":")[1]));
        		}
        	}

        }

    } catch (Exception ignored) {
    	ignored.printStackTrace();
    }
    return itemStack;
}

public static PotionEffect parseEffect(List<String> effect) {
    if (effect.size() < 2) {
        return null;
    }

    PotionEffect potionEffect = null;

    try {
    	int length;
    	int level;
    	PotionEffectType pType = getPotionType(effect.get(0));
       	if (Integer.parseInt(effect.get(1)) == -1) {
    	   length = Integer.MAX_VALUE;
       	} else {
    	   length = 20 * Integer.parseInt(effect.get(1));
       	}
       	level = Integer.parseInt(effect.get(2));
       	
       	potionEffect = new PotionEffect(pType, length, level);

    } catch (Exception ignored) {

    }
    return potionEffect;
}


private static PotionEffectType getPotionType(String type) {
	switch (type.toLowerCase()) {
	case "speed": return PotionEffectType.SPEED;
	case "slowness": return PotionEffectType.SLOW;
	case "haste": return PotionEffectType.FAST_DIGGING;
	case "miningfatique": return PotionEffectType.SLOW_DIGGING;
	case "strength": return PotionEffectType.INCREASE_DAMAGE;
	case "instanthealth": return PotionEffectType.HEAL;
	case "instantdamage": return PotionEffectType.HARM;
	case "jumpboost": return PotionEffectType.JUMP;
	case "nausea": return PotionEffectType.CONFUSION;
	case "regeneration": return PotionEffectType.REGENERATION;
	case "resistance": return PotionEffectType.DAMAGE_RESISTANCE;
	case "fireresistance": return PotionEffectType.FIRE_RESISTANCE;
	case "waterbreathing": return PotionEffectType.WATER_BREATHING;
	case "invisibility": return PotionEffectType.INVISIBILITY;
	case "blindness": return PotionEffectType.BLINDNESS;
	case "nightvision": return PotionEffectType.NIGHT_VISION;
	case "hunger": return PotionEffectType.HUNGER;
	case "weakness": return PotionEffectType.WEAKNESS;
	case "poison": return PotionEffectType.POISON;
	case "wither": return PotionEffectType.WITHER;
	case "healthboost": return PotionEffectType.HEALTH_BOOST;
	case "absorption": return PotionEffectType.ABSORPTION;
	case "saturation": return PotionEffectType.SATURATION;
	}
	
	try {
		return PotionEffectType.getByName(type.toUpperCase());
	} catch(Exception ex) {
		ex.printStackTrace();
		return PotionEffectType.getById(Integer.valueOf(type));
	}

}

private static Enchantment getEnchant(String enchant) {
	switch (enchant.toLowerCase()) {
	case "protection": return Enchantment.PROTECTION_ENVIRONMENTAL;
	case "projectileprotection": return Enchantment.PROTECTION_PROJECTILE;
	case "fireprotection": return Enchantment.PROTECTION_FIRE;
	case "featherfall": return Enchantment.PROTECTION_FALL;
	case "blastprotection": return Enchantment.PROTECTION_EXPLOSIONS;
	case "respiration": return Enchantment.OXYGEN;
	case "aquaaffinity": return Enchantment.WATER_WORKER;
	case "sharpness": return Enchantment.DAMAGE_ALL;
	case "smite": return Enchantment.DAMAGE_UNDEAD;
	case "baneofarthropods": return Enchantment.DAMAGE_ARTHROPODS;
	case "knockback": return Enchantment.KNOCKBACK;
	case "fireaspect": return Enchantment.FIRE_ASPECT;
	case "depthstrider": return Enchantment.DEPTH_STRIDER;
	case "looting": return Enchantment.LOOT_BONUS_MOBS;
	case "power": return Enchantment.ARROW_DAMAGE;
	case "punch": return Enchantment.ARROW_KNOCKBACK;
	case "flame": return Enchantment.ARROW_FIRE;
	case "infinity": return Enchantment.ARROW_INFINITE;
	case "efficiency": return Enchantment.DIG_SPEED;
	case "silktouch": return Enchantment.SILK_TOUCH;
	case "unbreaking": return Enchantment.DURABILITY;
	case "fortune": return Enchantment.LOOT_BONUS_BLOCKS;
	case "luckofthesea": return Enchantment.LUCK;
	case "luck": return Enchantment.LUCK;
	case "lure": return Enchantment.LURE;
	case "thorns": return Enchantment.THORNS;	
	}
	
	try {
		return Enchantment.getByName(enchant.toUpperCase());
	} catch(Exception ex) {
		return Enchantment.getById(Integer.valueOf(enchant));
	}
}

public static ItemStack name(ItemStack itemStack, String name, String... lores) {
    ItemMeta itemMeta = itemStack.getItemMeta();

    if (!name.isEmpty()) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    }

    if (lores.length > 0) {
        List<String> loreList = new ArrayList<String>(lores.length);

        for (String lore : lores) {
            loreList.add(ChatColor.translateAlternateColorCodes('&', lore));
        }

        itemMeta.setLore(loreList);
    }

    itemStack.setItemMeta(itemMeta);
    return itemStack;
}
}