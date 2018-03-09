package stream.reconfig.kirinmaru.android.util.prefs

import android.content.SharedPreferences
import android.support.annotation.AnyThread
import android.support.annotation.WorkerThread

/**
 * Preference model of a given [T] type with dynamic String key created from a [P] parameter.
 *
 * [T] can be any valid SharedPreferences primitive type (String set included)
 */
abstract class PrefDynamicModel<T, in P>(
    private val default: T,
    private inline val retrieve: SharedPreferences.(key: String, default: T) -> T,
    private inline val store: SharedPreferences.Editor.(key: String, data: T) -> Unit,
    private val prefs: SharedPreferences
) {

  abstract fun key(input: P): String

  @WorkerThread
  open fun load(keyedBy: P, defaultVal: T = default): T = retrieve(prefs, key(keyedBy), defaultVal)

  @AnyThread
  open fun persist(keyedBy: P, data: T) {
    prefs.edit().also { store(it, key(keyedBy), data) }.apply()
  }
}