package com.thekrinker.nightvision;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("NightVision");

  public void onEnable()
  {
    LOGGER.info("NightVision Plugin Enabled! :3");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    //Gives the player night vision if /nv or /nightvision
    if ( command.getName().equalsIgnoreCase("nv") || command.getName().equalsIgnoreCase("nightvision")) {

      //Check if a Player sent the command
      if (sender instanceof Player){
        Player p = (Player) sender;

        //Checks if the player already has Night Vision applied
        PotionEffect effect = p.getPotionEffect( PotionEffectType.NIGHT_VISION );
        if ( effect != null ){
          //Removes Night Vision effect as the player already had it
          p.removePotionEffect(PotionEffectType.NIGHT_VISION);
        } else{
          //Adds Night Vision to player
          p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE,0, false, false), true);
        }
      }
    }
    return true;
  }
}

