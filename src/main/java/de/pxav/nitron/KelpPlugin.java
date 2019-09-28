package de.pxav.nitron;

import com.google.inject.Injector;
import de.pxav.nitron.application.KelpApplicationRepository;
import de.pxav.nitron.application.SimpleBinderModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.io.File;

/**
 * A class description goes here.
 *
 * @author pxav
 */
@Plugin(name = "Kelp", version = "0.1-SNAPSHOT")
@Author("pxav")
@Description("A cross version spigot framework.")
public class KelpPlugin extends JavaPlugin {

  private static Injector injector;

  @Override
  public void onLoad() {
    SimpleBinderModule simpleBinderModule = new SimpleBinderModule(this);
    injector = simpleBinderModule.createInjector();
    injector.injectMembers(this);
    injector.getInstance(KelpApplicationRepository.class)
            .detectGamePlugins(new File(Bukkit.getWorldContainer(), "nitron_plugins"))
            .load()
            .enable();
  }

  @Override
  public void onEnable() {
    injector.getInstance(KelpApplicationRepository.class).enablePlugins();
  }

  public static Injector getInjector() {
    return injector;
  }

}