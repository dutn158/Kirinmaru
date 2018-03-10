package stream.reconfig.kirinmaru.android.util.offline

import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Contract for offline resource
 *
 * [V] : Any type to serve as a view.
 *
 * [L] : Local type to queried and stored
 *
 * [R] : Remote type
 */
interface ResourceContract<out V, L, R> {

  /**
   * Local type [L] queried into a [Flowable] emission
   */
  fun local(): Flowable<L>

  /**
   * Remote type [R] returned as Rx [Single] query
   */
  fun remote(): Single<R>

  /**
   * Transform from remote [R] type into any local [L] type.
   * [persist] should be called after this.
   */
  fun transform(remote: R): L

  /**
   * Persist data. Final transformations can also be done here
   */
  fun persist(data: L)

  /**
   * Transform from local queried type [L] into the view type [V]
   */
  fun view(local: L): V
}
