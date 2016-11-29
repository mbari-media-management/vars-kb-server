package org.mbari.vars.kbserver

import com.google.inject.{ Binder, Module }

/**
 *
 *
 * @author Brian Schlining
 * @since 2016-11-18T11:11:00
 */
class InjectorModule extends Module {
  override def configure(binder: Binder): Unit =
    binder.install(new vars.jpa.InjectorModule)
}