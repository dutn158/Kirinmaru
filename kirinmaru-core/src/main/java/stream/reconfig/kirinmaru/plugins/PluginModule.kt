package stream.reconfig.kirinmaru.plugins

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import stream.reconfig.kirinmaru.core.Plugin
import stream.reconfig.kirinmaru.plugins.gravitytales.GravityTalesPlugin
import stream.reconfig.kirinmaru.plugins.wuxiaworld.WuxiaworldPlugin
import javax.inject.Singleton

/**
 * Plugin registry
 */
@Singleton
@Module
interface PluginModule {

  @Binds
  @IntoMap
  @StringKey("GravityTales") //this will dictate the plugin name in the app
  fun bindGravityTales(gravityTalesPlugin: GravityTalesPlugin): Plugin

  @Binds
  @IntoMap
  @StringKey("WuxiaWorld")
  fun bindWuxiaWorld(wuxiaworldPlugin: WuxiaworldPlugin): Plugin

}